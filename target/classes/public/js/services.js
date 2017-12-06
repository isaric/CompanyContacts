angular.module('app.services.employee', [])
    .service('employeeService', ['$http', function ($http) {

        var urlBase = '/employees';

        this.getEmployees = function () {
            return $http.get(urlBase);
        };

        this.getEmployee = function (id) {
            return $http.get(urlBase + '/' + id);
        };

        this.insertEmployee = function (employee) {
            return $http.post(urlBase + '/add', employee);
        };

        this.updateEmployee = function (cust) {
            return $http.put(urlBase + '/' + cust.ID, cust)
        };

        this.deleteEmployee = function (id) {
            return $http.delete(urlBase + '/' + id);
        };

        this.getOrders = function (id) {
            return $http.get(urlBase + '/' + id + '/orders');
        };
    }]);

angular.module('app.services.login',[]).service('loginService', ['$http', function ($http) {

    var urlBase = '/login';

    this.doLogin = function (loginForm) {
        return $http.post(urlBase, loginForm);
    };
    this.isAuthenticated = function () {
        return ($state.user != null);
    };
    this.isEmployee = function () {
        return ($state.user.role == 'EMPLOYEE');
    };
    this.isAdmin = function (state) {
        return (state.user.role == 'ADMIN');
    };
}]);