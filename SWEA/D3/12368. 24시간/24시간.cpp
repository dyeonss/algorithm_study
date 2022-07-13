#include <iostream>
using namespace std;
int main(int argc, char** argv)
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