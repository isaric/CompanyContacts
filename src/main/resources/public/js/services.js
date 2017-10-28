angular.module('app.services', []).factory('Employee', function ($resource) {
    return $resource('/employees/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
}).service('popupService', function ($window) {
    this.showPopup = function (message) {
        return $window.confirm(message);
    }
});
angular.module('app.services', []).factory('Employee', function ($resource) {
    return $resource('/employees/add', {},{
        create: {
            method: 'POST'
        }
    });
}).service('popupService', function ($window) {
    this.showPopup = function (message) {
        return $window.confirm(message);
    }
});
angular.module('app.services', []).factory('Login', function ($resource) {
    return $resource('/login', {},{
        doLogin: {
            method: 'POST'
        }
    });
}).service('popupService', function ($window) {
    this.showPopup = function (message) {
        return $window.confirm(message);
    }
});
