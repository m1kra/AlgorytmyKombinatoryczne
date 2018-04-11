
/**
 * This code implements Trotten-Johnson algorithm.
 *
 * run with 
 *     $ groovy zadanie4 n
 * or 
 *     $ groovyc zadanie4.groovy
 * and, being in the same catalogue as zadanie4.groovy,
 *     $ java -cp ".:$GROOVY_HOME/lib/*" zadanie4 n
 *
 */

def TrottenJohnson(int n){
	permutations = [[]]
	for (i in 1..n) {
		copy = []
		permutations.eachWithIndex { p, ind ->
			def order = ind % 2 ? 0..<i : (0..<i).reverse()
			for (j in order) {
				copy.push(p.plus(j, i))
			}
		}
		permutations = copy
	}
	return permutations
}

if(!args) { return }

println(TrottenJohnson(args[0] as int))