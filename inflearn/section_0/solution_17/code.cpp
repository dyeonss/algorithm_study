/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 층간 소음
 * @version 0.1
 * @date 2022-05-30
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
int arr[100];
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int n, m, cnt=0, max=INT_MIN;
    
    cin>>n>>m;

    for(int i=0;i<n;i++){
        cin>>arr[i];
        if(arr[i]>m){
            cnt++;
        }
        else{
            cnt=0;
        }
        if(cnt>max){
            max=cnt;
        }
    }
    if(max==0){
        max=-1;
    }

    cout<<max<<"\n";
    return 0;
}