CREATE TABLE IF NOT EXISTS public.books
(
    id serial NOT NULL,
    name character varying(120) COLLATE pg_catalog."default" NOT NULL,
    category character(4) COLLATE pg_catalog."default",
    quantity integer NOT NULL,
    CONSTRAINT books_pkey PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.books
    OWNER to "book";

INSERT INTO public.books( name, category, quantity)
    VALUES ('Book 1', 'OLD', 20),
        ('Book 2', 'OLD', 30),
        ('Book 3', 'NEW', 30),
        ('Book 4', 'NEW', 50),
        ('Book 5', 'KID', 40);
