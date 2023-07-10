create table product_ingredient (
       product_id uuid not null,
        ingredient_id uuid not null
    );

    create table profiles (
       person_id uuid not null,
        profiles integer
    );

    create table tb_address (
       id uuid not null,
        bairro varchar(255),
        city varchar(255),
        complemento varchar(255),
        name varchar(255),
        number varchar(255),
        postal_code varchar(255),
        uf varchar(255),
        person_id uuid,
        primary key (id)
    );

    create table tb_cargo (
       id uuid not null,
        name varchar(255),
        primary key (id)
    );

    create table tb_categoria (
       id uuid not null,
        name varchar(255),
        primary key (id)
    );

    create table tb_ingredients (
       id uuid not null,
        description varchar(255),
        price numeric(38,2),
        primary key (id)
    );

    create table tb_orders (
       id uuid not null,
        amount_change numeric(38,2),
        amount_order numeric(38,2),
        order_data date,
        person_id uuid,
        primary key (id)
    );

    create table tb_person (
       person_type varchar(31) not null,
        id uuid not null,
        cel_phone varchar(255),
        cpf varchar(255),
        last_name varchar(255),
        name varchar(255),
        phone varchar(255),
        status varchar(255),
        birth_date date,
        admission_date date,
        user_id uuid,
        cargo_id uuid,
        primary key (id)
    );

    create table tb_produtos (
       id uuid not null,
        description varchar(255),
        price numeric(38,2),
        categoria_id uuid,
        primary key (id)
    );

    create table tb_usuario (
       id uuid not null,
        login varchar(255),
        pass varchar(255),
        primary key (id)
    );

    create table usuario_roles (
       usuario_id uuid not null,
        role varchar(255)
    );

    alter table if exists product_ingredient
       add constraint FKn2ojjyx71g19piwb0trwqwtvr
       foreign key (ingredient_id)
       references tb_ingredients;

    alter table if exists product_ingredient
       add constraint FKaft3nqkkbyo3h2gl7f14d1mih
       foreign key (product_id)
       references tb_produtos;

    alter table if exists profiles
       add constraint FKdvct6x1ebnx9n8u557yolccgg
       foreign key (person_id)
       references tb_person;

    alter table if exists tb_address
       add constraint FKtrocr0nyv92c11b6gvu9p5rcr
       foreign key (person_id)
       references tb_person;

    alter table if exists tb_orders
       add constraint FKfu2t9c2626lfts3tfd9v1bsgf
       foreign key (person_id)
       references tb_person;

    alter table if exists tb_person
       add constraint FKc4adphkrhxj5mxmvwo4jxkbt0
       foreign key (user_id)
       references tb_usuario;

    alter table if exists tb_person
       add constraint FKloqi73i53s8wncb1d32587syi
       foreign key (cargo_id)
       references tb_cargo;

    alter table if exists tb_produtos
       add constraint FK555mlvcyvwis1o07pywhrr83p
       foreign key (categoria_id)
       references tb_categoria;

    alter table if exists usuario_roles
       add constraint FK156s3ye7ajlyyalbyfj1k2tyu
       foreign key (usuario_id)
       references tb_usuario;