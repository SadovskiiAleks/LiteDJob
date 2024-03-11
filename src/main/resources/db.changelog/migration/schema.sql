
CREATE SCHEMA IF NOT EXISTS public;
create table public.user_role (
            id SERIAL PRIMARY KEY,
            created timestamp(6), email varchar(255) not null,
            number varchar(255), password varchar(255) not null,
            role varchar(255) check (role in ('ROLE_ADMIN','ROLE_OPERATOR','ROLE_USER')),
            username varchar(255) not null
);

CREATE SCHEMA IF NOT EXISTS public;
create table public.request (
                                id SERIAL PRIMARY KEY,
                                created timestamp(6),
                                full_text varchar(255),
                                status varchar(255) check (status in ('DRAFT','SEND','ACCEPT','DISMISS')),
                                user_role_id bigserial,
                                FOREIGN KEY (user_role_id) REFERENCES user_role (id)
);
-- -- rollback drop table hw_netology.CUSTUMERS;