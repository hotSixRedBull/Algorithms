#include<iostream>
using namespace std;

// data start
int siz = 4; // example size is 4*4 matrix
int ans = 0;
// 3 arrays below are the thing i learned today. it's an awesome idea.
/*
    col   diag1 diag2
    0123  0123  3456
    0123  1234  2345
    0123  2345  1234
    0123  3456  0123
*/
int* col = new int[siz] {};
int* diag1 = new int[siz*2] {};
int* diag2 = new int[siz*2] {};
// data end

void search(int y);

int main() {
    search(0);
    cout << ans << "\n";
    return 0;
}

void search(int r) {
    if(r == siz) {
        ans++;
    }
    else {
        for(int c=0;c<siz;c++) {
            if(col[c] || diag1[r+c] || diag2[c-r+siz-1]) continue;
            col[c] = diag1[r+c] = diag2[c-r+siz-1] = 1;
            search(r+1);
            col[c] = diag1[r+c] = diag2[c-r+siz-1] = 0;
        }
    }
}

