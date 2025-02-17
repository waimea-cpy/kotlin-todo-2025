fun main() {
    val tasks = mutableListOf<Task>()

    // Make up some fake tasks for testing

    tasks.add(Task("Feed the cat", 3))
    tasks.add(Task("Kick the dog", 5))
    tasks.add(Task("Lick the fish", 2))

    tasks[2].markAsDone()

    println("=====================")
    println("  AWESOME TASK LIST")
    println("=====================")
    println()

    while(true) {
        showTasks(tasks)
        when(getUserAction()) {
            'x' -> break
            'n' -> tasks.add(getNewTask())
            'd' -> getTask(tasks).markAsDone()
        }
    }
}

/**
 * Show a list of options to the user
 * a return their selected option
 */
fun getUserAction(): Char {
    while (true) {
        // Show the menu
        println("MENU:")
        println(" [N]ew task")
        println(" Mark task [d]one")
        println(" E[x]it")
        print("> ")

        // Get input
        val action = readln().lowercase()

        // Did they type something?
        if (action.isNotEmpty()) {
            // Yes, so pass back the first char
            return action.first()
        }
    }

}


/**
 * Get a specific task from the task list
 * returning the selected Task
 */
fun getTask(tasks: MutableList<Task>): Task {
    println("Select a task...")
    // Show the tasks, numbered 1...
    var num = 1
    for(task in tasks) {
        print("$num: ")
        print("${task.priority} ")
        println(task.name)
        num++
    }

    // Get the number of a task from user
    print("Pick a task: ")
    val taskNum = readln().toInt() - 1  // Sub 1 since index 0...

    // Return the selected Task object
    val selectedTask = tasks[taskNum]
    return selectedTask
}





/**
 * Get details of a new task from the
 * user, create a Task object, and
 * return it
 */
fun getNewTask(): Task {
    println("New task")

    print("Task name: ")
    val name = readln()

    print("Priority: ")
    val priority = readln().toInt()

    return Task(name, priority)
}


/**
 * Show a list of tasks
 */
fun showTasks(tasks: MutableList<Task>) {
    println("Tasks:")
    for(task in tasks) {
        print(" ")
        print(if(task.done) "[X]" else "[ ]")
        print(" ${task.priority} ")
        println(task.name)
    }
    println()
}


/**
 * Task class - holds info about a single task
 */
class Task(var name: String, var priority: Int) {
    var done: Boolean = false

    fun markAsDone() {
        done = true
    }

    fun markAsNotDone() {
        done = false
    }
}