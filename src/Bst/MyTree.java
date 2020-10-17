package Bst;


import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 张烈文
 */
public class MyTree<E extends  Comparable<E>> {


    private Node root;
    private int size;


    private class Node {

        public E e;
        public Node left, right;

        public Node() {
            this.e = null;
            this.left = null;
            this.right = null;
        }
        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;

        }
    }

    /**
     * 判断该二叉树是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;

    }

    /**
     * 返回该二叉树的节点个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 供用户使用的添加元素的方法
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }


    /**
     * 用户不可见添加操作
     * 具体实现逻辑：
     * 1.先判断该二叉树是否为空,倘若为空，则新创建一个节点，并且size++
     * 2.将传进元素与该节点元素相比较，以此进行递归，来实现添加一个元素
     *
     * 注意：为什么要在方法中判断该节点是否为空？
     *      1.主要为了防止报空指针异常
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {
        if (node == null) {
            node = new Node();
            node.e = e;
            size++;
            return node;
        }

        if (e.compareTo(node.e)<0){
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }


    /**
     * 判断该二叉树中是否有某个元素
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     *
     * 1.先判断传入节点是否为空，若为空则直接返回为false
     * 2.递归调用该二叉树并将传入节点的元素与传入元素进行比较
     * 3.
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else if (e.compareTo(node.e) == 0) {
            return true;
        }

        return false;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历
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
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     *后序遍历
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
     * 层序遍历使用非递归写法
     * 注意事项：重点是使用队列来实现
     * 主要实现思路：
     * 1.先将根节点加入到队列中，然后用一个循环使，先删除队列中的队首元素
     * 2.然后再添加该节点的左右节点进去，然后再该队列中就有了新的节点，再进入新的一次循环
     * 3.同样删除队首元素，并输出，再添加进删除节点的左右子树节点，此时队首的新元素是上一个节点的右子树节点
     * 4.以此类推
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
     * 寻找二叉树中最小元素
     * @return
     */
    public E min() {
        return min(root).e;
    }


    /**
     * 寻找二叉树中的最小元素
     * @return
     */
    private Node min(Node node) {
        if (root == null) {
            throw new IllegalArgumentException("This Tree is Empty");
        }
        if (node.left != null) {
            return min(node.left);
        }

        return node;
    }


    /**
     * 寻找二叉树最大元素
     * @return
     */
    public E max() {
        return max(root).e;
    }

    /**
     * 寻找二叉树中的最大元素
     * @param node
     * @return
     */
    private Node max(Node node) {
        if (root == null) {
            throw new IllegalArgumentException("This Tree is Empty");
        }

        if (node.right != null) {
            return max(node.right);
        }
        return node;
    }


    /**
     * 移除二叉树中的最小元素，并返回该元素
     * @return
     */
    public E removeMin() {
        root = removeMin(root);

        return min();
    }

    /**
     *
     * 移除最小元素
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            return rightNode;
        }

        node.left=removeMin(node.left);
        return node;
    }


    /**
     * 移除二叉树中的最大元素，并返回该元素
     * @return
     */
    public E removeMax() {
        root = removeMax(root);

        return max();
    }

    /**
     *
     * 移除最大元素
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            return leftNode;
        }

        node.right=removeMin(node.right);
        return node;
    }


    public void remove(E e) {
        root = remove(root, e);
    }


    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }


        //一开始两个if判断代表着寻找该元素是否存在
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
        }else{

        //待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                return leftNode;
            }

        //待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                return rightNode;
            }

            //待删除节点左右都不为空的情况
            Node successor = min(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
        return node;

    }


}


