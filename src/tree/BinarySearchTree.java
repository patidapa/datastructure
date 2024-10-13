package tree;

import java.util.ArrayList;

public class BinarySearchTree {
    private TreeNode root;

    private static class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data=data;
        }

    }
    public void insert(int data){
        root=insertNode(root, data);
    }
    public TreeNode insertNode(TreeNode root, int data){
        if(root==null){
            root=new TreeNode(data);
            return root;
        }
        if(data<root.data){
         root.left=insertNode(root.left,data);
        }else{
            root.right= insertNode(root.right,data);
        }
        return root;
    }
    public boolean searchValue(TreeNode node, int value){
        boolean isPresent=false;
        if(node==null || node.data==value) {
            return isPresent=true;
        }
        if(value<node.data){
            isPresent= searchValue(node.left,value);
        }else{
            isPresent= searchValue(node.right,value);
        }
        return isPresent;
    }
    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ->");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ->");
        inOrder(root.right);

    }
    public TreeNode deleteNode(TreeNode root,int val){
      if(root.data>val){
          root.left= deleteNode(root.left,val);
      }else if(root.data<val){
          root.right= deleteNode(root.right,val);
      }else{
          if(root.left==null && root.right==null){
              return null;
          } else if (root.left==null) {
              return root.right;
          }else if(root.right==null){
              return root.left;
          }
          TreeNode IS= inOrderSuccesser(root.right);
          root.data= IS.data;
          root.right= deleteNode(root.right,IS.data);
      }
      return root;
    }
    public TreeNode inOrderSuccesser(TreeNode node){
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
    public void printNodesBetweenNode(int x,int y,TreeNode root){
        if(root==null){
            return;
        }
        if( root.data>=x && root.data  <= y){
            printNodesBetweenNode(x,y,root.left);
            System.out.print(root.data+" ");
            printNodesBetweenNode(x,y,root.right);
        } else if (root.data>=y) {
            printNodesBetweenNode(x,y,root.left);
        }else{
            printNodesBetweenNode(x,y,root.right);
        }
    }
    public void printRoot2leaf(TreeNode root, ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null) {
            printPath(path);
        }else {
            printRoot2leaf(root.left,path);
            printRoot2leaf(root.right,path);
        }
        path.remove(path.size()-1);
    }

    private void printPath(ArrayList<Integer> path) {
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        BinarySearchTree tree= new BinarySearchTree();
        tree.insert(5);
        tree.insert(4);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        //tree.printNodesBetweenNode(3,6,tree.root);
//         tree.inOrder(tree.root);
        tree.deleteNode(tree.root,5);
        System.out.println();
        tree.inOrder(tree.root);
       // tree.printRoot2leaf(tree.root,new ArrayList<>());
         if(tree.searchValue(tree.root,0)){
             System.out.print("Given value is present in tree");
         }else
             System.out.print("Given value is not present in tree");
    }
}
