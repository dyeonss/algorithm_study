/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 1244. [S/W 문제해결 응용] 2일차 - 최대 상금
 * @version 0.1
 * @date 2022-05-16
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include<iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> makeNumArray(int x){
    vector<int> arr;
    int i=0;

    while(x>0){
        arr.push_back(x%10);
        x=x/10;
        i++;
    }
    reverse(arr.begin(), arr.end());

    return arr;
}
int main(int argc, char** argv)
{
	int test_case;
    int T;
    vector<int> arr;

	freopen("input.txt", "r", stdin);

    cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{   
        int num, chance;
        int tmp, idx=0;
        int balance=0;
        vector <int> arr;

        cin>>num>>chance;

        arr=makeNumArray(num);

        while(chance>0){
            int maxidx, max=0;

            if(idx>=arr.size())
                idx=idx%arr.size();
            if(idx==max_element(arr.begin()+idx,arr.end())-arr.begin()){
                idx++;
            }

            for(int j=arr.size()-1;j>=idx;j--){
                    if(idx!=j&&arr[j]>max){
                        max=arr[j];
                        maxidx=j;
                    }
                
            }

            tmp=arr[idx];
            arr[idx]=arr[maxidx];
            arr[maxidx]=tmp;

            chance--;
            balance++;

            if(balance>=arr.size())
                idx--;
            else
                idx++;

        }

        cout<<"#"<<test_case<<" ";
        for(int i=0;i<arr.size();i++){
            cout<<arr[i];
        }
        cout<<"\n";
    }

	return 0;
}