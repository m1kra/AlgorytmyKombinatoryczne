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

    let k = &args[0];
    let subset = &args[1..];
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