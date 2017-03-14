var app=angular.module("application",[]);

app.controller("bodyCtrl",function ($scope,$http) {


    $scope.listCities=[];
    $scope.selected=[];
    $scope.form=false;


    $http.get('http://localhost:8080/city/list').success(function (data) {
        $scope.listCities=data;
    });

    $scope.exist=function (city) {
        return $scope.selected.indexOf(city) > -1;
    };

    $scope.toggleSelection=function (city) {
        var idx=$scope.selected.indexOf(city);

        if(idx > -1){
            $scope.selected.splice(idx,1);
        }
        else{
            $scope.selected.push(city);
        }
    };

    $scope.edit=function (city) {
        $scope.edit=true;
        $scope.city=city;
        $scope.titleForm='Редактировать';
        $scope.form=true;
    };

    $scope.create=function () {
        $scope.edit=false;
        $scope.titleForm='Создать';
        $scope.form=true;
    };

    $scope.update=function (city) {
        var query='http://localhost:8080/city/update?id='+city.id+'&name='+city.name;
        $http.post(query);
        location.reload();
    };

    $scope.add=function (city) {
        var query='http://localhost:8080/city/add?name='+city.name;
        $http.post(query);
        location.reload();
    };

    $scope.delete=function () {
        var query=[];
        for(var i=0;i<$scope.selected.length;i++){
            query.push('http://localhost:8080/city/delete?id='+$scope.selected[i].id);
        }
        for(var i=0;i<query.length;i++){
            $http.post(query[i]);
        }

        location.reload();

    };

});
