/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 1986. 지그재그 숫자
 * @version 0.1
 * @date 2022-05-24
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
using namespace std;
int main(void)
{
    int t;

    freopen("input.txt", "r", stdin);
    
    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        int n, res=0;

        cin>>n;

        for(int i=1;i<=n;i++){
            if(i%2==0)
                res=res-i;
            else
                res=res+i;
        }
        
        cout<<"#"<<test_case<<" "<<res<<"\n";

    }
    return 0;
}





