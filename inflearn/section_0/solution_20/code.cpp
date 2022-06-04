/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 카드 게임
 * @version 0.1
 * @date 2022-06-02
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
using namespace std;
#define size 10
int A[size];
int B[size];
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int apnt=0, bpnt=0;
    char win=' ';

    for(int i=0;i<size;i++){
        cin>>A[i];
    }
    for(int i=0;i<size;i++){
        cin>>B[i];
    }

    for(int i=0;i<size;i++){
        if(A[i]==B[i]){
            apnt+=1;
            bpnt+=1;
        } 
        else{
            if(A[i]>B[i])
                apnt+=3;
            else
                bpnt+=3;
            win=A[i]>B[i]?'A':'B';
        }

    }
    cout<<apnt<<" "<<bpnt<<"\n";

    if(apnt==bpnt){
        if(win==' '){
            win='D';
        }
        cout<<win<<"\n";
    }
    else if(apnt>bpnt)
        cout<<'A'<<"\n";
    else if(bpnt>apnt)
        cout<<'B'<<"\n";

    return 0;
}