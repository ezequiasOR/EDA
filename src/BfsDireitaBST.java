import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class BfsDireitaBST {
	private static NodeBST root;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputArray = input.split(" ");

		for (int i = 0; i < inputArray.length; i++)
			insert(Integer.parseInt(inputArray[i]));

		System.out.println(bfs());
	
	}
	
	public static String bfs() {
		String out = "";
        if (!isEmpty()) {
            Deque<NodeBST> queue = new LinkedList<NodeBST>();
            queue.addLast(root);

            while (!queue.isEmpty()) {
            
                NodeBST n = queue.removeFirst();
                out += n.getData() + " ";
            
                if (n.getRight() != null)
                    queue.addLast(n.getRight());
                
                if (n.getLeft() != null)
                    queue.addLast(n.getLeft());
            
            }
        }
        return (String) out.subSequence(0, out.length() - 1);
    }

	private static boolean isEmpty() {
		return root == null;
	}

	private static void insert(Integer e) {
		NodeBST newNode = new NodeBST(e, null, null, null);

		if (isEmpty()) {
			root = newNode;
		} else {
			insertNotEmpty(e, newNode);
		}
	}

	private static void insertNotEmpty(Integer e, NodeBST newNode) {
		NodeBST aux = root;

		while (aux != null) {
			if (e > aux.getData()) {
				if (aux.getRight() == null) {
					newNode.setParent(aux);
					aux.setRight(newNode);
					break;
				} else {
					aux = aux.getRight();
				}
			} else if (e < aux.getData()) {
				if (aux.getLeft() == null) {
					newNode.setParent(aux);
					aux.setLeft(newNode);
					break;
				} else {
					aux = aux.getLeft();
				}
			} else if (e == aux.getData())
				break;
		}
	}

}

class NodeBST {
	private Integer data;
	private NodeBST right;
	private NodeBST left;
	private NodeBST parent;
	public NodeBST(Integer data, NodeBST right, NodeBST left, NodeBST parent) {
		this.data = data;
		this.right = right;
		this.left = left;
		this.parent = parent;
	}
	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public NodeBST getRight() {
		return right;
	}
	public void setRight(NodeBST right) {
		this.right = right;
	}
	public NodeBST getLeft() {
		return left;
	}
	public void setLeft(NodeBST left) {
		this.left = left;
	}
	public NodeBST getParent() {
		return parent;
	}
	public void setParent(NodeBST parent) {
		this.parent = parent;
	}
}