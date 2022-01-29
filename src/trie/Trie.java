package trie;

public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for(char ch:word.toCharArray()) {
            if(!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    //searching complete word
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd();
    }

    //searching just the prefix
    private boolean startsWith(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(char ch:word.toCharArray()) {
            if(node.containsKey(ch)) {
                node=node.get(ch);
            } else {
                return null;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("shivaranjan");
        trie.insert("shashikumar");
        System.out.println("should return true "+trie.startsWith("shiv".toLowerCase()));
        System.out.println("should return false "+trie.search("shashi".toLowerCase()));
    }
}
