PGDMP      (                 {         
   veterinary    16.1    16.1 ?    L           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            M           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            N           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            O           1262    18475 
   veterinary    DATABASE     l   CREATE DATABASE veterinary WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE veterinary;
                postgres    false            �            1259    18773    animals    TABLE     9  CREATE TABLE public.animals (
    id bigint NOT NULL,
    breed character varying(255) NOT NULL,
    colour character varying(255),
    date_of_birth date,
    gender character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    species character varying(255) NOT NULL,
    customer_id bigint
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    18772    animals_id_seq    SEQUENCE     w   CREATE SEQUENCE public.animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.animals_id_seq;
       public          postgres    false    222            P           0    0    animals_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.animals_id_seq OWNED BY public.animals.id;
          public          postgres    false    221            �            1259    18514    animals_seq    SEQUENCE     u   CREATE SEQUENCE public.animals_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.animals_seq;
       public          postgres    false            �            1259    18782    appointments    TABLE     �   CREATE TABLE public.appointments (
    id bigint NOT NULL,
    appointment_date timestamp(6) without time zone,
    animal_id bigint,
    doctor_id bigint
);
     DROP TABLE public.appointments;
       public         heap    postgres    false            �            1259    18781    appointments_id_seq    SEQUENCE     |   CREATE SEQUENCE public.appointments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.appointments_id_seq;
       public          postgres    false    224            Q           0    0    appointments_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.appointments_id_seq OWNED BY public.appointments.id;
          public          postgres    false    223            �            1259    18515    appointments_seq    SEQUENCE     z   CREATE SEQUENCE public.appointments_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.appointments_seq;
       public          postgres    false            �            1259    18789    available_dates    TABLE     o   CREATE TABLE public.available_dates (
    id bigint NOT NULL,
    available_date date,
    doctor_id bigint
);
 #   DROP TABLE public.available_dates;
       public         heap    postgres    false            �            1259    18788    available_dates_id_seq    SEQUENCE        CREATE SEQUENCE public.available_dates_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.available_dates_id_seq;
       public          postgres    false    226            R           0    0    available_dates_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.available_dates_id_seq OWNED BY public.available_dates.id;
          public          postgres    false    225            �            1259    18516    available_dates_seq    SEQUENCE     }   CREATE SEQUENCE public.available_dates_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.available_dates_seq;
       public          postgres    false            �            1259    18796 	   customers    TABLE       CREATE TABLE public.customers (
    id bigint NOT NULL,
    address character varying(255) NOT NULL,
    city character varying(255) NOT NULL,
    mail character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    18795    customers_id_seq    SEQUENCE     y   CREATE SEQUENCE public.customers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.customers_id_seq;
       public          postgres    false    228            S           0    0    customers_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.customers_id_seq OWNED BY public.customers.id;
          public          postgres    false    227            �            1259    18517    customers_seq    SEQUENCE     w   CREATE SEQUENCE public.customers_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.customers_seq;
       public          postgres    false            �            1259    18805    doctors    TABLE     �   CREATE TABLE public.doctors (
    id bigint NOT NULL,
    address character varying(255),
    city character varying(255),
    mail character varying(255),
    name character varying(255),
    phone character varying(255)
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    18804    doctors_id_seq    SEQUENCE     w   CREATE SEQUENCE public.doctors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.doctors_id_seq;
       public          postgres    false    230            T           0    0    doctors_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.doctors_id_seq OWNED BY public.doctors.id;
          public          postgres    false    229            �            1259    18518    doctors_seq    SEQUENCE     u   CREATE SEQUENCE public.doctors_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.doctors_seq;
       public          postgres    false            �            1259    18814    vaccines    TABLE     �   CREATE TABLE public.vaccines (
    id bigint NOT NULL,
    code character varying(255),
    name character varying(255),
    protection_finish_date date,
    protection_start_date date,
    animal_id bigint
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    18813    vaccines_id_seq    SEQUENCE     x   CREATE SEQUENCE public.vaccines_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.vaccines_id_seq;
       public          postgres    false    232            U           0    0    vaccines_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.vaccines_id_seq OWNED BY public.vaccines.id;
          public          postgres    false    231            �            1259    18519    vaccines_seq    SEQUENCE     v   CREATE SEQUENCE public.vaccines_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.vaccines_seq;
       public          postgres    false            �           2604    18776 
   animals id    DEFAULT     h   ALTER TABLE ONLY public.animals ALTER COLUMN id SET DEFAULT nextval('public.animals_id_seq'::regclass);
 9   ALTER TABLE public.animals ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    222    222            �           2604    18785    appointments id    DEFAULT     r   ALTER TABLE ONLY public.appointments ALTER COLUMN id SET DEFAULT nextval('public.appointments_id_seq'::regclass);
 >   ALTER TABLE public.appointments ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    223    224            �           2604    18792    available_dates id    DEFAULT     x   ALTER TABLE ONLY public.available_dates ALTER COLUMN id SET DEFAULT nextval('public.available_dates_id_seq'::regclass);
 A   ALTER TABLE public.available_dates ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    225    226    226            �           2604    18799    customers id    DEFAULT     l   ALTER TABLE ONLY public.customers ALTER COLUMN id SET DEFAULT nextval('public.customers_id_seq'::regclass);
 ;   ALTER TABLE public.customers ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    227    228    228            �           2604    18808 
   doctors id    DEFAULT     h   ALTER TABLE ONLY public.doctors ALTER COLUMN id SET DEFAULT nextval('public.doctors_id_seq'::regclass);
 9   ALTER TABLE public.doctors ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    230    229    230            �           2604    18817    vaccines id    DEFAULT     j   ALTER TABLE ONLY public.vaccines ALTER COLUMN id SET DEFAULT nextval('public.vaccines_id_seq'::regclass);
 :   ALTER TABLE public.vaccines ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    231    232    232            ?          0    18773    animals 
   TABLE DATA           g   COPY public.animals (id, breed, colour, date_of_birth, gender, name, species, customer_id) FROM stdin;
    public          postgres    false    222   �E       A          0    18782    appointments 
   TABLE DATA           R   COPY public.appointments (id, appointment_date, animal_id, doctor_id) FROM stdin;
    public          postgres    false    224   �F       C          0    18789    available_dates 
   TABLE DATA           H   COPY public.available_dates (id, available_date, doctor_id) FROM stdin;
    public          postgres    false    226   G       E          0    18796 	   customers 
   TABLE DATA           I   COPY public.customers (id, address, city, mail, name, phone) FROM stdin;
    public          postgres    false    228   |G       G          0    18805    doctors 
   TABLE DATA           G   COPY public.doctors (id, address, city, mail, name, phone) FROM stdin;
    public          postgres    false    230   sH       I          0    18814    vaccines 
   TABLE DATA           l   COPY public.vaccines (id, code, name, protection_finish_date, protection_start_date, animal_id) FROM stdin;
    public          postgres    false    232   7I       V           0    0    animals_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.animals_id_seq', 7, true);
          public          postgres    false    221            W           0    0    animals_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.animals_seq', 1, false);
          public          postgres    false    215            X           0    0    appointments_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.appointments_id_seq', 7, true);
          public          postgres    false    223            Y           0    0    appointments_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.appointments_seq', 1, false);
          public          postgres    false    216            Z           0    0    available_dates_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.available_dates_id_seq', 13, true);
          public          postgres    false    225            [           0    0    available_dates_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.available_dates_seq', 1, false);
          public          postgres    false    217            \           0    0    customers_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.customers_id_seq', 7, true);
          public          postgres    false    227            ]           0    0    customers_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.customers_seq', 1, false);
          public          postgres    false    218            ^           0    0    doctors_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.doctors_id_seq', 6, true);
          public          postgres    false    229            _           0    0    doctors_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.doctors_seq', 1, false);
          public          postgres    false    219            `           0    0    vaccines_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.vaccines_id_seq', 12, true);
          public          postgres    false    231            a           0    0    vaccines_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.vaccines_seq', 1, false);
          public          postgres    false    220            �           2606    18780    animals animals_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    222            �           2606    18787    appointments appointments_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.appointments DROP CONSTRAINT appointments_pkey;
       public            postgres    false    224            �           2606    18794 $   available_dates available_dates_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT available_dates_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT available_dates_pkey;
       public            postgres    false    226            �           2606    18803    customers customers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    228            �           2606    18812    doctors doctors_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    230            �           2606    18821    vaccines vaccines_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    232            �           2606    18827 (   appointments fk95vepu86o8syqtux9gkr71bhy    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk95vepu86o8syqtux9gkr71bhy FOREIGN KEY (animal_id) REFERENCES public.animals(id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk95vepu86o8syqtux9gkr71bhy;
       public          postgres    false    222    224    3481            �           2606    18822 #   animals fkb36lt3kj4mrbdx5btxmp4j60n    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n FOREIGN KEY (customer_id) REFERENCES public.customers(id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n;
       public          postgres    false    228    222    3487            �           2606    18842 $   vaccines fkeasdy15b2kp5j4k13x2dfudqs    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs FOREIGN KEY (animal_id) REFERENCES public.animals(id);
 N   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs;
       public          postgres    false    232    3481    222            �           2606    18832 (   appointments fkmujeo4tymoo98cmf7uj3vsv76    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76 FOREIGN KEY (doctor_id) REFERENCES public.doctors(id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76;
       public          postgres    false    224    230    3489            �           2606    18837 +   available_dates fknb419ilm71d71rm584rk460pk    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT fknb419ilm71d71rm584rk460pk FOREIGN KEY (doctor_id) REFERENCES public.doctors(id);
 U   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT fknb419ilm71d71rm584rk460pk;
       public          postgres    false    226    230    3489            ?   �   x�m��n�0���S��pBhעTu��R�#9%W'1�c���kS*QɃ������ak��������l���2>oΐ�=W�=�o.V0g74�4�^��а�C��K�K��PM�^��G��<�����_�jM5�ZdPڞ�ȕ�١i�ݬ(O��{�L�3����/��oUr�NbJ��H�1�G����(�3ht(5��П��X�A�����c�o2�}>	!~ 	�n�      A   Y   x�]���0Dѳ��4�� v�Z�![����,��B�ƣ�W�{a!|꽫!���f�6�W�\(E۪Y�Fk���ٞ�6���#$�      C   [   x�Eι�0Dј�E�Ջ���(������7Z�%����LF�3��H��hʦ]�NM��H	�G�Z��q��y�c�e�~�\x @o �      E   �   x�m�An� E��Sp�(��ul�R++ͦ�n�&#0T�DrO_�٪�}���A@�݄hG�ʍh'm�Ӈ���/mv���yf� �ؗeɹ���=��(���*���?>|	/hZ��0�S�N��wm��Ub�2�dK��vd���*m4��A���ݼ�C���Ț�5��K�C��!�p�W���7ݲ��xK��d���O��(�]�;����#���'��Q�6>vEQ� �#�#      G   �   x�uα�0����>J��b،�K�hk�%���5�����wt3Z	��B�z?���SK���]\@�h�eY�SJ�?H����WdEA(ŋ�N�PM������%�	��eԌ��8͢��A�}E\����G�g�"�~��qƸ��;��j���^�J,��|y�VwO!_��l      I   �   x�u�9�0E�Sp� ��8)#��
%��)BA����� �tO�_o�]����<t˴L �T�J4o$ $���،���f���M�h�i2RD���QU���6�X�w�1�MM[2~�B���4{U�\-ܝ��u����ܶ�a�v��ی�%�s�a_�N����RZV     