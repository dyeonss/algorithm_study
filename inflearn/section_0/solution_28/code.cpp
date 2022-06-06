/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 3의 개수는?(small)
 * @version 0.1
 * @date 2022-06-04
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <vector>
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);
    
    int n,tmp, cnt=0;

    cin>>n;

    for(int i=1;i<=n;i++){
        tmp=i;
        while(tmp>0){
            if(tmp%10==3){
                cnt++;
            }
            tmp=tmp/10;
        }
    }

    cout<<cnt<<"\n";
    return 0;
}