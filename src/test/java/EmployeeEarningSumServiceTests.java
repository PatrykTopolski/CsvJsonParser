import com.patryk.dao.DataReader;
import com.patryk.dao.JsonReader;
import com.patryk.model.Employee;
import com.patryk.service.EmployeeEarningSumService;
import com.patryk.service.StringToFloatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeEarningSumServiceTests {

    private  DataReader dataReader = mock(JsonReader.class);
    private  StringToFloatService stfService = mock(StringToFloatService.class);
    private  String filePath = "Any file path";
    private EmployeeEarningSumService earningSumService;


    @BeforeEach
    void init(){
        when(stfService.validateAndChangeStringToFloat(anyString())).thenReturn(2.99f);
        earningSumService = new EmployeeEarningSumService();
    }



    @Test
    @DisplayName("Test Sum salary  for Each job with many persons on the same job")
    void testSumSalary(){

        assertEquals( createTestOutPutMapForMany(), earningSumService.CountEarningsByOccupation(createTestEntryMapForMany(), stfService),
                "should group all Jobs together and sum their earnings");
    }

    @Test
    @DisplayName("Test Sum salary for each job with empty employee list")
    void testSumEmpty(){
        assertEquals(Collections.EMPTY_MAP, earningSumService.CountEarningsByOccupation(Collections.emptyList(), stfService));
    }

    @Test
    @DisplayName("Test Sum salary for each job with just one employee")
    void testOneEmployeeSumSalary(){
        assertEquals(createTestOutPutMapForOneEmp(), earningSumService.CountEarningsByOccupation(createTestEntryMapForOneEmployee(), stfService));
    }




    private  List<Employee>  createTestEntryMapForMany(){
        ArrayList<Employee> employeesMock = new ArrayList<>();
        employeesMock.add(new Employee(0, "Mark", "Apple", "Teacher", "2.99"));
        employeesMock.add(new Employee(1, "Geeck", "Tomato", "Teacher", "2.99"));
        employeesMock.add(new Employee(2, "Kate", "Potato", "Priest", "2.99"));
        return employeesMock;
    }

    private  Map<String, Float> createTestOutPutMapForMany(){
        Map<String, Float> outcome  = new HashMap<>();
        outcome.put("Teacher", 2.99f + 2.99f);
        outcome.put("Priest", 2.99f);
        return outcome;
    }

    private  List<Employee>  createTestEntryMapForOneEmployee(){
        ArrayList<Employee> employeesMock = new ArrayList<>();
        employeesMock.add(new Employee(2, "Kate", "Potato", "Priest", "2.99"));
        return employeesMock;
    }

    private  Map<String, Float> createTestOutPutMapForOneEmp(){
        Map<String, Float> outcome  = new HashMap<>();
        outcome.put("Priest", 2.99f);
        return outcome;
    }
}
