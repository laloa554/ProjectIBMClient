PGDMP     6    2            	    y           Cards    13.3    13.3 	    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    26865    Cards    DATABASE     d   CREATE DATABASE "Cards" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Mexico.1252';
    DROP DATABASE "Cards";
                postgres    false            ?            1259    26911    credit_cards    TABLE     R  CREATE TABLE public.credit_cards (
    id bigint NOT NULL,
    age_max double precision NOT NULL,
    age_min double precision NOT NULL,
    credit_card character varying(150) NOT NULL,
    monthly_salary_max double precision NOT NULL,
    monthly_salary_min double precision NOT NULL,
    your_passion character varying(150) NOT NULL
);
     DROP TABLE public.credit_cards;
       public         heap    postgres    false            ?            1259    26909    credit_cards_id_seq    SEQUENCE     ?   ALTER TABLE public.credit_cards ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.credit_cards_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    201            ?          0    26911    credit_cards 
   TABLE DATA              COPY public.credit_cards (id, age_max, age_min, credit_card, monthly_salary_max, monthly_salary_min, your_passion) FROM stdin;
    public          postgres    false    201   ?	       ?           0    0    credit_cards_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.credit_cards_id_seq', 74, true);
          public          postgres    false    200            #           2606    26915    credit_cards credit_cards_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.credit_cards
    ADD CONSTRAINT credit_cards_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.credit_cards DROP CONSTRAINT credit_cards_pkey;
       public            postgres    false    201            ?   ?  x??ֽ??0 ?Z<?	??-m_qE2??\?F??33< <?C]?G??̊?
Υ?ۅ]-?(a?Дl?%jMh?eI?  ͹?\???c`6?????߉??BNxg??d!??d?]!?? P?y=?????????dU?JR????????[Q
%??8?v??K??GG3K????b%?Z-?2??]?`?TA???md j?c#????%z?+?Ȱ?@)?#?#?
?3|,pl??Y???i4
Ů??y???Sk.zԭ??2l.P?_Mׂ}!t^???(?Y?pʀB?p?}??C?V?pl;??#??R?Z??ݭ???˽?u?}#?WQj?.	{h?z?kq?E?q?b6??S?Ƿ@u??6m??.M?I??!)?ua??/4l??&??????4d??Y/??o????$`fc;??]Wݶm????^b\?ax?hf??ᅠ(? k??B(???f???????k?g??Gȥ?u?Lw??{??????Ѩ
???U?Yա)?*?/$7K?C?WY?j@<?y_K??jV??e?@?????Z??K?
?E)??h?????????o?d??vT2?z?">9?Q?^ Q???ѻȰ5?(q_E,?Z????0??Ȩ$p_j,i?}?????ೞ$???*Å#cN?<????.?     