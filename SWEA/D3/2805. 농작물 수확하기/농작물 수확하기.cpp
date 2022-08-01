#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;
char farm[49][49];
int main(void)
{
    int t;

    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        int n, sum=0;
        int right, left;

        cin>>n;

        memset(farm,0,49*49);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cin>>farm[i][j];
            }
        }

        left=n/2;
        right=n/2;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(left<=j&&j<=right){
                    sum+=(farm[i][j]-48);
                }
            }
            if(i<n/2){
                right++;
                left--;
            }
            else{
                right--;
                left++;
            }
        }
        cout<<"#"<<test_case<<" "<<sum<<"\n";
    }
    return 0;
}