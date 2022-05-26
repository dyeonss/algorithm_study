/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 2001. 파리 퇴치
 * @version 0.1
 * @date 2022-05-22
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <string>

using namespace std;
int map[15][15];
int main(void)
{
    int t;

    freopen("input.txt", "r", stdin);
    
    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        int n,m;

        cin>>n>>m;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cin>>map[i][j];
            }
        }

        int r=0, c=0, sum=0, max=0;

        for(int i=0;i<=n-m;i++){
            for(int j=0;j<=n-m;j++){
                sum=0;
                for(int k=0;k<m;k++){
                    for(int l=0;l<m;l++){
                        sum+=map[i+k][j+l];
                    }
                if(sum>max)
                    max=sum;
                }
            }
        }

        cout<<"#"<<test_case<<" "<<max<<"\n";
    }
    return 0;

}





