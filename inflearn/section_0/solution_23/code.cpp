/**
 * @file code.cpp
 * @author shindoyeon
 * @brief Jolly Jumpers
 * @version 0.1
 * @date 2022-06-03
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <algorithm>
using namespace std;
int arr[100];
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int n;
    string res="YES";

    cin>>n;
    int diff[n-1];

    /**
     * @brief My code
     * 
     */
    
    for(int i=0;i<n;i++){
        cin>>arr[i];
        if(i>=1&&i<=n-1){
            diff[i-1]=i;
        }
    }

    for(int i=0;i<n-1;i++){
        int pos =find(diff,diff+(n-1),abs(arr[i]-arr[i+1]))-diff;  //만약 없으면 last 반환
        if(pos==n-1){
            res="NO";
            break;
        }
        else{
            diff[pos]=0;
        }
    }


   /**
    * @brief 강의 code
    * 
    */
   /*
    fill_n(diff,n-1,0);

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    for(int i=0;i<n-1;i++){
        int d=abs(arr[i]-arr[i+1]);
        if(d>n-1){
            res="NO";
            break;
        }
        if(diff[d-1]==0){
            diff[d-1]=1;
        }
        else if(diff[d-1]!=0){
            res="NO";
            break;
        }
    }
    */

    cout<<res<<"\n";

    return 0;
}