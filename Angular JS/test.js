var app=angular.module('todoApp',[]);

app.controller('todocontroller',function($scope){
    $scope.tasks = [];

    //function to add a new task
    $scope.addTask=function(){
        if($scope.newTask){
            $scope.tasks.push({text: $scope.newTask, editing:false});
            $scope.newTask = '';
        }
    };

    //function to delete task
    $scope.deleteTask=function(index)
    {
        $scope.tasks.splice(index,1);
    }

    //function to edit task
    $scope.editTask=function(task){
        task.editing = !task.editing;
    }
});