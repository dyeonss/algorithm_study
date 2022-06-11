/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 삽입정렬
 * @version 0.1
 * @date 2022-06-08
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <vector>
using namespace std;
int main(int argc, char* argv[]){

    int n, i, j, tmp, arr[100];

    cin>>n;

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    
    for(i=1;i<n;i++){
        int cmp =arr[i];
        for(j=i-1;j>=0;j--){
            if(cmp<arr[j]){  //arr[j]는 이미 정렬 된 상태
                arr[j+1]=arr[j];
            }
            else 
                break;
        }
        cout<<"j: "<<j<<"\n";
        arr[j+1]=cmp;
    }

    for(i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}