#include<string>
#include<iostream>

using namespace std;

class B{
public:
	B();

};

class C : public B{
public:
	C();
};

B::B(){
	cout << "B"; 
}

C::C(){
	cout << "C";
}

int main(){
	C* c = new C();
	cout << endl;

}