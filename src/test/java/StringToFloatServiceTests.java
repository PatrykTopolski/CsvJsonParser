import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import com.patryk.service.StringToFloatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringToFloatServiceTests {

    private StringToFloatService stfService = new StringToFloatService();
    private final String wrongFloatPattern = "2,99";
    private final String goodFloatPattern = "2.99";
    private final float expectedFloatValue = Float.parseFloat("2.99");

    @Test
    @DisplayName("validate and change string to float method return tests")
    void testFloatReturn(){
        assertAll(
                () -> assertEquals( expectedFloatValue, stfService.validateAndChangeStringToFloat(goodFloatPattern), "should validate and leave value as it is and just change to float"),
                () -> assertEquals(expectedFloatValue, stfService.validateAndChangeStringToFloat(wrongFloatPattern), " should validate negatively and change , to . and return proper float afterwards")
        );
    }
}
