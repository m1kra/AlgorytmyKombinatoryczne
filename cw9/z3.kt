import java.util.Arrays;

/*
 * This code computes @nth Bell number.
 * Run inside kotlinc-jvm.
 * load the file with :load z3.kt
 * then run with e.g. zadanie3(5)
 */

fun zadanie3(n: Int): Int {
 	var bells = IntArray(n + 1)
	bells[0] = 1
	for(i in 1 .. n){
		var sum = 0
		for(k in 0 .. i - 1){
			sum += calcBinom(i - 1, k) * bells[k]
		}
		bells[i] = sum
	}
	return bells[n]
}

 fun calcBinom(n: Int, k: Int): Int {
  if (k > n){
    return 0
    }
  var coeffs = IntArray(k + 1)
  coeffs[0] = 1
  for(i in 1 .. n){
    for(j in minOf(i, k) downTo 1){
      coeffs[j] = coeffs[j] + coeffs[j - 1]
    }
  }
  return coeffs[k];
}
