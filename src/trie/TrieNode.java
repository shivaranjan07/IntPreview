package trie;

//using array of 26 characters
public class TrieNode {
    public static final int N=26;
    public TrieNode[] children;
    public boolean isEnd;

    public TrieNode() {
         children = new TrieNode[N];
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public void setEnd() {
        this.isEnd = true;
    }
}

/** Usage:
 *  Initialization: TrieNode root = new TrieNode();
 *  Return a specific child node with char c: root.children[c - 'a']
 */

