#include<iostream>
using namespace std;

/*
   simple implemetation of getting all subsets of given array.
*/

void print_subset(int cur);

template <typename T>
class Vector {
	T* data;
	int length;
	int capacity;

public:
	Vector(int n = 1) : data(new T[n]), capacity(n), length(0) {}
	void push_back(T s) {
		if (capacity <= length) {
			T* temp = new T[capacity * 2];
			for (int i = 0; i < capacity; i++) {
				temp[i] = data[i];
			}
			delete[] data;
			data = temp;
			capacity *= 2;
		}

		data[length] = s;
		length++;
	}

	T operator[](int i) { return data[i]; }

	T pop_back() {
		if (length == 0) {
			return NULL;
		}

		length--;
		return data[length + 1];
	}

	int size() { return length; }

	~Vector() {
		if (data) {
			delete[] data;
		}
	}
};

// data
Vector<int> arr;
int siz = 4;
// end data

/*
int main() {
    print_subset(0);
    return 0;
}
*/

void print_subset(int cur) {
    if(cur == siz) {
        cout << "{";
        for(int i=0;i< arr.size();i++) {
            cout << arr[i];
            if(i != siz - 1 && arr.size() - 1 > i) {
                cout << ",";
            }
        }
        cout << "}\n"; // '\n' is faster than 'endl'
    } 
    else {
        // add an element of `cur` position
		arr.push_back(cur+1);
        print_subset(cur+1);
        // don't add the element
		arr.pop_back();
        print_subset(cur+1);
    }
}

/*
 To implement the task, i need to implement a simple vector.
*/

