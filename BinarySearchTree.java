

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class BinarySearchTree extends LinkedBinaryTree<String> {
	
	public BinarySearchTree() {
		super();
	}
	public void readIn(String fileName) {
		String file = null;
		try {
			FileReader input = new FileReader(fileName);
			BufferedReader readIn = new BufferedReader(input);
			
			//Read in & store info
			while ((file = readIn.readLine()) != null)
			{
				if(file.isEmpty())
				{
					continue;
				}
				String[] split = file.split(" ");
				int counter = 0;
				
				
				for(counter = 0; counter < split.length; counter++)
				{
					
					BTNode<String> p = root;
					split[counter] = split[counter].toLowerCase();
					String[] words = split[counter].replaceAll("[^a-z]", "").toLowerCase().split("\\s+");
					split[counter] = "";
					for(int c2 = 0; c2 < words.length; c2++)
					{
						split[counter] = split[counter] + words[c2];
					}
					if(root == null)
					{
						addRoot(split[counter]);
						root.increaseWordCounter();
									
					}
					else
					{
							nextElement (p, split[counter]);
					}
						
				}
			}
			readIn.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(fileName + " not found.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		private void nextElement(BTNode<String> p, String word) {
			if(word.compareTo(p.element()) == 0)
			{
				p.increaseWordCounter();
			}
			if((p.left == null) && word.compareTo(p.element()) < 0)
			{
				addLeft(p, word);
			}
			else if ((p.right == null) && word.compareTo(p.element()) > 0)
			{
				addRight(p, word);
			}
			else if((p.left != null) && word.compareTo(p.element()) < 0)
			{
				nextElement(p.left, word);
			}
			else if((p.right != null) && word.compareTo(p.element()) > 0)
			{
				nextElement(p.right, word);
			}
		}
		public int maxSearchPath()
		{
			if(root == null)
			{
				return 0;
			}
			return maxSearchPath(root);
		}
		
		private int maxSearchPath(BTNode<String> p) {
			//Base Case
			if(p == null)
			{
				return -1;
			}
			int leftHeight = maxSearchPath(p.left);
			int rightHeight = maxSearchPath(p.right);
			
			if(leftHeight > rightHeight)
			{
				return leftHeight + 1;
			}
			else
			{
				return rightHeight + 1;
			}
		}
		public void printWordsSorted() {
			// TODO Auto-generated method stub
			sort(root);
		}
		
		private void sort(BTNode<String> root) {
			
				  if(root !=  null) {
					  if(root.left!= null)
					  {
						  
						  sort(root.left);
					  }
				   //Visit the node by Printing the node data  
				   System.out.println(root.element());
				   if(root.right!= null)
					  {
					   sort(root.right);
					  }
				 }
			}
		public void printTenMostCommonWords() {
			// TODO Auto-generated method stub
			ArrayList<String> list = new ArrayList<String>();
			int x = 0;
			for(x = 0; x< 10; x++)
			{
			BTNode<String> maxNode = createNode("", null, null, null);
			maxNode = sort2(root, maxNode, list);
			list.add(maxNode.element());
			System.out.println(maxNode.element() + "\t" + maxNode.getWordCounter());
			}
			
		}
		
		private BTNode<String> sort2(BTNode<String> root, BTNode<String> maxNode, ArrayList<String> list) {
			
			  if(root !=  null) {
				  if(root.left!= null)
				  {
					  sort2(root.left, maxNode, list);
				  }
			   //Visit the node by Printing the node data
				  if((root.getWordCounter() > maxNode.getWordCounter()) && !(list.contains(root.element())))
				  {
					  maxNode.resetWord(root.element(), root.getWordCounter());
					  return maxNode;
				  }
				  
			
			   if(root.right!= null)
				  {
				   sort2(root.right, maxNode, list);
				  }
			  
			 }
			  return maxNode;
		}
		
	}
