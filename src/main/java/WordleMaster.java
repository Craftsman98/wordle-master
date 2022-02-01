import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WordleMaster {
    public static void main(String[] args) throws IOException {
        Word lastWord = new Word("world");
        String s = "";
        Pattern pattern = new Pattern();
        int[] res = pattern.result();


        List<Word> allWords = new ArrayList<>();

        String filename = "/Users/zouhd/Documents/Programming/IdeaProjects/wordle-master/build/resources/main/wordle_words.txt";
        File file = new File(filename);
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
                switch (res[i]){
                    case 0:
//                    int finalI = i;
                        hope = hope.stream().filter(w -> w.notInclude(finalLastWord.getWord().charAt(finalI))).collect(Collectors.toList());
                        break;
                    case 1:
                        hope = hope.stream().filter(w -> w.getWord().charAt(finalI) == finalLastWord.getWord().charAt(finalI)).collect(Collectors.toList());
                        break;
                    case 2:
                        hope = hope.stream().filter(w -> w.notLocate(finalLastWord.getWord().charAt(finalI), finalI)).collect(Collectors.toList());
                        break;
                }
            }
            lastWord = hope.get(0);
            System.out.println(hope.get(0).getWord() + "  size: " + hope.size());
            if (hope.size() > 1) {
                res = pattern.result();
            }
        }




        System.out.println(hope.size());

    }

}
