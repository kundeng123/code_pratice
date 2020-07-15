package code_practice;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToNodeInTree {

	static class Node{
		int value;
		Node left, right;
		Node(int value){
			this.value = value;
			left = right = null;
		}
	}
	public static boolean hasPath(Node root, List<Integer> arr, int x) {
		if(root == null) {
			return false;
		}
		arr.add(root.value);
		if(root.value == x) {
			return true;
		}
		if(hasPath(root.left, arr, x) || hasPath(root.right, arr, x)) {
			return true;
		}
		arr.remove(arr.size()- 1);
		return false;
	}
	
	public static void printPath(Node root, int x) {
		List<Integer> result = new ArrayList<>();
		if(hasPath(root, result, x)) {
			for(int i = 0; i<result.size(); i++) {
				System.out.println(result.get(i) + "-> ");
			}
		}
		else {
			System.out.println("no path found");
		}
	}
	public static void main(String[] args) {
		// using preorder traversal (depth first traversal)
		// visit root, then left, right
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		int x = 5;
		printPath(root, 6);

	}

}
