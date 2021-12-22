package file;

import entities.User;

import java.io.*;

public class SaveFile implements Serializable {

    private File miFile = new File("User.todo");
    private ObjectOutputStream oos;

    public void Guardar(User usuario){

        try {
            this.oos = new ObjectOutputStream(new FileOutputStream(this.miFile));
            oos.writeObject(usuario);
            oos.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}
