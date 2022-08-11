#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	int n, tmp;
	int arr[11] = { 0 };
	int copy[11] = { 0 };
	int op[4] = { 0 };
	vector<int> per;
	cin >> n;
	for (int i = 0; i < n; i++) 
		cin >> arr[i];
	for (int i = 0; i < 4; i++) {
		cin >> op[i];
		if (op[i] != 0) {
			tmp = op[i];
			for (int j = 0; j < tmp; j++)
				per.push_back(i);
		}
	}
	int minresult = 1000000000;
	int maxresult = -1000000000;
	do {
		for (int i = 0; i < n; i++) {
			copy[i] = arr[i];
		}
		for (int i = 0; i < n - 1; i++) {
			if (per[i] == 0)
				copy[i + 1] = copy[i] + copy[i + 1];
			else if (per[i] == 1)
				copy[i + 1] = copy[i] - copy[i + 1];
			else if (per[i] == 2)
				copy[i + 1] = copy[i] * copy[i + 1];
			else
				copy[i + 1] = copy[i] / copy[i + 1];
		}
		minresult = min(copy[n - 1], minresult);
		maxresult = max(copy[n - 1], maxresult);
	} while (next_permutation(per.begin(),per.end()));
	cout << maxresult << "\n";
	cout << minresult << "\n";

	return 0;
}