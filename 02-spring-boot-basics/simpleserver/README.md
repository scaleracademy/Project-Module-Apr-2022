

## REST APIs 

|        | /users                                                                                                                                                        | /users/23                                                                                                                      |
|--------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------|
| GET    | get all users  search ops also work here via query <br>     /users?name=Arnav : fetch users with name Arnav <br> /users?minAge=20 : fetch users with age > 20 | get user whose id = 23                                                                                                         |
| POST   | create a new user   request must contain new user obj NOTE: server will generate id of new obj                                                                | ---NA---                                                                                                                       |
| PUT    | ---NA---                                                                                                                                                      | create a new user with id = 23   overwrite an user if that existed  <br>   NOTE: only if server lets clients set id of new obj |
| PATCH  | ---NA---                                                                                                                                                      | update the fields of user with id = 23   fields which are supplied in request body <br>    are merged to existing object       |
| DELETE | ---NA---                                                                                                                                                      | delete user whose id = 23                                                                                                      |


## Assignment

Create an in-memory task manager API. 


### Submission Requirements 
1. Have a working API for tasks and notes
2. tasks & notes are stored in memory (data gets reset on server restart)
3. have a Swagger (OpenAPI) UI to show the API docs 
4. \[BONUS\] write unit-tests for task and notes service 

Given entities as following 

#### Task 
```json
{
  "id": 1,
  "name": "This is a task",
  "dueDate": "2020-01-01",
  "done": false
}
```

#### Notes 

```json
{
  "id": 1,
  "taskId": 1,
  "text": "This is a note"
}
```

Create a REST API for the above entities. 

#### `GET /tasks`
get all tasks 

response 

```json
{
  "taskCount": 2,
  "tasks": [
    {
      "id": 1,
      "name": "This is a task",
      "dueDate": "2020-01-01",
      "done": false
    },
    {
      "id": 2,
      "name": "This is another task",
      "dueDate": "2020-01-03",
      "done": true
    }
  ]
}
```

#### `POST /tasks`
create a new task

request 
```json
{
  "name": "This is a task",
  "dueDate": "2020-01-01",
  "done": false
}
```

response 
```json
{
  "id": 3,
  "name": "This is a task",
  "dueDate": "2020-01-01",
  "done": false
}
```

#### `GET /tasks/:id`
get task with id = :id

response [](#task)

response = 404 (if task not found)
```json
{
  "error": "Task not found"
}
```


#### `DELETE /tasks/:id`
delete task with id = :id

#### `PATCH /tasks/:id`
update task with id = :id
(we can update the due date and/or the done status)

request 
```json
{
  "dueDate": "2020-01-01",
  "done": false
}
```

#### `GET /tasks/:id/notes`
get all notes for task with id = :id

#### `POST /tasks/:id/notes`
create a new note for task with id = :id

#### `DELETE /tasks/:id/notes/:noteId`
delete note with id = :noteId for task with id = :id

[comment]: <> (http://localhost:9090/swagger-ui/index.html)