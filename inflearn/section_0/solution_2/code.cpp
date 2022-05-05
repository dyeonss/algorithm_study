/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 진약수의 합(진약수: 자기 자신을 제외함)
 * @version 0.1
 * @date 2022-05-04
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int n, i, sum = 1;

    cin>>n;
    cout<<"1";

    //진약수이기 때문에 자기자신 제외
    for(i=2;i<n;i++){
        if(n%i==0){
            cout << " + " << i;
            sum = sum + i;
        }
    }
    
    cout<<" = "<<sum;
    return 0;
}