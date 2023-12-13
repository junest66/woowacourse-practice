package menu.constants;

public enum FoodMenu {
    GYUDON("규동", FoodCategory.JAPANESE), UDON("우동", FoodCategory.JAPANESE),
    MISO_SOUP("미소시루", FoodCategory.JAPANESE), SUSHI("스시", FoodCategory.JAPANESE),
    KATSUDON("가츠동", FoodCategory.JAPANESE), ONIGIRI("오니기리", FoodCategory.JAPANESE),
    HAYASHI_RICE("하이라이스", FoodCategory.JAPANESE), RAMEN("라멘", FoodCategory.JAPANESE),
    OKONOMIYAKI("오코노미야끼", FoodCategory.JAPANESE),

    KIMBAP("김밥", FoodCategory.KOREAN), KIMCHI_STEW("김치찌개", FoodCategory.KOREAN),
    SSAM_BAP("쌈밥", FoodCategory.KOREAN), DOENJANG_STEW("된장찌개", FoodCategory.KOREAN),
    BIBIMBAP("비빔밥", FoodCategory.KOREAN), KALGUKSU("칼국수", FoodCategory.KOREAN),
    BULGOGI("불고기", FoodCategory.KOREAN), TTEOKBOKKI("떡볶이", FoodCategory.KOREAN),
    JAEYUK_BOKEUM("제육볶음", FoodCategory.KOREAN),

    KUNG_PAU_CHICKEN("깐풍기", FoodCategory.CHINESE), FRIED_NOODLES("볶음면", FoodCategory.CHINESE),
    DONGPO_PORK("동파육", FoodCategory.CHINESE), JAJANGMYEON("짜장면", FoodCategory.CHINESE),
    JJAMPPONG("짬뽕", FoodCategory.CHINESE), MAPO_TOFU("마파두부", FoodCategory.CHINESE),
    SWEET_AND_SOUR_PORK("탕수육", FoodCategory.CHINESE),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음", FoodCategory.CHINESE),
    HOT_PEPPER_JAPCHAE("고추잡채", FoodCategory.CHINESE),

    PAD_THAI("팟타이", FoodCategory.ASIAN), KHAO_PHAT("카오 팟", FoodCategory.ASIAN),
    NASI_GORENG("나시고렝", FoodCategory.ASIAN),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥", FoodCategory.ASIAN),
    PHO("쌀국수", FoodCategory.ASIAN), TOM_YUM_GOONG("똠얌꿍", FoodCategory.ASIAN),
    BANH_MI("반미", FoodCategory.ASIAN), GOI_CUON("월남쌈", FoodCategory.ASIAN),
    BUN_CHA("분짜", FoodCategory.ASIAN),

    // 양식 메뉴
    LASAGNA("라자냐", FoodCategory.WESTERN), GRATIN("그라탱", FoodCategory.WESTERN),
    GNOCCHI("뇨끼", FoodCategory.WESTERN), QUICHE("끼슈", FoodCategory.WESTERN),
    FRENCH_TOAST("프렌치 토스트", FoodCategory.WESTERN), BAGUETTE("바게트", FoodCategory.WESTERN),
    SPAGHETTI("스파게티", FoodCategory.WESTERN), PIZZA("피자", FoodCategory.WESTERN),
    PANINI("파니니", FoodCategory.WESTERN);

    private final String name;
    private final FoodCategory category;

    FoodMenu(String name, FoodCategory category) {
        this.name = name;
        this.category = category;
    }

    public static boolean isValidName(String name) {
        for (FoodMenu menu : values()) {
            if (menu.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public FoodCategory getCategory() {
        return category;
    }
}
