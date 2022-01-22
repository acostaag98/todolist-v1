package helpers;

public class IdGenerator {

    //applying Replace Magic Number with Symbolic Constant method
    static final int INTEGER_CONSTANT = 1;

    //applying Introduce Foreign Method
    public String AssignUniqueId(int hash){
        int tmpID = hash;

        if (tmpID < INTEGER_CONSTANT){
            tmpID = -1 * tmpID;
        }
        return String.valueOf( tmpID );
    }

}
