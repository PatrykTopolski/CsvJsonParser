import static org.junit.jupiter.api.Assertions.*;
import com.patryk.service.StringToFloatService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringToFloatServiceTests {

    private StringToFloatService stfService = new StringToFloatService();
    private final String wrongFloatPattern = "2,99";
    private final String goodFloatPattern = "2.99";
    private final float expectedFloatValue = 2.99f;

    @Test
    @DisplayName("validate good float pattern and return float")
    void testFloatGoodPatternReturn(){
        assertEquals( expectedFloatValue, stfService.validateAndChangeStringToFloat(goodFloatPattern),
                "should validate and leave value as it is and just change to float");
    }

    @Test
    @DisplayName("validate wrong float patter and return float")
    void testFloatWrongPattern(){
        assertEquals(expectedFloatValue, stfService.validateAndChangeStringToFloat(wrongFloatPattern),
                " should validate negatively and change , to . and return proper float afterwards");
    }



    //todo negative minus float tests
}
