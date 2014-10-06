import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(root == null){
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null){
                node = node.right;
                while(node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args){
	TreeNode root = new TreeNode(3);
	TreeNode first = new TreeNode(1);
	TreeNode second = new TreeNode(2);
	
	root.right = first;
	first.left = second;
	
	System.out.println(BinaryTreeInorderTraversal.inorderTraversal(root));
    }
}
