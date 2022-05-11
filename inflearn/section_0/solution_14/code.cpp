/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 소수의 개수(제곱근을 활용하자)
 * @version 0.1
 * @date 2022-05-09
 * @copyright Copyright (c) 2022
 * 
 */
#include <stdio.h>
#include <iostream>

using namespace std;

int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int num, cnt = 0;
    bool flag;

    scanf("%d", &num);

    for(int i=2; i<=num; i++){
        flag = true;
        for(int j=2; j*j<=i; j++){
            if(i%j==0){
                flag = false;
                break;
            }
        }
        if(flag==true)
            cnt++;
    }
    
    printf("%d\n", cnt);
    return 0;
}