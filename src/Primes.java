/*
 * Copyright (c) 2021, Jake Downie, All Rights Reserved
 */

/**
 * Primes Class
 *
 * @author Jake Downie
 * @author jwd2488
 */
public class Primes {
    /**
     * Our main function for calling the isPrime function for all 100 real numbers.
     *
     * @param args any input args that would be used
     */
    public static void main(String[] args) {
        int i = 1;
        while (i < 101) {
            System.out.println(i + " " + isPrime(i));
            i += 1;
        }
    }

    /**
     * @param n the input number to test if it's prime
     * @return true or false depending on whether the input number is prime.
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else if (n % 2 == 0) {
            // A Number Divisible by two cant be prime unless its 2.
            return n == 2;
        }
        int i = 2;
        while (i != (n - 1)) {
            if (n % i == 0) {
                return false;
            }
            i += 1;
        }
        return true;
    }
}