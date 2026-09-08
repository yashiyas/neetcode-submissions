class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int s = s1.length();
        for(int i=0; i<= s2.length()-s; i++){
            if(checkIfPermutation(i, i+s-1, s1, s2)){
                return true;
            }
        }
        return false;
    }
    bool checkIfPermutation(int start, int end, string s1, string s2){
       string s3 = s2.substr(start, s1.size());
       string s4 = s1;
       sort(s4.begin(), s4.end());
       sort(s3.begin(), s3.end());
       return s3==s4;
    }
};
