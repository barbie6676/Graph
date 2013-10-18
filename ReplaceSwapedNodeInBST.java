public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        
        while (root.left!=null){
             s.push(root);
            root = root.left;
           
        }
        s.push(root);
        TreeNode tail = new TreeNode (Integer.MIN_VALUE);
        TreeNode strange = null;
        TreeNode strange2= null;
        TreeNode curr = null;
        //boolean  first = true;
        while(!s.isEmpty()){
            curr = s.pop();
            if (curr.val<tail.val) {
                if (strange == null) {
                    strange = tail;
                    strange2 = curr;
                } else {
                    int temp = curr.val;
                    curr.val = strange.val;
                    strange.val = temp;
                    strange2 = null;
                    break;
                }
            }
            
            if (curr.right != null){
                TreeNode right = curr.right;
                while (right.left!=null){
                    s.push(right);
                    right = right.left;
                }
                s.push(right);
            }
            
            tail = curr;
        }
        
        if (strange2 !=null){
            int temp = strange2.val;
            strange2.val = strange.val;
            strange.val = temp;
        }
    }
