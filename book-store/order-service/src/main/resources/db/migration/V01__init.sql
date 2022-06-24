CREATE TABLE IF NOT EXISTS public.orders
(
    id serial NOT NULL,
    user_id integer NOT NULL,
    book_id integer NOT NULL,
    quantity integer NOT NULL,
    description character varying(200) COLLATE pg_catalog."default",
    price integer,
    CONSTRAINT orders_pkey PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.orders
    OWNER to "order";

INSERT INTO public.orders( user_id, book_id, quantity, price, description)
VALUES (1, 1, 20, 100, 'Order 1'),
       (2, 2, 20, 100, 'Order 2'),
       (3, 2, 20, 100, 'Order 3'),
       (4, 3, 20, 100, 'Order 4'),
       (1, 4, 20, 100, 'Order 5');
