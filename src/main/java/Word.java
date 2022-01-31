public class Word {
    private final char[] word;

    Word(String word){
        this.word = word.toCharArray();
    }

    public char[] getWord(){
        return this.word;
    }
}
