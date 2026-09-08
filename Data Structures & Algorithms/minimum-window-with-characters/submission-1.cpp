class Solution {
public:
    string minWindow(string s, string t) {
        if(t.length() > s.length()){
            return "";
        }

        int start = 0;
        int end = INT_MAX;

        map<char,int> requiredChar;
        for(int i=0; i<t.length(); i++){
            requiredChar[t.at(i)]++;
        }

        int r = t.size();

        int i=0;
        int j=0;

        while(j < s.length()){
            char c = s.at(j);
            if(requiredChar[c] > 0){
                r--;
            }
            requiredChar[s[j]]--;
            j++;
            
            while(r == 0){
                if(j-i < end-start){
                    start = i;
                    end = j;
                }
                requiredChar[s[i]]++;
                if(requiredChar[s[i]] > 0){
                    r++;
                }
                i++;
            }
        }

        if(end != INT_MAX){
            return s.substr(start, end-start);
        }

        return "";

    }
};
