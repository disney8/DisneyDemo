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
2. Se usó el fichero logging.properties, para almacenar los log.
3. Se usó el fichero application.properties para los accesos a la bd.

## Correpciones del DEMO INICIAL

1. line 23: La variable "initialized" no esta siendo usada.
2. line 24: El map debe ser genérico "<String, String>"
3. line 51: No es necesario "Connection connection = null;". Se puede hacer la asignacion directamente   Connection connection =  DriverManager.ge.....
4. line 56:  En el connection = DriverManager.getConnection.. , no se está dando tratamiento a la exception.
5. En el código no se está verificando si dbParams == null.
6. Al establecer la conexción no se define la base datos que es requerida.
7. line 72: se debe dar tratamiento a la excepcion de conexcion o incluir en el   if(logToDatabase) 
8. La conexcion a la base de dator no se está cerrando.
9. Sintaxis del sql insert esta incorrecta insert into <tablename> (columns..) values(values..)
10. No es necesario un valor booleano para marcar el mensaje como "mensaje, advertencia o error" ,podría estar bien simplemente enviando el valor del texto.

