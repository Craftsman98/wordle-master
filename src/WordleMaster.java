package src;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordleMaster {
    public static void main(String[] args) throws IOException {
        // 默认第一个词，可自行修改
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用 wordle-master ！请在Wordle游戏中输入第一个单词：(默认使用abort作为初始词)");
        String firstWord = sc.nextLine();
        if (firstWord.equals("")){
            firstWord = "abort";
        }
        Word lastWord = new Word(firstWord);
        System.out.println("初始词为：" + firstWord);
        Pattern pattern = new Pattern();
        // 输入Wordle结果
        int[] res = pattern.result();

        // 读取所有的单词
        List<Word> allWords = new ArrayList<>();

        File file = new File("wordle_words.txt");
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String word = bufferedReader.readLine();
        while (word != null){
            Word w = new Word(word);
            allWords.add(w);
            word = bufferedReader.readLine();
        }
        bufferedReader.close();
        reader.close();

        // 符合条件的单词
        List<Word> hope = allWords;
        while (hope.size() > 1){
            for (int i = 0; i < res.length; i++) {
                int finalI = i;
                Word finalLastWord = lastWord;
                // 如果出现单词中有两个相同字母的情况（如cheer)
                for (int j = 0; j < finalLastWord.getWord().length(); j++) {
                    for (int k = j + 1; k < finalLastWord.getWord().length(); k++) {
                        if (finalLastWord.getWord().charAt(j) == finalLastWord.getWord().charAt(k)){
                            if (res[j] == 0 && res[k] != 0){
                                res[j] = 3;
                            }else if(res[j] != 0 && res[k] == 0){
                                res[k] = 3;
                            }
                        }
                    }
                }
                switch (res[i]) {
                    case 0:
                        hope = hope.stream().filter(w -> w.notInclude(finalLastWord.getWord().charAt(finalI))).collect(Collectors.toList());
                        break;
                    case 2:
                        hope = hope.stream().filter(w -> w.getWord().charAt(finalI) == finalLastWord.getWord().charAt(finalI)).collect(Collectors.toList());
                        break;
                    case 1:
                        hope = hope.stream().filter(w -> w.notLocate(finalLastWord.getWord().charAt(finalI), finalI)).collect(Collectors.toList());
                        break;
                    default:
                }
            }
            System.out.println("size: " + hope.size());
            for (int i = 0; i < Math.min(10, hope.size()); i++) {
                System.out.print(i + ". " + hope.get(i).getWord() + "  ");
            }
            System.out.println();
            if (hope.size() > 1) {
                Scanner scanner = new Scanner(System.in);
                int chose = Integer.MAX_VALUE;
                while (chose > 9 || chose < 0) {
                    System.out.println("请选择一个：");
                    String s = scanner.nextLine();
                    chose = s.length() == 1 ? Integer.parseInt(s) : Integer.MAX_VALUE;
                }
                lastWord = hope.get(chose);
                System.out.println(lastWord.getWord());
                res = pattern.result();
            }
        }
    }

}
