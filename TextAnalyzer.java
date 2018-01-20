
public class TextAnalyzer {
	public static void main(String[] args) {
		BinarySearchTree BST = new BinarySearchTree();
		BST.readIn("WisdomForRoad.txt");
		System.out.println(BST.maxSearchPath());
		BST.printWordsSorted();
		BST.printTenMostCommonWords();

	}
}
