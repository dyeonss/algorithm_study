/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 1926. 간단한 369게임
 * @version 0.1
 * @date 2022-05-16
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include<iostream>
#include <cstdio>
#include <algorithm>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
    
	freopen("input.txt", "r", stdin);
	T=10;

	for(test_case = 1; test_case <= T; ++test_case)
	{   
        int n;
        cin>>n;

        int length[1000];

        for(int i=0;i<n;i++){
            cin>>length[i];
        }

        bool front=false, back=false;
        int fmax, bmax, m;
        int total=0;

        for(int i=2;i<n-2;i++){
            m=0;
            fmax=0;
            bmax=0;

            front=false;
            back=false;

            if((length[i]>length[i+1])&&(length[i]>length[i+2])){
                front=true;
                fmax=max(length[i+1],length[i+2]);
            }
            if((length[i]>length[i-1])&&(length[i]>length[i-2])){
                back=true;
                bmax=max(length[i-1],length[i-2]);
            }

            if(front==true&&back==true){
                m=max(fmax, bmax);
                total+=(length[i]-m);
            }
        }
        
        cout<<"#"<<test_case<<" "<<total<<"\n";
    }
    cout<<"\n";
	return 0;
}