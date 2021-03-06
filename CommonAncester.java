//bottom up solution recursion

public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
	  if (root==null) return null;
	  if (root == p || root == q) return root;
	  TreeNode L = LCA(root.left, p, q);
	  TreeNode R = LCA(root.right, p, q);
	  if (L != null&& R != null) return root;  // if p and q are on both sides
	  return L !=null? L : R;  // either one of p,q is on one side OR p,q is not in L&R subtrees
}

// O(n) time O(1) space if parent pointers exist
Public int getHeight(TreeNode p) {
	int height = 0;
	while (p!=null) {
		height++;
		p = p.parent;
	}
	return height;
}
 
// As root->parent is NULL, we don't need to pass root in.
Public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
	int h1 = getHeight(p);
	int h2 = getHeight(q);
	// swap both nodes in case p is deeper than q.
	if (h1 > h2) {
		return LCA(root, q, p);
	}
	// invariant: h1 <= h2.
	int dh = h2 - h1;
	for (int h = 0; h < dh; h++)
		q = q.parent;
		while (p != null&& q != null) {
			if (p == q) return p;
			p = p.parent;
			q = q.parent;
		}
	return null;  // p and q are not in the same tree
}

// non efficient recursion

public TreeNode commonAncester (TreeNode root, TreeNode p, TreeNode q) {
	  // neither of p or q is null
	  if (covers(root.left, p)&&covers(root.left, q))
	    return commonAncester(root.left, p, q);
	  if (covers(root.right, p)&&covers(root.right, q))
	    return commonAncester(root.right, p, q);
	    
	  return root;
    
}

public TreeNode boolean covers(TreeNode root, TreeNode p) {
    if (root == null) return false;
    if (root == p) return true;
    return covers(root.left, p) || covers(root.right, p);
  
}

// more efficent recursion

public TreeNode commonAncester(TreeNode root, TreeNode p, TreeNode q) {
    if (p == q) && (root.left == q || root.right = q) return root;
    
    int nodesFoundLeft = covers(root.left, p, q);
    if (nodesFoundLeft == 2) {
        if (root.left == p || root.left == q) return root.left;
        return (root.left, p, q);
    } else if (nodesFoundLeft = 1) {
        if (root == p) return p;
        else if (root == q) return q;
    }
    
    int nodesFoundRight = covers(root.right, p, q);
    if (nodesFoundRight == 2) {
        if (root.right == p || root.right == q) return root.right;
        return (root.right, p, q);
    } else if (nodesFoundRight = 1) {
        if (root == p) return p;
        else if (root == q) return q;
    }
    
    if (nodesFoundRight == 1 && nodesFoundLeft == 1) return root;
    else return null;
    
}

public int covers(TreeNode root, TreeNode p, TreeNode q){
    int ret = 0;
    if (root == null) return 0;
    if (root == p || root == q) ret += 1;
    ret += covers(root.left, p, q);
    if (ret == 2) return ret;
    return ret + covers(root.right, p, q);
}
