#include<iostream>
using namespace std;
FILE* stream;
int main() {
	freopen_s(&stream, "input.txt", "r", stdin);
	freopen_s(&stream, "output.txt", "w", stdout);
	char c;
	cin >> c;
	cout << c << endl;
    return 0;
}