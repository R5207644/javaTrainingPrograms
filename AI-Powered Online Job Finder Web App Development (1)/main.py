import sys
import os
sys.path.insert(0, os.path.dirname(os.path.dirname(__file__)))  # DON'T CHANGE THIS !!!

from flask import Flask, render_template, send_from_directory
from flask_sqlalchemy import SQLAlchemy
from src.models.user import db
from src.routes.resume import resume_bp
from src.routes.github import github_bp
from src.routes.jobs import jobs_bp

app = Flask(__name__)

# Configure the app
app.config['SECRET_KEY'] = 'your-secret-key'
app.config['UPLOAD_FOLDER'] = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'static', 'uploads')

# Uncomment the following line to enable database functionality
app.config['SQLALCHEMY_DATABASE_URI'] = f"mysql+pymysql://{os.getenv('DB_USERNAME', 'root')}:{os.getenv('DB_PASSWORD', 'password')}@{os.getenv('DB_HOST', 'localhost')}:{os.getenv('DB_PORT', '3306')}/{os.getenv('DB_NAME', 'mydb')}"
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

# Initialize database
db.init_app(app)

# Register blueprints
app.register_blueprint(resume_bp)
app.register_blueprint(github_bp)
app.register_blueprint(jobs_bp)

# Create database tables
@app.before_first_request
def create_tables():
    db.create_all()

# Serve static files
@app.route('/<path:path>')
def serve_static(path):
    return send_from_directory('static', path)

# Serve index.html for all routes
@app.route('/', defaults={'path': ''})
@app.route('/<path:path>')
def serve_index(path):
    return send_from_directory('static', 'index.html')

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)
