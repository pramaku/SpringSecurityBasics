create table if not exists users_for_login(
      username_login varchar(50) not null primary key,
      password varchar(50) not null,
      enabled boolean not null);
      
create table if not exists  authorities_roles (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint fk_authorities_users foreign key(username) references users_for_login(username_login));

create unique index ix_auth_username_login on authorities_roles (username,authority);