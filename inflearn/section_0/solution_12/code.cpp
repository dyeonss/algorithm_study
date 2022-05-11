/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 가장 많이 사용된 자릿수
 * @version 0.1
 * @date 2022-05-09
 * @copyright Copyright (c) 2022
 * 
 */
#include <stdio.h>
#include <iostream>
// #include <limits.h>

int freq[10];
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    char num[101];
    int max = INT_MIN;
    int tmp, res;

    scanf("%s", num);

    for(int i=0; num[i]!='\0'; i++){
        tmp = num[i]-48;
        freq[tmp]++;
    }

    for(int i=0; i<10; i++){
        if(freq[i]>=max){
            max = freq[i];
            res = i;
        }
    }

    printf("%d\n", res);

    return 0;
}