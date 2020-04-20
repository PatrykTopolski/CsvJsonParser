import com.patryk.dao.DataReader;
import com.patryk.dao.JsonReader;
import com.patryk.model.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonReaderTests {

    @Test
    @DisplayName("Test CsvReader on exDample csv file")
    void TestCsvReader(){
        DataReader jsonReader = new JsonReader();
        assertEquals(getExpectedOutput().get(0).getName(), jsonReader.readData("test.json").get(0).getName().trim(), "functional Test for CsvReader");
    }


    private List<Employee>  getExpectedOutput(){
        List<Employee> testEmployees = new ArrayList<>();
        testEmployees.add(new Employee(0,"Mark", "Tasty", "Teacher", "2.99"));
        return testEmployees;
    }
}
