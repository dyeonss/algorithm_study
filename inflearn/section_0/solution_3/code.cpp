/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 나이 차이
 * @version 0.1
 * @date 2022-05-04
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <limits>

using namespace std;
int main(int argc, char* argv[]){
    // freopen(argv[1], "rt", stdin);
	// freopen(argv[2], "w", stdout);
    int n, i, a;
    int max = INT_MIN, min = INT_MAX;   //실제 max, min 구해야하기 때문에 max에는 INT_MIN, min에는 INT_MAX를

    cin>>n;

    for(i = 1; i <= n; i++){
        cin>>a;
        //첫 번째에는 무조건 a가 min, max이다.
        if(a > max)
            max = a;
        if(a < min)
            min = a;
    }
    cout << max - min;
}