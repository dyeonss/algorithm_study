/**
 * @file code.cpp
 * @author shindoyeon
 * @brief N!에서 0의 개수
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
    
    int n, tmp, j,res=1;

    cin>>n;
    vector<int> div(n+1);

    for(int i=2;i<=n;i++){
        tmp=i;
        j=2;
        while(tmp>1){
            if(tmp%j==0){
                div[j]++;
                tmp=tmp/j;
            }
            else
                j++;
        }
    }
    
    if(div[2]>=div[5])
        res=div[5];
    else
        res=div[2];
   cout<<res<<"\n";
    return 0;
}