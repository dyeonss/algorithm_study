/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 2806. N-Queen
 * @version 0.1
 * @date 2022-05-25
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <cmath>
#include <algorithm>
#include <cstring>
using namespace std;
int board[10][10];
int ans=0;
bool isTrue(int n, int row, int col){  //대각선 체크

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(board[i][j]==1){
                if((i==row)||(j==col)||(abs(i-row)==abs(j-col))){
                    return false;
                }
            }
        }
    }
    return true;
}
void dfs(int n, int row, int col, int queen){
    if(queen==n){
        ans++;
        return;
    }
    else{
        for(int i=0;i<n;i++){
            if(isTrue(n,row,i)){
                board[row][i]=1;
                dfs(n,row+1,i,queen+1);
                board[row][i]=0;
            }
        }
    }
}
int main(void)
{
    int t;

    //freopen("sample_input.txt", "r", stdin);
    
    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        int n;
        cin>>n;

        ans=0;
        memset(board,0,10*10);
        dfs(n,0,0,0);

        cout<<"#"<<test_case<<" "<<ans<<"\n";
    }
    return 0;
}



