#include<iostream>
#include<vector>
using namespace std;
int gcd(int a, int b) {
	int r;
	while (b!=0)
	{
		r = a % b;
		a = b;
		b = r;
	}
	return a;
}
int main() {
	vector <int>num;
	int g,t,n,tmp=0;
	long long sum = 0;
	cin >> t; 
	for (int i = 0; i < t; i++) {
		cin >> n; 
		for (int j = 0; j < n; j++) {
			cin >> tmp;
			num.push_back(tmp);
		}
		for (int j = 0; j < n - 1; j++) {
			for (int k = j + 1; k < n; k++) {
				g = gcd(num[j], num[k]);
				sum += g;
			}
		}
		cout << sum<<"\n";
		num.clear();
		sum = 0;
	}
	return 0;
}