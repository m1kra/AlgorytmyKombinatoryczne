#!/usr/bin/perl -w
use strict;

# The following code computes a successor to a subset in anti lexicographical order.
# arguments:
# $n - the number of the elements of {1,2, ... , n}
# $k - the number of the elements of the subset of {1, 2, ..., n}
# @set - the elements of the subset
# run with ./zadanie1.pl
# expected input in stdin: n, k followed by k elements of the subset in a new line 

sub nextSet {
	my ($n, $k, @set) = @_;
	my $i = $k - 1;
	while ($set[$i - 1] == $set[$i] + 1 and $i != 0){
		$i -= 1;
	}
	if ($i == 0 and $set[0] == $n) {
		return "Nie ma następnika.";
	}
	$set[$i] += 1;
	for (($i + 1)..($k - 1)){
		$set[$_] = $k - $_;
	}
	return join ", ", @set;
}

chomp(my $line = <STDIN>);
my ($n, $k) = split /\s+/, $line;

chomp($line = <STDIN>);
my @set = split /\s+/, $line;

print nextSet($n, $k, @set), "\n";

