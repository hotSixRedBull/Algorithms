// bit calculation
#include<iostream>
using namespace std;

void print_elements(int x);

int main() {
	int x = 0;
	/*
    cout << "printing continuous digit from left" << endl;
    x = 19;
    //cout << __builtin_clz(x) << endl;
    cout << "printing continuous digit from right" << endl;
    x = 4;
    cout << __builtin_clt(x) << endl;
    cout << "printing the number of digits" << endl;
    x = 5;
    cout << __builtin_popcount(x) << endl;
    */
	cout << "calculating all subsets from {0, 1, 2, ..., n}" << endl;
    int n = 10;
    for(int b = 0; b < (1<<n); b++) {
        print_elements(b);
    }
    // cout << "calculating all subsets having k elements" << endl;
    // int k = 3;
    // for(int b = 0;b<(1<<n);b++) {
    //     if(__builtin_popcount(x) == k) print_elements(x);
    // }
    cout << "calculating all subsets of x" << endl;
    x = 0;
    x |= (1<<1);
    x |= (1<<3);
    x |= (1<<4);
    x |= (1<<8);
    int b = 0;
    do {
        print_elements(b);
    }while (b=(b-x)&x);
}

void print_elements(int x) {
    for (int i=0; i<32; i++) {
        if(x&(1<<i)) cout << i << " ";
    }
    cout << endl;
}