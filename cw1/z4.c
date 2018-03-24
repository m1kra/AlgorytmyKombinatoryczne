
/*
 * Zadanie 4.
 * n - moc zbioru
 * r - numer podzbioru
 * n, r na standardowym wejœciu lub ./plik n r
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>


void printResult(int n, bool* assoc);

bool* binaryForm(int n, int r);

int main(int argc, char* argv[]) {
	int n, r;
	if (argc == 3) {
		n = atoi(argv[1]);
		r = atoi(argv[2]);
	}
	else {
		scanf("%d", &n);
		scanf("%d", &r);
	}
	r--; // numerujemy od 1 a nie od 0
	bool* bits = binaryForm(n, r);
	printResult(n, bits);
	getchar();
	return 0;
}

void printResult(int n, bool* assoc) {
	int j;
	printf("{");
	for (j = 0; j < n; j++) {
		if (assoc[j])
			printf(" %d ", j + 1);
	}
	printf("}\n");
}

bool* binaryForm(int n, int r) {
	bool *bits = (bool*)calloc(n, sizeof(bool));
	int i;
	for (i = 0; i < n; i++) {
		bits[n - i - 1] = 1 & (r >> i);
	}
	return bits;
}