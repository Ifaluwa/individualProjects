import java.util.*;
import java.util.regex.Pattern;
import java.io.*;


public class recursion {

/* REVERSING A LINKED LIST */
public static Node reverse(Node current){
	//check for empty list
	if(current == null || current.next == null ){
		return current;
	}
	
	Node secondElem = current.next; //splits first element from rest of list
	current.next = null;

	Node reverseRest = reverse(secondElem);
	reverseRest.print();
	
	secondElem.next = current;
	
	reverseRest.print();
	
	return reverseRest;
}


public static void main(String[] args) throws IOException{
	Node test = new Node(1);
	test.appendToTail(2);
	test.appendToTail(3);
	//test.print();
	Node result = reverse(test);
	//result.print();



}

}
