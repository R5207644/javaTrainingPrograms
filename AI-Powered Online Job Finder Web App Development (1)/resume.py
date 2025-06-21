import os
import json
import PyPDF2
from flask import Blueprint, request, jsonify, current_app
from werkzeug.utils import secure_filename
import requests
from src.models.user import db, Resume, ResumeSuggestion, Skill, UserSkill

resume_bp = Blueprint('resume', __name__, url_prefix='/api/resume')

# Configure upload folder
UPLOAD_FOLDER = os.path.join(os.path.dirname(os.path.abspath(__file__)), '..', 'static', 'uploads', 'resumes')
os.makedirs(UPLOAD_FOLDER, exist_ok=True)
ALLOWED_EXTENSIONS = {'pdf'}

def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

# Free GPT API integration
def analyze_resume_with_gpt(text):
    """
    Send resume text to a free GPT API for analysis
    """
    # This is a placeholder for the actual API integration
    # In a production environment, you would use a specific GPT API
    
    api_url = "https://api.openai.com/v1/chat/completions"  # Example API endpoint
    
    # Example prompt for resume analysis
    prompt = f"""
    Analyze the following resume and provide:
    1. A list of technical skills
    2. A list of soft skills
    3. A summary of experience
    4. A summary of education
    5. An overall score (0-100)
    6. Specific improvement suggestions
    
    Resume text:
    {text}
    """
    
    # This is a mock response for development purposes
    # In production, you would make an actual API call
    mock_response = {
        "skills": ["Python", "JavaScript", "Flask", "AngularJS", "SQL", "Data Analysis"],
        "soft_skills": ["Communication", "Teamwork", "Problem Solving"],
        "experience_summary": "5+ years of software development experience with focus on web applications",
        "education_summary": "Bachelor's degree in Computer Science",
        "score": 75,
        "suggestions": [
            {
                "title": "Quantify Your Achievements",
                "description": "Add specific metrics and results to your work experiences",
                "example": "Increased website performance by 40% through code optimization",
                "section": "experience"
            },
            {
                "title": "Add More Technical Skills",
                "description": "Consider adding more relevant technical skills to match job requirements",
                "example": "Add skills like Docker, Kubernetes, or cloud platforms if you have experience",
                "section": "skills"
            },
            {
                "title": "Improve Resume Structure",
                "description": "Reorganize sections to highlight your strongest qualifications first",
                "example": "Move technical skills section above education for technical roles",
                "section": "structure"
            }
        ]
    }
    
    return mock_response

@resume_bp.route('/upload', methods=['POST'])
def upload_resume():
    # Check if the post request has the file part
    if 'resume' not in request.files:
        return jsonify({'error': 'No file part'}), 400
    
    file = request.files['resume']
    
    # If user does not select file, browser also
    # submit an empty part without filename
    if file.filename == '':
        return jsonify({'error': 'No selected file'}), 400
    
    if file and allowed_file(file.filename):
        filename = secure_filename(file.filename)
        file_path = os.path.join(UPLOAD_FOLDER, filename)
        file.save(file_path)
        
        # Extract text from PDF
        try:
            pdf_text = extract_text_from_pdf(file_path)
            
            # Analyze resume with GPT
            analysis_result = analyze_resume_with_gpt(pdf_text)
            
            # For demo purposes, we're not saving to database yet
            # In production, you would save this to the database
            
            return jsonify({
                'message': 'Resume uploaded successfully',
                'filename': filename,
                'content': pdf_text[:500] + '...' if len(pdf_text) > 500 else pdf_text,
                'analysis': {
                    'skills': analysis_result['skills'],
                    'soft_skills': analysis_result['soft_skills'],
                    'experience_summary': analysis_result['experience_summary'],
                    'education_summary': analysis_result['education_summary'],
                    'score': analysis_result['score']
                },
                'suggestions': analysis_result['suggestions']
            }), 200
            
        except Exception as e:
            return jsonify({'error': f'Error processing PDF: {str(e)}'}), 500
    
    return jsonify({'error': 'File type not allowed'}), 400

def extract_text_from_pdf(pdf_path):
    """
    Extract text content from a PDF file
    """
    text = ""
    with open(pdf_path, 'rb') as file:
        pdf_reader = PyPDF2.PdfReader(file)
        for page_num in range(len(pdf_reader.pages)):
            page = pdf_reader.pages[page_num]
            text += page.extract_text()
    return text

@resume_bp.route('/analyze/<int:resume_id>', methods=['GET'])
def analyze_resume(resume_id):
    # This would typically fetch a resume from the database
    # For demo purposes, we're returning mock data
    
    return jsonify({
        'skills': ["Python", "JavaScript", "Flask", "AngularJS", "SQL", "Data Analysis"],
        'soft_skills': ["Communication", "Teamwork", "Problem Solving"],
        'experience_summary': "5+ years of software development experience with focus on web applications",
        'education_summary': "Bachelor's degree in Computer Science",
        'score': 75
    }), 200

@resume_bp.route('/suggestions/<int:resume_id>', methods=['GET'])
def get_suggestions(resume_id):
    # This would typically fetch suggestions from the database
    # For demo purposes, we're returning mock data
    
    return jsonify([
        {
            'title': "Quantify Your Achievements",
            'description': "Add specific metrics and results to your work experiences",
            'example': "Increased website performance by 40% through code optimization",
            'section': "experience"
        },
        {
            'title': "Add More Technical Skills",
            'description': "Consider adding more relevant technical skills to match job requirements",
            'example': "Add skills like Docker, Kubernetes, or cloud platforms if you have experience",
            'section': "skills"
        },
        {
            'title': "Improve Resume Structure",
            'description': "Reorganize sections to highlight your strongest qualifications first",
            'example': "Move technical skills section above education for technical roles",
            'section': "structure"
        }
    ]), 200

@resume_bp.route('/build', methods=['POST'])
def build_resume():
    data = request.json
    template = data.get('template', 'professional')
    content = data.get('content', '')
    
    # This would typically use GPT to generate an improved resume
    # For demo purposes, we're returning mock data
    
    return jsonify({
        'message': 'Resume built successfully',
        'template': template,
        'content': "This is an AI-generated resume based on your content and the selected template."
    }), 200
