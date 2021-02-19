package lotto.domain;

import lotto.exception.InvalidLottoHitCountException;

import java.util.Arrays;

public enum Reword {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int hitCount;
    private final int winningMoney;

    Reword(final int hitCount, final int winningMoney) {
        this.hitCount = hitCount;
        this.winningMoney = winningMoney;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Reword valueOf(final int hitCount, final boolean isHitBonus) {
        validateHitCount(hitCount);

        if (hitCount == SECOND.hitCount) {
            return checkBonusReword(isHitBonus);
        }

        return Arrays.stream(values())
            .filter(reword -> reword.matchHitCount(hitCount))
            .findFirst()
            .orElse(Reword.NONE);
    }

    private static Reword checkBonusReword(final boolean isHitBonus) {
        if (isHitBonus) {
            return Reword.SECOND;
        }
        return Reword.THIRD;
    }

    private boolean matchHitCount(final int hitCount) {
        return hitCount == this.hitCount;
    }

    private static void validateHitCount(final int value) {
        if (value < NONE.hitCount || value > FIRST.hitCount) {
            throw new InvalidLottoHitCountException();
        }
    }
}
