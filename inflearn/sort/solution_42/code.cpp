/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 이분검색
 * @version 0.1
 * @date 2022-06-27
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);
 
    int n, sum=1, cnt=0;
    vector<int> arr;
    cin>>n;

    arr.push_back(1);
    
    for(int i=2;i<=n/2;i++){
        arr.push_back(i);
        sum+=i;
        
        if(n-sum<0)
            break;
        if((n-sum)%i==0){
            for(int j=0;j<arr.size()-1;j++){
                cout<<arr[j]+(n-sum)/i<<" + ";
            }
            cout<<arr.end()-arr.begin()+(n-sum)/i<<" = "<<n<<"\n";
            cnt++;
        }
    }

    cout<<cnt<<"\n";
    return 0;
}