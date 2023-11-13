package christmas.DTO;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.DiscountResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountResultDTOTest {
    @DisplayName("모든 이벤트 금액이 0이면 true를 반환한다.")
    @Test
    void shouldReturnTrueWhenAllDiscountsAreZero() {
        DiscountResult discountResult = new DiscountResult();
        discountResult.addDiscount("크리스마스 디데이 할인", 0);
        discountResult.addDiscount("평일 할인", 0);
        discountResult.addDiscount("증정 이벤트", 0);
        discountResult.addDiscount("특별 할인", 0);
        DiscountResultDTO discountResultDTO = new DiscountResultDTO(discountResult);
        assertThat(discountResultDTO.isAllZeroValues()).isTrue();
    }

    @DisplayName("하나라도 이벤트 금액이 0이 아니라면 false를 반환한다.")
    @Test
    void shouldReturnFalseWhenAnyDiscountIsNonZero() {
        DiscountResult discountResult = new DiscountResult();
        discountResult.addDiscount("크리스마스 디데이 할인", 0);
        discountResult.addDiscount("평일 할인", 1000);
        discountResult.addDiscount("증정 이벤트", 1000);
        discountResult.addDiscount("특별 할인", 0);
        DiscountResultDTO discountResultDTO = new DiscountResultDTO(discountResult);
        assertThat(discountResultDTO.isAllZeroValues()).isFalse();
    }
}
