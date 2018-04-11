
/**
 * The following code computes a permutation of {1, 2, ..., `n`}
 * with the given rank `r`.
 *
 * run with 
 *     $ groovy zadanie3 n r
 * or 
 *     $ groovyc zadanie1.groovy
 * and, being in the same catalogue as zadanie3.groovy,
 *     $ java -cp ".:$GROOVY_HOME/lib/*" zadanie3 n r
 *
 */

factorial = {n -> n == 0 ? 1 : n * factorial(n-1)}

def factorialRepresentation(int r){
	int n = 0;
	while (r >= factorial(n)) { n++ }
	return (1..<n).collect{ i -> (r % factorial(i + 1)).intdiv(factorial(i)) }
}

def unrank(int n, int r){
	p = [0] * (n + 1)
	p[n] = 1
	for (i in 1..<n){
		def f = factorial(i)
		def d = (r % ((i + 1) * f)).intdiv(f)
		r = r - d * f
		p[n - i] = d + 1
		for (j in (n - i + 1)..n){
			if (p[j] > d) { p[j]++ }
		}
	}
	return p[1..n]
}


println(unrank(args[0] as int, args[1] as int))