#include <iostream>
using namespace std;
char farm[49][49];
int main(void)
{
    int t;

    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        int n, cnt=0;

        cin>>n;

        if(n<3)
            cnt=0;
        else 
            cnt=n/3;
        
        cout<<"#"<<test_case<<" "<<cnt<<"\n";
    }
    return 0;
}