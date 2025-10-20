-- Crear BD si no existe y usarla
CREATE DATABASE IF NOT EXISTS `DI`
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci;
USE `DI`;

-- Tabla usuarios
-- Añadimos id como PK auto-inc por buenas prácticas.
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre`     VARCHAR(100)  NOT NULL,
  `apellidos`  VARCHAR(150)  NOT NULL,
  `curso`      VARCHAR(50)   NOT NULL,
  `fecha_alta` DATE          NOT NULL DEFAULT (CURRENT_DATE),
  PRIMARY KEY (`id`),
  KEY `idx_apellidos` (`apellidos`),
  KEY `idx_curso` (`curso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Los grants para el usuario de aplicación (creado por variables de entorno)
-- Nota: el entrypoint crea el usuario ${MYSQL_USER}; aquí aseguramos privilegios.
-- Si el usuario ya existe, el GRANT funciona igual.
GRANT ALL PRIVILEGES ON `DI`.* TO 'di_user'@'%';
FLUSH PRIVILEGES;
-- Fin del script