// chirp.cpp: Laolu Peters
// Description: finds the temperature giving number of chirps per minute


#include <iostream>
using namespace std;

#define constantadder 40.0

int main(){

	float chirpnumber;
	float temperature;

	cout << "Number of chirps: "; cin >> chirpnumber;

	temperature = (chirpnumber + constantadder) / 4.0;

	cout << "The temperature is: " << temperature << " degrees." << endl;

	return(0);
}