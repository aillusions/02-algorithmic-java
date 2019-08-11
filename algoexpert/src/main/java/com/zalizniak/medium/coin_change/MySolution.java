package com.zalizniak.medium.coin_change;

import java.util.List;

/**
 * https://www.ideserve.co.in/learn/coin-change-problem-number-of-ways-to-make-change
 *
 * If we are make change of 50 using infinite number of coins of denominations {20,10,5,1} then
 * total number of ways to make change of 50 using denominations {20,10,5,1} = total number of ways to make change of 50 using 0 coins of 20 + total number of ways to make change of 50 using 1 coin of 20 + total number of ways to make change of 50 using 2 coins of 20
 * Now first term on the right hand side of above equation that is - total number of ways to make change of 50 using 0 coins of 20 can be restated as total number of ways to make change of 50 using denominations {10,5,1}
 * And second term that is total number of ways to make change of 50 using 1 coin of 20 = total number of ways to make change of 30 using denominations {10,5,1}
 * Similarly, total number of ways to make change of 50 using 2 coins of 20 = total number of ways to make change of 10 using denominations {10,5,1}.
 *
 * Time Complexity is O(nm)
 * Space Complexity is O(nm)
 *
 */
public class MySolution implements MakingChange {

    /**
     * Assuming ordered
     *
     *
     */
    @Override
    public int numberOfWays(int sum, List<Integer> coins) {

        int thisSumResult = 0;
        for (int i = 0; i < coins.size(); i++) {
            int denom = coins.get(i);
            int maxCoinsPerDenom = sum / denom;

            for (int j = 0; j < sum; j++) {

            }
        }

        if (coins.size() > 1) {
            int preSumResult = numberOfWays(sum, coins.subList(1, coins.size()));
            return thisSumResult + preSumResult;
        } else {
            return thisSumResult;
        }

    }
}
