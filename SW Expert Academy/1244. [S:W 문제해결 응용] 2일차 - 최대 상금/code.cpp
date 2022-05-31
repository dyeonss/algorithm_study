/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 1244. [S/W 문제해결 응용] 2일차 - 최대 상금
 * @version 0.1
 * @date 2022-05-16
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int ans, change;
string s;

void dfs(int index, int current)
{
    if(current == change)
    {
        ans = max(ans, stoi(s));
        return;
    }
    else{
        for(int i = index; i < s.size() - 1; i++)
        {
            for(int j = i + 1; j < s.size(); j++)
            {
                swap(s[i], s[j]);
                dfs(i, current + 1);
                swap(s[i], s[j]);
        }
    }
    }
}

int main(void)
{
    int t;

    freopen("input.txt", "r", stdin);

    cin >> t;
    
    for(int i = 1; i <= t; i++)
    {
        cin >> s >> change;
        ans = 0;
        
        if(change > s.size())
            change = s.size();
            ;
        dfs(0, 0);
        cout << "#" << i << " " << ans << endl;
    }

    return 0;
}