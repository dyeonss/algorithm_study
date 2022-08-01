#include <iostream>
#include <cstring>

using namespace std;

int main(void)
{
    int t;
    
    cin >> t;
    
    for(int i = 1; i <= t; i++)
    {
        int n;

        cin>>n;

        int map[n][n];

        memset(map,0,sizeof(map));

        cout<<"#"<<i<<"\n";
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    map[i][j] = 1;
                else{
                    map[i][j]=map[i-1][j-1]+map[i-1][j];
                }
                cout << map[i][j] << " ";
            }
            cout<<"\n";
        }
    }
    return 0;
}