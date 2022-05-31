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

    int n, cnt=0;
    int length[100];
    
    cin>>n;

    for(int i=0;i<n;i++){
        cin>>length[i];
    }

    for(int i=0;i<n-1;i++){
        bool tall=true;
        for(int j=i+1;j<n;j++){
            if(length[j]>=length[i]){
                tall=false;
                break;
            }
        }
        if(tall==true)
            cnt++;
    }

    cout<<cnt<<"\n";

    return 0;
}