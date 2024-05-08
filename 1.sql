CREATE TABLE user(
    username TEXT PRIMARY KEY NOT NULL ,
    password TEXT NOT NULL
);

CREATE TABLE todo(
    id INTEGER PRIMARY KEY AUTOINCREMENT ,
    creator TEXT NOT NULL,
    description TEXT NOT NULL,
    start_time TEXT NOT NULL ,
    end_time TEXT NOT NULL
);