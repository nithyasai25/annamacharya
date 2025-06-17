class Node{
	int data;
	Node left;
	Node right;
	Node(int value){
		data=value;
		left=right=null;
	}
}
public class BinaryTree{
	Node root;
	int count=0;
	int leafnodes=0;
	int sum=0;
	int max=0;
	public BinaryTree(){
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
	}
	public void printPreorder(Node node){
		if(node==null)
			return;
		System.out.print(node.data+" ");
		count++;
		if(node.left==null && node.right==null)
			leafnodes++;
		printPreorder(node.left);
		printPreorder(node.right);
	}
	public void printInorder(Node node){
		if(node==null)
			return;
		printInorder(node.left);
		System.out.print(node.data+" ");
		printInorder(node.right);
	}
	public void printPostorder(Node node){
		if(node==null)
			return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data+" ");
	}
	public int findHeight(Node node){
		if(node==null)
			return -1;
		int lh=findHeight(node.left);
		int rh=findHeight(node.right);
		return Math.max(lh,rh)+1;
	}
	public void sumOfNodes(Node node){
		if (node==null)
			return;
		sum=sum+node.data;
		sumOfNodes(node.left);
		sumOfNodes(node.right);
	}
	public void findMax(Node node){
		if (node==null)
			return;
		if(node.data>max)
			max=node.data;
		findMax(node.left);
		findMax(node.right);
	}
	public static void main(String[] args){
		BinaryTree tree=new BinaryTree();
		System.out.println("\nPreorder Travarsal:");
		tree.printPreorder(tree.root);
		System.out.println("\nInorder Travarsal:");
		tree.printInorder(tree.root);
		System.out.println("\nPostorder Travarsal:");
		tree.printPostorder(tree.root);
		System.out.println();
		System.out.println("\ncount:"+tree.count);
		System.out.println("\nNumber of Leaf Nodes:"+tree.leafnodes);
		tree.sumOfNodes(tree.root);
		System.out.println("\nSum of Nodes:"+tree.sum);
		tree.findMax(tree.root);
		System.out.println("\nMaximum Element:"+tree.max);
		int height=tree.findHeight(tree.root);
		System.out.println("\nHeight:"+height);
	}
}