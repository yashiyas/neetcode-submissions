class Solution {
public:
    int minDistance(string word1, string word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        return findDistance(word1,word2,n1,n2);
    }

    int findDistance(string word1, string word2, int n1, int n2){
        if(n1 == 0){
            return n2;
        }

        if(n2 == 0){
            return n1;
        }

        if(word1[n1-1] == word2[n2-1]){
            return findDistance(word1, word2, n1-1, n2-1);
        }

        int insert = 1+findDistance(word1, word2, n1, n2-1);
        int del = 1+findDistance(word1, word2, n1-1, n2);
        int repl = 1+findDistance(word1, word2, n1-1, n2-1);
        int res = min(insert,del);
        res = min(res, repl);
        return res;
    }
};
