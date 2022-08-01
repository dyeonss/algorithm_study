#include <iostream>
#include <algorithm>
using namespace std;
int main(void)
{
    int t;

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> t;

    for (int test_case = 1; test_case <= t; test_case++)
    {
        int lamp[4];
        int x, y, res=0;

        for (int i = 0; i < 4; i++)
        {
            cin >> lamp[i];
        }
        x=max(lamp[0],lamp[2]);
        y=min(lamp[1],lamp[3]);
        res=y-x;
        
        if(res<0)
            res=0;
       
        cout<<"#"<<test_case<<" "<<res<<"\n";
    }
    return 0;
}