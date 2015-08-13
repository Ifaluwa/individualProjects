//math puzzle example, Laolu Peters
//Description: A math puzzle

#include<iostream>
using namespace std;

int main () {

  for (int r = 0; r < 100; r++)
    for (int p = 0; p < 100; p++)
      for (int h = 0; h < 100; h++)
        if ((h + p + r) == 100)
          if (((10 * h) + (3 * p) + (0.5 * r)) == 100)
            cout << "Found one! " << h << " horses " << p << " pigs " << r << " rabbits "  << endl;
}