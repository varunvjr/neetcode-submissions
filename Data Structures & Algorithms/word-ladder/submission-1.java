class Pair{
    String word;
    int step;
    public Pair(String word,int step){
        this.word = word;
        this.step = step;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair>queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        while(!queue.isEmpty()){
            Pair pair = queue.remove();
            String curWord = pair.word;
            int curStep = pair.step;
            if(curWord.equals(endWord)){
                return curStep;
            }
            for(int i = 0;i<curWord.length();i++){
                char wordArr[] = curWord.toCharArray();
                for(char ch = 'a';ch<='z';ch++){
                    wordArr[i] = ch;
                    String temp = new String(wordArr);
                    if(wordList.contains(temp)){
                        queue.add(new Pair(temp,curStep+1));
                        wordList.remove(temp);
                    }
                }
            }
        }
        return 0;
    }
}
