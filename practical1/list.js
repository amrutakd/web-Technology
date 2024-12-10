document.addEventListener("DOMContentLoaded", () => {
    const taskInput = document.getElementById("task-input");
    const addButton = document.getElementById("add-btn");
    const taskList = document.getElementById("task-list");

    // Function to add a task
    const addTask = () => {
        const taskText = taskInput.value.trim();
        if (taskText === "") {
            alert("Please enter a task!");
            return;
        }

        const li = document.createElement("li");
        li.textContent = taskText;

        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Delete";
        deleteButton.addEventListener("click", () => li.remove());

        li.appendChild(deleteButton);
        taskList.appendChild(li);

        taskInput.value = ""; // Clear input field
    };

    // Event listeners
    addButton.addEventListener("click", addTask);
    taskInput.addEventListener("keypress", (event) => {
        if (event.key === "Enter") {
            addTask();
        }
    });
});
