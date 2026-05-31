package dropdown;

import base.baseTests;
import org.testng.annotations.Test;
import pages.dropDownPage;
import static org.testng.Assert.*;

import java.util.List;

public class DropdownTests extends baseTests {
    @Test
    public void testDropdown(){
        String option = "Option 1";
        dropDownPage dropdownpage = HomePage.clickDropdown();
        dropdownpage.selectFromDropdown(option);
        List<String> selectedOptions = dropdownpage.getSelectedOption();
        assertEquals(selectedOptions.size(),1,"the size is not correct");
        assertTrue(selectedOptions.contains(option),"The option is not selected");

    }
}
