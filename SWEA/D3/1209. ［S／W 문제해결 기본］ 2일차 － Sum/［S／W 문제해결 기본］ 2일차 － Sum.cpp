#include <iostream>
#include <algorithm>
#include <climits>
#include <cmath>
using namespace std;
#define size 100
int board[100][100];
int main(void)
{
    int test_case;
	int T;

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

	for (test_case = 1; test_case <= 10; ++test_case)
	{
		int t, rsum=0, csum=0, maxsum=INT_MIN;
		int row[100]={0},col[100]={0}, dia[2]={0};

		cin>>t;

		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				cin>>board[i][j];
			}
		}

		for(int i=0;i<size;i++){
			csum=0;
			rsum=0;
			for(int j=0;j<size;j++){
				csum+=board[j][i];
				rsum+=board[i][j];
			}
			col[i]=csum;
			row[i]=rsum;

			maxsum=max(maxsum,max(col[i],row[i]));
		}

		for(int i=0;i<size;i++){
			dia[0]+=board[i][i];
			dia[1]+=board[size-1-i][size-1-i];
		}
		maxsum=max(maxsum,max(dia[0],dia[1]));

		cout << "#" << t << " " << maxsum << "\n";
	}
    return 0;
}