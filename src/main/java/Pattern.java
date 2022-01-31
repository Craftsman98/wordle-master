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
        boolean isNum = true;
        this.pattern = new int[5];
        while (s.length() != 5 || !isNum){
            System.out.println("输入单词判定结果：0为灰色，1为绿色，2为黄色。例如10120。");
            Scanner scanner = new Scanner(System.in);
            s = scanner.nextLine();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < '0' || s.charAt(i) > '2'){
                    isNum = false;
                    break;
                }
                pattern[i] = s.charAt(i) - '0';
            }
        }

        return pattern;
    }
}
