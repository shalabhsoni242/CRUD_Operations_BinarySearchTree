package tester;

import java.util.Scanner;

import com.app.core.BSTreeClass;

public class BSTreeTester {

	public static void main(String[] args) {
		
		BSTreeClass bst = new BSTreeClass();
				
		boolean flag = true;		
		
		try(Scanner sc = new Scanner(System.in)){
			while(flag) {
				System.out.println("\n1. Insert Node in BS Tree\n2. Find a Node in BS Tree\n3. Print Nodes of BS Tree\n4. Delete a Node from BS Tree\n5. EXIT\nEnter your choice");
				switch(sc.nextInt()) {
				
				case 1:
					System.out.println("Enter the element");
					bst.insertNode(sc.nextInt());
					System.out.println("Data inserted Successfully");
					break;
					
				case 2:
					System.out.println("Enter the element you want to search");
					bst.findNode(sc.nextInt());
					break;
					
				case 3:
					System.out.println("Nodes of BS Tree : ");
					bst.printNode();
					break;
					
				case 4: 
					System.out.println("Enter the element you want to delete");
					bst.deleteNode(sc.nextInt());
					System.out.println("Node deleted succesfully !!!");
					break;
					
				case 5:
					System.out.println("Thank you !!");
					flag = false;
					break;
				
				default:
					System.out.println("Wrong choice");
					break;
				}		
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
