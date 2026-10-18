class Pair{
    String word;
    int steps;
    Pair(String w,int s){
        word = w;
        steps = s;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>words = new HashSet<>();
        for(String word:wordList){
            words.add(word);
        }
        Queue<Pair>queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        words.remove(beginWord);
        while(!queue.isEmpty()){
            Pair curPair = queue.remove();
            String curWord = curPair.word;
            int steps = curPair.steps;
            if(curWord.equals(endWord))
                return steps;
            for(int i=0;i<curWord.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char arr[] = curWord.toCharArray();
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if(words.contains(newWord)){
                        words.remove(newWord);
                        queue.add(new Pair(newWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
