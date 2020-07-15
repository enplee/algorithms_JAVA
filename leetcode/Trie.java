package enplee.algorithms_JAVA.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 *  基于java 的前缀树实现
 */
public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode temp = this.root;

        for(char c : word.toCharArray()){
            int idx = c-'a';
            if(temp.children[idx]==null) temp.children[idx] = new TrieNode();
            temp = temp.children[idx];
        }
        temp.isWordEnd = true;
    }

    public void reverseInsert(String word){
        TrieNode temp = this.root;

        for(int i=word.length()-1;i>=0;i--){
            int idx = word.charAt(i)-'a';
            if(temp.children[idx]==null) temp.children[idx] = new TrieNode();
            temp = temp.children[idx];
        }
        temp.isWordEnd = true;
    }

    public boolean search(String word){
        TrieNode temp = this.root;

        for(char c: word.toCharArray()){
            int idx = c-'a';
            if(temp.children[idx]==null){
                return false;
            }
            temp = temp.children[idx];
        }

        return temp.isWordEnd;
    }

    public List<Integer> search(String sentence,int endPos){
        TrieNode temp = this.root;
        List<Integer> idxList = new LinkedList<>();

        for(int i=endPos;i>=0;i--){
            int idx = sentence.charAt(i)-'a';
            if(temp.children[idx]==null) break;
            if(temp.children[idx].isWordEnd) idxList.add(i);
            temp = temp.children[idx];
        }
        return idxList;
    }

    class TrieNode{
        boolean isWordEnd = false;
        TrieNode[] children = new TrieNode[26];
    }
}
