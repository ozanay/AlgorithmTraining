package com.algorithm.practice.primeandcompositenumbers;

/**
 * @see <a href=
 *      "https://funnelgarden.com/countfactors-codility-solution/">
 *      Funnel Garden's Solution</a>
 */
public class CountFactors {
    public int solution(int number) {
        int factors = 0;
        int squareRootN = (int) Math.sqrt(number);
        if (Math.pow(squareRootN, 2) != number) {
            squareRootN++;
        } else {
            factors++;
        }

        for (int i = 1; i < squareRootN; i++) {
            if (number % i == 0) {
                factors += 2;
            }
        }

        return factors;
    }
}
