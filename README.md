# task-tracker-springboot

A simple task management REST API built with Spring Boot + JPA (Hibernate).
Supports creating, updating (PUT/PATCH), retrieving, and deleting tasks, backed by Postgres (or in-memory H2 for dev/testing).

## Features

- ✅ CRUD operations on tasks

- ✅ PUT for full updates, PATCH for partial updates

- ✅ Clean architecture with Controller → Service → Repository → Entity separation (SoC)

- ✅ Swappable database: start with H2 in-memory DB or use Postgres

## Tech Stack

- Java 21

- Spring Boot (Web, Data JPA)

- PostgreSQL (default DB)

- H2 Database (testing/dev fallback)

- Maven

## Getting Started

1. Clone Repo:

```bash
git clone https://github.com/HShrigma/task-tracker-springboot.git
cd task-tracker
```

2. Create user + DB:

### Option A: Postgres (recommended)

```sql
CREATE USER task_user WITH PASSWORD 'APasswordMoreSecureThanThisOne';
CREATE DATABASE task_db OWNER task_user;
```

3. Add a .env file in project root:

```env
DB_URL=jdbc:postgresql://localhost:5432/task_db
DB_USER=task_user
DB_PASSWORD=superSecretPass123
```

### Option B: H2 (quick start)

No setup needed. Spring Boot will start with H2 if you run with the `dev` profile (edit `application.properties`).

4. Run the App:

```bash
./mvnw spring-boot:run
```

## API Endpoints

Base URL: `http://localhost:8080/api/tasks`
| Method | Endpoint | Description |
| ------ | -------------------- | ------------------------------------- |
| GET | `/` | Get all tasks (grouped by topic) |
| GET | `/topic/{topic}` | Get tasks by topic |
| GET | `/{id}` | Get single task |
| POST | `/` | Create a task |
| PUT | `/{id}` | Update entire task |
| PATCH | `/{id}` | Partial update (only provided fields) |
| DELETE | `/{id}` | Delete task |

### Example JSON

#### Create a Task (`POST /api/tasks`)

```json
{
  "topic": "work",
  "name": "Finish project",
  "description": "Write the documentation"
}
```

#### Update a Task (`PUT /api/tasks/{id}`)

```json
{
  "topic": "work",
  "name": "Unfinish project",
  "description": "Remove the documentation"
}
```

#### Patch a Task (`PATCH /api/tasks/{id}`)

```json
{
  "topic": "work",
  "description": "Write the documentation"
}
```

## Project Structure

```bash
src/main/java/com/hshrigma/task_tracker/
│
├── controller/       # REST controllers (handle HTTP requests)
├── service/          # Business logic (validation, transformations)
├── repo/             # Repositories (Spring Data JPA interfaces)
├── entity/           # JPA entities (map to DB tables)
└── dto/              # Data transfer objects (requests/responses)
```

## Notes

- H2 Db is good for API Testing, I personally use Postman, helps to not worry about persistence
- TODO: Response DTOs, authentication
