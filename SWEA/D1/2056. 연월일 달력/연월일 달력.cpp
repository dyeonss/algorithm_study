#include<iostream> 
#include<cstring> 
using namespace std;

int days[12]={31,28,31,30,31,30,31,31,30,31,30,31};
int main(int argc, char** argv) 
{
    int test_case;
	int T;
   
    cin>>T;

    for(test_case = 1; test_case <= T; ++test_case)
	{
        string date;
        string year,month, day;

        cin>>date;

        for(int i=0;i<date.length();i++){
            if(i<=3)
                year+=date[i];
            if(i==4||i==5)
                month+=date[i];
            else if(i==6||i==7)
                day+=date[i];
        }

        cout<<"#"<<test_case<<" ";
        if(stoi(month)>=1&&stoi(month)<=12){
            if(stoi(day)>=1&&stoi(day)<=days[stoi(month)-1])
                cout<<year<<"/"<<month<<"/"<<day;
            else
                cout<<"-1";
        }
        else
            cout<<"-1";

        cout<<"\n";
    }
       return 0;
}