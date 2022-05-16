/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 13732. 정사각형 판정
 * @version 0.1
 * @date 2022-05-15
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include<iostream>
#include <cstdio>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	freopen("input.txt", "r", stdin);
	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        int n;

        cin>>n;
		
        bool res[T];
        char rec[n][n];
        int width[n];
        int length[n];
        int firstX[n], firstY[n];
        bool isFirst;

        res[test_case]=false;

        for(int i=0; i<n; i++){
            cin>>rec[i];
        }
        for(int i=0; i<n; i++){
            isFirst=true;
            width[i]=1;
            firstX[i]=0;
            firstY[i]=0;

            for(int j=0; j<n-1; j++){
                if(rec[i][j]=='#'){
                    if(isFirst){
                        firstX[i]=i;
                        firstY[i]=j;
                        isFirst=false;
                    }
                    if(rec[i][j+1]=='#'){
                        width[i]++;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            length[i]=1;
            for(int j=0;j<n-1;j++){
                if(rec[j][i]=='#'){
                    if(rec[j+1][i]=='#'){
                        length[i]++;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            if(width[i]==length[i]&&(width[i]>1&&length[i]>1)&&(width[i]-firstX[i]==length[i]-firstY[i])){
                res[test_case-1]=true;
                break;
            }
        }

        if(res[test_case-1]==true)
            cout<<"#"<<test_case<<" yes\n";
        else
            cout<<"#"<<test_case<<" no\n";
    }
	return 0;
}