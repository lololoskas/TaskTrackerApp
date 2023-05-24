import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }

    @Override
    public String toString() {
        return "[" + (completed ? "X" : " ") + "] " + description;
    }
}

class TaskTracker {
    private List<Task> tasks;

    public TaskTracker() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsCompleted();
            System.out.println("Task marked as completed: " + task.getDescription());
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}

public class TaskTrackerApp {
    public static void main(String[] args) {
        TaskTracker taskTracker = new TaskTracker();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to TaskTracker!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a task");
            System.out.println("2. Mark a task as completed");
            System.out.println("3. Display tasks");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter task description: ");
                String description = scanner.nextLine();
                Task task = new Task(description);
                taskTracker.addTask(task);
                System.out.println("Task added successfully!");
            } else if (choice == 2) {
                System.out.print("Enter task index: ");
                int index = scanner.nextInt();
                taskTracker.markTaskAsCompleted(index - 1);
            } else if (choice == 3) {
                taskTracker.displayTasks();
            } else if (choice == 4) {
                System.out.println("Exiting TaskTracker...");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }
}
