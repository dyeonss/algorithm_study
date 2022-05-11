/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 선생님 퀴즈
 * @version 0.1
 * @date 2022-05-10
 * @copyright Copyright (c) 2022
 * 
 */
#include <stdio.h>
#include <iostream>

using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int num, n, sum;

    scanf("%d", &num);

    string res[num];
    
    for(int i=0; i<num; i++){
        scanf("%d %d", &n, &sum);

        if(int(double(1+n)/2*n)== sum)
            printf("YES\n");
        else
            printf("NO\n");
    }

    return 0;
}