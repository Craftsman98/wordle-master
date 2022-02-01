import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class WordleMaster {
    public static void main(String[] args) throws IOException {
        Word lastWord = new Word("world");
        String s = "";
        Pattern pattern = new Pattern();
        int[] res = pattern.result();


        List<Word> allWords = new ArrayList<>();

        File file = new File("src/main/resources/wordle_words.txt");
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

        List<Word> hope = allWords;
        while (hope.size() > 1){
            for (int i = 0; i < res.length; i++) {
                int finalI = i;
                Word finalLastWord = lastWord;
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
                lastWord = hope.get(Integer.parseInt(scanner.nextLine()));
                System.out.println(lastWord.getWord());
                res = pattern.result();
            }
        }




        System.out.println(hope.size());

    }

}
