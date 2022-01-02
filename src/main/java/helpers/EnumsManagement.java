package helpers;

import enums.priorityType;
import enums.stateType;

public class EnumsManagement {

    public priorityType findPriorityByValue(String val ){
        for(priorityType priority : priorityType.values()){
            if( priority.getValue().equals(val)){
                return priority;
            }
        }
        return null;
    }

    public stateType findStateByValue (String val ) {
        for ( stateType state : stateType.values() ){
            if ( state.getValue().equals(val) ){
                return state;
            }
        }
        return null;
    }

}
