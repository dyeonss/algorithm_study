/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 13038. 교환학생
 * @version 0.1
 * @date 2022-05-27
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;
int main(void)
{
    int t;

    freopen("sample_input.txt", "r", stdin);
    
    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        int n, min_day=INT_MAX;
        int day[7];

        cin>>n;

        for(int i=0;i<7;i++){
            cin>>day[i];
        }

        for(int i=0;i<7;i++){
            if(day[i]==1){
                int cnt=0;
                int j=i;
                int daycnt=0;
                 while(cnt<n){
                     if(day[j%7]==1){
                         cnt++;
                     }
                     daycnt++;
                     j++;
                 }
                 min_day=min(daycnt,min_day);
            }
        }

        cout<<"#"<<test_case<<" "<<min_day<<"\n";
    }
    return 0;
}