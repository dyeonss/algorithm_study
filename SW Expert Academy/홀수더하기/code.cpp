/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 2072. 홀수만 더하기
 * @version 0.1
 * @date 2022-05-15
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include<iostream>
#include <cstdio>
#include <cmath>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	freopen("input.txt", "r", stdin);
	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        int avg=0;
        double sum=0;
        for(int i=0; i<10;i++){
            int num;

            cin>>num;

            sum+=num;
        }
        avg=round(sum/10.0);

        printf("#%d %d\n", test_case, avg);
    }
	return 0;
}