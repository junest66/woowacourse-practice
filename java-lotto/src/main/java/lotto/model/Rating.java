package lotto.model;

import java.text.DecimalFormat;
import java.util.NoSuchElementException;

public enum Rating {
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    MISS(0, 0, "");

    private int matchCount;
    private int reward;
    private String printFormat;

    Rating(int matchCount, int reward, String printFormat) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.printFormat = printFormat;
    }

    public static Rating getRating(final int matchCount, final boolean containBonusBall) {
        if (matchCount == THIRD.matchCount && !containBonusBall) {
            return THIRD;
        }

        if (matchCount < FIFTH.matchCount) {
            return MISS;
        }

        return findRatingByMatchCount(matchCount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public String getPrintFormat() {
        return printFormat;
    }

    public static Rating findRatingByMatchCount(int matchCount) {
        for (Rating rating : values()) {
            if (rating.matchCount == matchCount) {
                return rating;
            }
        }
        throw new NoSuchElementException();
    }
}