
/**
 * The following code computes a rank of a given permutation
 * in the lexicographical order.
 *
 * run with 
 *     $ groovy zadanie2 p_1 p_2 ... p_n
 * or 
 *     $ groovyc zadanie2.groovy
 * and 
 *     $ java -cp ".:$GROOVY_HOME/lib/*" zadanie2 p_1 p_2 ... p_n
 * where p_1 p_2 ... p_n is the permtation of {1, 2, ..., n} in argv.
 *
 */

factorial = {n -> n == 0 ? 1 : n * factorial(n-1)}

int rank(p){
	int n = p.size()
	if (n < 1) { return 0 };
	return (p[0] - 1) * factorial(n - 1) + rank(p[1..<n].collect{ el -> el > p[0] ? el - 1 : el })
}

if (!args) { return }

println(rank(args.collect { el -> el as int }))