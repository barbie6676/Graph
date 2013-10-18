/* Inserts a value into the BST. */
public class TreapNode {
    TreapNode left = null;
    TreapNode right = null;
    int priority;
    int val;
    public TreapNode(int a, int b){
        val = a;
        priority = b;
    }
}
public void bstInsert(TreapNode node, int value) {
  	if (node == null) {
  		node = new TreapNode(value, new Random().nextDouble());
  	} else if (node.val == value) {
  		return;
  	} else if (node.val < value) {
  		bstInsert(node.right, value);
  		
    		/* Treap step: Rotate this node up if it is in the wrong place. */
    		if (node.right.priority > node.priority) {
    			rotateLeft(node);
    		}
  	} else {
    		bstInsert(node.left, value);
    		
    		/* Treap step: Rotate this node up if it is in the wrong place. */
    		if (node.left.priority > node.priority) {
    			rotateRight(node);
    		}
  	}
}
