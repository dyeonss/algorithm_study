/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 이분검색
 * @version 0.1
 * @date 2022-06-27
 * @copyright Copyright (c) 2022
 **/
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main(int argc, char* argv[]){
    int n, lt, rt, mid, key;

    cin>>n>>key;

    vector<int> arr(n);

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    sort(arr.begin(),arr .end());

    lt=0, rt=n-1;

    while(true){
        mid=(lt+rt)/2;

        if(arr[mid]==key){
            break;
        }
        else if(arr[mid]>key){
            rt=mid-1;
        }
        else if(arr[mid]<key){
            lt=mid+1;
        }
    }

    cout<<mid+1<<"\n";
    return 0;
}