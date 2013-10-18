
public int diameter(TreeNode tree){
     /* base case where tree is empty */
     if (tree == null)
        return 0;
    
      /* get the height of left and right sub-trees */
      int lheight = depth(tree.left);
      int rheight = height(tree.right);
      
      /* get the diameter of left and right sub-trees */
      int ldiameter = diameter(tree.left);
      int rdiameter = diameter(tree.right);
      
      /* Return max of following three
       1) Diameter of left subtree
       2) Diameter of right subtree
       3) Height of left subtree + height of right subtree + 1 
       */
      return max(lheight + rheight + 1, max(ldiameter, rdiameter));
} 
