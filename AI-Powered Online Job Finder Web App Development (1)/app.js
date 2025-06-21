/* Main Application Module */
var app = angular.module('jobFinderApp', ['ngRoute']);

/* Route Configuration */
app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/home', {
            templateUrl: 'js/templates/home.html',
            controller: 'HomeController'
        })
        .when('/resume', {
            templateUrl: 'js/templates/resume.html',
            controller: 'ResumeController'
        })
        .when('/skills', {
            templateUrl: 'js/templates/skills.html',
            controller: 'SkillsController'
        })
        .when('/github', {
            templateUrl: 'js/templates/github.html',
            controller: 'GitHubController'
        })
        .when('/jobs', {
            templateUrl: 'js/templates/jobs.html',
            controller: 'JobsController'
        })
        .when('/profile', {
            templateUrl: 'js/templates/profile.html',
            controller: 'ProfileController'
        })
        .otherwise({
            redirectTo: '/home'
        });
}]);

/* Global Configuration */
app.config(['$httpProvider', function($httpProvider) {
    // Add CSRF token to all requests
    $httpProvider.defaults.xsrfCookieName = 'csrf_token';
    $httpProvider.defaults.xsrfHeaderName = 'X-CSRFToken';
}]);

/* Initialize Application */
app.run(['$rootScope', function($rootScope) {
    $rootScope.appName = 'AI Job Finder';
    $rootScope.appVersion = '1.0.0';
}]);
