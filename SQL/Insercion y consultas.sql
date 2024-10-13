/** INSERTAR USUARIO ADMINISTRADOR **/
insert into rol(tipo_rol) values('Administrador');
insert into usuario(nombre,apellido_paterno,apellido_materno,dni,fecha_nacimiento,telefono,imagen,email,contrasenia,id_rol) values('Henry','Vidal','Fernandez','74767840','07/01/2001','922659760','userHenry.png','henry123@hotmail.com','$2a$10$jCbFdzNaQXbbhm3UKg/h3OgLsyaj/XPyRECrLdvh88oPxBs0pM5QK',1);


/** CONSULTAR USUARIO ADMINISTRADOR **/
select * from usuario;


create table boleta(
	id_boleta int primary key auto_increment,
    tipo_planilla varchar(100) not null,
	mes_anio varchar(20) not null,
    codmodular varchar(30) not null,
	nr_registro BIGINT not null,
    nombres varchar(200) not null,
    cod_concepto varchar(10) not null,
    concepto varchar(100) not null,
    monto_bruto decimal(10,2) not null
);

select * from boleta;
INSERT INTO quinta_categoria.boleta (tipo_planilla, mes_anio, codmodular, nr_registro, nombres, cod_concepto, concepto, monto_bruto) VALUES ('OCASIONAL', '07/2024', '1009586583', '107053', 'PINTO BAUTISTA CARLOTA', '+090', 'credevnaf', '145.85');