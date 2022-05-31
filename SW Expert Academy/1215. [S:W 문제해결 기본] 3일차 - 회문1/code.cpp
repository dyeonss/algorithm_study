/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 1215. [S/W 문제해결 기본] 3일차 - 회문1
 * @version 0.1
 * @date 2022-05-27
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <algorithm>
using namespace std;
#define length 8
char board[8][8];
bool isWidthTrue(int r, int c, int n);
bool isVerticalTrue(int r, int c, int n);
int main(void)
{
    int test_case;
	int T;
	
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	freopen("input.txt", "r", stdin);

	for(test_case = 1; test_case <= 10; ++test_case)
	{
		int n, res=0;

		cin>>n;

		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				cin>>board[i][j]; 
			}
		}

		for(int i=0;i<length;i++){
			for(int j=0;j<=length-n;j++){
				if(isWidthTrue(i,j,n)){  //행 열 
					res++;
				}
			}
		}

		for(int i=0;i<length;i++){  //열
			for(int j=0;j<=length-n;j++){  //행
				if(isVerticalTrue(j,i,n)){
					res++;
				}
			}
		}


		cout << "#" << test_case << " " <<res<< "\n";
	}
    return 0;
}
bool isWidthTrue(int r, int c, int n){ //행 열 0 0

	for(int i=0;i<n/2;i++){
		if(board[r][c+i]!=board[r][c+n-1-i]){
			return false;
		}
	}

	return true;
}
bool isVerticalTrue(int r, int c, int n){ 
	for(int i=0;i<n/2;i++){ 
		if(board[r+i][c]!=board[r+n-1-i][c]){
			return false;
		}
	}
	return true;
}
