package com.app.core;

public class BSTreeClass {

	public class BSTreeNode{
		int data;
		BSTreeNode rChild, lChild;
	}
	
	private BSTreeNode root, current, previous;
	
	public BSTreeClass() {
		root = null;
	}
	
	// node insertion
	public void insertNode(int elem) {
		
		// new node creation
		BSTreeNode newNode = new BSTreeNode();
		newNode.data = elem;
		newNode.lChild = null;
		newNode.rChild = null;
		
		//if tree is empty
		if(root == null) {
			root = newNode;
			return;
		}	
		
		//Assigning current to root & previous to null
		current = root;
		previous = null;
		// iterations to find suitable location for new node
		while(current != null) {
			previous = current; // incrementing prev
			//finding location
			if(elem < current.data) {
				current = current.lChild;
			}				
			else {
				current = current.rChild;
			}					
		}
		
		//if data < leaf node
		if(newNode.data < previous.data) {
			previous.lChild = newNode;
		}		
		
		// data < leaf node
		else {
			previous.rChild = newNode;
		}
		
	}
	
	// print all BSTree nodes in : inorder format
		public void printNode(BSTreeNode node) {
			if(node == null) {
				return;
			}
			if(node.lChild != null) {
				printNode(node.lChild);
			}
			
			System.out.print(node.data+" ");
			
			if(node.rChild != null)
				printNode(node.rChild);		
		}
		
		public void printNode() {
			printNode(root);
		}
		
		// find the particular node iff exists in BSTree
		public void findNode(int elem) {
			current = root;
			while(current != null && current.data != elem) {
				if(elem < current.data)
					current = current.lChild;
				else
					current = current.rChild;
			}
			if(current == null)
				System.out.println("Match not found !!!");
			else
				System.out.println("Match found !!!");
		}
		
		// node deletion 
		
		// find inorder Successor of a node : smallest element in the right sub tree
		public int inorderSuccessor(BSTreeNode node) {
			int min = node.data;
			while(node.lChild != null) {
				min = node.lChild.data;
				node = node.lChild;
			}
			return min;
		}
		
		public BSTreeNode deleteNode(BSTreeNode node, int data) {
			// check for empty tree
			if(node == null) {
				System.out.println("TREE : EMPTY");
				return node;
			}
				
			System.out.println("TREE NOT EMPTY, THERE FORE : TREE TRAVERSAL");
			// tree traversal : postorder leftRightRoot
			if(data < node.data) {
				System.out.println("data < node.data");
				node.lChild = deleteNode(node.lChild, data);
			}
				
			else if(data > node.data) {
				System.out.println("data > node.data");
				node.rChild = deleteNode(node.rChild, data);
			}
				
			else {
				//node with no child or only 1 child
				System.out.println("node with no child or only 1 child");
				if(node.lChild == null)
					return node.rChild;
				else if(node.rChild == null)
					return node.lChild;
				
				//node with 2 childs : inorderSucc
				node.data = inorderSuccessor(node.rChild);
				node.rChild = deleteNode(node.rChild, node.data);
					
			}			
			return node;
		}
		
		public void deleteNode(int data) {
			System.out.println("DATA TO BE DELETED : "+data);
			root = deleteNode(root, data);
		}
}




















