public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if( root == null) return;
        
        Stack<TreeLinkNode> s = new Stack<TreeLinkNode>();
        
        s.push(root);
        
        while(!s.isEmpty()){
            TreeLinkNode curr = s.pop();
            TreeLinkNode next = curr.next;
            TreeLinkNode prev = null;
            if (curr.left!=null&&curr.right!=null){
                s.push(curr.left);
                s.push(curr.right);
                curr.left.next = curr.right;
                prev = curr.right;
            } else if (curr.left!=null){
                s.push(curr.left);
                prev = curr.left;
            } else if (curr.right != null) {
                s.push(curr.right);
                prev = curr.right;
            }
            
            if (next!=null&&prev!=null) {
                
                while (next.left==null&&next.right==null&&next.next!=null){
                        next = next.next;
                }
                
                if (next.left!=null){
                    prev.next = next.left;
                } else if (next.right !=null) {
                                    prev.next = next.right;
                } 
            }
        }
        
        return;
    }
