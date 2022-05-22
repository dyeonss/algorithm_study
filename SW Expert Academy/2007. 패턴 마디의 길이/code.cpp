/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 2007. 패턴 마디의 길이
 * @version 0.1
 * @date 2022-05-21
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <string>
using namespace std;
int main(void)
{
    int t;

    freopen("input.txt", "r", stdin);

    cin >> t;
    
    for(int i = 1; i <= t; i++)
    {
        string s, tmp;
        cin >> s;
        
        tmp.push_back(s[0]);

        for(int i=1;i<s.length();i++){          //SAMSUNGSAMSUNGSAMSUNGSAMSUNGSA
            if(tmp!=s.substr(tmp.size(),i))     //11 22 33  44 55 66 77 
                tmp.push_back(s[i]);           //SAMSUNG
            else
                break;
        }
        cout << "#" << i << " " << tmp.size() << endl;
    }
    return 0;
}





