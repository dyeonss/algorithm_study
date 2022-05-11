/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 뒤집은 소수
 * @version 0.1
 * @date 2022-05-09
 * @copyright Copyright (c) 2022
 * 
 */
#include <stdio.h>
#include <iostream>
// #include <limits.h>

using namespace std;
int reverse(int x){
    int d = 1, res = 0;

    while(x>0){
        res = res*10+(x%10);
        x = x/10;
    }

    return res;
}
bool isPrime(int x){
    bool flag = true;

    if(x==1)
        return false;
    for(int i=2;i<x;i++){
        if(x%i==0){
            flag = false;
            break;
        }
    }
    
    return flag;
}
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int n, num, revnum;

    scanf("%d", &n);

    for(int i=0; i< n; i++){
        scanf("%d", &num);
        revnum = reverse(num);
        
        if(isPrime(revnum)==true){
            printf("%d ", revnum);
        }
    }
    return 0;
}