#!/usr/bin/python3
# -*- coding: utf-8 -*-


#
# Run inside python3 shell.
#


def gen_gray(n):
  """
  A generator that yields the elements of a gray sequence (as lists) with `n` bits.
  """
  k = 0
  even = True
  seq = [False]*n
  while k < 2**n:
    yield seq
    if even:
      seq[n - 1] = not seq[n - 1]
    else:
      tmp = n - 1
      while not seq[tmp]:
        tmp -= 1
      seq[tmp - 1] = not seq[tmp - 1]
    even = not even
    k += 1


def print_gray_subsets(n):
  """
  Prints all subsets of {1, 2, ..., `n`} in the order 
  given by grey ordering of characteristic vectors.
  """
  for gray in gen_gray(n):
    # assoc_seq = [0 ^ gray[0]] + [gray[k - 1] ^ gray[k] for k in range(1, n)]
    print([k + 1 for k in range(n) if gray[k]])
    
    
def calc_rank(someset, n):
  """
  Calculates the rank of a subset `someset` of {1, 2, ..., `n`} 
  in the ordering given by grey sequenccce of characteristic vectors.
  """
  assoc_seq = [k + 1 in someset for k in range(n)]
  bit = False
  rank = 0
  for k, x in enumerate(assoc_seq):
    bit ^= x
    rank += bit * 2**(n - k - 1)
  return rank
    
    
def calc_set(pos, n):
  """
  Computes the subset of {1, 2, ..., `n`} with given rank `pos` 
  in the ordering induces by gray ordering of indicator vectors.
  """
  binary = [1 & (pos >> (n - k - 1)) for k in range(n)]
  assoc_seq = list(map(lambda x: x[0] ^ x[1], zip([0] + binary[:-1], binary)))
  return [x + 1 for x in range(n) if assoc_seq[x]]
  

def calc_set_lazy(pos, n):
  k = -1
  for gray in gen_gray(n):
    k += 1
    if k == pos:
      return [x + 1 for x in range(n) if gray[x]]