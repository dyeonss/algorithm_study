/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 숫자만 추출
 * @version 0.1
 * @date 2022-05-05
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <stdio.h>

using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);
    
    char input[50];
    int result = 0, cnt = 0, i;

    scanf("%s", input);

    //result 구하기
    for(i=0; input[i] != '\0'; i++){
        // '0' ~ '9': 48 ~ 57
        if(input[i] >=48 && input[i] <=57){
            result = result * 10 + (input[i]-48);       //  **result에 10을 곱하는 이유: 숫자가 정렬될 때 백, 십, 일의 자리 이런 순으로 정렬되기 때문 
        }
    }

    printf("%d\n", result);

    //약수 구하기
    for(i=1; i<=result; i++){
        if(result%i == 0){
            cnt++;
        }
    }
    
    printf("%d\n", cnt);

    return 0;
}