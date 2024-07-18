package lk.ijse;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        Book book = new Book("The Catcher in the Rye", "J.D. Salinger", 1951);

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.ser"))) {
            oos.writeObject(book);
            System.out.println("Serialization successful: " + book);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.ser"))) {
            Book deserializedBook = (Book) ois.readObject();
            System.out.println("Deserialization successful: " + deserializedBook);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
