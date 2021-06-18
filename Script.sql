
CREATE TABLE public.log_values
(
    id serial NOT NULL,
    msg text COLLATE pg_catalog."default"
)

    TABLESPACE pg_default;

ALTER TABLE public.log_values
    OWNER to postgres;