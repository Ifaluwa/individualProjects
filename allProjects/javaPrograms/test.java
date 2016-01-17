
import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class test {


/* ATOI FUNCTION  -  O(N) */
public static int atoi(String str) {
	//check for if string is empty or one number
	if (str == null || str.length() < 1)
		return 0;
 
	// trim white spaces
	str = str.trim();

 	//sets the flag for positive or negative signs
	char flag = '+';
 
	// check negative or positive
	int i = 0;
	if (str.charAt(0) == '-') {
		flag = '-';
		i++;
	} else if (str.charAt(0) == '+') {
		i++;
	}

	// use double to store result
	double result = 0;
 
	// calculate value
	while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
		result = result * 10 + (str.charAt(i) - '0');
		i++;
	}
 
	if (flag == '-')
		result = -result;
 
	// handle max and min
	if (result > Integer.MAX_VALUE)
		return Integer.MAX_VALUE;
 
	if (result < Integer.MIN_VALUE)
		return Integer.MIN_VALUE;
 
	return (int) result;
}


/* REMOVE DUPLICATES FUNCTION FOR STRINGS - O(N^2) */
public static String removeDuplicates(String str){
	//create character array of the said string
	char[] charArray = str.toCharArray();

	//edge cases, empty string or one character string
	if (charArray == null) return str;
 	if (charArray.length < 2) return str;
 	

 	//starting from the second character(innerloop) check for if any character before it is a duplicate
 	for(int i = 1; i < charArray.length; ++i){
 		for(int j = 0; j < i; ++j){
 			if (charArray[i] == charArray[j]) charArray[i] = 0;
 		}
 		
 	}

 	// convert character array to string and return
 	return new String(charArray);
}

/* FIND MAX CROSSING SUB-ARRAY * O(N) */
public static HashSet<Integer> findMaxCrossingSubArray(int[] array){
	//set minimum sentinel values for the left and right sum, find index of median
	int leftSum = Integer.MIN_VALUE;
	int rightSum = Integer.MIN_VALUE;
	int mid = array.length/2;

	//indices for how far left and right the max crossing sub array goes
	int lIndex = 0, rIndex = 0;


	//left-side
	int lSum = 0;
	for(int i = mid - 1; i >= 0; i--){
		lSum = array[i] + lSum;
		if (lSum > leftSum){
			leftSum = lSum;
			lIndex = i;
		}
	}

	//right-side
	int rSum = 0;
	for(int j = mid; j < array.length; j++){
		rSum = array[j] + rSum;
		if(rSum >rightSum){
			rightSum = rSum;
			rIndex = j;
		}
	}


	HashSet<Integer> stuff = new HashSet<Integer>();
	stuff.add(lIndex);
	stuff.add(rIndex);
	stuff.add(leftSum+rightSum);
	return stuff;

}

/* QUICKSORT  - best-case:O(NlogN) - worst-case: O(N^2) */
public static void quickSort(int[] array, int lo, int hi){
	//index of the middle element
	int mid;

	if(lo < hi){
		mid = partition(array, lo, hi);
		quickSort(array, lo, mid-1);
		quickSort(array, mid+1, hi);
	} 

}

public static int partition(int[] array, int p, int r){

	//resolves issue of if index is out of bounds
	if(r == array.length){
		r -= 1;		
	} 
	
	
	int pivot = array[r];
	int i = p-1;
	for(int j = p; j < r; j++){
		if(array[j] <= pivot){
			//move wall forward
			i+=1;
			
			//swap and place before wall
			int tmp1;
			tmp1 = array[i];
			array[i] = array[j];
			array[j] = tmp1;
		}
		
	}
	
	//swap and place pivot in final resting place
	int tmp;
	tmp = array[i+1];
	array[i+1] = array[r];
	array[r] = tmp;

	//return index of pivot
	return i+1;
}


/* BINARY SEARCH O(logN) */
public static int binarySearch(int[] array, int needle, int start, int end){
	int mid = (start+end)/2;
	//base case
	if(array[mid] == needle){
		return mid;
	}

	//recursive case
	else if(array[mid] > needle){
		return(binarySearch(array, needle, start, mid));
	} else {
		return(binarySearch(array, needle, mid, end));
	}
}


/* MERGE SORT O(nLOGn) */
// public static int[] mergeSort(int[] array, int lo, int hi){
// 	int mid;


// 	if(lo < hi){
// 		mid = (lo + hi)/2;
// 		mergeSort(array, lo, mid);
// 		mergeSort(array,mid+1 , hi);
// 		merge(array, lo, mid, hi);
// 	}
// 	return array;
// }

// public static int[] merge(int[] array, int lo, int mid, int hi){
// 	int size = mid - lo;
// 	if(n1 == 0) return array;
// 	int n2 = r - q;


// 	int[] leftArray = new int[n1];
// 	int[] rightArray = new int[n2];
	
	
// 	int i;
// 	int j;

// 	for(i = 0; i < n1; i++){
// 		leftArray[i] = array[p + i];
// 	}
// 	for(j = 0; j < n2; j++){
// 		rightArray[j] = array[q + j];
// 	}
// 	int lcv = 0;
// 	int rcv = 0;



// 	for(int k = p; k < r; k++){
// 		if(lcv == n1){
// 			array[k] = rightArray[rcv];
// 			rcv++;
// 		} else if(rcv == n2) {
// 			array[k] = leftArray[lcv];
// 			lcv++;
// 		}else if (leftArray[lcv] <= rightArray[rcv]){
// 			array[k] = leftArray[lcv];
// 			lcv += 1;
// 		} else {
// 			array[k] = rightArray[rcv];
// 			rcv += 1;
// 		}
// 	}

// 	if(leftArray.length == 4){
// 		System.out.println(Arrays.toString(leftArray));
// 		System.out.println(Arrays.toString(rightArray));
			
// 	}
// 	return array;
// }

/* REVERSING A LINKED LIST */
public static Node reverse(Node current){
	//check for empty list
	if(current == null || current.next == null ){
		return current;
	}
	
	Node secondElem = current.next;
	current.next = null;

	Node reverseSet = reverse(secondElem);
	secondElem.next = current;
	
	return reverseSet;
}


/* reverse string O(N) */
public static String reverseString(String str){
	
	char[] chars = str.toCharArray();
	int size = str.length() - 1;

	for(int i = 0; i <= size/2; i++){
		char nChar = chars[size - i];
		chars[size - i] = chars[i];
		chars[i] = nChar;	
	}
	return new String(chars);
}

// check if a string has a sub string O(N^2) */
public static boolean hasSubstring(String sub, String full){

	for(int i = 0; i < full.length(); i++){
		boolean notMatch = false;
		for(int j = 0; j < sub.length(); j++){
			if(sub.charAt(j) != full.charAt(i+j)) notMatch = true;
			break;
		}
		if(!notMatch) return true;
	}
	return false;
}


// given a sorted array of numbers find a target sum O(N) */
public static HashSet<Integer> targetSum(int[] array, int tSum){
	quickSort(array, 0, array.length);
	int i = 0;
	int j = array.length - 1;
	HashSet<Integer> result = new HashSet<>();

	while(i <= j){
		if((array[i] + array[j]) == tSum){
			result.add(array[i]);
			result.add(array[j]);
			return result;
		} else if ((array[i] + array[j]) < tSum){
			i++;
		} else {
			j--;
		}

	}

	return result;
}


/* find the number that appears an odd number of times */
public static int oddManOut(int[] array){
	int sum = 0;
	for(int i = 0; i < array.length; i++){
		sum ^= array[i];
	}
	return sum;

}


/* O(N) */
public static void removeWhiteSpaces(String str){
	char[] cStr = str.toCharArray();
	for(int i = 0; i < cStr.length; i ++){
		if(cStr[i] == ' ') cStr[i] = 0;
	}
	String result = new String(cStr);
	System.out.println(result);
}

/* check for if a string has duplicates time - O(N) space - O(N) */
public static boolean isDuplicate(String str){
	boolean[] data = new boolean[256];

	for(int i = 0; i < str.length(); i++){
		if(data[str.charAt(i)]) return false;
		data[str.charAt(i)] = true;
	}
	return true;

}

/* checks to see if a string is an anagram of another O(N) */
public static boolean isAnagram(String a, String b){
	int[] charsInA = new int[256];
	int uniqueCharsA = 0;
	int uniqueCharsB = 0;


	// finds the amount of occurences of the unique characters in the first string
	for(int i = 0; i < a.length(); i++){
		if(a.charAt(i) == ' ') continue;
		if(charsInA[a.charAt(i)] == 0) ++uniqueCharsA;
		++charsInA[a.charAt(i)];
	}


	//cross checks it with the second character
	//checks for if the character was in A
	//subtracts the occurence by one, checks if its 0 and adds it to the amount of unique characters
	for(int j = 0; j < b.length(); j++){
		if(b.charAt(j) == ' ') continue;
		if(charsInA[b.charAt(j)] == 0) return false;
		--charsInA[b.charAt(j)];
		if(charsInA[b.charAt(j)] == 0) ++uniqueCharsB;
	}

	return (uniqueCharsA == uniqueCharsB);
}
	
/* the power of a number with no exp functions O(N) */	
public static long pow(int num, int exp){
	if(exp == 0) return 1;
	if(exp == 1) return num;

	long result = num;

	for(int i = 1; i < exp; i++){
		result *= num;
	}
	return result;
}

/* MINIMAL BST O(LOGN) */
 // public static TreeNode createMinimalBST(int array[]) {
 // 	return addToTree(array, 0, array.length - 1);
 // }
// public static TreeNode addToTree(int arr[], int start, int end){
// 	if (end < start) {
//  		return null;
//  	}

//  	int mid = (start + end) / 2;

//  	TreeNode n = new TreeNode(arr[mid]);
//  	n.left = addToTree(arr, start, mid - 1);
//  	n.right = addToTree(arr, mid + 1, end);
//  	return n;
//  }


// public static void findSum(TreeNode head, int sum, ArrayList<Integer> buffer, int level) {
// 	if (head == null) return;
// 	int tmp = sum;
// 	buffer.add(head.data);
// 	for (int i = level;i >- 1; i--){
// 		tmp -= buffer.get(i);
// 		if (tmp == 0) print(buffer, i, level);
// 	}
	
// 	ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
// 	ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
// 	findSum(head.left, sum, c1, level + 1);
// 	findSum(head.right, sum, c2, level + 1);

// }


// static int columnForRow[] = new int[8];
// boolean check(int row){

// 	for(int i = 0; i < row; i++){
// 		int diff = Math.abs(columnForRow[i] - columnForRow[row]);
// 		if(diff == 0 | diff == row - 1) return false;
// 	}
// 	return true;  //returns true if the pieces are not on the same column or diagonal
// }

// void placeQueen(int row){
// 	// base case for if we've placed on pieces
// 	if(row == FINAL_SIZE){ 
// 		printBoard();
// 		return;
// 	}

// 	//recursive case keeps checking until finds somewhere to place, if it doesn't it backtracks
// 	for(int i = 0; i < FINAL_SIZE; i++){
// 		columnForRow[row] = i;
// 		if(check(row)){
// 			placeQueen(row + 1);
// 		}
// 	}

// }

/*finds an element in an ordered matrix */
public boolean findElem(int[][] mat, int m, int n, int element){
	int row = 0;
	int col = n - 1; 
	while(row < m && col >= 0){
		if(mat[row][col] == element){
			return true;
		}
		if(mat[row][col] > element){
			col--;
		} else {
			row++;
		}
	}
	return false;

}

/* FINDS MISSING NUMBER IN AP O(N) */
public static int findMissingAP(int size, int[] array){
	int diff = (array[size - 1] - array[0]) / size;
	
	for(int i = 0; i < size - 1; i++){
		if( (array[i+1] - array[i]) != diff ) return (array[i] + diff);
	}
	return 0;
}

static long fib(int n){
	return n <= 1 ? n : fib(n-1) + fib(n-2);
}

public static void mulTables(int max){

	for(int i = 1; i <= max; i++){
		for(int k = 1; k <= max; k++){
			System.out.print( String.format ( "%4d", k * i )) ;
		}
		System.out.println();
	}
}

// public static void sumFile ( String name ) {
//         try {
//             int total = 0;
//             BufferedReader in = new BufferedReader ( new FileReader ( name ));
//             for ( String s = in.readLine(); s != null; s = in.readLine() ) {
//                 total += Integer.parseInt ( s );
//             }
//             System.out.println ( total );
//             in.close();
//         }
//         catch ( Exception xc ) {
//             xc.printStackTrace();
//         }
//     }

    public static void printOdds(){
    	for(int i = 1; i < 100; i += 2){
    		System.out.println(i);
    	}

    }

    public static int largest(int[] input){
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i < input.length; i++){
    		if(max < input[i]) max = input[i];
    	}
    	return max;
    }

    public static void swap(int a, int b){
    	a = a^b;
    	b = a^b;
    	a = a^b;
    	System.out.println(a +" "+ b);
    }

    public static int numZeros(int num){
    	int count = 0;
    	if(num < 0){
    		System.out.println("Non-negative numbers only!");
    	}

    	for (int i = 5; i <= num ; i *= 5){
    		count += num/i;

    	}
    	return count;

    }

    public static void findMax(int a, int b){
    	int c = a - b;
    	int k = (c >> 31) & 0x1;
    	//System.out.println(a - k * c);
    }

    public static String toHex(int n){
    StringBuffer buffer = new StringBuffer(); 
    while (n > 0) { 
    	int base = n % 16;
    	buffer.append( (base < 10 ? base : (char)('a'+ base-10) )); 
    	n /= 16; 
   	}
   	 String result = reverseString(buffer.toString());
   	 return result;
   	}
    
 //    public static void inOrder (Node root)
	// {
 
 //  	if(root == null) return;
  
 //  	inOrder( root.leftNode() );
  
 //  	root.printNodeValue();
  
 //  	inOrder( root.rightNode() ); 
  
	// }

	public static String longestSubstring(String str, int max){
		boolean[] data = new boolean[256];
		int limit = 0;
		int size = 0;
		int maxSize = 0;
		int start = 0;
		int end = 0;
		int i = 0;
		int k = 0;

	for( k = 0; k < str.length(); k++){
		for(i = k; limit <= max; i++){
			if(!data[str.charAt(i)]) {
				limit++;
				data[str.charAt(i)] = true;
			}
		}
		size = i - k;
		System.out.println(size);
		if (size > maxSize){
 			maxSize = size;
			start = i;
			end = k;
		}
	}
	System.out.println(str.length()); 
	


	return str.substring(start, end);

	}

	// public void printInOrder(Node root){
	// 	if(root == null) return;

	// 	printInOrder(root.left);
	// 	System.out.println(root.data);
	// 	printInOrder(root.right);
	// }
// public static boolean isBalanced(Node root){
// 	int leftSum;
// 	int rightSum;
// 	leftSum = checkValues(root.left);
// 	rightSum = checkValues(root.right);
// 	return leftSum == rightSum;
// }

public static int  checkValues(Node val){
	if(val == null) return 0;
	if (val.left == null && val.right == null){
		return val.data;
	}
	else {
		return checkValues(val.left) + checkValues(val.right) + val.data;
	}
}
	
 static void findingDigits(int[] foo) {
        
        for(int i = 0; i < foo.length; i++){
            int count = 0;
            int standard = foo[i];
            while(standard > 0){
                int rem = standard % 10;
                standard /= 10;
                if (rem == 0) continue;
                else if((foo[i] % rem) == 0) count++; 
            }
            System.out.println(count);
        }
        


    }

    static void maxProfit(int[] prices){
    	

    	int start = 0;
    	int sum = 0;
    	int maxp = Integer.MIN_VALUE;
    	int min = prices[0];
    	for(int end = 1; end < prices.length; end++){
    		int val = prices[end] - prices[start];

    		if(val < 0){
    			if(prices[end] < min){
    				min = prices[end];
    				start = end;
    			}
    		}

    		if(val > maxp){
    			maxp = val;
    		}
    	}

    	System.out.println(maxp);

    }

public static int gcd(int[] arr){
	int a = arr[0];
	for(int i = 1; i < arr.length; i++){
		a = gcdHelper(a, arr[i]);
	}
	return a;
}    

static int gcdHelper(int m, int n){
	if(m == n)
      return m;
    else if (m > n)
      return gcdHelper(m-n, n);
    else
      return gcdHelper(m, n-m);
}

 




public static void main(String[] args) throws IOException{
	int [] arr = {4, 6, 18};
	int ans = gcd(arr);
	System.out.println(ans);
	Integer a = new Integer(10.75);
	System.out.println(a);

	// String sX = "hello";
	// String s1 = "hel";
	// String s2 = "lo";
	// System.out.println(sX.equals(s1+s2));
	// int[] prices = {40, 40, 40, 43, 10, 12};
	// maxProfit(prices);
	// Node test = new Node(8);
	// test.appendToTail(3);
	// System.out.println(test.next);
	

	// String answer;
	// answer = longestSubstring("ABCDEABABEED", 4);
	// System.out.println(answer);

	// findMax(101, 100);
	// String answer;
	// answer = toHex(12);
	// System.out.println(answer);
	// int count = numZeros(26);
	// System.out.println(count);
	// String atoiVariable = "77";
	//String duplicateString = "faded af";
	// int[] maxCrossingArray = {1,-2,3,6,7,8,-9,2,4};
	// System.out.println("function atoi >> " + atoi(atoiVariable));
	//System.out.println("function removeDuplicates >> " + removeDuplicates(duplicateString));
	// System.out.println("function maxCrossingArray >> " + findMaxCrossingSubArray(maxCrossingArray));
	// quickSort(maxCrossingArray, 0, maxCrossingArray.length);
	// System.out.println("Quicksorted array > " + Arrays.toString(maxCrossingArray) );
	// mulTables(9);
	// HashMap<String, Integer> numbers = new HashMap<>();
	// numbers.put("one", 1);
	// System.out.println(numbers.get("one"));
	// String random = "lana";
	// String reverse = reverseString(random);
	// System.out.println(reverse);
	 // boolean b = Pattern.matches("ab", "ab");
	 // System.out.println(b);

	// InputStreamReader cin = null;
	// FileReader in = null;
	// FileWriter out = null;


	// try {
 //         cin = new InputStreamReader(System.in);
 //         in = new FileReader("input.txt");
 //         out = new FileReader("output.txt");
 //         System.out.println("Enter characters, 'q' to quit.");
 //         char c;
        
 //        do {
 //            c = (char) cin.read();
 //            System.out.print(c);
 //        } while(c != 'q');
      
 //    }finally {
 //         if (cin != null)
 //        {
 //            cin.close();
 //        }

 //     }




	
	
	
}

	public class Node{
		Node left;
		Node right;
		Node next;
		int data;
	}
}



