/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 3등의 성적은
 * @version 0.1
 * @date 2022-06-05
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <vector>
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int arr[100], n, tmp, score, third;

    cin>>n;

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    for(int i=0;i<n-1;i++){
        int idx=i;
        for(int j=i+1;j<n;j++){
            if(arr[j]>arr[idx])  //내림차순
                idx=j;
        }
        tmp=arr[idx];
        arr[idx]=arr[i];
        arr[i]=tmp;
    }

    score=arr[0];
    third=1;
    for(int i=1;i<n;i++){
        if(score>arr[i]){
            score=arr[i];
            third++;
        }
        if(third==3){
            break;
        }
    }

    cout<<score<<"\n";
    return 0;
}