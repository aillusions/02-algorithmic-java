package com.zalizniak.medium.coin_change_min_coins;

import java.util.List;

public class MySolution implements ChangeMinCoins {

    @Override
    public int minCoins(int sum, List<Integer> coins) {

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
