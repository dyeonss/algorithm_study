/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 선택정렬
 * @version 0.1
 * @date 2022-06-06
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <vector>
using namespace std;
int main(int argc, char* argv[]){

    int n, tmp, arr[100];

    cin>>n;

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    
    for(int i=0;i<n-1;i++){
        int idx=i;
        for(int j=i+1;j<n;j++){
            if(arr[j]<arr[idx]){
                idx=j;
            }
        }
        tmp=arr[idx];
        arr[idx]=arr[i];
        arr[i]=tmp;

        for(int i=0;i<n;i++){
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
    }

    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }

    return 0;
}