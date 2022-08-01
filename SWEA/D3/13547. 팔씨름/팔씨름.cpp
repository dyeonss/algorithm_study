#include <iostream>
using namespace std;
char board[20][20];
int main(void)
{
    int t;

    cin >> t;
    
    for(int test_case = 1; test_case<= t; test_case++)
    {
        string game, res="NO";   
        int lose=0;

        cin>>game;

        for(int i=0;i<game.length();i++){
            if(game[i]=='x')
                lose++;
        }
        if(lose<=7)
            res="YES";

        cout<<"#"<<test_case<<" "<<res<<"\n";
    }
    return 0;
}