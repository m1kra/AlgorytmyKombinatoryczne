import java.util.Arrays;

/*
 * This code computes Stirling number of the second kind on @n, and @k
 * Run inside kotlinc-jvm.
 * load the file with :load z1.kt
 * then run with e.g. zadanie1(5, 3)
 * 
 */

fun zadanie1(n: Int, k: Int): Int {
	if(k > n){
		return 0
	}
	if(k == 0 && n > 0){
		return 0
	}

	var S = IntArray(k + 1)
	S[0] = 1
	for(i in 1 .. n){
		if(i > 1){
			S[0] = 0
		}
		for(j in minOf(i, k) downTo 1){
			S[j] = j * S[j] + S[j - 1]
		}
	}
	return S[k];
}