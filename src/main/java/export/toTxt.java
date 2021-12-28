package export;
import java.io.FileWriter;
import java.io.IOException;

public class toTxt {
    public static void main(String[] arg) throws IOException {
        FileWriter list = new FileWriter("C:\\Users\\agust\\OneDrive\\Documentos\\list.txt");
        for (int x = 0; x < 9; x++) {
            list.write("Fila numero " + x + "\n");
        }
        list.close();
    }
}
