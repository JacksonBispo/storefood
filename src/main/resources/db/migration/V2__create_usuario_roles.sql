
create table usuario_roles (
       usuario_id binary(16) not null,
        role varchar(255)
    );


 alter table usuario_roles
       add constraint FK_USUARIO_ROLES
       foreign key (usuario_id)
       references tb_usuario (id);