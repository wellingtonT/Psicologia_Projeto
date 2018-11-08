--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.14
-- Dumped by pg_dump version 9.5.14

-- Started on 2018-11-08 17:22:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2155 (class 1262 OID 17451)
-- Name: Psicologia; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Psicologia" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE "Psicologia" OWNER TO postgres;

\connect "Psicologia"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 189 (class 1259 OID 17525)
-- Name: consulta_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.consulta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.consulta_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 187 (class 1259 OID 17497)
-- Name: consulta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.consulta (
    id integer DEFAULT nextval('public.consulta_id_seq'::regclass) NOT NULL,
    data_agendada date NOT NULL,
    hora_agendada time without time zone NOT NULL,
    cpf_paciente character varying(11) NOT NULL,
    cpf_psicologo character varying(11) NOT NULL,
    cpf_secretaria character varying(11) NOT NULL
);


ALTER TABLE public.consulta OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 17486)
-- Name: medicamento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.medicamento_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medicamento_id_seq OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 17481)
-- Name: medicamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medicamento (
    id integer DEFAULT nextval('public.medicamento_id_seq'::regclass) NOT NULL,
    nome character varying(50),
    dose character varying(50),
    cpf_paciente character varying(11) NOT NULL
);


ALTER TABLE public.medicamento OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 17460)
-- Name: paciente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.paciente (
    cpf character varying(11) NOT NULL,
    nome character varying(50) NOT NULL,
    rua character varying(50) NOT NULL,
    cidade character varying(30) NOT NULL,
    telefone character varying(15) NOT NULL
);


ALTER TABLE public.paciente OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 17465)
-- Name: psicologo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.psicologo (
    cpf character varying(11) NOT NULL,
    nome character varying(50) NOT NULL,
    rua character varying(50) NOT NULL,
    cidade character varying(30) NOT NULL,
    telefone character varying(15) NOT NULL,
    salario character varying NOT NULL,
    crp character varying(20) NOT NULL
);


ALTER TABLE public.psicologo OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 17473)
-- Name: secretaria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.secretaria (
    cpf character varying(11) NOT NULL,
    nome character varying(50) NOT NULL,
    rua character varying(50) NOT NULL,
    cidade character varying(30) NOT NULL,
    telefone character varying(15) NOT NULL,
    salario character varying NOT NULL
);


ALTER TABLE public.secretaria OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 17522)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_seq OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 17489)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id integer DEFAULT nextval('public.usuario_id_seq'::regclass) NOT NULL,
    perfil integer NOT NULL,
    senha character varying
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 2147 (class 0 OID 17497)
-- Dependencies: 187
-- Data for Name: consulta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.consulta (id, data_agendada, hora_agendada, cpf_paciente, cpf_psicologo, cpf_secretaria) FROM stdin;
\.


--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 189
-- Name: consulta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.consulta_id_seq', 11, true);


--
-- TOC entry 2144 (class 0 OID 17481)
-- Dependencies: 184
-- Data for Name: medicamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medicamento (id, nome, dose, cpf_paciente) FROM stdin;
\.


--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 185
-- Name: medicamento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.medicamento_id_seq', 1, false);


--
-- TOC entry 2141 (class 0 OID 17460)
-- Dependencies: 181
-- Data for Name: paciente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.paciente (cpf, nome, rua, cidade, telefone) FROM stdin;
12806337607	Wellington	Rua João Ferraz	Pouso Alegre	997254641
\.


--
-- TOC entry 2142 (class 0 OID 17465)
-- Dependencies: 182
-- Data for Name: psicologo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.psicologo (cpf, nome, rua, cidade, telefone, salario, crp) FROM stdin;
1234	Well	Rua dos abc	Cidade da paz	9876	5000	85ACX1
\.


--
-- TOC entry 2143 (class 0 OID 17473)
-- Dependencies: 183
-- Data for Name: secretaria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.secretaria (cpf, nome, rua, cidade, telefone, salario) FROM stdin;
5241	Secreta	Rua secreta	Cidade dos segredos	526987	1500
\.


--
-- TOC entry 2146 (class 0 OID 17489)
-- Dependencies: 186
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id, perfil, senha) FROM stdin;
\.


--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 188
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_seq', 1, false);


--
-- TOC entry 2022 (class 2606 OID 17501)
-- Name: consulta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_pkey PRIMARY KEY (id);


--
-- TOC entry 2018 (class 2606 OID 17485)
-- Name: medicamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicamento
    ADD CONSTRAINT medicamento_pkey PRIMARY KEY (id);


--
-- TOC entry 2012 (class 2606 OID 17464)
-- Name: paciente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (cpf);


--
-- TOC entry 2014 (class 2606 OID 17472)
-- Name: psicologo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.psicologo
    ADD CONSTRAINT psicologo_pkey PRIMARY KEY (cpf);


--
-- TOC entry 2016 (class 2606 OID 17480)
-- Name: secretaria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secretaria
    ADD CONSTRAINT secretaria_pkey PRIMARY KEY (cpf);


--
-- TOC entry 2020 (class 2606 OID 17496)
-- Name: usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 2023 (class 2606 OID 17502)
-- Name: cpf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicamento
    ADD CONSTRAINT cpf FOREIGN KEY (cpf_paciente) REFERENCES public.paciente(cpf);


--
-- TOC entry 2024 (class 2606 OID 17507)
-- Name: cpf_paciente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT cpf_paciente FOREIGN KEY (cpf_paciente) REFERENCES public.paciente(cpf);


--
-- TOC entry 2025 (class 2606 OID 17512)
-- Name: cpf_psicologo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT cpf_psicologo FOREIGN KEY (cpf_psicologo) REFERENCES public.psicologo(cpf);


--
-- TOC entry 2026 (class 2606 OID 17517)
-- Name: cpf_secretaria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT cpf_secretaria FOREIGN KEY (cpf_secretaria) REFERENCES public.secretaria(cpf);


--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-11-08 17:22:03

--
-- PostgreSQL database dump complete
--

