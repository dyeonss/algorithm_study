/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 13229. 일요일
 * @version 0.1
 * @date 2022-05-25
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
vector<string> days={"SAT","FRI","THU","WED","TUE","MON","SUN"};
int main(void)
{
    int t;
    freopen("sample_input.txt", "r", stdin);
    
    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        string s;
        int i=0;
        cin>>s;

        int idx=find(days.begin(),days.end(),s)-days.begin();
   
        cout<<"#"<<test_case<<" "<<idx+1<<"\n";
    }
    return 0;
}



