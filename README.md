# Student Management System

A simple Spring Boot Student Management app used as a **live demo project** for the Advanced Git KT Session.

## Run the App
```bash
mvn spring-boot:run
```

## API Endpoints

| Method | URL                    | Description          |
|--------|------------------------|----------------------|
| GET    | /api/students          | Get all students     |
| GET    | /api/students/{id}     | Get student by id    |
| POST   | /api/students          | Create student       |
| PUT    | /api/students/{id}     | Update student       |
| DELETE | /api/students/{id}     | Delete student       |

## Sample Postman Data

### POST /api/students
```json
{
  "name": "David Brown",
  "email": "david@example.com",
  "course": "Computer Science",
  "grade": "B"
}
```

### PUT /api/students/1
```json
{
  "name": "Alice Johnson",
  "email": "alice@example.com",
  "course": "Computer Science",
  "grade": "A+"
}
```

## Pre-loaded Students
| ID | Name          | Email               | Course           | Grade |
|----|---------------|---------------------|------------------|-------|
| 1  | Alice Johnson | alice@example.com   | Computer Science | A     |
| 2  | Bob Smith     | bob@example.com     | Mathematics      | B     |
| 3  | Carol White   | carol@example.com   | Physics          | A     |

## Git KT Topics Demonstrated Here
- Branching Strategies (feature, develop, release, hotfix)
- Merge vs Rebase
- Interactive Rebase
- Git Stash
- Cherry-Pick
- Reset vs Revert
- Merge Conflict Resolution
