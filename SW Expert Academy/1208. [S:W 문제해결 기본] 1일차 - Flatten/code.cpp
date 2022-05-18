/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 1208. [S/W 문제해결 기본] 1일차 - Flatten
 * @version 0.1
 * @date 2022-05-16
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include<iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
    int dump;
    vector<int> length(100);

	freopen("input.txt", "r", stdin);

	for(test_case = 1; test_case <= 10; ++test_case)
	{   
        cin>>dump;

        int input;
        int maxidx, minidx;
        int diff=0;
        for(int i=0;i<100;i++){
            cin>>length[i];
        }

        for(int i=0;i<=dump;i++){
            maxidx=max_element(length.begin(),length.end())-length.begin();
            minidx=min_element(length.begin(),length.end())-length.begin();

            diff=length[maxidx]-length[minidx];
            length[maxidx]--;
            length[minidx]++;
            if(diff<=1)
                break;
        }
        cout<<"#"<<test_case<<" "<<diff<<"\n";
    }

	return 0;
}