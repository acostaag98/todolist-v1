package test;

import enums.actionType;
import enums.priorityType;
import enums.stateType;
import helpers.EnumsManagement;
import org.junit.Test;

import java.lang.reflect.AccessibleObject;

import static org.junit.Assert.*;

public class EnumsManagementTest {

    @Test
    public void find_PriorityType_By_Wrong_Value() {

        assertEquals(null, new EnumsManagement().findPriorityByValue("José"));
    }

    @Test
    public void find_PriorityType_By_Correct_Value() {

        assertEquals( priorityType.LOW, new EnumsManagement().findPriorityByValue("Low"));
    }

    @Test
    public void find_StateType_By_Wrong_Value() {

        assertEquals(null, new EnumsManagement().findStateByValue("Malo"));
    }

    @Test
    public void find_StateType_By_Correct_Value() {

        assertEquals( stateType.FINISHED, new EnumsManagement().findStateByValue("Finished"));
    }

}