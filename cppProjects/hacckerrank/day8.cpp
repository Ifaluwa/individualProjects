//Author: Laolu Peters
// Hackerrank warmups, Summer '16'

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int N;
    cin >> N;

    
    //defining dictionary
    map<string, long int> dict;
    
    //Filling dictionary
    for(int i = 0; i < N; i++){
        string key;
        long int value;
        cin >> key;
        cin >> value;
        dict[key] = value;
    }
    
    //checking entries
    while(cin >> key){
        
        if (dict.find(key) != dict.end()){
            cout << key << "=" << dict[key] << endl;
        } else {
            cout << "Not found" << endl;
        }
    }

    return 0;
}
