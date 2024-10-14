SET SQL_SAFE_UPDATES = 0;

/** CREAR ROL **/
ALTER TABLE rol AUTO_INCREMENT = 1;
insert into rol(tipo_rol) values('Administrador');
insert into rol(tipo_rol) values('Tecnico 1');
insert into rol(tipo_rol) values('Tecnico 2');
select * from rol;

/** CREAR USUARIO **/
ALTER TABLE usuario AUTO_INCREMENT = 1;
insert into usuario(nombre,apellido_paterno,apellido_materno,dni,fecha_nacimiento,telefono,imagen,email,contrasenia,id_rol, estado) values('Josue','Cisneros','Ochante','74767840','07/01/2001','922659760','userJosue.png','josuepro@hotmail.com','$2a$10$jCbFdzNaQXbbhm3UKg/h3OgLsyaj/XPyRECrLdvh88oPxBs0pM5QK',1, 1);
select * from usuario;


/** CREAR COLABORADOR **/
ALTER TABLE colaborador AUTO_INCREMENT = 1;
insert into colaborador(nombres,apellido_paterno,apellido_materno,numero_documento,codigo_modular,codigo_secuencial) values('Josue', 'cisneros', 'Ochante', 74767840, 1000824761, 107001);
select * from colaborador;


/** CREAR PLANILLA **/
ALTER TABLE planilla AUTO_INCREMENT = 1;
insert into planilla(tipo_planilla, periodo, codigo_ugel, fecha_registro, fecha_modificacion) values('Complementaria', '8-2024', '0H', '2024-10-13 15:45:35', null);
select * from planilla;


/** CREAR PLANILLA_COLABORADOR **/
ALTER TABLE planilla_colaborador AUTO_INCREMENT = 1;
insert into planilla_colaborador(id_planilla, id_colaborador, total_haber, total_descuento) values(1, 1, 3133.96, 1822.01);
select * from planilla_colaborador;


/** OTHER QUERYS **/
select * from planilla;
select * from colaborador;
select * from planilla_colaborador;
select * from descuento;
select * from haber;

ALTER TABLE planilla_colaborador DROP COLUMN total_habers;