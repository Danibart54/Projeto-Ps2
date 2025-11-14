# Portal de Estágios

## Overview
This is a Portuguese internship portal (Portal de Estágios) that connects students, companies, and administrators on an integrated web platform. The application was developed as a final project for Programming Language II course.

**Purpose**: Simplify the process of connecting companies offering internship positions with students seeking opportunities.

**Current State**: Fully functional full-stack application running in Replit environment with:
- Backend: Java Spring Boot with H2 in-memory database
- Frontend: React Single Page Application
- Both services integrated and running together

## Project Structure

### Backend (`backend/portal-estagios/`)
- **Technology**: Java 11 with Spring Boot 3.5.0
- **Database**: H2 in-memory database (PostgreSQL compatibility mode)
- **Port**: 8080 (localhost only)
- **Build Tool**: Maven
- **API Documentation**: Swagger UI available at `/swagger-ui.html`

Key packages:
- `controller/` - REST API endpoints
- `entity/` - JPA entity classes
- `repository/` - Data access layer
- `service/` - Business logic
- `dao/` - Data Access Objects
- `config/` - Application configuration

### Frontend (`frontend/`)
- **Technology**: React 19.2.0
- **Port**: 5000 (exposed to internet)
- **Build Tool**: npm
- **Dev Server**: Create React App with proxy to backend

Key directories:
- `src/pages/` - Application pages (Admin, Empresa, Estudante, Vagas)
- `src/components/` - Reusable components
- `src/contexts/` - React contexts (Auth)
- `src/api/` - API integration

## User Profiles

1. **Administrator**: Manages interest areas, users, and portal statistics
2. **Company (Empresa)**: Creates job positions, views applicants, closes positions
3. **Student (Estudante)**: Registers, searches for positions, applies to internships

## Running the Application

The application starts automatically via the workflow. Both backend and frontend run together through `start.sh`.

**Development URLs**:
- Frontend: Port 5000 (webview)
- Backend API: http://localhost:8080
- H2 Console: http://localhost:8080/h2-console

## Key Features

- User authentication with role-based access **with BCrypt password encryption**
- CRUD operations for interest areas (admin only)
- Company and student registration
- Job position creation and management (10 vagas abertas)
- Public job listing with filtering
- Application/enrollment system
- Personalized dashboards for each user type
- Admin statistics dashboard
- PDF curriculum generation for students

## Recent Changes

**2025-11-14 (Session 1)**: Initial Replit setup + Security improvements + Public Job Listing
- Installed Java (Graal VM) and Node.js 20
- Configured React dev server for port 5000 with host bypass
- Created startup script to run backend and frontend together
- Set up workflow for webview on port 5000
- Configured deployment settings for VM deployment
- **Backend runs on localhost:8080, Frontend proxies API requests**
- Uses simple Create React App proxy configuration in package.json
- **Added BCrypt password encryption** (Spring Security Crypto)
  - Senhas criptografadas com BCrypt
  - Credentials de teste: admin123, empresa123, aluno123, AlunoMack
- **Added 10 vagas abertas** (open job positions) in database
- **Implemented Public Job Listing** (`/vagas` route)
  - Created VagaCard component for displaying job cards
  - Created ListaVagasPublicas page with area and modality filters
  - Backend VagaController accepts `/api/vaga`, `/vaga`, and `/vagas` routes
  - Public jobs display without login; clicking redirects to student login page

**2025-11-14 (Session 2)**: Application System + Student Dashboard + Registration Pages
- **Inscricoes (Application System)**:
  - Created DTOs: InscricaoRequest, InscricaoResponse
  - Extended InscricaoRepository with findAllByEstudanteId, findAllByVagaId, existsByVagaIdAndEstudanteId
  - Updated InscricaoService with createInscricao, findByEstudanteId, findByVagaId, existsByVagaAndEstudante
  - Added InscricaoController endpoints: GET /estudante/{id}, GET /vaga/{id}, GET /check, POST
  - Fixed EstudanteDAO adding findById method
  - Updated frontend API to use /api/inscricao endpoints

- **Authentication-Aware VagaCard**:
  - VagaCard now uses useAuth to check authentication status
  - Shows "Candidatar-se" button for logged-in students
  - Shows "Faça login para se candidatar" for unauthenticated users
  - Integrated with handleCandidatar function in ListaVagasPublicas

- **Enhanced Student Dashboard** (`/painel-estudante`):
  - Added "Minhas Candidaturas" section displaying student's applications
  - Added "Gerar Currículo (TXT)" button generating downloadable text curriculum
  - Created Painel.css with candidatura cards and status badges
  - Fetches applications via apiGetInscricoesByEstudante

- **Registration Pages with Password**:
  - Created CadastroEstudante page (`/cadastro-estudante`)
    - Fields: nome, email, senha, confirmarSenha, cpf, curso, telefone, areasInteresse
    - Password confirmation validation
    - Auto-login after successful registration
    - Redirects to /painel-estudante after signup
  - Created CadastroEmpresa page (`/cadastro-empresa`)
    - Fields: nome, email, senha, confirmarSenha, cnpj, telefone, endereco, areasAtuacao
    - Password confirmation validation
    - Auto-login after successful registration
    - Redirects to /painel-empresa after signup
  - Added "Cadastre-se" links to both login pages (student and company)
  - Updated Form.css with checkbox-group and form-footer styles

- **Routing**:
  - Added /cadastro-empresa route in App.js
  - Both registration pages accessible from respective login pages

**2025-11-14 (Session 3)**: Complete Registration Flow Implementation ✅

**2025-11-14 (Session 4)**: Authentication & Job Creation Fixes + PDF Curriculum ✅
- **Backend Registration Endpoints**:
  - Created DTOs: RegisterEstudanteRequest, RegisterEmpresaRequest
  - Created RegisterController with endpoints:
    - POST /api/candidato - Creates Usuario + Estudante atomically
    - POST /api/empresa - Creates Usuario + Empresa atomically
  - Created RegisterService with atomic transaction methods
  - Passwords are BCrypt-hashed before storage
  - Duplicate email validation implemented
  - Returns created entity with ID after successful registration

- **Database Auto-Increment Fix**:
  - Added ALTER TABLE commands in data.sql to reset auto-increment counters
  - All tables (usuario, estudante, empresa, vaga, inscricao, area_interesse) start IDs at 100
  - Prevents primary key conflicts when inserting new records via API

- **Frontend Registration Updates**:
  - Fixed CadastroEstudante to send `interesses` as array of IDs (not objects)
  - Fixed CadastroEmpresa to send `areasAtuacao` as array of IDs (not objects)
  - Both forms now successfully create accounts and auto-login users
  - Proper navigation after registration (estudante → /painel-estudante, empresa → /painel-empresa)

- **Login Response Enhancement**:
  - Created LoginResponse DTO with usuarioId, estudanteId, empresaId fields
  - Added findByUsuario methods to EstudanteRepository and EmpresaRepository
  - Updated AuthController to return profile-specific IDs in login response
  - Frontend now correctly uses user.estudanteId and user.empresaId for API calls

- **Job Creation System**:
  - Created VagaCreateRequest DTO with areaId and empresaId validation
  - Updated VagaService with createVaga method and proper error handling
  - Modified VagaController to use DTO with detailed error messages
  - Rewrote CriarVaga.jsx to load areas from API and use dropdown selection
  - Frontend sends correct areaId and empresaId when creating jobs

- **Company Dashboard**:
  - Updated PainelEmpresa to display all jobs created by the company
  - Added job deletion functionality
  - Shows job status (Aberta/Encerrada) with color-coded badges
  - Displays full job details including area, location, modality, and requirements

- **PDF Curriculum Generation**:
  - Installed jsPDF library in frontend
  - Replaced TXT curriculum with PDF generation
  - PDF includes formatted sections: personal data, interest areas, active applications
  - Automatic page breaks for long content
  - Professional formatting with bold headers and bullet points

## Known Issues & TODO

**Registration Flow**: ✅ COMPLETED
- ✅ Registration endpoints implemented with atomic Usuario + Estudante/Empresa creation
- ✅ BCrypt password hashing working correctly
- ✅ Auto-login after successful registration functional
- ✅ Area validation with proper error messages

**Candidatura System**: ✅ IMPROVED
- ✅ Error messages now return specific details (já inscrito, estudante não encontrado, vaga não encontrada)
- ✅ Frontend shows user-friendly error messages based on backend responses

**Issues Identified - Pending Fix**:
- ⚠️ CriarVaga frontend sends "area" as string but backend expects areaId (Long) and empresaId
  - TODO: Create VagaCreateRequest DTO, add area selection dropdown, include empresaId from logged user
- ⚠️ CadastroEmpresa may fail if areas don't load before form submission
  - TODO: Add loading state validation, require at least one area selection
- ⚠️ InscricaoController lacks authentication/authorization checks - users can create applications for others
  - TODO: Add authentication middleware to verify logged-in user matches estudanteId

**Features to Implement**:
- 📄 PDF curriculum generation (currently generates TXT format) - Use Apache PDFBox or OpenPDF
- 🎯 Interview simulation with 8 multiple choice questions and score (bom/médio/ruim)
  - Recommended: Static question bank (JSON or database) instead of AI API
  - Deterministic scoring based on correct answers
- 📧 Email notifications for applications

## Configuration Files

- `frontend/.env` - Frontend environment variables (PORT, HOST settings)
- `start.sh` - Startup script that launches both backend and frontend
- `backend/portal-estagios/src/main/resources/application.properties` - Spring Boot config
- `backend/portal-estagios/pom.xml` - Maven dependencies
- `frontend/package.json` - Includes `"proxy": "http://localhost:8080"` for API requests

## Dependencies

**Backend**:
- Spring Boot Web
- Spring Data JPA
- PostgreSQL driver (for production)
- H2 Database (for development)
- Swagger/OpenAPI
- Lombok
- **Spring Security Crypto** (BCrypt password hashing)

**Frontend**:
- React and React DOM
- React Router DOM
- http-proxy-middleware
- Testing libraries

## Database

Currently using H2 in-memory database with PostgreSQL compatibility mode. Database is recreated on each restart with sample data loaded from `data.sql`.

**Connection Info**:
- URL: `jdbc:h2:mem:devdb`
- Username: `sa`
- Password: (empty)

## Development Team

- Backend Developer: José Pedro
- Frontend Developer: Daniel Bartels

## Additional Notes

- The application uses Portuguese language for all UI text
- Backend uses Lombok for reducing boilerplate code
- Frontend uses Create React App with custom proxy configuration
- CORS is configured in the backend to allow frontend requests
