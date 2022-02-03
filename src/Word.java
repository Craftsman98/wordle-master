package src;
public class Word {
    private final String word;

    Word(String word){
        this.word = word;
    }

    public boolean notInclude(char c){
        return !word.contains(String.valueOf(c));
    }

    public boolean notLocate(char c, int i){
        return word.contains(String.valueOf(c)) && word.charAt(i) != c;
    }

    public String getWord(){
        return this.word;
    }
    public boolean isValid() {
        if (word.length() != 5) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
                return false;
            }
        }
        return true;
    }
}
