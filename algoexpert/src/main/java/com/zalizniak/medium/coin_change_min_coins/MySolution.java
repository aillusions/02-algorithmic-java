package com.zalizniak.medium.coin_change_min_coins;

import java.util.List;

public class MySolution implements ChangeMinCoins {

    @Override
    public int minCoins(int sum, List<Integer> coins) {
        int rv = sum;

        for (int i = 0; i < coins.size(); i++) {
            int biggest = biggestCoins(sum, coins.subList(i, coins.size()));
            if (biggest < rv) {
                rv = biggest;
            }
        }

        return rv;
    }

    public int biggestCoins(int sum, List<Integer> coins) {
        if (sum <= 0 || coins.isEmpty()) {
            return 0;
        }

        int denom = coins.get(0);
        if (sum >= denom) {
            return 1 + minCoins(sum - denom, coins);
        } else {
            return minCoins(sum, coins.subList(1, coins.size()));
        }
    }
}
