class StringIterator {

    String word;
    int index;
    int currLen;
    int len;

    public StringIterator(String compressedString) {

        this.word = compressedString;
        this.index = 0;
        this.currLen = 0;
        this.len = getLength(0,compressedString);
        
    }
    
    public char next() {

        if(currLen < len){
            currLen++;
            return word.charAt(index);
        }
        update();
        if(index < word.length()){
            currLen++;
            return word.charAt(index);
        }

        return ' ';
        
    }
    
    public boolean hasNext() {

        if(currLen < len){
            return true;
        }

        return index < word.length();
        
    }

    private int getLength(int index, String word){
        int s = index+1;
        String count = "";

        while(word.charAt(s) <= '9' && word.charAt(s) >= '0'){
            count = count + String.valueOf(word.charAt(s));
            s++;
        }

        return Integer.valueOf(count);
    }

    private void update(){
        currLen = 0;
        index = index+1;

        while(index < word.length() && word.charAt(index) >= '0' && word.charAt(index) <= '9'){
            index++;
        }

        if(index < word.length()){
            len = getLength(index, word);
        }else{
            len = -1;
        }
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
