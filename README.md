# To-Do-List-Planner
The To-Do list planner application provides a user-friendly experience with detailed task management capabilities. This application in Java involves several components: a console-based user interface, a model to represent tasks, and the logic to manage tasks using core Java only. We'll use standard input and output for interaction.

# How it looks: 
````
   To-Do List Application
----====================----
1. Add a new task
2. List all tasks
3. Mark a task as completed
4. Update a task
5. Remove a task
6. Exit
Enter your choice: 1
Enter the task description: Buy groceries
Enter the date (dd-MM-yyyy): 31-05-2024
Enter the time (HH:mm): 18:00
Task added.

Your Tasks:
1. [ ] Buy groceries (Due: 31-05-2024 18:00)
````
# How it works:
To-Do list application provides a robust console interface for managing tasks with specific due dates and times. It offers the following functionalities:

- Adding new tasks with descriptions, dates, and times.
- Listing all tasks with their completion status, descriptions, due dates, and due times.
- Marking tasks as completed.
- Updating task descriptions, dates, and times.
- Removing tasks from the list.
- Exiting the application gracefully.

# Explanation: 
### Task class:

Fields:

- description: Stores the text description of the task.
- isCompleted: Boolean indicating whether the task is completed.
- date: The due date of the task.
- time: The due time of the task.
  
Constructor:

- Initializes the description, date, and time, and sets isCompleted to false.
  
Methods:

- Standard getter and setter methods for all fields.
- markAsCompleted(): Sets isCompleted to true.
- toString(): Returns a string representation of the task, showing its status, description, due date, and due time.
  
### ToDoList class:

Fields:

- tasks: A list of Task objects representing the to-do list.
  
Constructor:

- Initializes the tasks list.
  
Methods:

- addTask(String description, LocalDate date, LocalTime time): Adds a new task with the given description, date, and time to the list.
- completeTask(int index): Marks the task at the specified index as completed if the index is valid.
- updateTask(int index, String newDescription, LocalDate newDate, LocalTime newTime): Updates the description, date, and time of the task at the specified index if the index is valid.
- removeTask(int index): Removes the task at the specified index if the index is valid.
- listTasks(): Prints all tasks in the list, showing their status, description, due date, and due time.
  
### ToDoListApp class:

Fields:

- toDoList: A static instance of ToDoList to manage the tasks.
- dateFormatter: A DateTimeFormatter for parsing and formatting dates.
- timeFormatter: A DateTimeFormatter for parsing and formatting times.
  
Main Method:

- Sets up a Scanner for user input.
- Runs a loop (while (running)) to display the menu and process user input until the user chooses to exit.
- Uses a switch statement to handle the user’s choice.
  
Methods:

- printMenu(): Displays the menu options.
- addTask(Scanner scanner): Prompts the user for a task description, date, and time, adds the task to the list, and shows the updated list.
- listTasks(): Displays the current list of tasks.
- completeTask(Scanner scanner): Prompts the user for a task number, marks the corresponding task as completed, and shows the updated list.
- updateTask(Scanner scanner): Prompts the user for a task number, new description, new date, and new time, updates the corresponding task, and shows the updated list.
- removeTask(Scanner scanner): Prompts the user for a task number, removes the corresponding task, and shows the updated list.
- getDateFromUser(Scanner scanner): Prompts the user for a date and returns a LocalDate object. Repeats until a valid date is entered.
- getTimeFromUser(Scanner scanner): Prompts the user for a time and returns a LocalTime object. Repeats until a valid time is entered.

# Step-By-Step Execution: 
Option 1: Add a New Task
- Prompting for Task Details:

  - The addTask(Scanner scanner) method is called.
  - The user is prompted to enter the task description.
  - The getDateFromUser(Scanner scanner) method is called to get the due date from the user.
  - The getTimeFromUser(Scanner scanner) method is called to get the due time from the user. 
- Adding the Task:
  
  - The task is added to the toDoList by calling toDoList.addTask(description, date, time).
  - The updated list of tasks is displayed by calling listTasks().

Option 2: List All Tasks
- Displaying Tasks:

  - The listTasks() method is called, which prints all tasks in the list with their descriptions, due dates, and completion statuses.

Option 3: Mark a Task as Completed
- Completing a Task:
  
  - The completeTask(Scanner scanner) method is called.
  - The user is prompted to enter the task number to mark as completed.
  - The task's status is updated by calling toDoList.completeTask(taskNumber - 1).
  - The updated list of tasks is displayed by calling listTasks().

Option 4: Update a Task
- Updating a Task:

  - The updateTask(Scanner scanner) method is called.
  - The user is prompted to enter the task number to update, the new task description, the new due date, and the new due time.
  - The task's details are updated by calling toDoList.updateTask(taskNumber - 1, newDescription, newDate, newTime).
  - The updated list of tasks is displayed by calling listTasks().

Option 5: Remove a Task
- Removing a Task:
  
  - The removeTask(Scanner scanner) method is called.
  - The user is prompted to enter the task number to remove.
  - The task is removed from the list by calling toDoList.removeTask(taskNumber - 1).
  - The updated list of tasks is displayed by calling listTasks().
    
Option 6: Exit
- Exiting the Application:
  
  - The running variable is set to false, breaking the while loop and exiting the application.
  - A farewell message is displayed.

