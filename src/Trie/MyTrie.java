package Trie;

import Bst.MyTree;

import java.util.TreeMap;

/**
 * @author 张烈文
 */
public class MyTrie {


    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }
    private Node root;
    private int size;

    public MyTrie() {
        root = new Node();
        size = 0;
    }

    /**
     * 添加一个单词
     * @param s
     */
    public void add(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }


    /**
     * 判断字典树中是否存在某个单词
     * @param s
     * @return
     */
    public boolean contains(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    /**
     * 判断字典树中是否存在该前缀
     * @param s
     * @return
     */
    public boolean prefix(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
