#!/usr/bin/python3
# -*- coding: utf-8 -*-


#
# Run inside python3 interpreter.
#


def gen_full(k, n):
  """
  Lists all sequences of length `k` with elements in 
  {1, 2, ..., `n`} in the lexicographical order. 
  """
  gen(k, n, [])
  

def gen(k, n, pocz):
  if k == 0:
    print(pocz)
    return
  for x in range(1, n + 1):
    gen(k - 1, n, pocz + [x])    


def find_position(someset, n, in_binary=False):
  """
  Computes the rank of a given subset `someset` of {1, 2, ..., `n`}
  in the lexicographical order. If `in_binary` is true, assumes that 
  `someset` is given as a characteristic vector.
  """
  if(in_binary):
    someset = [k for k in range(1, n + 1) if someset[k - 1]]
  return sum(2**(n - k) for k in someset) + 1