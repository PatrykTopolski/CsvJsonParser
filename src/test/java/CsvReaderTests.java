import com.patryk.dao.CsvReader;
import com.patryk.dao.DataReader;
import com.patryk.model.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvReaderTests {
    @Test
    @DisplayName("Test CsvReader on example csv file")
    void TestCsvReader(){
        DataReader csvReader = new CsvReader();
        assertEquals(getExpectedOutput().get(0).getName(), csvReader.readData("test.csv").get(0).getName().trim(), "functional Test for CsvReader");
    }

    private List<Employee>  getExpectedOutput(){
        List<Employee> testEmployees = new ArrayList<>();
        testEmployees.add(new Employee(0,"Test", "Tasty", "Teacher", "2.99"));
        return testEmployees;
    }
}
