/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 교집합(투포인터 알고리즘)
 * @version 0.1
 * @date 2022-06-11
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <algorithm>
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int n, m, p1=0, p2=0, idx=0;
    int arrn[30000], arrm[30000], res[30000];

    cin>>n;
    for(int i=0;i<n;i++){
        cin>>arrn[i];
    }
    sort(arrn,arrn+n);

    cin>>m;
    for(int i=0;i<m;i++){
        cin>>arrm[i];
    }
    sort(arrm,arrm+m);

    while(p1<n&&p2<m){
        if(arrn[p1]<arrm[p2]){
            p1++;
        }
        else if(arrn[p1]==arrm[p2]){
            res[idx]=arrn[p1];
            p1++;
            p2++;
            idx++;
        }
        else{
            p2++;
        }
    }
    
    for(int i=0;i<idx;i++){
        cout<<res[i]<<" ";
    }
    return 0;
}