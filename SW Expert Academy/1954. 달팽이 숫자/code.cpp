/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 1954. 달팽이 숫자
 * @version 0.1
 * @date 2022-05-20
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include<iostream> 
#include<cstring> 
using namespace std;

int row[4]={0,1,0,-1};
int col[4]={1,0,-1,0};
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

        int map[n][n];
        int val=2;
        int r, c , dir=0;
        int i=0, j=0;

        memset(map,0,sizeof(map));  //map 0으로 초기화

        map[0][0]=1;

        while(n*n>=val){  
            r=row[dir]+i; 
            c=col[dir]+j; 
            if(r>=n||c>=n||r<0||c<0||map[r][c]>0){
                dir++;
                if(dir>=4)
                    dir=dir%4;
                continue;
            }
            map[r][c]=val; 

            val++;
            i=r;
            j=c;
        }
        
        cout<<"#"<<test_case<<"\n";
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                cout<<map[i][j]<<" ";
            }
            cout<<"\n";
        }
    }
       return 0;
}





