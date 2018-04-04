/*
 * The following code computes the rank of a set in the order of minimal changes. 
 *
 * compile with rustc zadanie2.rs
 * run with ./zadanie1 t_1 t_2 ... t_k
 * where t_1 t_2 ... t_k are the elements of the set in argv.	
 *
 */ 

use std::env;

fn binom(n: i64, k: i64) -> i64 {
	if n < k {
		return 0;
	}
    let mut res = 1;
    for i in 0..k {
        res = res * (n - i) / (i + 1);
    }
    res
}

fn main() {
    let args: Vec<i64> = env::args().skip(1).map(|x| x.parse::<i64>().unwrap()).collect();

    let subset = &args[0..];
    let k = subset.len();
    let mut sum: i64 = 0;
    let mut sgn: i64 = -1;
    for i in 1..(subset.len()+1){
    	sum += sgn * binom(subset[i - 1], i as i64);
    	sgn *= -1;
    } 
    if k % 2 == 0 {
    	println!("{}", sum);
    } else {
    	println!("{}", -1*sum - 1);
    }

}