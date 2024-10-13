create database quinta_categoria;
use quinta_categoria;

create table rol(
id_rol int primary key auto_increment,
tipo_rol varchar(20) not null
);
create table usuario(
	id_usuario int primary key auto_increment,
    nombre varchar(100) not null,
	apellido_paterno varchar(100) not null,
    apellido_materno varchar(100) not null,
	dni varchar(8) not null,
    fecha_nacimiento varchar(40) not null,
    telefono varchar(12) not null,
    imagen varchar(200) not null,
    email varchar(100) not null,
    contrasenia varchar(100) not null,
	id_rol int not null,
    foreign key(id_rol) references rol(id_rol)
);