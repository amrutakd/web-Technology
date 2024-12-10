var app=angular.module("simpleApp",[]);

app.controller("simplectrl",function($scope)
{
    $scope.collection=[{name:"Siya",city:"Shirdi"},{name:"Riya",city:"Pune"}]
    $scope.addEntry=function(){
        $scope.collection.push($scope.newData);
        $scope.newData={};
    };
});