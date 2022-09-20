# DB access practice in java (Current: v2.0.0)

## Intro
This project is a practice to create a connection to a database in java.

## Progress (v1.0.0)
For this project I use SQLite3 & SQlite editor & JDBC:
* SQLite : https://www.sqlite.org/download.html

        SQLite has the advantage to be a portable database which could be shared.

* JDBC for sqlite : https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc

        JDBC for sqlite is a prerequisite to do queries

* SQlite editor : https://sqlitebrowser.org/

        SQlite editor is an optional app to edit sqlite database


## Progress (v2.0.0)
Use Layered Model to have a good structure and an ORM to generate database from model and handle mutliple database format : 
* hibernate : https://hibernate.org/
        I use some libs from hibernate. WARNING: the ORM need an old version of Java to work, I currently use java 1.8.