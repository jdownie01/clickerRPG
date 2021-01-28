/*
 * Copyright (c) 2021, Jake Downie, All Rights Reserved
 */

/**
 * Collatz Conjecture
 * The Collatz Conjecture states that, given an initial value
 * n that is greater than 0, the sequence will always eventually
 * arrive at 1.
 *
 * @author Jake Downie
 * @author jwd2488
 */
public class Collatz {

    /**
     * Our main function, calls sequence with different values for n.
     *
     * @param args any input args that would be used.
     */
    public static void main(String[] args) {
        System.out.println("Sequence for 1: " + sequence(1));
        System.out.println("Sequence for 13: " + sequence(13));
        System.out.println("Sequence for 5: " + sequence(5));
        System.out.println("Sequence for 0: " + sequence(0));
    }

    /**
     * Static function for the Collatz Conjecture.
     *
     * @param n the input number
     * @return returns the completed sequence in string form.
     */
    public static String sequence(int n) {
        String sequence = Integer.toString(n);
        if (!(n < 1)) {
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = (3 * n) + 1;
                }
                sequence += " " + Integer.toString(n);
            }
            return sequence.toString();
        } else {
            return "";
        }
    }
}