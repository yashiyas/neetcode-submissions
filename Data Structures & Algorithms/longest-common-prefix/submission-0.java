class Solution {
    public String longestCommonPrefix(String[] strs) {

        Trie trie = new Trie();

        for(int i=0; i<strs.length; i++){
            String word = strs[i];
            Trie curr = trie;
            for(int j=0; j<word.length(); j++){
                if(!curr.child.containsKey(word.charAt(j))){
                    curr.child.put(word.charAt(j), new Trie());
                }
                curr = curr.child.get(word.charAt(j));
            }
            curr.isWord = true;
        }

        String prefix = "";

        Trie curr = trie;

        while(curr.child.size() == 1 && !curr.isWord){
            for(Map.Entry<Character,Trie> entry: curr.child.entrySet()){
                 prefix = prefix + String.valueOf(entry.getKey());
                 curr = entry.getValue();
            }
            
        }

        return prefix;


        
    }

    class Trie{
        Map<Character,Trie> child;
        boolean isWord;

        Trie(){
            this.child = new HashMap();
        }
    }
}