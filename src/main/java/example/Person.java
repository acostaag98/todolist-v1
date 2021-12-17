package example;

public class Person {
    public static void main(String[] args) {
        PersonExample ejemplo = new PersonExample();
        ejemplo.setName("Agustín");
        ejemplo.setPhone("3518021321");
        ejemplo.setEmail("acostaag98@gmail.com");

        System.out.println("Persona creada con éxito");
        System.out.println(ejemplo.toString());

    }
}
