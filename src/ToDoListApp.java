import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task{
    private String description;
    private boolean isCompleted;
    private LocalDate date;
    private LocalTime time;

    public Task(String description, LocalDate date, LocalTime time) {
        this.description = description;
        this.isCompleted = false;
        this.date = date;
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted(){
        this.isCompleted = true;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return (isCompleted ? "[X]" : "[ ]") + description + " (Due: " + date.format(dateFormatter) + " " + time.format(timeFormatter) + ")";
    }
}
class ToDOList{
    private List<Task> tasks;
    public ToDOList() {
        tasks = new ArrayList<>();
    }
    public void addTask(String description, LocalDate date, LocalTime time){
        tasks.add(new Task(description, date, time));
    }
    public void completeTask(int index){
        if (index>= 0 && index < tasks.size()){
            tasks.get(index).markAsCompleted();
        }else {
            System.out.println("Invalid task number.");
        }
    }
    public void updateTask(int index, String newDescription, LocalDate newDate, LocalTime newTime){
        if (index>=0 && index < tasks.size()){
            Task task = tasks.get(index);
            task.setDescription(newDescription);
            task.setDate(newDate);
            task.setTime(newTime);
        }else {
            System.out.println("Invalid task number.");
        }
    }
    public void removeTask(int index){
        if(index>=0 && index < tasks.size()){
            tasks.remove(index);
        }else {
            System.out.println("Invalid task number.");
        }
    }
    public void listTasks(){
        if (tasks.isEmpty()){
            System.out.println("No tasks in the list.");
        }else {
            for(int i=0; i<tasks.size(); i++){
                System.out.println((i+1)+"."+tasks.get(i));
            }
        }
    }
}
public class ToDoListApp {
    private static ToDOList toDOList = new ToDOList();
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running){
            printMenu();
            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    addTask(scanner);
                    break;
                case "2":
                    listTask();
                    break;
                case "3":
                    completeTask(scanner);
                    break;
                case "4":
                    updateTask(scanner);
                    break;
                case "5":
                    removeTask(scanner);
                    break;
                case "6":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
        System.out.println("Thank You for using the To-Do List Application, Visit Again !");
        scanner.close();
    }
    private static void printMenu(){
        System.out.println("\n  To-Do List Application");
        System.out.println("----====================----");
        System.out.println("1. Add a new task");
        System.out.println("2. List all tasks");
        System.out.println("3. Mark a task as completed");
        System.out.println("4. Update a task");
        System.out.println("5. Remove a task");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");
    }
    private static void addTask(Scanner scanner){
        System.out.println("Enter the task description: ");
        String description = scanner.nextLine();
        LocalDate date = getDateFromUser(scanner);
        LocalTime time = getTimeFromUser(scanner);
        toDOList.addTask(description, date, time);
        System.out.println("Task added successfully.");
        listTask();
    }
    private static void listTask(){
        System.out.println("\nYour Tasks: ");
        toDOList.listTasks();
    }
    private static void completeTask(Scanner scanner){
        System.out.println("Enter the task number to mark as completed: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());
        toDOList.completeTask(taskNumber-1);
        System.out.println("Task marked as completed.");
        listTask();
    }
    private static void updateTask(Scanner scanner){
        System.out.println("Enter the task number to update: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the new task description: ");
        String newDescription = scanner.nextLine();
        LocalDate newDate = getDateFromUser(scanner);
        LocalTime newTime = getTimeFromUser(scanner);
        toDOList.updateTask(taskNumber-1, newDescription, newDate, newTime);
        System.out.println("Task updated.");
        listTask();
    }
    private static void removeTask(Scanner scanner){
        System.out.println("Enter the task number to remove: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());
        toDOList.removeTask(taskNumber-1);
        System.out.println("Task removed successfully.");
        listTask();
    }
    private static LocalDate getDateFromUser(Scanner scanner) {
        LocalDate date = null;
        while (date == null) {
            System.out.print("Enter the date (dd-MM-yyyy): ");
            String dateString = scanner.nextLine();
            try {
                date = LocalDate.parse(dateString, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
        return date;
    }

    private static LocalTime getTimeFromUser(Scanner scanner) {
        LocalTime time = null;
        while (time == null) {
            System.out.print("Enter the time (HH:mm): ");
            String timeString = scanner.nextLine();
            try {
                time = LocalTime.parse(timeString, timeFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please try again.");
            }
        }
        return time;
    }
}