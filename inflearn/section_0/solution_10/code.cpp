/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 숫자의 총 개수(small)
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

    int num, res = 0;

    scanf("%d", &num);

    for (int i = 1; i <= num; i++)
    {
        int x = i;
        while (x > 0)
        {
            res += 1;
            x = x / 10;
        }
    }
    printf("%d\n",res);
    return 0;
    
    return 0;
}