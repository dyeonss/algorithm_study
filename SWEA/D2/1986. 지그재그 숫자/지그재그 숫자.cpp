#include <iostream>
using namespace std;
int main(void)
{
    int t;

    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        int n, res=0;

        cin>>n;

        for(int i=1;i<=n;i++){
            if(i%2==0)
                res=res-i;
            else
                res=res+i;
        }
        
        cout<<"#"<<test_case<<" "<<res<<"\n";

    }
    return 0;
}