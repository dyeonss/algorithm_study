/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 올바른 괄호
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
    
    char input[30];
    int i, cnt = 0;

    scanf("%s", input);

    //문자열의 끝 '\0'
    for(i=0; input[i]!='\0'; i++){
        if(input[i]=='(')
            cnt++;
        else if(input[i]==')')
            cnt--;
        if(cnt < 0)
            break;
    }

    if(cnt==0)
        printf("YES\n");
    else
        printf("NO\n");

    return 0;
}