package helpers;

public class IdGenerator {
    //applying Introduce Foreign Method
    public String AssignUniqueId(int hash){
        int tmpID = hash;

        if (tmpID < 1){
            tmpID = -1 * tmpID;
        }
        return String.valueOf( tmpID );
    }

}
