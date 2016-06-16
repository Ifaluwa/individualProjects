// euclid.cpp, Laolu Peters
// Description: An implementation of Euclid's algorithm for computing gcd.
// Fundamental idea of Euclid's algorithm (one of the oldest known algorithms)
// for finding the greatest common divisor of two integers:
// gcd(a, 0) = a
// gcd(a, b) = gcd(b, a % b)  // % means modulo, that is, the remainder of a/b.
// For example, gcd(6, 4) = 2; gcd(12, 18) = 6.

#include <iostream>
using namespace std;

// A non-recursive version of Euclid's algorithm
int gcd (int a, int b) {
  int temp;
  while (b != 0) {
    temp = a % b;
    a = b;
    b = temp;
  }
  return(a);
}

int recursiveGcd(int a, int b){
  //base case
  if (b == 0){
    return a;
  //recursive case
  }else {
    return(recursiveGcd(b, a % b));
  }
}

int main () {
  int x, y;
  cout << "Enter two integers: ";
  if (!(cin >> x >> y)) {
    cout << "Please enter only integers" << endl;
  } else {
    cout << "gcd(" << x << ", " << y << ") = " << gcd(x,y) << " recursive gcd = " << recursiveGcd(x,y) << endl;
  }
  return(0);
}