
import java.util.*;
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

// public static void removeDuplicates(char[] str){
// 	if (str == null) return;
//  	int len = str.length;
//  	if (len < 2) return;

//  	int tail = 1;

//  	for (int i = 1; i < len; ++i) {
//  	int j;	
//  		for (j = 0; j < tail; ++j) {
//  			if (str[i] == str[j]) {
//  				break;
//  			}
//  		}
//  		if (j == tail) {
//  			str[tail] = str[i];
//  			++tail;
//  		}
//  	}

//  	str[tail] = 0;

// }

public static HashSet<Integer> findMaxCrossingSubArray(int[] array){
	int leftSum = Integer.MIN_VALUE;
	int rightSum = Integer.MIN_VALUE;
	int mid = array.length/2;


	
	int lSum = 0;
	for(int i = mid - 1; i >= 0; i--){
		lSum = array[i] + lSum;
		if (lSum > leftSum){
			leftSum = lSum;
		}
	}

	int rSum = 0;
	for(int j = mid; j < array.length; j++){
		rSum = array[j] + rSum;
		if(rSum >rightSum){
			rightSum = rSum;
		}
	}


	HashSet<Integer> stuff = new HashSet<Integer>();
	stuff.add(leftSum);
	stuff.add(rightSum);
	//stuff.add(leftSum+rightSum);
	return stuff;

}


public static void quickSort(int[] array, int p, int r){
	int q;
	if(p < r){
		q = partition(array, p, r);
		quickSort(array, p, q-1);
		quickSort(array, q+1, r);
	} 

}

public static int partition(int[] array, int p, int r){
	//resolves issue of if index is out of bounds
	if(r == array.length){
		r -= 1;		
	} 
	
	int x = array[r];
	int i = p-1;
	for(int j = p; j < r; j++){
		if(array[j] <= x){
			i+=1;
			int tmp1;
			tmp1 = array[i];
			array[i] = array[j];
			array[j] = tmp1;
		}
		
	}
	
	int tmp;
	tmp = array[i+1];
	array[i+1] = array[r];
	array[r] = tmp;
	return i+1;
}

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

// public static boolean hasDuplicate(int[] array){
// 	boolean[] data = new boolean[256];
// 	for(int i = 0 ; i < array.length; i++){
// 		if(data[array[i]] == true){
// 		 	return true;
// 		 }
// 		data[array[i]] = true;
// 	}
// 	return false;
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

public static int oddManOut(int[] array){
	int sum = 0;
	for(int i = 0; i < array.length; i++){
		sum ^= array[i];
	}
	return sum;

}





public static void main(String[] args){
	int[] array = {1,-3,5,-2,9,-8,-6,4};
	// //quickSort(array, 0, array.length);
	//String stuff = Arrays.toString(mergeSort(array, 0, array.length));
	//System.out.println(stuff);
	String sub = "bat";
	String full = "adfdfadfafafdsabate";
	// boolean ans = hasSubstring(sub, full);
	System.out.println(findMaxCrossingSubArray(array));
	
}

}
