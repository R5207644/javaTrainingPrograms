import os
import json
import requests
from flask import Blueprint, request, jsonify, current_app

github_bp = Blueprint('github', __name__, url_prefix='/api/github')

# GitHub API integration
def analyze_repository(repo_url):
    """
    Analyze a GitHub repository using GitHub API and AI
    """
    # Extract username and repo name from URL
    # Example URL: https://github.com/username/repository
    parts = repo_url.strip('/').split('/')
    if len(parts) < 5 or parts[2] != 'github.com':
        return {'error': 'Invalid GitHub URL format'}
    
    username = parts[3]
    repo_name = parts[4]
    
    # This is a placeholder for the actual GitHub API integration
    # In a production environment, you would use GitHub API
    
    # Mock response for development purposes
    mock_response = {
        'repository': {
            'name': repo_name,
            'owner': username,
            'url': repo_url,
            'description': 'A sample repository for demonstration',
            'stars': 25,
            'forks': 10,
            'languages': ['JavaScript', 'HTML', 'CSS', 'Python'],
            'last_updated': '2025-04-15T10:30:00Z'
        },
        'code_analysis': {
            'code_quality_score': 85,
            'maintainability_index': 78,
            'complexity_score': 65,
            'documentation_score': 70
        },
        'strengths': [
            'Well-structured codebase',
            'Good use of modern JavaScript features',
            'Responsive design implementation',
            'Proper error handling'
        ],
        'improvement_areas': [
            'Increase test coverage',
            'Add more inline documentation',
            'Optimize database queries',
            'Implement more robust input validation'
        ],
        'technologies_used': [
            'React', 'Node.js', 'Express', 'MongoDB', 'Bootstrap'
        ]
    }
    
    return mock_response

@github_bp.route('/analyze', methods=['POST'])
def analyze_github_repo():
    data = request.json
    repo_url = data.get('repository_url')
    
    if not repo_url:
        return jsonify({'error': 'Repository URL is required'}), 400
    
    try:
        analysis_result = analyze_repository(repo_url)
        
        if 'error' in analysis_result:
            return jsonify({'error': analysis_result['error']}), 400
        
        # For demo purposes, we're not saving to database yet
        # In production, you would save this to the database
        
        return jsonify(analysis_result), 200
        
    except Exception as e:
        return jsonify({'error': f'Error analyzing repository: {str(e)}'}), 500

@github_bp.route('/repositories', methods=['GET'])
def get_repositories():
    # This would typically fetch repositories from the database
    # For demo purposes, we're returning mock data
    
    return jsonify([
        {
            'id': 1,
            'name': 'e-commerce-platform',
            'url': 'https://github.com/username/e-commerce-platform',
            'description': 'A full-stack e-commerce platform with React and Node.js',
            'code_quality_score': 85,
            'languages': ['JavaScript', 'HTML', 'CSS', 'Python']
        },
        {
            'id': 2,
            'name': 'data-visualization-tool',
            'url': 'https://github.com/username/data-visualization-tool',
            'description': 'Interactive data visualization dashboard using D3.js',
            'code_quality_score': 78,
            'languages': ['JavaScript', 'HTML', 'CSS', 'SVG']
        }
    ]), 200

@github_bp.route('/analysis/<int:repo_id>', methods=['GET'])
def get_repository_analysis(repo_id):
    # This would typically fetch analysis from the database
    # For demo purposes, we're returning mock data
    
    return jsonify({
        'code_quality_score': 85,
        'maintainability_index': 78,
        'complexity_score': 65,
        'documentation_score': 70,
        'strengths': [
            'Well-structured codebase',
            'Good use of modern JavaScript features',
            'Responsive design implementation',
            'Proper error handling'
        ],
        'improvement_areas': [
            'Increase test coverage',
            'Add more inline documentation',
            'Optimize database queries',
            'Implement more robust input validation'
        ],
        'technologies_used': [
            'React', 'Node.js', 'Express', 'MongoDB', 'Bootstrap'
        ]
    }), 200
