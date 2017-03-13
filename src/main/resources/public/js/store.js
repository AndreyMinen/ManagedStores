var app=angular.module("application",[]);

app.controller("bodyCtrl",function ($scope,$http) {

    $scope.listStores=[];
    $scope.listCities=[];
    $scope.form=false;

    $http.get('http://localhost:8080/store/list').success(function (data) {
        $scope.listStores=data;
    });
    $http.get('http://localhost:8080/city/list').success(function (data) {
        $scope.listCities=data;
    });

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
        $http.post(query).success(function (data) {
            $scope.listStores=data;
        });
        location.reload();
    };

    $scope.add=function (store) {
        var query='http://localhost:8080/store/add?name='+store.name+'&city_id='+store.city.id;
        $http.post(query);
        location.reload();
    };

    $scope.delete=function (store) {
        var query='http://localhost:8080/store/delete?id='+store.id;
        $http.post(query);
        location.reload();
    };

    $scope.search=function (seller) {

        var query='';
        if(seller.name!=''){
            query='http://localhost:8080/store/filter?name='+seller.name;
        }
        if(seller.city!=null){
            query='http://localhost:8080/store/filter?city_id='+seller.city;
        }
        if((seller.city!=null) && (seller.name!='')){
            query='http://localhost:8080/store/filter?name='+seller.name+"&city_id="+seller.city;
        }

        for(var i=0;listStores<listStores.length;i++){
            if(listStores[i].indexOf(seller.name)!=-1){
                alert(listStores[i]);
            }
        }

    };

});

