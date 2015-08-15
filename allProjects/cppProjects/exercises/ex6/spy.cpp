//spy.cpp: Laolu Peters
//Description: code to figure out expiry dates given encoding

#include <iostream>
using namespace std;
#define kyear 1995

int main(){

	string encode, month, day, year;
	cout << "Enter encoded date: "; cin >> encode;
	month = encode.substr(0,1);
	year = encode.substr(3,4);
	cout << year << endl;


	return(0);
}