/**
 * @file 2309.cpp
 * @author shindoyeon
 * @brief 일곱난쟁이
 * @version 0.1
 * @date 2022-05-19
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int ans[7];
int length[9];
void insert(int x, int y){

    for(int i=0;i<sizeof(length)/sizeof(int);i++){
        if((i!=x)&&(i!=y)){
            cout<<length[i]<<"\n";
        }
    }
}
int main(){

    int sum=0;

    for(int i=0;i<9;i++){
        cin>>length[i];
        sum+=length[i];
    }
    sort(length,length+9);

    for(int i=0;i<sizeof(length)/sizeof(int)-1;i++){
        for(int j=i+1;j<sizeof(length)/sizeof(int);j++){
            if(sum-length[i]-length[j]==100){
                insert(i,j);
                return 0;
            }
        }
    }

    return 0;
}