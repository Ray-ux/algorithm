package Trie;

import java.util.TreeMap;

/**
 * @author 张烈文
 */
public class Trie {

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

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获取Trie中存储的单词数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 向Trie中添加一个新的单词word
     * 不会添加重复的单词
     * 可以使用递归
     * @param word
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
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


//    public void addCur(String word) {
//        addCur(root, word,0);
//    }
//    private Node addCur(Node node,String word,int i) {
//        char c = word.charAt(i);
//        if (node.next.get(c) == null) {
//            addCur(node.next.put(c,new Node()),word,i++);
//        }
//
//
//    }

    /**
     * 查询单词word是否在Trie中
     * isWord的重要性
     * 可以使用递归
     * @return
     */

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }else{
                cur = cur.next.get(c);
            }
        }
        return cur.isWord;
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

}
