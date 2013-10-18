
//rotate tree to make a binary search tree balanced 
//raise the left child, make it the new root
public void rotateRight(TreeNode root) {
  	if (root == null|| root.left == null) {
  		  System.out.error("You can't rotate that tree.");
  	}
  	
  	TreeNode leftChild = root.left;
  	root.left = leftChild.right;
  	leftChild.right = root;
  	root = leftChild;
}


//rotate tree to make a binary search tree balanced 
//raise the right child, make it the new root
public void rotateLeft(TreeNode root) {
  	if (root == null|| root.right == null) {
  		  System.out.error("You can't rotate that tree.");
  	}
  	
  	TreeNode rightChild = root.right;
  	root.right = rightChild.left;
  	rightChild.left = root;
  	root = rightChild;
}
