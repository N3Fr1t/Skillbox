import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ToDoList myToDoList = new ToDoList();

        System.out.println("Список доступных команд: LIST, ADD, EDIT, DELETE.\n");

        myToDoList.start();
    }
}