
/**
 * The following code computes a successor of a given permutation
 * in the lexicographical order.
 *
 * run with 
 *     $ groovy zadanie1 p_1 p_2 ... p_n
 * or 
 *     $ groovyc zadanie1.groovy
 * and 
 *     $ java -cp ".:$GROOVY_HOME\lib\*" zadanie1 p_1 p_2 ... p_n
 * where p_1 p_2 ... p_n is the permtation of {1, 2, ..., n} in argv.
 *
 */


if(!args){ return }

int[] permutation = args.collect{ elem -> Integer.parseInt(elem) }
int n = permutation.size()

int i = n - 2
while(permutation[i] > permutation[i + 1]) { i-- }

if (i < 0){
	println("Nie ma następnika!")
	return
}

int j = n - 1
while (permutation[j] < permutation[i]) { j-- }

permutation.swap(i, j)
println(permutation[0..i] + permutation[i+1..<n].reverse())