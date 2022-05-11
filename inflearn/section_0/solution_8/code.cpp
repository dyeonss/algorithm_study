/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 모두의 약수(제한시간 1초)
 * @version 0.1
 * @date 2022-05-05
 * @copyright Copyright (c) 2022
 * 
 */
#include <stdio.h>
using namespace std;

int cnt[50001];  //0으로 초기화됨
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int i, j, n;

    scanf("%d", &n);

    for(i=1; i<=n; i++){
        //1의 배수, 2의 배수, 3의 배수 ... 카운트 올려주기
        for(j=i; j<=n; j=j+i){
            cnt[j]++;
        }
    }

    for(i=1;i<=n;i++){
        printf("%d ",cnt[i]);
    }

    printf("\n");

    return 0;
}