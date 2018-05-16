import java.util.Arrays;

/*
 * This code computes Stirling number of the first kind on @n, and @k
 * Run inside kotlinc-jvm.
 * load the file with :load z2.kt
 * then run with e.g. zadanie2(5, 3)
 */

 fun zadanie2(n: Int, k: Int): Int {
	if(k > n){
		return 0
	}
	if(k == 0 && n > 0){
		return 0
	}

	var s = IntArray(k + 1)
	s[0] = 1
	for(i in 1 .. n){
		if(i > 1){
			s[0] = 0
		}
		for(j in minOf(i, k) downTo 1){
			s[j] = s[j - 1] - (i - 1) * s[j]
		}
	}
	return s[k];
}