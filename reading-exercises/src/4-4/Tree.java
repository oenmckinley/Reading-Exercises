

public class Tree<T> {
	private static class Node<T> {
		public T value;
		public Node<T> left;
		public Node<T> right;

		public Node(T value, Node<T> left, Node<T> right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public Node (T value) {
			this(value, null, null);
			}
		}

	private Node<T> root;

	public Tree() {
		root = null;
	}
	
	/**
	 * Prints the values of the nodes in a given tree from left to right, in order.
	 */
	public void printInOrder() {
		if (this.root != null) {
			Tree<T> leftSub = new Tree<T>(); 
			Tree<T> rightSub = new Tree<T>(); //Create subtrees of left and right...
			leftSub.root = this.root.left;    //...and then assign their roots to be the left and right nodes
			rightSub.root = this.root.right;
			leftSub.printInOrder();           //Then recurse on the left, print the center, and recurse on the right
			System.out.println(this.root.value);
			rightSub.printInOrder();
		}
	}
}
