-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-11-2025 a las 01:08:12
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `grupo10-spa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `nombreCompleto` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `afecciones` text DEFAULT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `dni`, `nombreCompleto`, `telefono`, `edad`, `afecciones`, `estado`) VALUES
(2, '46617010', 'Esteban Redón', '2664552752', 20, 'Rodilla izquierda pa la mielda', 1),
(3, '45563425', 'Yamil Barbeito', '2664688808', 21, '', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dia_de_spa`
--

CREATE TABLE `dia_de_spa` (
  `id` int(11) NOT NULL,
  `fechaHora` datetime NOT NULL,
  `preferencias` text DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  `monto` decimal(10,2) DEFAULT 0.00,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dia_de_spa`
--

INSERT INTO `dia_de_spa` (`id`, `fechaHora`, `preferencias`, `idCliente`, `monto`, `estado`) VALUES
(1, '2025-10-30 16:09:00', '', 3, 0.00, 'Confirmado'),
(2, '2025-10-31 17:38:00', 'Rodilla', 2, 0.00, 'Completado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instalacion`
--

CREATE TABLE `instalacion` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `detalleUso` text DEFAULT NULL,
  `precio30m` decimal(10,2) NOT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `instalacion`
--

INSERT INTO `instalacion` (`id`, `nombre`, `detalleUso`, `precio30m`, `estado`) VALUES
(1, 'Sala de masaje 1', 'Sala con varias camillas para masaje', 37500.00, 0),
(6, 'Sauna', 'Sauna', 35000.00, 1),
(8, 'Jacuzzi', 'Bañera con chorros de agua a presion', 27500.00, 1),
(9, 'Juan', 'Hola', 56.00, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `masajista`
--

CREATE TABLE `masajista` (
  `id` int(11) NOT NULL,
  `nombreCompleto` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `especialidad` varchar(20) NOT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `masajista`
--

INSERT INTO `masajista` (`id`, `nombreCompleto`, `telefono`, `especialidad`, `estado`) VALUES
(2, 'Pepe Argento', '2342342343', 'Relajacion', 1),
(3, 'Pumba', '32342343', 'Corporal', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE `sesion` (
  `id` int(11) NOT NULL,
  `fechaHoraInicio` datetime NOT NULL,
  `fechaHoraFin` datetime NOT NULL,
  `idTratamiento` int(11) DEFAULT NULL,
  `idMasajista` int(11) DEFAULT NULL,
  `idDiaSpa` int(11) NOT NULL,
  `idInstalacion` int(11) NOT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`id`, `fechaHoraInicio`, `fechaHoraFin`, `idTratamiento`, `idMasajista`, `idDiaSpa`, `idInstalacion`, `estado`) VALUES
(2, '2025-10-30 17:08:33', '2025-10-30 17:20:00', 4, 2, 1, 6, 'Completada'),
(4, '2025-10-30 17:39:05', '2025-10-30 17:45:00', 4, 2, 2, 9, 'Reservada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento`
--

CREATE TABLE `tratamiento` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `detalle` text DEFAULT NULL,
  `productos` text DEFAULT NULL,
  `duracion` int(11) NOT NULL COMMENT 'Duración en minutos',
  `costo` decimal(10,2) NOT NULL,
  `estado` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tratamiento`
--

INSERT INTO `tratamiento` (`id`, `nombre`, `tipo`, `detalle`, `productos`, `duracion`, `costo`, `estado`) VALUES
(4, 'Hola', 'Relajacion', 'Epico', 'no', 30, 55555.00, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `dia_de_spa`
--
ALTER TABLE `dia_de_spa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Indices de la tabla `instalacion`
--
ALTER TABLE `instalacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `masajista`
--
ALTER TABLE `masajista`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idTratamiento` (`idTratamiento`),
  ADD KEY `matricula` (`idMasajista`),
  ADD KEY `idPack` (`idDiaSpa`),
  ADD KEY `idInstalacion` (`idInstalacion`);

--
-- Indices de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `dia_de_spa`
--
ALTER TABLE `dia_de_spa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `instalacion`
--
ALTER TABLE `instalacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `masajista`
--
ALTER TABLE `masajista`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `sesion`
--
ALTER TABLE `sesion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dia_de_spa`
--
ALTER TABLE `dia_de_spa`
  ADD CONSTRAINT `dia_de_spa_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`);

--
-- Filtros para la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD CONSTRAINT `sesion_ibfk_1` FOREIGN KEY (`idTratamiento`) REFERENCES `tratamiento` (`id`),
  ADD CONSTRAINT `sesion_ibfk_3` FOREIGN KEY (`idMasajista`) REFERENCES `masajista` (`id`),
  ADD CONSTRAINT `sesion_ibfk_4` FOREIGN KEY (`idDiaSpa`) REFERENCES `dia_de_spa` (`id`),
  ADD CONSTRAINT `sesion_ibfk_5` FOREIGN KEY (`idInstalacion`) REFERENCES `instalacion` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
