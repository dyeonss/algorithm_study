/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 자릿수의 합
 * @version 0.1
 * @date 2022-05-07
 * @copyright Copyright (c) 2022
 * 
 */
#include <stdio.h>
#include <iostream>
using namespace std;

int digit_sum(int x){ 
    int tmp, sum=0;

    while(x>0){
        tmp=x%10;
        sum+=tmp;
        x=x/10;  
    }

    return sum;
}
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int n, num, i, sum, res, max=INT_MIN;

    scanf("%d",&n);

    for(i=0;i<n;i++){
        scanf("%d", &num); 
        sum=digit_sum(num);

        if(sum>max){
            max=sum;
            res=num;
        }
        else if(sum==max){
            if(num>res)
                res=num;
        }
    }

    printf("%d\n", res);
    return 0;
}