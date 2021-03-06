var app=angular.module("application",[]);

app.controller("bodyCtrl",function ($scope,$http) {

    $scope.listStores=[];
    $scope.listCities=[];
    $scope.selected=[];
    $scope.form=false;

    $http.get('http://localhost:8080/store/list').success(function (data) {
        $scope.listStores=data;
    });
    $http.get('http://localhost:8080/city/list').success(function (data) {
        $scope.listCities=data;
    });

    $scope.exist=function (store) {
        return $scope.selected.indexOf(store) > -1;
    };

    $scope.toggleSelection=function (store) {
        var idx=$scope.selected.indexOf(store);

        if(idx > -1){
            $scope.selected.splice(idx,1);
        }
        else{
            $scope.selected.push(store);
        }
    };

    $scope.edit=function (store) {
        $scope.edit=true;
        $scope.store=store;
        $scope.titleForm='Редактировать';
        $scope.form=true;
    };

    $scope.create=function () {
        $scope.edit=false;
        $scope.store={};
        $scope.titleForm='Создать';
        $scope.form=true;
    };

    $scope.update=function (store) {
        var query='http://localhost:8080/store/update?id='+store.id+'&name='+store.name+'&city_id='+store.city.id;
        $http.post(query);
        location.reload();
    };

    $scope.add=function (store) {
        var query='http://localhost:8080/store/add?name='+store.name+'&city_id='+store.city.id;
        $http.post(query);
        location.reload();
    };

    $scope.delete=function () {
        var query=[];
        for(var i=0;i<$scope.selected.length;i++){
            query.push('http://localhost:8080/store/delete?id='+$scope.selected[i].id);
        }
        for(var i=0;i<query.length;i++){
            $http.post(query[i]);
        }

        location.reload();

    };



});

