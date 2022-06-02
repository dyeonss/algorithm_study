/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 분노 유발자
 * @version 0.1
 * @date 2022-05-31
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int n, max, cnt=0;
    int length[100];
    
    cin>>n;

    for(int i=0;i<n;i++){
        cin>>length[i];
    }

    max=length[n-1];
    for(int i=n-2;i>=0;i--){
        if(length[i]>max){
            max=length[i];
            cnt++;
        }
    }

    cout<<cnt<<"\n";

    return 0;
}