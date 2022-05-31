/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 12741. 두 전구
 * @version 0.1
 * @date 2022-05-27
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <algorithm>
using namespace std;
int main(void)
{
    int t;

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    freopen("sample_input.txt", "r", stdin);
    
    cin >> t;

    for (int test_case = 1; test_case <= t; test_case++)
    {
        int lamp[4];
        int x, y, res=0;

        for (int i = 0; i < 4; i++)
        {
            cin >> lamp[i];
        }

        if (lamp[1] <= lamp[2])
        {
            res = 0;
        }
        else
        {

            x=max(lamp[0],lamp[2]);

            y=min(lamp[1],lamp[3]);
            
            res=y-x;
        }
        cout<<"#"<<test_case<<" "<<res<<"\n";
    }
    return 0;
}