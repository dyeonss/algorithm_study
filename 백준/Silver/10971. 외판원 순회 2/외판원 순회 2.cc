#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main() {
	int w[10][10] = { 0 };
	int n;
	vector<int> per;
	cin >> n;

	for (int i = 0; i < n; i++) {
		per.push_back(i);
		for (int j = 0; j < n; j++) {
			cin >> w[i][j];
		}
	}
	int sum = 0, result= INT32_MAX;
	
	do {
		sum = 0;
		bool flag = true;
		for (int i = 0; i < n-1; i++) {  //1234
			if (w[per[i]][per[i + 1]] != 0) {
				sum += w[per[i]][per[i + 1]];
			}
			else
				flag = false;
		}
		if ((flag == false)||(w[per[n - 1]][per[0]]==0))
			continue;
		else
			sum += w[per[n - 1]][per[0]];
		result = min(result, sum);
	} while (next_permutation(per.begin(), per.end()));
	cout <<result;
	return 0;
}