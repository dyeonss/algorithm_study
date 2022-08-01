/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 뮤직비디오
 * @version 0.1
 * @date 2022-06-28
 * @copyright Copyright (c) 2022
 **/
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int count(vector<int> arr, int mid){
    int i=0, cnt=0, sum=0;

    while(i<arr.size()){
        sum+=arr[i];

        if(sum<=mid){
            i++;
            if(i==arr.size())
                cnt++;
        }
        else if(sum>mid){
            cnt++;
            sum=0;
        }
    }
    return cnt;
}
int main(int argc, char* argv[]){

    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int n, m, i, lt, rt, mid, key, sum=0, max=INT_MIN;

    cin>>n>>m;
    vector<int> play(n);

    for(i=0;i<n;i++){
        cin>>play[i];
        sum+=play[i];
        if(play[i]>max)
            max=play[i];
    }

    lt=1, rt=sum;
    key=sum;

    while(true){
        mid=(lt+rt)/2;

        if(mid>=max&&count(play, mid)<=m){
            rt=mid-1;
            key = mid;
        }
        else{
            lt=mid+1;
        }

        if(lt>rt)
            break;
    }

    cout<<key<<"\n";

    return 0;
}