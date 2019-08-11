package com.zalizniak.medium.coin_change;

import java.util.List;

/**
 * https://www.ideserve.co.in/learn/coin-change-problem-number-of-ways-to-make-change
 * <p>
 * If we are make change of 50 using infinite number of coins of denominations {20,10,5,1} then
 * total number of ways to make change of 50 using denominations {20,10,5,1} = total number of ways to make change of 50 using 0 coins of 20 + total number of ways to make change of 50 using 1 coin of 20 + total number of ways to make change of 50 using 2 coins of 20
 * Now first term on the right hand side of above equation that is - total number of ways to make change of 50 using 0 coins of 20 can be restated as total number of ways to make change of 50 using denominations {10,5,1}
 * And second term that is total number of ways to make change of 50 using 1 coin of 20 = total number of ways to make change of 30 using denominations {10,5,1}
 * Similarly, total number of ways to make change of 50 using 2 coins of 20 = total number of ways to make change of 10 using denominations {10,5,1}.
 * <p>
 * Time Complexity is O(nm)
 * Space Complexity is O(nm)
 */
public class MySolution implements MakingChange {

    /**
     * Assuming ordered
     */
    @Override
    public int numberOfWays(int sum, List<Integer> coins) {

        if (sum == 0) {
            return 1;
        }

        if (sum < 0 || coins.isEmpty()) {
            return 0;
        }

        final int denomination = coins.get(0);
        final int sumRemainded = sum - denomination;
        final List<Integer> denomRemainded = coins.subList(1, coins.size());

        final int incl = numberOfWays(sumRemainded, coins);
        final int excl = numberOfWays(sum, denomRemainded);

        return incl + excl;
    }
}
