#!/usr/bin/perl -w
use strict;
use List::Util qw(sum);


# The following code computes the rank of a subset in anti lexicographical order.
# arguments:
# $k - the number of the elements of the subset
# @set - the elements of the subset
# run with ./zadanie2.pl
# expected input in stdin: k followed by k elements of the subset in a new line 

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


sub rank {
	my ($k, @set) = @_;
	return sum map {calcBinom $set[$_ - 1] - 1, $k - $_ + 1} 1..$k;
}


chomp(my $line = <STDIN>);
my ($k) = split /\s+/, $line;

chomp($line = <STDIN>);
my @set = split /\s+/, $line;

print rank $k, @set;
print "\n";