package lotto.constant;

import lotto.model.Lotto;

public final class ErrorOutputMessage {

    private static final String ERROR = "[ERROR] ";

    public static final String LOTTO_LENGTH = ERROR + "로또번호는 6개입니다.";

    public static final String PURCHASE_TYPE = ERROR + "구매 금액은 숫자로만 이루어져야 합니다.";

    public static final String PURCHASE_MONEY = ERROR + "구매 금액은 " + Lotto.LOTTO_PRICE + "로 나누어 떨어져야 합니다.";

    public static final String LOTTO_DUPLICATED = ERROR + "로또번호는 중복되지 않아야합니다.";

    public static final String LOTTO_RANGE = ERROR + "로또번호는 " + Lotto.LOTTO_MIN_NUMBER + "부터 " + Lotto.LOTTO_MAX_NUMBER + " 까지 입니다.";
}
