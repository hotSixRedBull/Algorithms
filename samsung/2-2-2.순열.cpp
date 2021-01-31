#include<iostream>
using namespace std;

template<typename T>
class Vector {
	T* data;
	int capacity;
	int length;
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

	int size() { return length; }

	T pop_back() {
		length--;
		return data[length + 1];
	}

	T operator[](int i) { return data[i]; }

	~Vector() {
		if (data) {
			delete[] data;
		}
	}
};

// data start
Vector<int> permutation_vector;
int permutation_siz = 4;
bool chosen[4] = { false, false, false, false };
// data end

void print_permutation(int cur);
void print_vector();

int main() {
    print_permutation(0);
    return 0;
}

void print_permutation(int cur) {
    if(permutation_siz == cur) {
        print_vector();
    }
    else {
        for (int i=0;i< permutation_siz;i++) {
            if(chosen[i]) continue;
            chosen[i] = true;
            permutation_vector.push_back(i);
            print_permutation(cur+1);
            chosen[i] = false;
            permutation_vector.pop_back();
        }
    }
}

void print_vector() {
    cout << "{";
    for (int i=0;i<permutation_vector.size();i++) {
        cout << permutation_vector[i];
        if(i != permutation_vector.size() -1) {
            cout << ",";
        }
    }
    cout << "}\n"; // \n is faster than 'endl'
}