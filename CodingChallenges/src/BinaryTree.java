
public class BinaryTree {
	boolean checkBST(Node root) {        
	    return checkNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE); // start with an infinite range
	}

	boolean checkNode(Node node, int min, int max) {
	    return node == null 
	        || node.data > min && node.data < max // validate if the value is within the allowed range
	        && checkNode(node.left, min, node.data) // check the left child decreasing the end of the allowed range to the current value
	        && checkNode(node.right, node.data, max); // check the right child increasing the beginning of the range to the current value 
	}
}

class Node {
	int data;
	Node left;
	Node right;
}
