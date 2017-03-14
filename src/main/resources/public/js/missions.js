var app=angular.module("application",[]);

app.controller("bodyCtrl",function ($scope,$http) {

    $scope.listMissions=[];
    $scope.listStores=[];
    $scope.selected=[];
    $scope.form=false;


    $http.get('http://localhost:8080/mission/list').success(function (data) {
        $scope.listMissions=data;
    });

    $http.get('http://localhost:8080/store/list').success(function (data) {
        $scope.listStores=data;
    });

    $scope.exist=function (mission) {
        return $scope.selected.indexOf(mission) > -1;
    };

    $scope.toggleSelection=function (mission) {
        var idx=$scope.selected.indexOf(mission);

        if(idx > -1){
            $scope.selected.splice(idx,1);
        }
        else{
            $scope.selected.push(mission);
        }
    };

    $scope.edit=function (mission) {
        $scope.edit=true;
        $scope.mission=mission;
        $scope.titleForm='Редактировать';
        $scope.form=true;
    };

    $scope.create=function () {
        $scope.edit=false;
        $scope.titleForm='Создать';
        $scope.form=true;
    };

    $scope.update=function (mission) {
        var query='http://localhost:8080/mission/update?id='+mission.id+'&descr='+mission.descr+'&store_id='+mission.store_id.id;
        $http.post(query);
        location.reload();
    };

    $scope.add=function (mission) {
        var query='http://localhost:8080/mission/add?descr='+mission.descr+'&store='+mission.store_id.id;
        $http.post(query);
        location.reload();
    };

    $scope.delete=function () {
        var query=[];
        for(var i=0;i<$scope.selected.length;i++){
            query.push('http://localhost:8080/mission/delete?id='+$scope.selected[i].id);
        }
        for(var i=0;i<query.length;i++){
            $http.post(query[i]);
        }

        location.reload();

    };

});
