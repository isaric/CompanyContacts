angular.module("app.controllers.register",[]).controller('registerController', ['$state', '$scope', 'employeeService',
    function ($state, $scope, employeeService) {
        $scope.employee = {};
        $scope.doRegister = function () {
            employeeService.insertEmployee($scope.loginForm).then(function onSuccess(response) {
                $state.user = response.data;
                $state.go('home')
            })
        };
    }]);