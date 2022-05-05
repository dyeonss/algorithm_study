/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 나이 계산(문자열 컨트롤)
 * @version 0.1
 * @date 2022-05-04
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <stdio.h>

using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    char idNum[20];
    int year, age;

    scanf("%s", idNum);

    /*
    아스키코드 
    'A' ~ 'Z': 65 ~ 90
    'a' ~ 'z': 97 ~ 122
    '0' ~ '9': 48 ~ 57
    */
    if(idNum[7]=='1' || idNum[7]=='2') {
        year = 1900 + ((idNum[0] - 48) * 10) + (idNum[1] - 48);
    }
    else {
        year = 2000 + ((idNum[0] - 48) * 10) + (idNum[1] - 48);
    }
    age = 2019 - year + 1;

    printf("%d ", age);

    if(idNum[7]=='1' || idNum[7]=='3') 
        printf("M\n");
    else
        printf("W\n");

    return 0;
}