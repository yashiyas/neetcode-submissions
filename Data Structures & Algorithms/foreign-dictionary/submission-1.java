class Solution {
    public String foreignDictionary(String[] words) {

        Set<List<Character>> order = new HashSet();
        

        Map<Character,List<Character>> adjList = new HashMap();

        String ans = "";

        List<Character> sortOrder = new ArrayList();

        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                String word1 = words[i];
                String word2 = words[j];
                if(!createOrder(word1,word2,order)){
                    return "";
                }
            }
        }

        print(order);

        Map<Character,Integer> outEdges = new HashMap();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new ArrayList<>());
                outEdges.putIfAbsent(c, 0);
            }
        }

        for(List<Character> curr: order){
            Character c1 = curr.get(0);
            Character c2 = curr.get(1);

            if(!adjList.containsKey(c1)){
                adjList.put(c1,new ArrayList());
            }
            if(!adjList.containsKey(c2)){
                 adjList.put(c2,new ArrayList());
            }

            if(!outEdges.containsKey(c1)){
                outEdges.put(c1,0);
            }

            if(!outEdges.containsKey(c2)){
                outEdges.put(c2,0);
            }

            adjList.get(c1).add(c2);
            outEdges.put(c2,outEdges.get(c2)+1);
        }

        System.out.println(adjList);

        Queue<Character> queue = new LinkedList();

        for(Map.Entry<Character,Integer> entry: outEdges.entrySet()){
            String c = String.valueOf(entry.getKey());
            String val = String.valueOf(entry.getValue());
            System.out.println(c+" "+val);
            if(entry.getValue() == 0){
                queue.offer(entry.getKey());
            }
        }

        while(!queue.isEmpty()){
            Character c = queue.poll();
            ans=ans+String.valueOf(c);
            for(Character ch: adjList.get(c)){
                int num = outEdges.get(ch) - 1;
                outEdges.put(ch,num);
                if(num == 0){
                    queue.offer(ch);
                }
            }
        }

        for(Map.Entry<Character,Integer> entry: outEdges.entrySet()){
            if(entry.getValue() != 0){
                return "";
            }
        }

        return ans;
    
      
    }

    private boolean createOrder(String word1, String word2, Set<List<Character>> order){
        int n = Math.min(word1.length(), word2.length());

        for(int i=0; i<n; i++){
            if(word1.charAt(i) != word2.charAt(i)){
                order.add(List.of(word1.charAt(i), word2.charAt(i)));
                return true;
            }
        }

        if(word1.length() > word2.length()){
            return false;
        }

        return true;
    }

    private void print(Set<List<Character>> order){
        for(List<Character> ch: order){
            String c1 = String.valueOf(ch.get(0));
            String c2 = String.valueOf(ch.get(1));
            System.out.println(c1+" "+c2);
        }
    }
}
