package tdd.vendingMachine.domain.money;

import java.util.EnumMap;

public class MoneyBox {

    private EnumMap<Coins, Integer> coins = new EnumMap<Coins, Integer>(Coins.class) {{
        put(Coins.COIN_0_1, 0);
        put(Coins.COIN_0_2, 0);
        put(Coins.COIN_0_5, 0);
        put(Coins.COIN_1, 0);
        put(Coins.COIN_2, 0);
        put(Coins.COIN_5, 0);
    }};

    public MoneyBox() {
    }

    public MoneyBox(MoneyBox box) {
        for (Coins coin : Coins.values()) {
            coins.put(coin, box.getCoinCount(coin));
        }
    }

    public int getCoinCount(Coins coin) {
        return coins.get(coin);
    }

    public MoneyBox insert(Coins coin, int count) {
        coins.put(coin, coins.get(coin) + count);

        return this;
    }

    public boolean isEmpty(Coins coin) {
        return coins.get(coin) == 0;
    }

    public MoneyBox remove(Coins coin, int count) {
        if (coins.get(coin) < count) {
            throw new IllegalArgumentException("Not enough coins");
        }

        coins.put(coin, coins.get(coin) - count);

        return this;
    }

    public int getTotalAmount() {
        int total = 0;

        for (Coins coin : Coins.values()) {
            total += coins.get(coin) * coin.getValue();
        }

        return total;
    }

    public MoneyBox reset() {
        for (Coins coin : Coins.values()) {
            coins.put(coin, 0);
        }

        return this;
    }

    public MoneyBox mergeWith(MoneyBox boxToMergeWith) {
        for (Coins coin : Coins.values()) {
            coins.put(coin, coins.get(coin) + boxToMergeWith.getCoinCount(coin));
        }

        return this;
    }
}
