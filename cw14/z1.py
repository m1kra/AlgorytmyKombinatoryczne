#!/usr/bin/python3
# -*- coding: utf-8 -*-

#
# Run inside python3 shell.
# To generate all partitions of {1, 2, ..., n} run partitions(n)
#

def partitions(n):
    B = [0] * n   
    PR = [1] * n  
    P = [-1] * n
    N = [-1] * n 
    
    j = 0
    end = False
    
    while not end:
        if(PR[j]):
            B, N, P = _move_right(B, N, P, B[j], j)
        else:
            B, N, P = _move_left(B, N, P, B[j], j)
        _print_nicely(B)
        j, PR = _find_next(PR, B)
        if j == 0:
            end = True

def _move_right(B, N, P, k, j):
    B[j] = N[k]
    if N[k] == -1:
        N[k] = j
        N[j] = -1
        P[j] = k
        B[j] = N[k]
        B[j] = j
                
    if N[k] > j:
        P[j] = k
        N[j] = N[k]
        P[N[j]] = j
        N[k] = j
        B[j] = N[k]
    return B, N, P

def _move_left(B, N, P, k, j):
    B[j] = P[k]
    if j == k:
        if N[k] == -1:
            N[P[k]] = -1
        if N[k] > -1:
            N[P[k]] = N[k]
            P[N[k]] = P[k]
    return B, N, P


def _find_next(PR, B):
    j = len(B) - 1    
    while j > 0 and ((PR[j] and B[j] == j) or (not PR[j] and B[j] == 0)):
            PR[j] = 1 - PR[j]
            j -= 1
    return j, PR


def _print_nicely(B):
    print("Podział:")
    for x in range(len(B)):
        print([y + 1 for y in range(len(B)) if x == B[y]])
    print()


if __name__ == "__main__":
    partitions(4)
