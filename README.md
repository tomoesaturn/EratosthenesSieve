# EratosthenesSieve
Eratosthenes' Sieve for Java

I use lazy evaluation of Stream API and lambdas.
It helps to avoid StackOverflow Error, and to use no additional memory. Furthermore, this code is faster than O(N*sqrt(N)).

However, this code is slower than O(N*loglon(N)) because of redundant filtering. Please see Issues.
