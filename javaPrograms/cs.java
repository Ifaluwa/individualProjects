import java.util.*;
import java.io.IOException;



public class cs {
	public static void main(String[] args) throws IOException{
		Node stuff = new Node(0);

		Node ref = stuff;


		for(int i = 1; i < 5; i++){
			ref.next = new Node(i);
			ref = ref.next;
		}

		while(stuff != null){
			System.out.println(stuff.data);
			stuff = stuff.next;
		}

		}
	
	
	





}