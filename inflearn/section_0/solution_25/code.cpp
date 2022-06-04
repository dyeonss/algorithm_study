/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 마라톤
 * @version 0.1
 * @date 2022-06-04
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
using namespace std;
int arr[10000];
int res[10000];
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int n;

    cin>>n;

    for(int i=0;i<n;i++){
        cin>>arr[i];
        res[i]=1;
        for(int j=0;j<i;j++){
            if(arr[j]>=arr[i])
                res[i]++;
        }
    }

    for(int i=0;i<n;i++){
        cout<<res[i]<<" ";
    }

    return 0;
}