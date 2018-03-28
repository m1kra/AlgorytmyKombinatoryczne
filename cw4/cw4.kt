import java.util.Arrays;

/*
 * Run inside kotlinc-jvm.
 * load the file with :load cw4.kt
 * then run with e.g. zadanie1(5, 3, arrayOf(1, 2, 3))
 * 
 */

fun zadanie1(n: Int, k: Int, set: Array<Int>) {
  var i: Int = k - 1
  while (i > -1 && set[i] == n - k + i + 1){
    i--
  }
  if (i == -1){
    println("Nie ma następnika!")
  } else {
    set[i] = set[i] + 1
    for(j in k - 1 downTo i + 1){
      set[j] = set[j - 1] + 1
    }
    println(Arrays.toString(set))
  }
}

fun minOf(a: Int, b:Int):Int {
  return if (a < b) a else b
}

fun calcBinom(n: Int, k: Int):Int {
  if (k > n) {
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

fun zadanie2(n: Int, k: Int, set: Array<Int>):Int {
  var rank: Int = 0
  var vec = BooleanArray(100)
  for(x in set){
    vec[x] = true
  }
  var i: Int = 1
  var j: Int = 1
  while (i <= n && j <= k){
    if (vec[i]) {
        j++
        i++
      } else {
      rank = rank + calcBinom(n - i, k - j)
      i++
    }
  }
  return rank
}





