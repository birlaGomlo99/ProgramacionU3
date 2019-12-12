-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.9-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para demo
CREATE DATABASE IF NOT EXISTS `demo` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `demo`;


-- Volcando estructura para tabla demo.personas
CREATE TABLE IF NOT EXISTS `personas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `telefono` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla demo.personas: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` (`id`, `created_at`, `nombre`, `apellido`, `telefono`) VALUES
	(1, NULL, 'juan', 'gomez lopez', 2147483647),
	(2, NULL, 'pedro', 'jhkh', 1234567891),
	(17, NULL, 'Pablo Marmol', 'khgghj', 24681012),
	(18, NULL, 'juan', 'gomez lopez', 2147483647);
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;


-- Volcando estructura para tabla demo.productos
CREATE TABLE IF NOT EXISTS `productos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `lugar` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla demo.productos: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` (`id`, `created_at`, `descripcion`, `nombre`, `lugar`) VALUES
	(6, NULL, 'foco de 100w', 'foco', 'Ocosingo'),
	(7, NULL, 'marca china', 'arduino uno', 'Tuxtla'),
	(8, NULL, 'marca china', 'arduino uno', 'Tuxtla'),
	(9, NULL, 'foco de 100w', 'foco', 'Ocosingo');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;


-- Volcando estructura para tabla demo.proveedores
CREATE TABLE IF NOT EXISTS `proveedores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla demo.proveedores: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` (`id`, `nombre`, `direccion`, `telefono`, `created_at`) VALUES
	(2, 'arimas', 'motozintla', 2147483647, NULL),
	(3, 'arimas', 'motozintla', 2147483647, NULL),
	(4, 'arimas', 'motozintla', 2147483647, NULL),
	(5, 'arimas', 'motozintla', 2147483647, NULL);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;


-- Volcando estructura para procedimiento demo.spproductosearch
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spproductosearch`(IN arg varchar(30))
BEGIN 
    SELECT p.* FROM productos p where p.nombre like concat("%",arg,"%") or descripcion like concat("%",arg,"%");
END//
DELIMITER ;


-- Volcando estructura para tabla demo.trabajadores
CREATE TABLE IF NOT EXISTS `trabajadores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `direccion` varchar(50) NOT NULL DEFAULT '0',
  `turno` varchar(50) NOT NULL DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla demo.trabajadores: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `trabajadores` DISABLE KEYS */;
INSERT INTO `trabajadores` (`id`, `nombre`, `direccion`, `turno`, `created_at`) VALUES
	(1, 'juan', 'ocosingo', 'mañana', NULL),
	(2, 'juan', 'ocosingo', 'mañana', NULL),
	(3, 'juan', 'ocosingo', 'mañana', NULL),
	(4, 'juan', 'ocosingo', 'mañana', NULL);
/*!40000 ALTER TABLE `trabajadores` ENABLE KEYS */;


-- Volcando estructura para tabla demo.ventas
CREATE TABLE IF NOT EXISTS `ventas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `precio` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla demo.ventas: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` (`id`, `created_at`, `nombre`, `descripcion`, `precio`) VALUES
	(1, NULL, 'aceite', 'litros', 'veinte'),
	(2, NULL, 'aceite', 'litros', 'veinte'),
	(3, NULL, 'aceite', 'litros', 'veinte'),
	(4, NULL, 'aceite', 'litros', 'veinte');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
