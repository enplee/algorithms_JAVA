package enplee.algorithms.ag4java;

import javax.print.attribute.standard.NumberOfDocuments;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>,Value> {
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int N;

        public Node(Key key,Value val,int N){
            this.key = key;this.value = val;this.N = N;
        }
    }
    public int size(){
        return size(root);
    }

    public int size(Node node){
        if(node==null) return 0;
        return node.N;
    }

    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node node,Key key){
        if(node==null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp<0) return get(node.left,key);
        else if(cmp>0) return get(node.right,key);
        else return node.value;
    }

    public void put(Key key,Value val){
        root = put(root,key,val);
    }
    private Node put(Node node,Key key,Value val){
        if(node==null) return new Node(key,val,1);
        int cmp = key.compareTo(node.key);
        if(cmp<0) node.left = put(node.left,key,val);
        else if(cmp>0) node.right = put(node.right,key,val);
        else node.value = val;
        node.N = size(node.left)+size(node.right)+1;
        return node;
    }

    public Key min(){
        return min(root).key;
    }
    private Node min(Node root){
        if(root==null) return null;
        if(root.left!=null) return min(root.left);
        return root;
    }

    public Key max(){
        return max(root).key;
    }
    private Node max(Node root){
        if(root==null) return null;
        if(root.right!=null) return min(root.right);
        return root;
    }

    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node node){
        if(node==null) return null;
        if(node.left==null) return node.right;
        node.left = deleteMin(node.left);
        node.N = size(node.left)+size(node.right)+1;
        return node;
    }

    public void deleteMax(){
        root = deleteMax(root);
    }
    private Node deleteMax(Node node){
        if(node==null) return null;
        if(node.right==null) return node.left;
        node.right = deleteMax(node);
        node.N = size(node.left)+size(node.right)+1;
        return node;
    }

    public void delete(Key key){
        root = delete(root,key);
    }
    private Node delete(Node node,Key key){
        if(node==null) return null;
        if(key.compareTo(node.key)<0) {node.left = delete(node.left,key);}
        else if(key.compareTo(node.key)>0) {node.right = delete(node.right,key);}
        else {
            if(node.left==null) return root.right;
            if(node.right==null) return root.left;
            /*Node temp = node;
            node = min(node.right);
            node.right = deleteMax(temp.right);
            node.left  = temp.left;*/
            Node temp = min(node.right);
            node.key =temp.key;
            node.right = deleteMax(node.right); // 自己的想法，这样感觉逻辑更加清晰
        }
        node.N = size(node.left)+size(node.right)+1;
        return node;
    }

    public Iterable<Key> keys(){
        return keys(min(),max());
    }
    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue = new LinkedList<>();
        keys(root,queue,lo,hi);
        return queue;
    }
    private void keys(Node node ,Queue<Key> queue,Key lo,Key hi){
        if(node == null) return;
        int cmplo = lo.compareTo(node.key);
        int cmphi = hi.compareTo(node.key);
        if(cmphi<0) keys(node.left,queue,lo,hi);
        if(cmplo>0) keys(node.right,queue,lo,hi);
        if(cmphi>=0 && cmplo<=0) queue.add(node.key);
    }

}
