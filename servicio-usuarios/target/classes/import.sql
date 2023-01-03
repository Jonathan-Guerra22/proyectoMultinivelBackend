insert into roles(nombre_rol,ganancia_lvl1,ganancia_lvl2,ganancia_lvl3) values("Mayorista Asociado",0.25,0,0);
insert into roles(nombre_rol,ganancia_lvl1,ganancia_lvl2,ganancia_lvl3) values("Mayorista",0.10,0.15,0);
insert into roles(nombre_rol,ganancia_lvl1,ganancia_lvl2,ganancia_lvl3) values("Vendedor",0.05,0.10,0.10);



insert into usuarios(cedula,correo,nomusuario,contrasena,estado) values(11,"jonathan@correo.com","Jonathan","usu222","Activo");
insert into usuarios(cedula,correo,nomusuario,contrasena,estado) values(22,"David@correo.com","David","usu222","Activo");
insert into usuarios(cedula,correo,nomusuario,contrasena,estado) values(33,"Andres@correo.com","Andres","usu333","Activo");
insert into usuarios(cedula,correo,nomusuario,contrasena,estado) values(44,"David2@correo.com","David2","usu444","Activo");

insert into usuarios(cedula,correo,nomusuario,contrasena,estado) values(55,"javier@correo.com","JavierAdmin","admin555","Activo");
insert into usuarios(cedula,correo,nomusuario,contrasena,estado) values(66,"ana@correo.com","SantiagoAdmin","admin666","Activo");
insert into usuarios(cedula,correo,nomusuario,contrasena,estado) values(77,"santiago@correo.com","SantiagoAdmin","admin777","Activo");
insert into usuarios(cedula,correo,nomusuario,contrasena,estado) values(88,"jorge@correo.com","JorgeAdmin","admin888","Activo");

insert into usuarios(cedula,correo,nomusuario,contrasena,estado) values(1,"empresa@correo.com","EmpresaAdminusu","empresa123","Activo");
insert into vendedores(cedulavendedor,estado_Vendedor,nombre_Vendedor,apellido_Vendedor,celular_Vendedor,ciudad_Vendedor,direccion,usuario_cedula) values(1,"Activo","Empresa","KarolJeans",3118989788,"Bogota","Calle 21 #5-18",1);

insert into vendedores(cedulavendedor,estado_Vendedor,nombre_Vendedor,apellido_Vendedor,celular_Vendedor,ciudad_Vendedor,direccion,usuario_cedula,grupo) values(11,"Activo","Jonathan","Guerra",3112902355,"Bogota","Calle 13 #2-23",11,1);
insert into vendedores(cedulavendedor,estado_Vendedor,nombre_Vendedor,apellido_Vendedor,celular_Vendedor,ciudad_Vendedor,direccion,usuario_cedula,grupo) values(22,"Activo","David","Popayan",3125896745,"Bogota","Calle 22 #14-27",22,2);
insert into vendedores(cedulavendedor,estado_Vendedor,nombre_Vendedor,apellido_Vendedor,celular_Vendedor,ciudad_Vendedor,direccion,usuario_cedula,vendedor_afiliador,grupo) values(33,"Activo","Andres","Galindo",3104456980,"Bogota","Calle 80 #10-74",33,11,1);
insert into vendedores(cedulavendedor,estado_Vendedor,nombre_Vendedor,apellido_Vendedor,celular_Vendedor,ciudad_Vendedor,direccion,usuario_cedula,vendedor_afiliador,grupo) values(44,"Activo","David","Sandoval",3122977455,"Bogota","Calle 1 #93-13",44,22,2);


insert into vendedor_rol(cedulavendedor,idrol) values(11,1);
insert into vendedor_rol(cedulavendedor,idrol) values(22,1);
insert into vendedor_rol(cedulavendedor,idrol) values(33,2);
insert into vendedor_rol(cedulavendedor,idrol) values(44,2);


insert into administradores(cedula_Administrador,nombre_Admin,estado,usuario_cedula) values(5555555555,"Javier Giraldo","Activo",55);
insert into administradores(cedula_Administrador,nombre_Admin,estado,usuario_cedula) values(6666666666,"Ana Muñoz","Activo",66);
insert into administradores(cedula_Administrador,nombre_Admin,estado,usuario_cedula) values(7777777777,"Santiago Almeida","Activo",77);
insert into administradores(cedula_Administrador,nombre_Admin,estado,usuario_cedula) values(8888888888,"Jorge Calderon","Activo",88);