/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 1859. 백만 장자 프로젝트 
 * @version 0.1
 * @date 2022-05-15
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include<iostream>
#include <cstdio>
using namespace std;

int price[1000000];
int main(int argc, char** argv)
{
	int test_case;
	int T;
    int n;

	freopen("input.txt", "r", stdin);
	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        int max=0;
        long long sum=0;

        cin>>n;

        for(int i=0;i<n;i++){
            cin>>price[i];
        }

        max=n-1;    //마지막 인덱스

        for(int i=n-2;i>=0;i--){
            if(price[max]>price[i]){
                sum+=(price[max]-price[i]);  //1
            }
            else{
                max=i;
            }
        }

        cout<<"#"<<test_case<<" "<<sum<<"\n";
    }
	return 0;
}