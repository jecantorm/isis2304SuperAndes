--RF1
INSERT INTO A_PROVEEDOR (NIT, NOMBRE, CALIFICACION, TIPOPROVEEDOR)
VALUES (100540005,'Proveedor A', 3, 'General')
;


--RF2: 1) Debe existir una sucursal, un almacenamiento de la sucursal, un proveedor y opcionalmente una promoción
INSERT INTO A_PRODUCTO (CODIGO_DE_BARRAS, NOMBRE, MARCA, PRECIO_UNITARIO, VOLUMEN_EMPAQUETADO, PESO, PRECIO_UNIDAD_MEDIDA, CANTIDAD_PRESENTACION, UNIDAD_DE_MEDIDA, PRECIO, CATEGORIA, NIVEL_DE_REORDEN)
VALUES ('6','Raid','Raid',20.5,23,50,2,1,'ml',1000,'De Aseo',50.0)
;

--RF3
INSERT INTO A_CLIENTE (CORREO, NOMBRE,PUNTOS_FIDELIZACION)
VALUES ('js.bravo@uniandes.edu.co','Juan Sebastian',0)

INSERT INTO A_PERSONANATURAL (NUMERO_IDENTIFICACION, TIPO_DOCUMENTO, CORREO_CLIENTE)
VALUES ('1018510315','CC','js.bravo@uniandes.edu.co')



--RF4
INSERT INTO A_LOCAL_VENTAS (ID_LOCALVENTAS)
VALUES (1)
;

INSERT INTO A_SUCURSAL (NOMBRE,DIRECCION,CIUDAD,ID_LOCALVENTAS)
VALUES ('SuperAndes 170', 'Calle 170 #57','Bogotá',1)
;

--RF5

INSERT INTO A_ALMACENAMIENTO
(ID_ALMACENAMIENTO, CATEGORIA, CAPACIDAD_VOLUMEN, CAPACIDAD_PESO, CANTIDAD_PRODUCTOS, SUCURSAL_NOMBRE, SUCURSAL_DIRECCION, SUCURSAL_CIUDAD)
VALUES (1,'Perecederos',500,500,0,'SuperAndes 170', 'Calle 170 #57','Bogotá');

INSERT INTO A_BODEGA
(ID_ALMACENAMIENTO,NOMBRE_BODEGA) VALUES (1,'Bodega_A')
;

--RF6

INSERT INTO A_ALMACENAMIENTO
(ID_ALMACENAMIENTO, CATEGORIA, CAPACIDAD_VOLUMEN, CAPACIDAD_PESO, CANTIDAD_PRODUCTOS, SUCURSAL_NOMBRE, SUCURSAL_DIRECCION, SUCURSAL_CIUDAD)
VALUES (2,'Perecederos',500,500,0,'SuperAndes 170', 'Calle 170 #57','Bogotá');

INSERT INTO A_ESTANTE
(ID_ALMACENAMIENTO,NOMBRE_ESTANTE) VALUES (2,'Estante_B')
;

--RF7

INSERT INTO A_PROMOCION (ID_PROMOCION, NIT_PROVEEDOR, TIPO_PROMOCION, NOMBRE_PROMOCION, CANTIDAD_PRODUCTOS, FECHA_INICIAL, FECHA_FINAL)
  VALUES (1,100000000,'Pague a lleve b','nombre',1000,TO_DATE('17/12/2015', 'DD/MM/YYYY'),TO_DATE('17/12/2015', 'DD/MM/YYYY'))
  ;