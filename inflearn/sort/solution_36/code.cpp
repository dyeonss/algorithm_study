/**
 * @file code.cpp
 * @author shindoyeon
 * @brief Least Recently Used(카카오 캐시 문제 변형)
 * @version 0.1
 * @date 2022-06-08
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    int s, n, tmp, arr[1000], cache[10];

    cin>>s>>n;

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    for(int i=0;i<s;i++){
        cache[i]=0;
    }

    for(int i=0;i<n;i++){
        int pos=find(cache,cache+s,arr[i])-cache;
        if(pos<s){ //cache hit
            tmp=cache[pos];
            for(int j=pos;j>=1;j--){
                cache[j]=cache[j-1];
            }
            cache[0]=tmp;
        }
        else if(pos==s){ //cache miss
            for(int j=s-1;j>=1;j--){
                cache[j]=cache[j-1];
            }
            cache[0]=arr[i];
        }
    }

    for(int i=0;i<s;i++){
        cout<<cache[i]<<" ";
    }
    return 0;
}