#include <iostream>
#include <string>
using namespace std;
int main(void)
{
    int t;

    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        int min, max;
        string s;

        cin>>s;
        min=stoi(s);
        max=stoi(s);

        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                string tmp=s;
                char ch;

                ch=tmp[i];
                tmp[i]=tmp[j];
                tmp[j]=ch;

                if(stoi(tmp)>max)
                    max=stoi(tmp);
    
                if(stoi(tmp)<min&&tmp[0]!='0')
                    min=stoi(tmp);
            }
        }
        cout<<"#"<<test_case<<" "<<min<<" "<<max<<"\n";
    }
    return 0;
}