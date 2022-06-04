/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 석차 구하기
 * @version 0.1
 * @date 2022-06-03
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <algorithm>
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    /**
     * @brief 강의 code
     * 
     */
    int a[100], b[100], n;

    cin>>n;

    for(int i=0;i<n;i++){
        cin>>a[i];
        b[i]=1;
    }

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(a[j]>a[i]){
                b[i]++;
            }
        }
    }

    for(int i=0;i<n;i++){
        cout<<b[i]<<" ";
    }
    /**
     * @brief My Code
     * 
     */
    
    // int n;
    // int arr[100]={0};
    // int tmp[100]={0};
    // int res[100]={0};
    // int chk[100]={0};

    // cin>>n;

    // for(int i=0;i<n;i++){
    //     cin>>arr[i];
    //     tmp[i]=arr[i];
    // }

    // sort(tmp,tmp+100);
    // reverse(tmp,tmp+100);
    
    // for(int i=0;i<n;i++){
    //     int fix;
    //     for(int j=0;j<n;j++){
    //         if(chk[j]!=0)
    //             continue;
    //         if(tmp[i]==arr[j]){
    //             if(i>=1&&tmp[i]==tmp[i-1]){
    //                 res[j]=fix;
    //             }
    //             else{
    //                 res[j]=i+1;
    //                 fix=res[j];
    //             }
    //             chk[j]=1;
    //             break;
    //         }
    //     }
    // }

    // for(int i=0;i<n;i++){
    //     cout<<res[i]<<" ";
    // }
    

    return 0;
}