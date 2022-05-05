/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 자연수의 합
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

    int a, b, i, sum = 0;

    cin>>a>>b;

    for(i = a; i < b; i++){
        cout<<i<<" + ";
        sum = sum + i;
    }
    cout<<i<<" = ";
    cout<<sum+i;
    return 0;
}