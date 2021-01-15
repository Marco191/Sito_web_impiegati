angular.module('myApp2', []).controller('getController', function($scope, $http) {
  $scope.e = [];
  
  alert("Ottenimento del id per il get js");
  
  $http.get("/get/")
  .then(function(response) {
      $scope.employee = response.data;
  },
  function(errResponse){
          console.error('Error while fetching Users');
          deferred.reject(errResponse);
          $scope.error='error getting'
  });
  
});