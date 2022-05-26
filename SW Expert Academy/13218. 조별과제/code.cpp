/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 13218. 조별과제
 * @version 0.1
 * @date 2022-05-26
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
using namespace std;
char farm[49][49];
int main(void)
{
    int t;

    freopen("sample_input.txt", "r", stdin);
    
    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        int n, cnt=0;

        cin>>n;

        if(n<3)
            cnt=0;
        else 
            cnt=n/3;

        
        cout<<"#"<<test_case<<" "<<cnt<<"\n";
    }
    return 0;
}