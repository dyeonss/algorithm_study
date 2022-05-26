/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 1984. 중간 평균값 구하기
 * @version 0.1
 * @date 2022-05-24
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main(void)
{
    int t;

    freopen("input.txt", "r", stdin);
    
    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        vector<int> arr;
        int n;
        double res=0;

        for(int i=0;i<10;i++){
            cin>>n;
            arr.push_back(n);
        }
        sort(arr.begin(),arr.end());
        
        for(int i=1;i<9;i++)
            res+=arr[i];

        cout<<"#"<<test_case<<" "<<fixed;
        cout.precision(0);
        cout<<res/8<<"\n";

    }
    return 0;
}





