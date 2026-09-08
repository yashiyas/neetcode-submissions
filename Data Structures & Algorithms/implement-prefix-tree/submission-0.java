class PrefixTree {

    TrieNode root;

    public PrefixTree() {
         this.root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;

        for(int i=0; i<word.length(); i++){
            Character character = word.charAt(i);
            if(curr.children.containsKey(character)){
                curr = curr.children.get(character);
            } else{
                curr.children.put(character, new TrieNode());
                curr = curr.children.get(character);
            }
        }

        curr.word = true;

    }

    public boolean search(String word) {

        TrieNode curr = root;

        for(int i=0; i<word.length(); i++){
            Character character = word.charAt(i);
            if(curr.children.containsKey(character)){
                curr = curr.children.get(character);
            } else{
                return false;
            }
        }

        return curr.word;

    }

    public boolean startsWith(String prefix) {

        TrieNode curr = root;

        for(int i=0; i<prefix.length(); i++){
            Character character = prefix.charAt(i);
            if(curr.children.containsKey(character)){
                curr = curr.children.get(character);
            } else{
                return false;
            }
        }

        return true;

    }

    class TrieNode {
    boolean word; 
    Map<Character, TrieNode> children = new HashMap<>();
}
}
