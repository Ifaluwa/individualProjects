// printing.cpp : Laolu Peters
// Description: printing big 


#include <iostream>
using namespace std;

void printF(int repeat){
	while (repeat > 0){
		cout << "FFFF" << endl;
		cout << "F" << endl;
		cout << "FFF" << endl;
		cout << "F" << endl;
		cout << "F" << endl;
		cout << endl;
		repeat--;
	}
}

void printR(int repeat){
	while (repeat > 0){
		cout << "RRRR" << endl;
		cout << "R  R"<< endl;
		cout << "RRR" << endl;
		cout << "R R" << endl;
		cout << "R  R" << endl;
		cout << endl;
		repeat--;
	}
}

void printE(int repeat){
	while (repeat > 0){
		cout << "EEEE" << endl;
		cout << "E" << endl;
		cout << "EEEE" << endl;
		cout << "E" << endl;
		cout << "EEEE" << endl;
		cout << endl;
		repeat--;
	}
}

void printY(int repeat){
	while(repeat > 0){
		cout << "Y   Y" << endl;
		cout << " Y Y " << endl;
		cout << "  Y  " << endl;
		cout << "  Y  " << endl;
		cout << "  Y  " << endl;
		cout << endl;
		repeat--;

	}
}


int main(){

	printF(1);
	
	printR(1);

	printE(2);


	return(0);
}