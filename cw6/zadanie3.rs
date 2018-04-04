/*
 * The following code computes @k-element subset of {1, 2, ..., @n} 
 * with the rank @r in the order of minimal changes. 
 *
 * compile with rustc zadanie3.rs
 * run with ./zadanie3 n k r
 * where n, k, r are given in argv.   
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
    let (n, k, mut r) = (args[0], args[1], args[2]);
    let mut x = n;
    let mut subset: Vec<i64> = Vec::new();
    for i in (1..(k+1)).rev() {
        while binom(x, i as i64) > r {
            x -= 1;
        }
        subset.push(x + 1);
        r = binom(x + 1, i as i64) - r - 1;
    }
    subset.reverse();
    println!("{:?}", subset);
}