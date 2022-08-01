#include<iostream>
using namespace std;
int main() {
	int e, s, m;
	int i = 1;
	cin >> e >> s >> m;

	while (1) {
		if ((i-e)%15 == 0 && (i-s)%28 == 0 && (i-m)%19 == 0) {
			break;
		}
		i++;
	}
	cout << i;

	return 0;
}