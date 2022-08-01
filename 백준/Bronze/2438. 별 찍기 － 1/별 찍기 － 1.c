#include<stdio.h>
int main() {
	int n,x;
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		for (x = 0; x <= i; x++)
			printf("*");
		printf("\n");
	}

	return 0;
}