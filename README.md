# DisneyDemo
Proyecto demo

* Maven
* PostgresSQL 9
* Jdk 11

## Comenzando

Se debe crear la Base de datos en postgres
```
CREATE DATABASE log_test
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Spanish_United States.1252'
       LC_CTYPE = 'Spanish_United States.1252'
       CONNECTION LIMIT = -1;
```

Se debe crear la tabla en postgres
```
CREATE TABLE public.log_values
(
    msg text COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE public.log_values
    OWNER to postgres;
```
### Se ejecuta la aplicación en el Main se encuentran los mensajes estáticos 

1. Se creó un hanlder personalizado para acceder a la base de datos.
- Se usó el fichero logging.properties, para almacenar los log.
* Se usó el fichero application.properties para los accesos a la bd.
