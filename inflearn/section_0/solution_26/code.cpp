/**
 * @file code.cpp
 * @author shindoyeon
 * @brief N!의 표현법
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

    int n, tmp, j;

    cin>>n;
    vector<int> div(n+1,0);

    for(int i=2;i<=n;i++){
        //소인수분해
        tmp=i;
        j=2;
        while(tmp>1){
            if(tmp%j==0){
                tmp=tmp/j;
                div[j]++;
            }
            else{
                j++;
            }
        }
    }

    cout<<n<<"! = ";
    for(int i=2;i<=n;i++){
        if(div[i]!=0)
            cout<<div[i]<<" ";
    }
    return 0;
}