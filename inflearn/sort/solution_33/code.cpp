/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 버블정렬
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
        for(int j=0;j<n-i-1;j++){
            if(arr[j]>arr[j+1]){  //인접한거끼리 스왑, 끝에서부터 가장 큰수 정렬
                tmp=arr[j];
                arr[j]=arr[j+1]; 
                arr[j+1]=tmp;
            }
        }
    }

    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }

    return 0;
}