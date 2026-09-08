class WordDictionary {

    TrieNode root;

    public WordDictionary() {

        this.root = new TrieNode();

    }

    public void addWord(String word) {

        TrieNode curr = root;

        for(int i=0; i<word.length(); i++){
            Character ch = word.charAt(i);
            if(curr.children.containsKey(ch)){
                curr = curr.children.get(ch);
            } else{
                curr.children.put(ch, new TrieNode());
                curr = curr.children.get(ch);
            }
        }

        curr.word = true;

    }

    public boolean search(String word) {

        return isPresent(word, root);

    }

    public boolean isPresent(String word, TrieNode curr){

        int n = word.length();

        if(word.isEmpty()){
            return curr.word;
        }

        Character ch = word.charAt(0);

        if(ch!='.'){
            if(curr.children.containsKey(ch)){
                return isPresent(word.substring(1),curr.children.get(ch));
            }
            else{
                return false;
            }
        }else{
            boolean res = false;
            for(Map.Entry<Character, TrieNode> entry: curr.children.entrySet()){
                res = res || isPresent(word.substring(1, n), entry.getValue());
                if(res){
                    return res;
                }
            }
            return res;
        }

    }

    class TrieNode{
        Map<Character, TrieNode> children;
        boolean word;

        TrieNode(){
            this.children = new HashMap();
            this.word = false;
        }
    }
}
