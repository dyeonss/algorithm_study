/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 13732. 정사각형 판정
 * @version 0.1
 * @date 2022-05-24
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
using namespace std;
char board[20][20];
int main(void)
{
    int t;

    freopen("sample_input.txt", "r", stdin);
    
    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        int n, size;
        string s, str;

        cin>>n;
        size=sizeof(board)/sizeof(board[0]);

        for(int i=0;i<size;i++){
            memset(board[i],0,size);
        }

        for(int i=0;i<n;i++){
            cin>>s;
            for(int j=0;j<n;j++){
                board[i][j]=s[j];
            }
        }

        int pos[4]={n,n,-1,-1};   //x최소 좌표, y최소 좌표, x최대 좌표, y최대 좌표

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='#'){
                    pos[0]=min(pos[0],i);
                    pos[1]=min(pos[1],j);
                    pos[2]=max(pos[2],i);
                    pos[3]=max(pos[3],j);
                }
            }
        }

        str="yes";

        if(pos[2] - pos[0] != pos[3] - pos[1]) 
            str="no";

        for(int i=pos[0];i<=pos[2];i++){
            for(int j=pos[1];j<=pos[3];j++){
                if(board[i][j]!='#'){
                    str="no";
                    break;
                }
            }
        }

        cout<<"#"<<test_case<<" "<<str<<"\n";
    }
    return 0;
}





