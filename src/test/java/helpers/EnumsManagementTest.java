package helpers;

import enums.actionType;
import enums.priorityType;
import enums.stateType;
import gui.ManageToDo;
import helpers.EnumsManagement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EnumsManagementTest {

    private static final Logger logger = LogManager.getLogger(ManageToDo.class);

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