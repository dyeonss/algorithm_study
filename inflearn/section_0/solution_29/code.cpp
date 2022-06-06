/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 3의 개수는?(large)
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
    
    int n, k, left, right, current, res=0;

    cin>>n;

    int tmp=n;
    k=1;
   
    while(tmp>0){
        left=tmp/10;
        current=tmp%10;
        right=n%k;

        if(current>3){
            res+=(left+1)*k;
        }
        else if(current==3){
            res+=left*k+right+1;
        }
        else if(current<3){
            res+=left*k;
        }
        k=k*10;
        tmp=tmp/10; //536
    }

    cout<<res<<"\n";
    return 0;
}