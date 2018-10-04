--- Sentencias SQL para la creación del esquema de superAndes
--- Las tablas tienen prefijo A_ para facilitar su acceso desde SQL Developer

-- Creación del secuenciador
create sequence superAndes_sequence;

-- Creación de la tabla A_PRODUCTO
CREATE TABLE A_PRODUCTO
(
  CODIGO_DE_BARRAS VARCHAR(30),
	ID_PROMOCION INTEGER,
  NOMBRE VARCHAR(30) NOT NULL,
  MARCA VARCHAR(30) NOT NULL,
  PRECIO_UNITARIO NUMBER(20,2) NOT NULL,
  VOLUMEN_EMPAQUETADO NUMBER(20,2) NOT NULL,
  PESO NUMBER(20,2) NOT NULL,
  PRECIO_UNIDAD_MEDIDA NUMBER(20,2) NOT NULL,
  CANTIDAD_PRESENTACION INTEGER NOT NULL,
  UNIDAD_DE_MEDIDA VARCHAR(30) NOT NULL,
  PRECIO NUMBER(20,2) NOT NULL,
  CATEGORIA VARCHAR(30) NOT NULL,
  NIVEL_DE_REORDEN NUMBER(20,2) NOT NULL,
  NUMERO_FACTURA INTEGER,
  ID_ALMACENAMIENTO INTEGER,
  NIT_PROVEEDOR INTEGER NOT NULL
);

-- Creación de la tabla A_PROMOCION.
CREATE TABLE A_PROMOCION
(
  ID_PROMOCION INTEGER,
	NIT_PROVEEDOR INTEGER NOT NULL,
	TIPO_PROMOCION VARCHAR(30) NOT NULL,
  NOMBRE_PROMOCION VARCHAR(30) NOT NULL,
  CANTIDAD_PRODUCTOS INTEGER NOT NULL,
  FECHA_INICIAL DATE NOT NULL,
  FECHA_FINAL DATE NOT NULL,
  DISPONIBLE NUMBER(1) NOT NULL
);

-- Creación de la tabla A_PROVEEDOR
CREATE TABLE A_PROVEEDOR
(
  NIT INTEGER,
	NOMBRE VARCHAR(30),
	CALIFICACION INTEGER,
	TIPOPROVEEDOR VARCHAR(30)
);

-- Creación de la tabla A_PEDIDO
CREATE TABLE A_PEDIDO
(
  NUMERO_PEDIDO INTEGER,
	NIT_PROVEEDOR INTEGER NOT NULL,
	NOMBRE_SUCURSAL VARCHAR(30) NOT NULL,
	DIRECCION_SUCURSAL VARCHAR(30) NOT NULL,
  CIUDAD_SUCURSAL VARCHAR(30) NOT NULL,
  CODIGO_DE_BARRAS_PRODUCTO VARCHAR(30) NOT NULL,
  FECHA_ENTREGA DATE,
  CALIDAD VARCHAR(30),
  CALIFICACION INTEGER,
  PRECIO NUMBER(20,2),
  CANTIDAD_VOLUMEN INTEGER
  );

-- Creación de la tabla A_SUCURSAL
CREATE TABLE A_SUCURSAL
(
  NOMBRE VARCHAR(30),
  DIRECCION VARCHAR(30),
  CIUDAD VARCHAR(30),
  ID_LOCALVENTAS INTEGER
);

-- Creación de la tabla A_LOCAL_VENTAS
CREATE TABLE A_LOCAL_VENTAS
(
  ID_LOCALVENTAS INTEGER,
  INGRESOS INTEGER
);


-- Creación de la tabla A_ALMACENAMIENTO
CREATE TABLE A_ALMACENAMIENTO
(
  ID_ALMACENAMIENTO INTEGER,
  CATEGORIA VARCHAR(30) NOT NULL,
  CAPACIDAD_VOLUMEN NUMBER(20,2) NOT NULL,
  CAPACIDAD_PESO NUMBER(20,2) NOT NULL,
  CANTIDAD_PRODUCTOS INTEGER NOT NULL,
  SUCURSAL_NOMBRE VARCHAR(30) NOT NULL,
  SUCURSAL_DIRECCION VARCHAR(30) NOT NULL,
  SUCURSAL_CIUDAD VARCHAR(30) NOT NULL
);

-- Creación de la tabla A_BODEGA
CREATE TABLE A_BODEGA
(
  ID_ALMACENAMIENTO INTEGER NOT NULL,
  NOMBRE_BODEGA VARCHAR(30)
);

-- Creación de la tabla A_ESTANTE
CREATE TABLE A_ESTANTE
(
  ID_ALMACENAMIENTO INTEGER NOT NULL,
  NOMBRE_ESTANTE VARCHAR(30),
  TIPO_ESTANTE VARCHAR(30) NOT NULL,
  NIVEL_ABASTECIMIENTO NUMBER(20,2) NOT NULL
);

-- Creación de la tabla A_FACTURA
CREATE TABLE A_FACTURA
(
  NUMERO_FACTURA INTEGER,
  FECHA_COMPRA DATE NOT NULL,
  VALOR_BASE NUMBER(20,2) NOT NULL,
  DESCUENTO NUMBER(20,2) NOT NULL,
  IVA NUMBER(20,2) NOT NULL,
  VALOR_TOTAL NUMBER(20,2) NOT NULL,
  SUCURSAL_NOMBRE VARCHAR(30) NOT NULL,
  SUCURSAL_DIRECCION VARCHAR(30) NOT NULL,
  SUCURSAL_CIUDAD VARCHAR(30) NOT NULL,
  CORREO_CLIENTE VARCHAR(30) NOT NULL
);
-- Creación de la tabla A_CLIENTE
CREATE TABLE A_CLIENTE
(
  CORREO VARCHAR(30),
  NOMBRE VARCHAR(30) NOT NULL,
  PUNTOS_FIDELIZACION INTEGER
);
-- Creación de la tabla A_EMPRESA
CREATE TABLE A_EMPRESA
(
  NIT INTEGER,
  DIRECCION VARCHAR(30) NOT NULL,
  CORREO_CLIENTE VARCHAR(30) NOT NULL
);
-- Creación de la tabla A_PERSONANATURAL
CREATE TABLE A_PERSONANATURAL
(
  TIPO_DOCUMENTO VARCHAR(2),
  NUMERO_IDENTIFICACION VARCHAR(15),
  CORREO_CLIENTE VARCHAR(30) NOT NULL
);

-- Creación de la tabla A_FACTURA_PRODUCTO
CREATE TABLE A_FACTURA_PRODUCTO
(
  NUMERO_FACTURA INTEGER,
  CODIGO_DE_BARRAS VARCHAR(30),
  CANTIDAD INTEGER NOT NULL
);
