/*
 * The following code lists all subsets of a given length @k of {1,2,...,@n}
 * in the order of minimal changes. 
 *
 * compile with rustc zadanie1.rs
 * run with ./zadanie1 n k
 * with n and k in argv.	
 *
 */ 

use std::env;

fn main() {
    let args: Vec<usize> = env::args().skip(1).map(|x| x.parse::<usize>().unwrap()).collect();
    let (n, k) = (args[0], args[1]);
    let mut sets: Vec<Vec<Vec<usize>>> = vec![vec![vec![]]];

    for i in 1 .. (n + 1) {
    	sets.push(vec![(1 .. i + 1).collect()]);
    	for j in (1 .. i).rev() {
    		let mut tmp = sets[j - 1].clone();
    		tmp.reverse();
    		for mut x in &mut tmp {
    			x.push(i)
    		}
    		sets[j].append(&mut tmp);
    	}
    }
    // println!("{:?}", sets);
    println!("{:?}", sets[k]);
}