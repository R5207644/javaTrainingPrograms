/* Services for JobFinderApp */

app.service('AuthService', ['$http', function($http) {
    this.login = function(credentials) {
        return $http.post('/api/auth/login', credentials);
    };
    
    this.register = function(userData) {
        return $http.post('/api/auth/register', userData);
    };
    
    this.logout = function() {
        return $http.post('/api/auth/logout');
    };
    
    this.isAuthenticated = function() {
        return $http.get('/api/auth/status');
    };
}]);

app.service('ResumeService', ['$http', function($http) {
    this.uploadResume = function(file) {
        var formData = new FormData();
        formData.append('resume', file);
        
        return $http.post('/api/resume/upload', formData, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        });
    };
    
    this.analyzeResume = function(resumeId) {
        return $http.get('/api/resume/analyze/' + resumeId);
    };
    
    this.getSuggestions = function(resumeId) {
        return $http.get('/api/resume/suggestions/' + resumeId);
    };
    
    this.generateResume = function(template, content) {
        return $http.post('/api/resume/generate', {
            template: template,
            content: content
        });
    };
}]);

app.service('SkillService', ['$http', function($http) {
    this.analyzeSkills = function() {
        return $http.get('/api/skills/analyze');
    };
    
    this.getSuggestions = function() {
        return $http.get('/api/skills/suggestions');
    };
    
    this.addSkill = function(skill) {
        return $http.post('/api/skills', skill);
    };
    
    this.removeSkill = function(skillId) {
        return $http.delete('/api/skills/' + skillId);
    };
}]);

app.service('GitHubService', ['$http', function($http) {
    this.analyzeRepository = function(repoUrl) {
        return $http.post('/api/github/analyze', {
            repository_url: repoUrl
        });
    };
    
    this.getRepositories = function() {
        return $http.get('/api/github/repositories');
    };
    
    this.getRepositoryAnalysis = function(repoId) {
        return $http.get('/api/github/analysis/' + repoId);
    };
}]);

app.service('JobService', ['$http', function($http) {
    this.getJobMatches = function() {
        return $http.get('/api/jobs/matches');
    };
    
    this.searchJobs = function(query) {
        return $http.get('/api/jobs/search', {
            params: query
        });
    };
    
    this.getJobDetails = function(jobId) {
        return $http.get('/api/jobs/' + jobId);
    };
    
    this.saveJob = function(jobId) {
        return $http.post('/api/jobs/save/' + jobId);
    };
}]);

app.service('ProfileService', ['$http', function($http) {
    this.getProfile = function() {
        return $http.get('/api/profile');
    };
    
    this.updateProfile = function(profileData) {
        return $http.put('/api/profile', profileData);
    };
    
    this.getExperience = function() {
        return $http.get('/api/profile/experience');
    };
    
    this.addExperience = function(experience) {
        return $http.post('/api/profile/experience', experience);
    };
    
    this.updateExperience = function(experienceId, experience) {
        return $http.put('/api/profile/experience/' + experienceId, experience);
    };
    
    this.deleteExperience = function(experienceId) {
        return $http.delete('/api/profile/experience/' + experienceId);
    };
}]);
