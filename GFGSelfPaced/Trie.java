package GFGSelfPaced;

class TrieNode {
    TrieNode links[] = new TrieNode[26];
    int cntEndWith=0;
    int cntPrefix=0;
    boolean flag = false;

    public TrieNode() {

    }

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }
    TrieNode get(char ch) {
        return links[ch-'a'];
    }
    void put(char ch, TrieNode node) {
        links[ch-'a'] = node;
    }
    void setEnd() {
        flag = true;
    }
    boolean isEnd() {
        return flag;
    }
    void increaseEnd(){
        cntEndWith++;
    }
    void increasePrefix(){
        cntPrefix++;
    }
    void delEnd(){
        cntEndWith--;
    }
    void reducePrefix(){
        cntPrefix--;
    }
    int getEnd(){
        return cntEndWith;
    }
    int getPrefix(){
        return cntPrefix;
    }


};
public class Trie {
    private static TrieNode root;

    //Initialize your data structure here

    Trie() {
        root = new TrieNode();
    }


    //Inserts a word into the trie

    public static void insert(String word) {
        TrieNode node = root;
        for(int i = 0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }


    //Returns if the word is in the trie
    public static boolean search(String word) {
        TrieNode node = root;
        for(int i = 0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    //Returns if there is any word in the trie that starts with the given prefix
    public static boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0;i<prefix.length();i++) {
            if(!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
    public void insert2(String word) {
        TrieNode node = root;
        for(int i = 0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new TrieNode());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }
    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for(int i = 0;i<word.length();i++) {
            if(node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            }
            else {
                return 0;
            }
        }
        return node.getEnd();
    }
    public int countWordsStartingWith(String word) {
        TrieNode node = root;
        for(int i = 0;i<word.length();i++) {
            if(node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            }
            else {
                return 0;
            }
        }
        return node.getPrefix();
    }
    public void erase(String word) {
        TrieNode node = root;
        for(int i = 0;i<word.length();i++) {
            if(node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reducePrefix();
            }
            else {
                return;
            }
        }
        node.delEnd();
    }
}
