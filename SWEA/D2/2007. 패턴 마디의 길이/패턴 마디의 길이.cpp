#include <iostream>
#include <string>
using namespace std;
int main(void)
{
    int t;

    cin >> t;
    
    for(int i = 1; i <= t; i++)
    {
        string s, tmp;
        cin >> s;
        
        tmp.push_back(s[0]);

        for(int i=1;i<s.length();i++){         
            if(tmp!=s.substr(tmp.size(),i))    
                tmp.push_back(s[i]);     
            else
                break;
        }
        cout << "#" << i << " " << tmp.size() << endl;
    }
    return 0;
}