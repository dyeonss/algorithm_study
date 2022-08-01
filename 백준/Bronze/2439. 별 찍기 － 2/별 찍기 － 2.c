#include<stdio.h>
int main() {
	int n, x,i;
	scanf("%d", &n);

	for (i = 1; i <= n; i++) {  //0  1
		for (x = 0; x < n-i; x++)  
			printf(" ");
		for (x = 0; x < i; x++) 
			printf("*");
		printf("\n");
	}

	return 0;
}