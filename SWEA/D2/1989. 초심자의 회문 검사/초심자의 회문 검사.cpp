#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int main(void)
{
    int t;
    
    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        string str;
        string right, left;
        bool cmp;

        cin>>str;
        
        right=str.substr(0,str.length()/2);
        left=str.substr((str.length()%2==0)?str.length()/2:str.length()/2+1);
        reverse(left.begin(),left.end()); //문자열 뒤집기

        if(right.compare(left)==0)
            cmp=true;
        else
            cmp=false;
        
        cout<<"#"<<test_case<<" "<<cmp<<"\n";

    }
    return 0;
}