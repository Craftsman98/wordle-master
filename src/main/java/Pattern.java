import java.io.IOException;
import java.util.Scanner;

public class Pattern {

    private int[] pattern;


    /**
     * 输入wordle结果，五位数字组成。
     * 0：The letter is not in the word in any spot.
     * 1：The letter is in the word and in the correct spot.
     * 2：The letter is in the word but in the wrong spot.
     * @return  int数组
     */
    public int[] result(){
        String s = "";
        while (input(s) == null){
            System.out.println("输入单词判定结果：0为灰色，1为黄色，2为绿色。例如10120。");
            Scanner scanner = new Scanner(System.in);
            s = scanner.nextLine();
        }
        pattern = input(s);
        return pattern;
    }

    public int[] input(String s){
        if (s.length() != 5) return null;
        int[] res = new int[5];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '2') {
                return null;
            }
            res[i] = s.charAt(i) - '0';
        }
        return res;
    }

    public int[] getPattern() {
        return pattern;
    }
}
