package menu.constants;

public enum FoodCategory {
    JAPANESE("일식", 1), KOREAN("한식", 2), CHINESE("중식", 3), ASIAN("아시안", 4), WESTERN("양식", 5);

    private final String name;
    private final int number;

    FoodCategory(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public static FoodCategory findByNumber(int number) {
        for (FoodCategory category : values()) {
            if (category.getNumber() == number) {
                return category;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않는 숫자입니다. " + number);
    }
}
