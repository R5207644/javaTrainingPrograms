/* Controllers for JobFinderApp */

app.controller('HomeController', ['$scope', function($scope) {
    $scope.welcomeMessage = 'Welcome to AI Job Finder';
    $scope.features = [
        {
            title: 'Resume Analysis',
            description: 'Upload your resume for AI-powered analysis and improvement suggestions',
            icon: 'fa-file-alt'
        },
        {
            title: 'Skills Assessment',
            description: 'Get a detailed breakdown of your skills and suggestions for improvement',
            icon: 'fa-chart-bar'
        },
        {
            title: 'GitHub Review',
            description: 'Submit your GitHub repositories for code quality analysis',
            icon: 'fa-code'
        },
        {
            title: 'Job Matching',
            description: 'Find job listings where you would be a top applicant',
            icon: 'fa-briefcase'
        }
    ];
}]);

app.controller('ResumeController', ['$scope', '$http', function($scope, $http) {
    $scope.resumeData = {
        file: null,
        content: null,
        analysis: null,
        suggestions: []
    };
    
    $scope.uploadResume = function() {
        var formData = new FormData();
        formData.append('resume', $scope.resumeData.file);
        
        $http.post('/api/resume/upload', formData, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(function(response) {
            $scope.resumeData.content = response.data.content;
            $scope.resumeData.analysis = response.data.analysis;
            $scope.resumeData.suggestions = response.data.suggestions;
        }, function(error) {
            console.error('Error uploading resume:', error);
        });
    };
    
    $scope.buildResume = function(template) {
        $http.post('/api/resume/build', {
            template: template,
            content: $scope.resumeData.content
        }).then(function(response) {
            $scope.resumeData.content = response.data.content;
        }, function(error) {
            console.error('Error building resume:', error);
        });
    };
}]);

app.controller('SkillsController', ['$scope', '$http', function($scope, $http) {
    $scope.skills = {
        technical: [],
        soft: [],
        suggestions: []
    };
    
    $scope.getSkills = function() {
        $http.get('/api/skills/analyze').then(function(response) {
            $scope.skills.technical = response.data.technical;
            $scope.skills.soft = response.data.soft;
            $scope.skills.suggestions = response.data.suggestions;
        }, function(error) {
            console.error('Error getting skills:', error);
        });
    };
}]);

app.controller('GitHubController', ['$scope', '$http', function($scope, $http) {
    $scope.github = {
        repositories: [],
        analysis: null
    };
    
    $scope.submitRepository = function(repoUrl) {
        $http.post('/api/github/analyze', {
            repository_url: repoUrl
        }).then(function(response) {
            $scope.github.repositories.push(response.data);
        }, function(error) {
            console.error('Error analyzing repository:', error);
        });
    };
}]);

app.controller('JobsController', ['$scope', '$http', function($scope, $http) {
    $scope.jobs = {
        matches: [],
        platforms: ['LinkedIn', 'Naukri', 'Indeed', 'Glassdoor']
    };
    
    $scope.getJobMatches = function() {
        $http.get('/api/jobs/matches').then(function(response) {
            $scope.jobs.matches = response.data;
        }, function(error) {
            console.error('Error getting job matches:', error);
        });
    };
}]);

app.controller('ProfileController', ['$scope', '$http', function($scope, $http) {
    $scope.profile = {
        name: '',
        email: '',
        phone: '',
        location: '',
        skills: [],
        experience: []
    };
    
    $scope.getProfile = function() {
        $http.get('/api/profile').then(function(response) {
            $scope.profile = response.data;
        }, function(error) {
            console.error('Error getting profile:', error);
        });
    };
    
    $scope.updateProfile = function() {
        $http.put('/api/profile', $scope.profile).then(function(response) {
            $scope.profile = response.data;
        }, function(error) {
            console.error('Error updating profile:', error);
        });
    };
}]);
