#!/usr/bin/perl -w
use strict;


# The following code computes a subset with a given rank in anti lexicographical order.
# arguments:
# $n - the number of the elements of {1,2, ... , n}
# $k - the number of the elements of the subset
# $r - the rank of the subset
# run with ./zadanie3.pl
# expected input in stdin: n k r 

sub min2 {
	my ($a, $b) = @_;
	return ($a, $b)[$b < $a];
}

sub calcBinom {
	my ($n, $k) = @_;
	return 0 if $n < $k;
	return 1 if $n == $k or $k == 0;
	my @coeffs = (0)x$n;
	$coeffs[0] = 1;
	foreach my $i (1..$n){
		foreach my $j (reverse 1 .. min2($i, $k)){
			$coeffs[$j] = $coeffs[$j] + $coeffs[$j - 1];
		}
	}
	return $coeffs[$k];
}

sub unrank {
	my ($n, $k, $r) = @_;
	my @t = (0) x $k;
	my $x = $n;
	for (1..$k){
		while ($r < calcBinom($x, $k - $_ + 1)) {
			$x--;
		}
		$t[$_ - 1] = $x + 1;
		$r -= calcBinom($x, $k - $_ + 1);
	}
	return join ", ", @t;
}


chomp(my $line = <STDIN>);
my ($n, $k, $r) = split /\s+/, $line;

print unrank $n, $k, $r;
print "\n";