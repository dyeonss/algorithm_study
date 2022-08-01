#include<iostream>
#include <cstdio>
using namespace std;

int HyphenCount(int n){
    int cnt=0;
    int x=n;
    int tmp=0;

    while(x>0){
        tmp=x%10;

        if(tmp==3||tmp==6||tmp==9){
            cnt++;
        }

        x=x/10;
    }

    return cnt;
}
int main(int argc, char** argv)
{
	int test_case;
	int T;
    
	//freopen("input.txt", "r", stdin);
	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{   
        if(HyphenCount(test_case)>0){
            int cnt=HyphenCount(test_case);
            for (int i = 0; i < cnt; i++)
            {
                cout<<"-";
            }
            
        }
        else{
            cout<<test_case;
        }
        cout<<" ";
    }
    cout<<"\n";
	return 0;
}