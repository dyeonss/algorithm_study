/**
 * @file code.cpp
 * @author shindoyeon
 * @brief Anagram(아나그램: 구글 인터뷰 문제)
 * @version 0.1
 * @date 2022-05-09
 * @copyright Copyright (c) 2022
 * 
 */
#include <stdio.h>
#include <iostream>

using namespace std;
int s1_alpha[52];
int s2_alpha[52];
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    char str[100];
    char in[100];
    bool flag = true;

    scanf("%s", str);

    for(int i=0;str[i]!='\0';i++){
        if(str[i]>=65&&str[i]<=90)
            s1_alpha[str[i]-65]++;
        else
            s1_alpha[str[i]-71]++;
    }

    scanf("%s", str);
    for(int i=0;str[i]!='\0';i++){
        if(str[i]>=65&&str[i]<=90)
            s2_alpha[str[i]-65]++;
        else
            s2_alpha[str[i]-71]++;
    }

    for(int i=0; i<52; i++){
        if(s1_alpha[i]!=s2_alpha[i]){
            flag = false;
            break;
        }
    }

    if(flag==true)
        printf("YES\n");
    else
        printf("NO\n");

    return 0;
}