/**
 * @file code.cpp
 * @author shindoyeon
 * @brief Inversion Sequence
 * @version 0.1
 * @date 2022-06-08
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int is[100], os[100], n, pos=0;

    cin>>n;

    for(int i=0;i<n;i++){
        cin>>is[i];
    }

    for(int i=n;i>=1;i--){
        pos=i-1;
        for(int j=is[i-1];j>0;j--){
            os[pos]=os[pos+1];
            pos++;
        }
        os[pos]=i;
    }

    for(int i=0;i<n;i++){
        cout<<os[i]<<" ";
    }
    return 0;
}