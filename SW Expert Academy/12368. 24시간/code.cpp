/**
 * @file code.cpp
 * @author shindoyeon
 * @brief 12368. 24시간
 * @version 0.1
 * @date 2022-05-27
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <algorithm>
using namespace std;
int main(void)
{
    int test_case;
	int T;

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int a, b, res;

		cin >> a >> b;

		res = (a + b) % 24;

		cout << "#" << test_case << " " << res << "\n";
	}
    return 0;
}