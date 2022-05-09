DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS notes;

CREATE TABLE task
(
    taskid  INTEGER PRIMARY KEY auto_increment,
    name VARCHAR(128) UNIQUE,
    completed BOOL,
    dueby TIMESTAMP
);

CREATE TABLE notes
(
    id  INTEGER PRIMARY KEY auto_increment,
    taskid INTEGER ,
    text VARCHAR(256)
);