var app=angular.module("application",[]);

app.controller("bodyCtrl",function ($scope,$http) {


    $scope.listSellers=[];
    $scope.listStores=[];
    $scope.selected=[];
    $scope.form=false;


    $http.get('http://localhost:8080/seller/list').success(function (data) {
        $scope.listSellers=data;
    });

    $http.get('http://localhost:8080/store/list').success(function (data) {
        $scope.listStores=data;
    });

    $scope.exist=function (seller) {
        return $scope.selected.indexOf(seller) > -1;
    };

    $scope.toggleSelection=function (seller) {
        var idx=$scope.selected.indexOf(seller);

        if(idx > -1){
            $scope.selected.splice(idx,1);
        }
        else{
            $scope.selected.push(seller);
        }
    };

    $scope.edit=function (seller) {
        $scope.edit=true;
        $scope.seller=seller;
        $scope.titleForm='Редактировать';
        $scope.form=true;
    };

    $scope.create=function () {
        $scope.edit=false;
        $scope.titleForm='Создать';
        $scope.form=true;
    };

    $scope.update=function (seller) {
        var query='http://localhost:8080/seller/update?id='+seller.id+'&name='+seller.name+'&store_id='+seller.store_id.id;
        $http.post(query);
        location.reload();
    };

    $scope.add=function (seller) {
        var query='http://localhost:8080/seller/add?name='+seller.name+'&store_id='+seller.store_id.id;
        $http.post(query);
        location.reload();
    };

    $scope.delete=function () {
        var query=[];
        for(var i=0;i<$scope.selected.length;i++){
            query.push('http://localhost:8080/seller/delete?id='+$scope.selected[i].id);
        }
        for(var i=0;i<query.length;i++){
            $http.post(query[i]);
        }

        location.reload();

    };

});
