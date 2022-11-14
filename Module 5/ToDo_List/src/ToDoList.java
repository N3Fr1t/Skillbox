import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ToDoList {
    private String task = "";
    private String[] taskArr;
    private final ArrayList<String> taskList = new ArrayList<>();

    public ToDoList() {
    }

    public void setTask(String task) {
        this.task = task;
    }


    public void setTaskArr(String[] taskArr) {
        this.taskArr = taskArr;
    }

    public boolean isCommandCorrect() {
        return taskArr[0].trim().equalsIgnoreCase("list")
                || taskArr[0].trim().equalsIgnoreCase("add")
                || taskArr[0].trim().equalsIgnoreCase("edit")
                || taskArr[0].trim().equalsIgnoreCase("delete")
                || taskArr[0].trim().equalsIgnoreCase("exit");
    }

    public boolean isCheckIndex() {
        return !taskList.isEmpty() && taskArr[1].trim().matches("\\d+.*") && Integer.parseInt(taskArr[1]) < taskList.size();
    }

    public void getList() {
        if (!taskList.isEmpty()) {
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println(i + " - " + taskList.get(i));
            }
        } else
            System.out.println("Список дел пуст");
    }

    public String textWithoutPrefix() {
        if (isCheckIndex()) {
            task = task.substring(taskArr[0].length() + taskArr[1].length() + 1).trim();
        } else {
            task = task.substring(taskArr[0].length()).trim();
        }
        return task;
    }

    public void addNewTask() {
        if (taskArr.length < 2) {
            System.out.println("Введена неверная команда");
        } else if (isCheckIndex()) {
            taskList.add(Integer.parseInt(taskArr[1]), textWithoutPrefix());
            System.out.println("Задача успешно добавлена");
        } else {
            taskList.add(textWithoutPrefix());
            System.out.println("Задача успешно добавлена");
        }
    }

    public void editTask() {
        if (isCheckIndex()) {
            taskList.set(Integer.parseInt(taskArr[1]), textWithoutPrefix());
            System.out.println("Задача успешно отредактирована");
        } else {
            System.out.println("Задачи с таким индексом не существует");
        }
    }

    public void deleteTask() {
        if (isCheckIndex() && taskArr.length < 3) {
            taskList.remove(Integer.parseInt(taskArr[1]));
            System.out.println("Задача успешно удалена");
        } else {
            System.out.println("Не понимаю");
        }
    }

    public void start() throws IOException {
        while (!task.equals("exit")) {
            System.out.print("Введите команду: ");
            setTask(new BufferedReader(new InputStreamReader(System.in)).readLine());

            setTaskArr(task.split(" "));

            if (isCommandCorrect()) {
                if (taskArr[0].equalsIgnoreCase("list"))
                    getList();
                else if (taskArr[0].equalsIgnoreCase("add"))
                    addNewTask();
                else if (taskArr[0].equalsIgnoreCase("edit"))
                    editTask();
                else if (taskArr[0].equalsIgnoreCase("delete"))
                    deleteTask();
                else if (taskArr[0].equalsIgnoreCase("exit"))
                    break;
            } else
                System.out.println("Введена неверная команда");
            System.out.println();
        }
    }
}