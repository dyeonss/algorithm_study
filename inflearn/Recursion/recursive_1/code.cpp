/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 재귀함수 분석
 * @version 0.1
 * @date 2022-05-19
 * @copyright Copyright (c) 2022
 * 
 */
#include <stdio.h>
#include <iostream>

void recursion(int num){
    if(num==0){
        return;
    }
    else{
        recursion(num-1);
        printf("%d",num);
    }
}
using namespace std;
int main(int argc, char* argv[]){
    // freopen(argv[1], "rt", stdin);
	// freopen(argv[2], "w", stdout);

    int n;

    scanf("%d", &n);

    recursion(n);

    printf("\n");
    return 0;
}