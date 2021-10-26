--
-- PostgreSQL database dump
--

-- Dumped from database version 10.6
-- Dumped by pg_dump version 10.6

-- Started on 2019-01-12 20:21:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 2874
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 2 (class 3079 OID 12973)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 1 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 16393)
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    title character varying NOT NULL,
    price double precision NOT NULL,
    storehouse character varying,
    qty integer,
    book_id integer NOT NULL
);


ALTER TABLE public.book OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16415)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    customer_id integer NOT NULL,
    surname character varying NOT NULL,
    district character varying NOT NULL,
    discount integer
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16423)
-- Name: purchase; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.purchase (
    purchase_id integer NOT NULL,
    date date NOT NULL,
    seller integer NOT NULL,
    customer integer NOT NULL,
    book integer NOT NULL,
    qty integer NOT NULL,
    price double precision
);


ALTER TABLE public.purchase OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16401)
-- Name: shop; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shop (
    shop_id integer NOT NULL,
    name character varying NOT NULL,
    district character varying NOT NULL,
    comission character varying(1)
);


ALTER TABLE public.shop OWNER TO postgres;

--
-- TOC entry 2865 (class 0 OID 16393)
-- Dependencies: 197
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.book (title, price, storehouse, qty, book_id) FROM stdin;
Harry Potter	300	House of books	2	1
\.


--
-- TOC entry 2867 (class 0 OID 16415)
-- Dependencies: 199
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (customer_id, surname, district, discount) FROM stdin;
1	Morozkina	Sormovskyi	10
\.


--
-- TOC entry 2868 (class 0 OID 16423)
-- Dependencies: 200
-- Data for Name: purchase; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.purchase (purchase_id, date, seller, customer, book, qty, price) FROM stdin;
1	2018-12-20	1	1	1	1	200
\.


--
-- TOC entry 2866 (class 0 OID 16401)
-- Dependencies: 198
-- Data for Name: shop; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.shop (shop_id, name, district, comission) FROM stdin;
1	House of books	Sormovskiy	1
\.


--
-- TOC entry 2734 (class 2606 OID 16400)
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (book_id);


--
-- TOC entry 2738 (class 2606 OID 16422)
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_id);


--
-- TOC entry 2740 (class 2606 OID 16430)
-- Name: purchase purchase_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_pkey PRIMARY KEY (purchase_id);


--
-- TOC entry 2736 (class 2606 OID 16414)
-- Name: shop shop_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shop
    ADD CONSTRAINT shop_pkey PRIMARY KEY (shop_id);


--
-- TOC entry 2743 (class 2606 OID 16441)
-- Name: purchase purchase_book_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_book_fkey FOREIGN KEY (book) REFERENCES public.book(book_id);


--
-- TOC entry 2742 (class 2606 OID 16436)
-- Name: purchase purchase_customer_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_customer_fkey FOREIGN KEY (customer) REFERENCES public.customer(customer_id);


--
-- TOC entry 2741 (class 2606 OID 16431)
-- Name: purchase purchase_seller_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_seller_fkey FOREIGN KEY (seller) REFERENCES public.shop(shop_id);


-- Completed on 2019-01-12 20:21:07

--
-- PostgreSQL database dump complete
--

