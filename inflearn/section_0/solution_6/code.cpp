/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 영어단어 복구
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
    
    char input[100], result[100];
    int i, pos = 0;

    gets(input);

    /*
    'A' ~ 'Z': 65 ~ 90
    'a' ~ 'z': 97 ~ 122
    '0' ~ '9': 48 ~ 57
    */
    for(i=0; input[i]!='\0';i++){
        if(input[i]!=' '){
            if(input[i]>=65 && input[i]<=90){
                result[pos++] = input[i] + 32;
            }
            else if(input[i]>=97 && input[i]<=122){
                result[pos++] = input[i];
            }
        }
    }

    result[pos]='\0';

    printf("%s\n", result);

    return 0;
}