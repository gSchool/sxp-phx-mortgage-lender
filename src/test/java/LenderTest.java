import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


final class LenderTest {
    /*getFunds
    * N - N/A
    * Z - when will this return 0?
    * O
    * M
    * B
    * I
    * E
    * S
     */
    @Test
    void getAvailableFundsShouldReturnZeroByDefault(){
        //Given
        Lender lender = new Lender();
        Long expected = 0L;

        //When
        Long actual = lender.getAvailableFunds();

        //Then
        assertThat(actual).isEqualTo(expected);
    }

    /*addFunds
     * N - N/A
     * Z - input 0 -> throw exception
     * O - input 1 -> availableFunds = 1
     * M - input 5 -> availableFunds = 5
     * B - input negative amount -> throw exception; input Long.MAX_VALUE ->
     * I
     * E
     * S
     */
    @Test
    void addFundsShouldThrowIllegalArgumentExceptionWhenPassedZero(){
        //Given
        Lender lender = new Lender();
        String expected = "Amount added must be greater than 0";

        //When
        Exception actual = assertThrows(IllegalArgumentException.class, () -> lender.addFunds(0L));

        //Then
        assertThat(actual.getMessage()).isEqualTo(expected);
    }

    @Test
    void addFundsShouldIncreaseFundsByOneWhenPassedOne(){
        //Given
        Lender lender = new Lender();
        Long expected = 1L;

        //When
        lender.addFunds(1L);
        Long actual = lender.getAvailableFunds();

        //Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void addFundsShouldIncreaseFundsByFiveWhenPassedFive(){
        //Given
        Lender lender = new Lender();
        Long expected = 5L;

        //When
        lender.addFunds(5L);
        Long actual = lender.getAvailableFunds();

        //Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void addFundsShouldThrowIllegalArgumentExceptionWhenPassedNegativeValue(){
        //Given
        Lender lender = new Lender();
        String expected = "Amount added must be greater than 0";

        //When
        Exception actual = assertThrows(IllegalArgumentException.class, () -> lender.addFunds(Long.MIN_VALUE));

        //Then
        assertThat(actual.getMessage()).isEqualTo(expected);
    }

    @Test
    void AddFundsShouldThrowArithmeticExceptionWhenFundsAreMaxedOut(){
        //Given
        Lender lender = new Lender();
        lender.addFunds(Long.MAX_VALUE);

        //When/Then
        assertThrows(ArithmeticException.class, ()-> lender.addFunds(1L));
    }
}
