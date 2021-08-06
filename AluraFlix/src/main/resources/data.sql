CREATE DATABASE IF NOT EXISTS db_alura_flix;

USE db_alura_flix;

create table if not exists tb_categoria (
id bigint not null auto_increment,
titulo varchar(255) not null,
cor varchar(255) not null,
primary key (id)) engine=InnoDB;

create table if not exists tb_video (
id bigint not null auto_increment,
titulo varchar(255) not null,
descricao varchar(255) not null,
url varchar(255) not null,
categoria_id bigint,
constraint FK2b3odso8ggtewt0ijl25lbdy foreign key (categoria_id) references tb_categoria (id),
primary key (id)) engine=InnoDB;

INSERT INTO tb_categoria (id, titulo, cor) VALUES (1, "LIVRE", "#ffffff")
ON DUPLICATE KEY UPDATE titulo = "LIVRE", cor = "#ffffff";