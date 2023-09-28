package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.ErrorOutputMessage;

import java.util.*;

import static lotto.model.Rating.getRating;

public class User {

    private List<Lotto> lottoList;
    private Lotto winningLotto;
    private int bonusNumber;
    private int purchaseMoney;
    private Map<Rating, Integer> result = new EnumMap<>(Rating.class);


    public User() {
        initResult();
    }

    private void initResult() {
        for (Rating rating : Rating.values()) {
            result.put(rating, 0);
        }
    }


    public void setLottoList(int purchaseMoney) {
        validate(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
        this.lottoList = lottoList(purchaseMoney / Lotto.LOTTO_PRICE);
    }

    private void validate(int purchaseMoney) {
        try {
            String money = Integer.toString(purchaseMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorOutputMessage.PURCHASE_TYPE);
        }

        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException(ErrorOutputMessage.PURCHASE_MONEY);
        }
    }

    public void setWinningLotto(String lotto) {
        List<Integer> list = new ArrayList<>();
        String[] numbers = lotto.split(",");
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }
        this.winningLotto = new Lotto(list);
    }

    public void setBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorOutputMessage.LOTTO_RANGE);
        }

        if (this.winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorOutputMessage.LOTTO_DUPLICATED);
        }

        this.bonusNumber = bonusNumber;
    }

    public Lotto inputRandomNumbers() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<Lotto> lottoList(int lottoNum) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            lottoList.add(inputRandomNumbers());
        }
        return lottoList;
    }

    public void printLotto() {
        System.out.println(purchaseMoney / Lotto.LOTTO_PRICE + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void checkWinning() {
        for (Lotto lotto : lottoList) {
            checkWinningNum(lotto);
        }
    }

    public void checkWinningNum(Lotto lotto) {
        int count = 0;
        boolean isBonusNumber = true;
        Set winningSet = new HashSet<>(winningLotto.getNumbers());
        List<Integer> numbers = lotto.getNumbers();
        for (Integer number : numbers) {
            if (winningSet.contains(number)) {
                count++;
            }
        }
        if (count == 5 && !winningSet.contains(bonusNumber)) {
            isBonusNumber = false;
        }
        result.put(getRating(count, isBonusNumber), result.get(getRating(count, isBonusNumber)) + 1);
    }

    public void printResult() {
        for (Rating rating : Rating.values()) {
            if(rating.getMatchCount() != 0) {
                System.out.println(rating.getPrintFormat() + " - " + result.get(rating) + "개");
            }
        }
    }

    public void getRate() {
        double sum = 0;
        for (Map.Entry<Rating, Integer> entry : result.entrySet()) {
            sum += entry.getKey().getReward() * entry.getValue();
        }
        System.out.println("총 수익률은 " + (Math.round(((sum - purchaseMoney) / purchaseMoney + 1) * 10000.0) / 100.0) + "%입니다.");
    }
}
