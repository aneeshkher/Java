package ds;

import java.util.Scanner;

public class MyTree {
	
	static int count = 0;
	static int maxDepth = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
	
		int[] elements = {50, 35, 20, 26, 38, 36, 42, 40, 39, 71, 55, 63, 92, 94};
		
		for (int i = 0; i < elements.length; i++) {
			insert(elements[i], TreeRoot.root);
		}
		int breakFlag = 0;

		while (true) {
			System.out.println("Enter your choice: ");
			System.out.println("A. Travrese");
			System.out.println("B. Insert");
			System.out.println("C. Exit");
			System.out.println("D. Get max height");
			System.out.println("E. Search");
			System.out.println("F. Get Minimum value");
			System.out.println("G. Get Maximum value");
			String choice = scan.next();

			switch(choice.toUpperCase()) {
			case "A":
				System.out.println("Choose traversal mathod: ");
				System.out.println("A. Preorder traversal");
				System.out.println("B. Postorder traversal");
				System.out.println("C. Inorder traversal");
				String travChoice = scan.next();
				
				switch(travChoice.toUpperCase()) {
				case "A":
					System.out.println("");
					traverse(TreeRoot.root);
					System.out.println("");
					break;
				case "B":
					System.out.println("");
					postOrderTraverse(TreeRoot.root);
					System.out.println("");
					break;
				case "C":
					System.out.println("");
					inOrderTraverse(TreeRoot.root);
					System.out.println("");
					break;
				default:
					break;
				}
				
				break;
				
			case "B":
				System.out.println("Enter the data that "
						+ "you want to insert");
				int data = scan.nextInt();
				insert(data,TreeRoot.root);
				break;
				
			case "C":
				breakFlag = 1;
				break;
				
			case "D":
				getMaxHeight(TreeRoot.root);
				System.out.println("Maximum height: " + maxDepth);
				break;
				
			case "E":
				System.out.println("Enter the data to be searched");
				int dataSearch = scan.nextInt();
				if (search(dataSearch, TreeRoot.root)) {
					System.out.println(dataSearch + " found in the tree");
				} else {
					System.out.println(dataSearch + " not found in the tree");
				}
				break;
				
			case "F":
				int minVal = getMin(TreeRoot.root);
				System.out.println("Minimum value: " + minVal);
				break;
				
			case "G":
				int maxVal = getMax(TreeRoot.root);
				System.out.println("Maximum value: " + maxVal);
				break;
			default:
				breakFlag = 1;
				break;
			}
			if (breakFlag == 1) {
				break;
			}
		}
		

		scan.close();

	}
	
	public static int getMin (TreeNode root) {
		if (root.left == null) {
			return root.data;
		} else {
			return getMin(root.left);
		}
	}
	
	public static int getMax (TreeNode root) {
		if (root.right == null) {
			return root.data;
		} else {
			return getMax(root.right);
		}
	}
	
	public static boolean search (int data, TreeNode root) {
		if (root == null) {
			return false;
		} else {
			if (data > root.data) {
				return search(data, root.right);
			} else if (data < root.data) {
				return search(data, root.left);
			} else {
				return true;
			}
		}
	}

	public static void traverse(TreeNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			traverse(node.left);
			traverse(node.right);
		}
	}
	
	public static void postOrderTraverse(TreeNode root) {
		if (root == null) {
			return;
		} else {
			postOrderTraverse(root.left);
			postOrderTraverse(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public static void inOrderTraverse(TreeNode root) {
		if (root == null) {
			return;
		} else {
			inOrderTraverse(root.left);
			System.out.print(root.data + " ");
			inOrderTraverse(root.right);
		}
	}
	
	public static void getMaxHeight(TreeNode root) {
		if (root == null) {
			count--;
			return;
		} else {
			count++;
			if (maxDepth < count) {
				maxDepth = count;
			}
			getMaxHeight(root.left);
			count++;
			if (maxDepth < count) {
				maxDepth = count;
			}
			getMaxHeight(root.right);
			count--;
		}
	}

	public static void insert(int data, TreeNode node) {
		if (node == null) {
			TreeRoot.root = new TreeNode();
			TreeRoot.root.left = null;
			TreeRoot.root.right = null;
			TreeRoot.root.data = data;
		} else if (data > node.data) {
			if (node.right == null) {
				node.right = new TreeNode();
				node.right.left = null;
				node.right.right = null;
				node.right.data = data;
			} else {
				insert(data, node.right);
			}
		} else {
			if (node.left == null) {
				node.left = new TreeNode();
				node.left.left = null;
				node.left.right = null;
				node.left.data = data;
			} else {
				insert(data, node.left);
			}
		}
	}
}
