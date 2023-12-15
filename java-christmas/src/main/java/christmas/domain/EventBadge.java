package christmas.domain;

public enum EventBadge {
    STAR(5000, "별"),
    TREE(10000, "트리"),
    SANTA(20000, "산타"),
    NONE(0, "없음");

    private final int minimumAmount;
    private final String koreanName;

    EventBadge(int minimumAmount, String koreanName) {
        this.minimumAmount = minimumAmount;
        this.koreanName = koreanName;
    }

    public int getMinimumAmount() {
        return minimumAmount;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public static EventBadge getByAmount(int amount) {
        if (amount >= SANTA.minimumAmount) {
            return SANTA;
        } else if (amount >= TREE.minimumAmount) {
            return TREE;
        } else if (amount >= STAR.minimumAmount) {
            return STAR;
        } else {
            return NONE;
        }
    }
}

