package Bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 张烈文
 */
public class BST<E extends Comparable<E>> {


    private class Node{

        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            right = null;
            left = null;
        }
    }


    /**
     * 根节点
     */
    private Node root;
    private int size;

    public BST() {
        size = 0;
        root = null;
    }


    /**
     * 返回节点个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断该二分搜索树是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

//    /**
//     * 判断根节点是否为空
//     * 空则为根节点新创建一个，否则
//     *
//     * @param e
//     */
//    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        }else{
//            add(root, e);
//        }
//    }


    /**
     * 配合简单版的递归函数进行
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

//    /**
//     * 该方式较为繁琐
//     * 向以node为根的二分搜索树中插入元素E，递归算法
//     *
//     * @param node
//     * @param e
//     */
//    private void add(Node node, E e) {
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        }else{
//            add(node.right, e);
//        }
//    }


    /**
     * 较上一种方式较为简单，但理解比较困难
     * @param node
     * @param e
     * @return
     */


    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);

        }
        return node;
    }



    /**
     *查询树中是否存在该元素
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的树中是否包含元素e，递归算法
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left,e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        }
        return false;
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }


    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     * @param node
     */

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 使用非递归前序遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);

            }
        }
    }
    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树，递归算法
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    /**
     * 层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue != null) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     * @return
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return minimum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }


    /**
     * 寻找二分搜索树的最大元素
     * @return
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }


    /**
     * 从二分搜索树中删除最小值所在节点，返回最小值
     *调用前面写好的minimum()函数
     *
     * @return
     */
    public E removeMin() {
        E ret = minimum();
        root=removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * 逻辑实现:
     * 1.当当前节点的左子树为空时，而右子树又不为空时
     * 2.先将当前节点的右子树节点保存
     * 3.而后将当前节点的右子树为空，这样就相当于将当前节点与它的右子树脱离,
     *   以便使它的右子树节点重新接入到根节点的左子树且需要进行size--
     * 特别说明：当当前节点左右子树都为空时，上述步骤依然是满足的，只不过这样返回的右节点是为空，
     *         这样根节点的左子树同样为空
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

//        此处递归调用比较巧妙
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 返回要移除节点的元素
     * 并重新设置根节点的值
     * @return
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的最大节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }


    /**
     * 从二分搜索数中删除元素为e的节点
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);

        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
        }else {
//            待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
//            待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //            待删除节点左右子树均不为空的情况
//            找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
//            用这个节点顶替待删除节点的位置

            Node successor = minimum(node.right);    //此处代表找到当前节点右子树中最小节点，当前节点的后继
            successor.right = removeMin(node.right);  //后继节点的右子树
            successor.left = node.left; //后继节点的左子树就等于原来节点的左子树
            node.left = node.right = null;  //当前节点左右子树为空，以便于虚拟机回收
            return successor;


        }
        return node;

////            待删除节点左右子树均不为空的情况
////            找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
////            用这个节点顶替待删除节点的位置
//
//            Node successor = minimum(node.right);    //此处代表找到当前节点右子树中最小节点，当前节点的后继
//            successor.right = removeMin(node.right);  //后继节点的右子树
//            successor.left = node.left; //后继节点的左子树就等于原来节点的左子树
//            node.left = node.right = null;  //当前节点左右子树为空，以便于虚拟机回收
//            return successor;

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");

        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }


    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("__");
        }
        return res.toString();
    }



}
