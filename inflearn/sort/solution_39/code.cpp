/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 두 배열 합치기
 * @version 0.1
 * @date 2022-06-11
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);
    //freopen("./test/in1.txt", "r", stdin);
    int i, n, m, p1=0, p2=0, idx=0;
    int arrn[100], arrm[100], res[200];

    cin>>n;
    for(i=0;i<n;i++){
        cin>>arrn[i];
    }
    
    cin>>m;
    for(i=0;i<m;i++){
        cin>>arrm[i];
    }

     while(p1<n&&p2<m){
        if(arrn[p1]<arrm[p2]){
            res[idx]=arrn[p1];
            p1++;
        }
        else{
            res[idx]=arrm[p2];
            p2++;
        }
        idx++;
    }

    if(p1==n){
        for(i=p2;i<m;i++){
            res[idx]=arrm[i];
            idx++;
        }
    }
    else{
        for(i=p1;i<n;i++){
            res[idx]=arrn[i];
            idx++;
        }
    }

    for(i=0;i<n+m;i++)
        cout<<res[i]<<" ";
    return 0;
}