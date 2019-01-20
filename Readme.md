### Run configuration

If you're running the hibernate version, just change th `hibernate.cfg.xml` content to point at your database

If you're running Spring JDBC version, make sure to 
* Change `dataSource` bean  defined in `spring-jdbc.xml` to point at your database
* Run `ddl.sql` from `resources` folder to create the database schema