
import java.util.*;
import javax.swing.tree.TreeNode;

public class test {

// public static int atoi(String str) {
// 	if (str == null || str.length() < 1)
// 		return 0;
 
// 	// trim white spaces
// 	str = str.trim();

 
// 	char flag = '+';
 
// 	// check negative or positive
// 	int i = 0;
// 	if (str.charAt(0) == '-') {
// 		flag = '-';
// 		i++;
// 	} else if (str.charAt(0) == '+') {
// 		i++;
// 	}

// 	// use double to store result
// 	double result = 0;
 
// 	// calculate value
// 	while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
// 		result = result * 10 + (str.charAt(i) - '0');
// 		i++;
// 	}
 
// 	if (flag == '-')
// 		result = -result;
 
// 	// handle max and min
// 	if (result > Integer.MAX_VALUE)
// 		return Integer.MAX_VALUE;
 
// 	if (result < Integer.MIN_VALUE)
// 		return Integer.MIN_VALUE;
 
// 	return (int) result;
// }

public static void removeDuplicates(char[] str){
	if (str == null) return;
 	int len = str.length;
 	if (len < 2) return;
 	int tail = 1;


 	for(int i = 1; i < str.length; ++i){
 		for(int j = 0; j < tail; ++j){
 			if (str[i] == str[j]) str[i] = 0;
 		}
 		tail++;
 	}

 	System.out.println(str);

}

// public static HashSet<Integer> findMaxCrossingSubArray(int[] array){
// 	int leftSum = Integer.MIN_VALUE;
// 	int rightSum = Integer.MIN_VALUE;
// 	int mid = array.length/2;


	
// 	int lSum = 0;
// 	for(int i = mid - 1; i >= 0; i--){
// 		lSum = array[i] + lSum;
// 		if (lSum > leftSum){
// 			leftSum = lSum;
// 		}
// 	}

// 	int rSum = 0;
// 	for(int j = mid; j < array.length; j++){
// 		rSum = array[j] + rSum;
// 		if(rSum >rightSum){
// 			rightSum = rSum;
// 		}
// 	}


// 	HashSet<Integer> stuff = new HashSet<Integer>();
// 	stuff.add(leftSum);
// 	stuff.add(rightSum);
// 	//stuff.add(leftSum+rightSum);
// 	return stuff;

// }


// public static void quickSort(int[] array, int p, int r){
// 	int q;
// 	if(p < r){
// 		q = partition(array, p, r);
// 		quickSort(array, p, q-1);
// 		quickSort(array, q+1, r);
// 	} 

// }

// public static int partition(int[] array, int p, int r){
// 	//resolves issue of if index is out of bounds
// 	if(r == array.length){
// 		r -= 1;		
// 	} 
	
// 	int x = array[r];
// 	int i = p-1;
// 	for(int j = p; j < r; j++){
// 		if(array[j] <= x){
// 			i+=1;
// 			int tmp1;
// 			tmp1 = array[i];
// 			array[i] = array[j];
// 			array[j] = tmp1;
// 		}
		
// 	}
	
// 	int tmp;
// 	tmp = array[i+1];
// 	array[i+1] = array[r];
// 	array[r] = tmp;
// 	return i+1;
// }

// public static int binarySearch(int[] array, int needle, int start, int end){
// 	int mid = (start+end)/2;
// 	//base case
// 	if(array[mid] == needle){
// 		return mid;
// 	}
// 	else if(array[mid] > needle){
// 		return(binarySearch(array, needle, start, mid));
// 	} else {
// 		return(binarySearch(array, needle, mid, end));
// 	}
// }



// public static int[] mergeSort(int[] array, int p, int r){
// 	int q;


// 	if(p < r){
// 		q = (p + r)/2;
// 		mergeSort(array, p, q);
// 		mergeSort(array,q +1 , r);
// 		merge(array, p, q, r);
// 	}
// 	return array;
// }

// public static int[] merge(int[] array, int p, int q, int r){
// 	int n1 = q - p;
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

// public static void reverse(Node current){
// 	if(current == NULL){
// 		return;
// 	}

// 	//base case
// 	if(current.next == NULL){
// 		head = current;
// 		return;
// 	}

// 	reverse(current.next);
// 	current.next.next = current;
// 	current.prev = current.next;
// 	current.next = null;

// }

// public static String reverseString(String str){
// 	StringBuilder nStr = new StringBuilder();

// 	for(int i = str.length() - 1; i >= 0; i--){
// 		nStr.append(str.charAt(i));

// 	}
// 	return nStr.toString();
// }

// public static boolean hasSubstring(String sub, String full){

// 	for(int i = 0; i < full.length(); i++){
// 		boolean notMatch = false;
// 		for(int j = 0; j < sub.length(); j++){
// 			if(sub.charAt(j) != full.charAt(i+j)) notMatch = true;
// 			break;
// 		}
// 		if(!notMatch) return true;
// 	}
// 	return false;
// }

// public static HashSet<Integer> targetSum(int[] array, int tSum){
// 	quickSort(array, 0, array.length);
// 	int i = 0;
// 	int j = array.length - 1;
// 	HashSet<Integer> result = new HashSet<>();

// 	while(i <= j){
// 		if((array[i] + array[j]) == tSum){
// 			result.add(array[i]);
// 			result.add(array[j]);
// 			return result;
// 		} else if ((array[i] + array[j]) < tSum){
// 			i++;
// 		} else {
// 			j--;
// 		}

// 	}

// 	return result;
// }

// public static int oddManOut(int[] array){
// 	int sum = 0;
// 	for(int i = 0; i < array.length; i++){
// 		sum ^= array[i];
// 	}
// 	return sum;

// }

// public static void removeWhiteSpaces(String str){
// 	char[] cStr = str.toCharArray();
// 	for(int i = 0; i < cStr.length; i ++){
// 		if(cStr[i] == ' ') cStr[i] = 0;
// 	}
// 	String result = new String(cStr);
// 	System.out.println(result);
// }

// public static boolean isDuplicate(String str){
// 	boolean[] data = new boolean[256];

// 	for(int i = 0; i < str.length(); i++){
// 		if(data[str.charAt(i)]) return false;
// 		data[str.charAt(i)] = true;
// 	}
// 	return true;

// }

// public static boolean isAnagram(String a, String b){
// 	int[] charsInA = new int[256];
// 	int uniqueChars = 0;
// 	int uniqueCharsB = 0;

// 	for(int i = 0; i < a.length(); i++){
// 		if(a.charAt(i) == ' ') continue;
// 		if(charsInA[a.charAt(i)] == 0) ++uniqueChars;
// 		++charsInA[a.charAt(i)];
// 	}


// 	for(int j = 0; j < b.length(); j++){
// 		if(b.charAt(j) == ' ') continue;
// 		if(charsInA[b.charAt(j)] == 0) return false;
// 		--charsInA[b.charAt(j)];
// 		if(charsInA[b.charAt(j)] == 0) ++uniqueCharsB;
// 	}

// 	return (uniqueChars == uniqueCharsB);
// }
	
// public static long pow(int num, int exp){
// 	if(exp == 0) return 1;
// 	if(exp == 1) return num;

// 	long result = num;

// 	for(int i = 1; i < exp; i++){
// 		result *= num;
// 	}
// 	return result;
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

//  public static TreeNode createMinimalBST(int array[]) {
//  	return addToTree(array, 0, array.length - 1);
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

// boolean findElem(int[][] mat, int m, int n, int element){
// 	int row = 0;
// 	int col = n - 1; 
// 	while(row < m && col >= 0){
// 		if(mat[row][col] == element){
// 			return true;
// 		}
// 		if(mat[row][col] > element){
// 			col--;
// 		} else {
// 			row++;
// 		}
// 	}
// 	return false;

// }





public static void main(String[] args){
	Stack stack = new Stack();
	int num = 4;
	LinkedList myQueue = new LinkedList();
	
	
	
	
}

}

