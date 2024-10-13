package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static int idx=-1;
    private TreeNode root;

    private static class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data=data;
        }

    }
    public TreeNode buildTree(int nodes[]){
       idx++;
       if(nodes[idx]==-1){
           return null;
       }
       TreeNode node=new TreeNode(nodes[idx]);
       node.left = buildTree(nodes);
       node.right = buildTree(nodes);
       return node;

    }
    public void createTree(){
        TreeNode first= new TreeNode(1);
        TreeNode second= new TreeNode(2);
        TreeNode third= new TreeNode(3);
        TreeNode fourth= new TreeNode(4);
        TreeNode fifth= new TreeNode(5);
        TreeNode sixth= new TreeNode(6);
        TreeNode seventh= new TreeNode(7);
        root=first;
        first.left=second;
        first.right=third;
        second.left=fourth;
        second.right=fifth;
        third.left=sixth;
        third.right=seventh;
    }
    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ->");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void postOrder(TreeNode root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ->");
    }
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        System.out.print(root.data+" ->");
        postOrder(root.right);

    }
    public void levelOrdertraverse(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            System.out.print(temp.data+"->");
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
    }
    public void levelOrderTravels(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            if(node==null){
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }else{
                    queue.add(null);
                }
            }else {
                System.out.print(node.data+" ");
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }

        }

    }
    public int countNode(TreeNode root){
        if(root==null){
            return 0;
        }
        int left= countNode(root.left);
        int right= countNode(root.right);
        return left+right+1;
    }
    public int sumOfNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSum= sumOfNodes(root.left);
        int rightSum= sumOfNodes(root.right);
        return leftSum+rightSum+root.data;
    }
    public int hightOfTree(TreeNode root){
        if(root==null){
           return 0;
        }
        int left=countNode(root.left);
        int right= countNode(root.right);
        return Math.max(left,right);
    }
    public boolean isSubtree(TreeNode tree,TreeNode subTree){
     return false;
    }
    public int findMaxValue(TreeNode root){

        if(root==null){
            return Integer.MIN_VALUE;
        }
        int result=root.data;
        int left= findMaxValue(root.left);
        int right=findMaxValue(root.right);
        if(result<left){
            result=left;
        }
        if(result<right)
            result=right;
        return result;
    }
    public static void main(String args[]){
        BinaryTree tree= new BinaryTree();
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

       TreeNode node= tree.buildTree(nodes);
       System.out.println("//////"+node.data);
        //tree.createTree();
       // tree.preOrder(node);
        //tree.postOrder(tree.root);
        // tree.inOrder(tree.root);
        tree.levelOrderTravels(node);
        System.out.println("total no of nods in tree are: "+tree.countNode(node));
        System.out.println("sum  of nods in tree are: "+tree.sumOfNodes(node));
        System.out.println("Hight of tree is: "+tree.hightOfTree(node));
        //System.out.print("Maximum value in tree "+tree.findMaxValue(tree.root));
    }
}
