angular.module("app.controllers", ['app.services.employee']).controller('employeeController', ['$state', '$scope', 'employeeService', '$routeParams',
    function ($state, $scope, employeeService, $routeParams) {


        $scope.employees = employeeService.getEmployees();

        $scope.employee = employeeService.getElementById($routeParams.id);

        $scope.insertEmployee = function () {
            employeeService.insertEmployee($scope.employee);
        };

        $scope.updateEmployee = function (id) {
            var cust;
            for (var i = 0; i < $scope.employees.length; i++) {
                var currCust = $scope.employees[i];
                if (currCust.ID === id) {
                    cust = currCust;
                    break;
                }
            }

            employeeService.updateEmployee(cust)
                .then(function (response) {
                    $scope.status = 'Updated Employee! Refreshing employee list.';
                }, function (error) {
                    $scope.status = 'Unable to update employee: ' + error.message;
                });
        };

        $scope.deleteEmployee = function (id) {
            employeeService.deleteEmployee(id)
                .then(function (response) {
                    $scope.status = 'Deleted Employee! Refreshing employee list.';
                    for (var i = 0; i < $scope.employees.length; i++) {
                        var cust = $scope.employees[i];
                        if (cust.ID === id) {
                            $scope.employees.splice(i, 1);
                            break;
                        }
                    }
                    $scope.orders = null;
                }, function (error) {
                    $scope.status = 'Unable to delete employee: ' + error.message;
                });
        };

        $scope.getEmployeeOrders = function (id) {
            employeeService.getOrders(id)
                .then(function (response) {
                    $scope.status = 'Retrieved orders!';
                    $scope.orders = response.data;
                }, function (error) {
                    $scope.status = 'Error retrieving employees! ' + error.message;
                });
        };
    }]);