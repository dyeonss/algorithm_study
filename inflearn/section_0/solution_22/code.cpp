/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 연속 부분 증가수열
 * @version 0.1
 * @date 2022-06-03
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
using namespace std;
int arr[100000];
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int n, size=1, max=0;
    
    cin>>n;

    for(int i=0;i<n;i++){
        cin>>arr[i];
        if(i>=1&&arr[i]>=arr[i-1]){
            size++;
            if(size>max)
                max=size;
        }
        else if(i>=1&&arr[i]<arr[i-1]){
            size=1;
        }
    }

    cout<<max<<"\n";
    return 0;
} 