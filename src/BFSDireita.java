import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class BFSDireita {
	private static BSTNode root;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputArray = input.split(" ");

		for (int i = 0; i < inputArray.length; i++) {
			insert(Integer.parseInt(inputArray[i]));			
		}

		System.out.println(bfs());
		sc.close();
	}
	
	public static String bfs() {
		String out = "";
        if (!isEmpty()) {
            Deque<BSTNode> queue = new LinkedList<BSTNode>();
            queue.addLast(root);

            while (!queue.isEmpty()) {
            
            	BSTNode n = queue.removeFirst();
                out += n.getData() + " ";
            
                if (n.getRight() != null) { queue.addLast(n.getRight()); }
                
                if (n.getLeft() != null) { queue.addLast(n.getLeft()); }
            }
        }
        return (String) out.subSequence(0, out.length() - 1);
    }

	private static boolean isEmpty() { return root == null; }

	private static void insert(Integer e) {
		BSTNode newNode = new BSTNode(e, null, null, null);

		if (isEmpty()) { root = newNode; }
		else { insertNotEmpty(e, newNode); }
	}

	private static void insertNotEmpty(Integer e, BSTNode newNode) {
		BSTNode aux = root;

		while (aux != null) {
			if (e > aux.getData()) {
				if (aux.getRight() == null) {
					newNode.setParent(aux);
					aux.setRight(newNode);
					break;
				}
				else { aux = aux.getRight(); }
			} else if (e < aux.getData()) {
				if (aux.getLeft() == null) {
					newNode.setParent(aux);
					aux.setLeft(newNode);
					break;
				}
				else { aux = aux.getLeft(); }
			} else if (e == aux.getData())
				break;
		}
	}
}

class BSTNode {
	private Integer data;
	private BSTNode right;
	private BSTNode left;
	private BSTNode parent;
	public BSTNode(Integer data, BSTNode right, BSTNode left, BSTNode parent) {
		this.data = data;
		this.right = right;
		this.left = left;
		this.parent = parent;
	}
	public boolean isLeaf() { return this.left == null && this.right == null; }
	
	public Integer getData() { return data; }
	
	public void setData(Integer data) { this.data = data; }
	
	public BSTNode getRight() { return right; }
	
	public void setRight(BSTNode right) { this.right = right; }
	
	public BSTNode getLeft() { return left; }
	
	public void setLeft(BSTNode left) { this.left = left; }
	
	public BSTNode getParent() { return parent; }
	
	public void setParent(BSTNode parent) { this.parent = parent; }
}
