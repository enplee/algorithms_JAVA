package enplee.algorithms.ag4java;

import javax.print.attribute.standard.NumberOfDocuments;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node{
        Key key;
        Value val;
        Node left,right;
        boolean color;
        int N;

        public Node(Key key, Value val, boolean color, int n) {
            this.key = key;
            this.val = val;
            this.color = color;
            N = n;
        }
    }

    private boolean isRED(Node node) {
        if(node==null) return false;
        return node.color==RED;
    }

    public int size(){
        return size(root);
    }
    private int size(Node node){
        return node==null ? 0 : node.N;
    }

    private Node rotateLeft(Node node){
        Node temp = node.right;
        node.right = temp.left;
        temp.color = node.color;
        node.color = RED;
        temp.N = node.N;
        node.N = size(node.left)+size(node.right)+1;
        return temp;
    }
    private Node rotateRight(Node node){
        Node temp = node.left;
        node.left = temp.right;
        temp.color = node.color;
        node.color = RED;
        temp.N = node.N;
        node.N = size(node.left)+size(node.right)+1;
        return temp;
    }
    private void flipColors(Node node){
        node.color = BLACK;
        node.left.color = RED;
        node.right.color = RED;
    }

    public void put(Key key,Value val){
        root = put(root,key,val);
        root.color = BLACK;
    }
    private Node put(Node node,Key key,Value value){
        if(node == null) return new Node(key,value,RED,1);
        int cmp = key.compareTo(node.key);
        if(cmp<0) node.left = put(node.left,key,value);
        else if(cmp>0) node.right = put(node.right,key,value);
        else node.val = value;

        if(!isRED(node.left) && isRED(node.right)) node = rotateLeft(node);
        if(isRED(node.left) && isRED(node.left.left)) node = rotateRight(node);
        if(isRED(node.left) && isRED(node.left)) flipColors(node);
        return node;
    }
}
