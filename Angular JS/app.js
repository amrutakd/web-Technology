var app = angular.module('todoApp', []);

app.controller('TodoController', function($scope) {
    $scope.tasks = [];

    // Function to add a new task
    $scope.addTask = function() {
        if ($scope.newTask) {
            $scope.tasks.push({ text: $scope.newTask, editing: false });
            $scope.newTask = ''; // Clear the input field
        }
    };

    // Function to delete a task
    $scope.deleteTask = function(index) {
        $scope.tasks.splice(index, 1);
    };

    // Function to edit a task
    $scope.editTask = function(task) {
        task.editing = !task.editing; // Toggle editing mode
    };
});
