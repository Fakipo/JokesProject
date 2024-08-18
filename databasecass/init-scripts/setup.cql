CREATE KEYSPACE IF NOT EXISTS joke_keyspace
WITH REPLICATION = {'class' : 'SimpleStrategy', 'replication_factor' : 1};

USE joke_keyspace;

CREATE TABLE IF NOT EXISTS jokeentity (
    id UUID PRIMARY KEY,
    setup text,
    punchline text,
    type text
);
