class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character,Integer> reqFreq = new HashMap();

        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            reqFreq.put(c, reqFreq.getOrDefault(c,0)+1);
        }

        Map<Character, Integer> currWindow = new HashMap();

        int i=0;
        String ans = "";

        while( i<s.length() && !reqFreq.containsKey(s.charAt(i))){
            i++;
        }

        int j=i;

        while(j< s.length()){
            char c = s.charAt(j);
            if(reqFreq.containsKey(c)){
                int f =  currWindow.getOrDefault(c,0)+1;
                currWindow.put(c, f);
                System.out.println(String.format("%c %d", c, f));
                if(validWindow(currWindow, reqFreq)){
                    System.out.println("Valid window");
                    System.out.println(i);
                    System.out.println(j);
                    if(ans == "" || ans.length() > j-i+1){
                        ans = s.substring(i,j+1);
                    }
                    while(i<s.length()){
                         if(!reqFreq.containsKey(s.charAt((i)))){
                            i++;
                         }
                        else if(validWindow(currWindow, reqFreq)){
                             if(ans == "" || ans.length() > j-i+1){
                                    ans = s.substring(i,j+1);
                             }
                            char c2 = s.charAt(i);
                            int c2Freq = currWindow.get(c2) - 1;
                            if(c2Freq == 0){
                                currWindow.remove(c2);
                            }
                            else{
                                currWindow.put(c2, c2Freq);
                            }
                            i++;
                        } else{
                            break;
                        }
                    }

                    if(i>=s.length()){
                        break;
                    }
                    System.out.println("new i::");
                    System.out.println(i);
                    j++;
                }
                else{
                    j++;
                }
            } else{
                j++;
            }
        }

        return ans;
    }

    private boolean validWindow(Map<Character,Integer> currFreq,Map<Character,Integer> reqFreq){
        if(currFreq.size() != reqFreq.size()){
            return false;
        }

        for(Map.Entry<Character,Integer> en: reqFreq.entrySet()){
            char key = en.getKey();
            int freq = en.getValue();

            if(!currFreq.containsKey(key) || (currFreq.getOrDefault(key,0) < freq)){
                return false;
            }
        }
        return true;
    }
}
