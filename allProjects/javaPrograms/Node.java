import java.util.*;

class Node{
	Node next = null;
	Object data;


	public Node(){
		data = null;
	}

	public Node (Object d){
		data = d;
	}

	void appendToTail(Object d){
		Node end = new Node(d);
		Node n = this;

		while(n.next != null){
			n = n.next;
		}
		n.next  = end;
	}
}