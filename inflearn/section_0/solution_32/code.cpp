/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 탄화수소 질량
 * @version 0.1
 * @date 2022-06-05
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <vector>
using namespace std;
int main(int argc, char* argv[]){
    freopen(argv[1], "rt", stdin);
	freopen(argv[2], "w", stdout);

    string s, c="", h="";

    cin>>s;
    //C10H100 7
    c=s.substr(1,s.find("H")-1);
    h=s.substr(s.find("H")+1,s.length()-1);

    if(c==""){
        c="1";
    }
    if(h==""){
        h="1";
    }
    
    cout<<12*stoi(c)+1*stoi(h);
    
    return 0;
}