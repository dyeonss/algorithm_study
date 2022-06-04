/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 온도의 최대값
 * @version 0.1
 * @date 2022-06-02
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <vector>
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int n, k, max, sum=0;

    cin>>n>>k;

    vector <int> temper(n);

    for(int i=0;i<n;i++){
        cin>>temper[i];
    }

    for(int i=0;i<k;i++){
        sum+=temper[i];
    }

    max=sum;

    for(int i=k;i<n;i++){
        sum=sum+temper[i]-temper[i-k];
        if(sum>max)
            max=sum;
    }

    /**
     * @brief time limit 오류 발생, 3초 넘게 걸림
     * 
     */
    // for(int i=0;i<=n-k;i++){
    //     int sum=0;
    //     for(int j=i;j<i+k;j++){
    //         sum+=temper[j];
    //     }
    //     if(sum>max)
    //         max=sum;
    // }

    cout<<max<<"\n";
    
    return 0;
}