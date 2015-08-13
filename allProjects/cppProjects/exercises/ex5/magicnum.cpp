// magicnum.cpp: Laolu Peters
// Description: magic number manipulation

#include <iostream>
using namespace std;

int reverseNum(int num){
	int result = 0;
	//get lsd multiply by 110 to make it the msd
	result += (num % 10) * 100;
	//subtract lsd from digit to get middle significant digit
	result += (num - (num % 10)) % 100;
	//get msd
	result += (num/100);
	return result;

}


int main(){

	int number, reverse, sub, subreverse, total;
	cout << "Enter a three digit number: "; cin >> number;
	reverse = reverseNum(number);
	cout << "reverse it: " << reverse << endl;
	sub = number - reverse;
	cout << "subtract: " << number << " - " << reverse << " = " << sub << endl;
	subreverse = reverseNum(sub);
	cout << "reverse it: " << subreverse << endl;
	total = subreverse + sub;
	cout << "add: " << sub << " + " << subreverse << " = " << total << endl;  

	return(0);
}