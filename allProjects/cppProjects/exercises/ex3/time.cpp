// time.cpp: Laolu Peters
// Description: calculates time given seconds

#include <iostream>
using namespace std;

#define secsinanhour 3600

int main(){
	int inputseconds, calchours, calcminutes, calcseconds ;

	cout << "Number of seconds: "; cin >> inputseconds;

	calchours = inputseconds/secsinanhour;
	calcminutes = (inputseconds % secsinanhour) / 60;
	calcseconds = (inputseconds % secsinanhour) % 60;

	cout << "Hours: " << calchours << endl;
	cout << "Minutes: " << calcminutes << endl;
	cout << "Seconds: " << calcseconds << endl;

	return(0);


}