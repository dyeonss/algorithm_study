/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 가위 바위 보
 * @version 0.1
 * @date 2022-05-31
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>

using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int n;
    int a[100], b[100];

    cin>>n;

    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    for(int i=0;i<n;i++){
        cin>>b[i];
    }

    for(int i=0;i<n;i++){
        int ap = a[i];
        int bp = b[i];
        char win;

        if(ap==bp)
            win='D';
        else if(ap==1&&bp==3)
                win='A';
        else if(ap==2&&bp==1)
            win='A';
        else if(ap==3&&bp==2)
            win='A';
        else
            win='B';
            
        cout<<win<<"\n";
    }

    return 0;
}