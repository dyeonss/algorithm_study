/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 숫자의 총 개수(large, 제한시간 1초)
 * @version 0.1
 * @date 2022-05-07
 * @copyright Copyright (c) 2022
 * 
 */
#include <stdio.h>
#include <iostream>
using namespace std;

int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int num, range = 0, res = 0;
    int c =1, d = 9;

    scanf("%d", &num);

    while(num>d+range){
        range = d + range; 
        res = res + c * d;
        d = d * 10;
        c++;
    }

    res = res + (num-range) * c;

    printf("%d\n",res);
    return 0;
}