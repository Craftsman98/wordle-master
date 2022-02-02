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
}
