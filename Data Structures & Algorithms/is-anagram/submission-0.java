class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> m = new HashMap<>();
        for(int c=0; c< s.length(); c++){
            Character character = s.charAt(c);
            if(m.containsKey(character)){
                int num = m.get(character) + 1;
                m.put(character, num);
            }
            else{
                m.put(character, 1);
            }
        }
        for(int c=0; c< t.length(); c++){
            char character = t.charAt(c);
            if(!m.containsKey(character)){
                return false;
            }
            else{
                int num = m.get(character);
                num = num - 1;
                if(num == 0){
                    m.remove(character);
                }
                else{
                m.put(character, num);
                }
            }
        }
        return m.isEmpty();
    }
}
