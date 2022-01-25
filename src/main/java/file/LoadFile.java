package file;

import entities.User;

import java.io.*;

public class LoadFile implements Serializable {

    private File miFile = new File("BD/User.todo");
    private ObjectInputStream ois;
    private User Usuario;

    public User Cargar(){
        try {
            this.ois = new ObjectInputStream(new FileInputStream(this.miFile));
            this.Usuario = (User) ois.readObject();

        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        return this.Usuario;
    }
}
