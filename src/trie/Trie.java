package trie;

import tree.BinaryTree;

public class Trie {

    static class Node{
        Node[] children =new Node[26];
        boolean eow;
        public Node(){
         for(int i=0;i<26;i++){
             children[i]=null;
         }
        }
    }
    static Node root=new Node();
    public void insert(String word){
       Node current=root;
        for(int i=0;i<word.length();i++){
            int idx= word.charAt(i)-'a';
            if (current.children[idx]==null){
                current.children[idx]=new Node();
            }
            current=current.children[idx];
        }
        current.eow=true;
    }
    public boolean search(String word){
        Node current=root;
        for(int i=0;i<word.length();i++) {
            int idx = word.charAt(i) - 'a';
            Node node=current.children[idx];
            if(current.children[idx]==null){
                return false;
            }
            if(i==word.length()-1 && !current.children[idx].eow){
                return false;
            }
            current=current.children[idx];
        }
        return true;
    }
    public boolean wordBreak(String word){
        if(word.length()==0){
            return true;
        }
        for(int i=1;i<=word.length();i++){
            String first=word.substring(0,i);
            String second= word.substring(i);
            if(search(first) && wordBreak(second) ){
                return true;
            }
        }
        return false;
    }
    public boolean startWith(String prefix){
        Node current=root;
        for(int i=0;i<prefix.length();i++){
            int idx= prefix.charAt(i)-'a';
            if(current.children[idx]==null){
                return false;
            }
            current=current.children[idx];
        }
        return true;
    }
    public int countSubstring(String word){
        for(int i=0;i<word.length();i++) {
            String string = word.substring(i);
            insert(string);
        }
        return countNode(root);
    }
    public int countNode(Node root){
        int count=0;
        if(root==null){
            return 0;
        }
        for (int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+= countNode(root.children[i]);
            }
        }
        return count+1;
    }
    public static void main(String args[]){
        Trie trie=new Trie();
//        trie.insert("i");
//        trie.insert("like");
//        trie.insert("sam");
//        trie.insert("samsung");
//        trie.insert("apple");
//        trie.insert("monsoon");
//        trie.insert("there");
//        trie.insert("their");
//        System.out.println("Given word is found: "+trie.search("there"));
//        System.out.println("Given word matched : "+trie.wordBreak("ilike"));
//        System.out.println("Given word is prefix  : "+trie.startWith("the"));
        System.out.println("Total count of substring : "+trie.countSubstring("ababa"));
    }

}
