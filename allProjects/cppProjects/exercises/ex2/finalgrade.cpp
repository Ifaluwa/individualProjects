// finalgrade.cpp: Laolu Peters
// Description: program to calculate the final grade 

#include <iostream>
using namespace std;


int main(){
	int firstasgnmnt, secondasgnmnt, thirdasgnmnt, fourthasgnmt, midterm, final, sectiongrade;
	float finalscore;

	cout << "Enter the score for the first assignment: "; cin >> firstasgnmnt; 
	cout << "Enter the score for the second assignment: "; cin >> secondasgnmnt;
	cout << "Enter the score for the third assignment: "; cin >> thirdasgnmnt;
	cout << "Enter the score for the fourth assignment: "; cin >> fourthasgnmt;
	cout << "Enter the score for the midterm: "; cin >> midterm;
	cout << "Enter the score for the final: "; cin >> final;
	cout << "Enter the score for the section grade: "; cin >> sectiongrade;

	finalscore = ((firstasgnmnt + secondasgnmnt + thirdasgnmnt + fourthasgnmt)/4) * .4;
	finalscore += (midterm * .15) + (final * .35) + (sectiongrade * .1);

	cout << "The final grade is: " << finalscore << endl;

	return(0);

}
