
/*
 * Zadanie 1.
 * n - moc zbioru
 * wywo³anie: n na standardowym wejœciu lub ./plik n
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>


void printResult(int n, bool* assoc);

void genFixedSize(int n, int k, bool* assoc, int last);

int main(int argc, char* argv[]) {
	int n, i;
	if (argc <= 1)
		scanf("%d", &n);
	else
		n = atoi(argv[1]);
	printf("{ }\n");
	for (i = 1; i < n + 1; i++) {
		bool* assoc = (bool*) calloc(n, sizeof(bool));
		genFixedSize(n, i, assoc, 0);
	}
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


void genFixedSize(int n, int k, bool* assoc, int last) {
	int j;
	if (last == n + 1)
		return;

	if (k == 0) {
		printResult(n, assoc);
	}
	else {
		genFixedSize(n, k, assoc, last + 1);

		for (j = last + 1; j < n; j++)
			assoc[j] = false;

		assoc[last] = true;
		genFixedSize(n, k - 1, assoc, last + 1);
	}
}
