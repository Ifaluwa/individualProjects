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

	void print (){
		Node cur = this;
		while(cur.next != null){
			System.out.print(cur.data+"->");
			cur = cur.next;
		}
		System.out.print(cur.data);
		System.out.println();
	}

}