#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
using namespace std;
int main() {
	int n,tmp;
	vector<int> arr;
	vector<int> per;
	vector<string> str;

	while (true)
	{
		cin >> n;
		if (n == 0)
			break;
		for (int i = 0; i < n; i++) {
			cin >> tmp;
			arr.push_back(tmp);
			if (i < n - 6)
				per.push_back(1);
			else
				per.push_back(0);
		}
		sort(per.begin(), per.end());
		do {
			for (int i = 0; i < n; i++) {
				if (per[i] == 0)
					str.push_back(to_string(arr[i])+" ");
			}
			str.push_back("\n");
		} while (next_permutation(per.begin(), per.end()));
		str.push_back("\n");
		per.clear();
		arr.clear();
	}
	for (int i = 0; i < str.size()-1; i++)
		cout << str[i];
	return 0;
}