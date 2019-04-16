public class AllTreeOrder {
	public static void main(String[] args) {
		Node node = new Node(3);
		node.left = new Node(1);
		node.left.left = new Node(2);
		node.right = new Node(11);
		node.right.left = new Node(13);
		node.right.right = new Node(14);
	  
    printPreNode(node);
		System.out.println();
		
    printInNode(node);
		System.out.println();
		
    printPostNode(node);
	}
  
  private static void printPreNode(Node node) {
		if(node ==null) {
			return ;
		}
		 System.out.print(node.value+" ");
		 printPreNode(node.left);
		 printPreNode(node.right);
	}
	
	private static void printInNode(Node node) {
		if(node ==null) {
			return ;
		}
		printInNode(node.left);
		 System.out.print(node.value+" ");
		 printInNode(node.right);
	}
	
	private static void printPostNode(Node node) {
		if(node ==null) {
			return ;
		}
		
		 printPostNode(node.left);
		 printPostNode(node.right);
		 System.out.print(node.value+" ");
	}
 }
