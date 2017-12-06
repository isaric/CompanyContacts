angular.module("app.controllers.login", []).controller('loginController', ['$state', '$scope', 'loginService',
    function ($state, $scope, loginService) {
        $scope.loginForm = {};
        $scope.doLogin = function () {
            loginService.doLogin($scope.loginForm).then(function onSuccess(response) {
                $state.user = response.data;
                $state.go('home');
            }).catch(function onFailure() {
                $state.user = null;
                $state.go("login");
            });
        }
    }]);