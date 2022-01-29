package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * It is even easier to visit a specific child directly by the corresponding character.
 * But it might be a little slower than using an array. However, it saves some space
 * since we only store the children nodes we need. It is also more flexible because we
 * are not limited by a fixed length and fixed range.
 *
 * */
public class TrieNodeMap {
    public Map<Character, TrieNode> children = new HashMap<>();
}

/** Usage:
 *  Initialization: TrieNode root = new TrieNode();
 *  Return a specific child node with char c: root.children.get(c)
 */
