-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2025 a las 00:51:05
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

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
(1, '45563425', 'Barbeito Yamil', '2664688808', 21, 'Dolor de muñeca por programar', 1),
(2, '46617010', 'Redon Esteban', '2664552752', 20, 'Lesión crónica de rodilla izquierda', 1),
(3, '44123456', 'Blanco Atahualpa', '2664123456', 22, 'Estrés por merge conflicts', 1),
(4, '10123456', 'Lionel Messi', '2664100001', 37, 'Desgaste muscular', 1),
(5, '05234567', 'Diego Maradona', '2664100002', 64, 'Rodilla izquierda', 0),
(6, '20345678', 'Pepe Argento', '2664100003', 58, 'Dolor de espalda por vender zapatos', 1),
(7, '18456789', 'Moni Argento', '2664100004', 55, 'Ninguna', 1),
(8, '25567890', 'Paola Argento', '2664100005', 28, 'Contractura por hacer yoga', 1),
(9, '30678901', 'Ricardo Fort', '2664100006', 45, 'Ninguna', 1),
(10, '32789012', 'María González', '2664200001', 34, 'Lumbalgia crónica', 1),
(11, '28890123', 'Carlos Rodríguez', '2664200002', 42, 'Estrés laboral', 1),
(12, '35901234', 'Ana Martínez', '2664200003', 29, 'Ninguna', 1),
(13, '40012345', 'Roberto Sánchez', '2664200004', 51, 'Artritis', 1),
(14, '33123456', 'Laura Fernández', '2664200005', 38, 'Migraña', 1),
(15, '29234567', 'Jorge López', '2664200006', 45, 'Ninguna', 1);

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
(1, '2025-11-19 10:00:00', 'Masaje suave, sin presión fuerte', 1, 254000.00, 'Completado'),
(2, '2025-11-19 14:30:00', 'Necesito relajarme después del parcial', 2, 113000.00, 'Completado'),
(3, '2025-11-19 11:00:00', 'Primera vez en un spa', 3, 70000.00, 'Completado'),
(4, '2024-10-28 16:00:00', 'Quiero la experiencia completa', 4, 207000.00, 'Completado'),
(5, '2025-11-19 09:30:00', 'Solo masaje relajante', 6, 57000.00, 'Completado'),
(6, '2024-11-10 10:00:00', 'Tratamiento facial y corporal', 7, 121000.00, 'Confirmado'),
(7, '2024-11-12 15:00:00', 'Masaje deportivo', 8, 113000.00, 'Confirmado'),
(8, '2025-11-19 11:30:00', 'Spa day completo', 9, 192000.00, 'Confirmado'),
(9, '2025-11-19 14:00:00', 'Relajación total', 10, 114000.00, 'Confirmado'),
(10, '2025-11-20 10:30:00', 'Tratamiento anti-estrés', 11, 125000.00, 'Confirmado'),
(11, '2024-11-25 13:00:00', 'Consultar disponibilidad de masajista', 12, 0.00, 'Pendiente'),
(12, '2025-11-20 16:30:00', 'Quiero probar las piedras calientes', 13, 0.00, 'Pendiente');

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
(1, 'Sala Boca', 'Sala premium decorada en azul y oro', 45000.00, 1),
(2, 'Sala River', 'Sala VIP con vista panorámica', 45000.00, 1),
(3, 'Sauna Finlandesa', 'Sauna de alta temperatura, ideal para relajación', 35000.00, 1),
(4, 'Jacuzzi Imperial', 'Bañera hidromasaje con cromoterapia', 40000.00, 1),
(5, 'Sala de Masajes Zen', 'Ambiente tranquilo con aromaterapia', 32000.00, 1),
(6, 'Piscina Climatizada', 'Piscina temperada con jets de agua', 38000.00, 1),
(7, 'Sala de Piedras Calientes', 'Terapia con piedras volcánicas', 35000.00, 1),
(8, 'Cabina de Vapor', 'Vapor eucalipto para vías respiratorias', 28000.00, 1),
(9, 'Sala Patagonia', 'Ambiente rústico estilo patagónico', 30000.00, 0),
(10, 'Gimnasio Wellness', 'Espacio para ejercicios de relajación', 25000.00, 1);

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
(1, 'Susana Giménez', '2664300001', 'Facial', 1),
(2, 'Mirtha Legrand', '2664300002', 'Relajacion', 1),
(3, 'Pepe Argento', '2664300003', 'Corporal', 1),
(4, 'Moria Casán', '2664300004', 'Estetico', 1),
(5, 'Flor Peña', '2664300005', 'Corporal', 1),
(6, 'Tinelli Marcelo', '2664300006', 'Relajacion', 0),
(7, 'Claudia Villafañe', '2664300007', 'Facial', 1),
(8, 'Valeria Mazza', '2664300008', 'Corporal', 1);

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
(1, '2025-11-19 10:00:00', '2025-11-19 11:00:00', 1, 2, 1, 5, 'Completada'),
(2, '2025-11-19 11:15:00', '2025-11-19 11:55:00', 4, 7, 1, 7, 'Completada'),
(3, '2025-11-19 14:30:00', '2025-11-19 15:15:00', 1, 3, 2, 1, 'Completada'),
(4, '2025-11-19 15:30:00', '2025-11-19 16:00:00', 7, 2, 2, 8, 'Completada'),
(5, '2025-11-19 11:00:00', '2025-11-19 11:45:00', 1, 5, 3, 2, 'Completada'),
(6, '2025-10-28 16:00:00', '2025-10-28 17:00:00', 1, 8, 4, 2, 'Completada'),
(7, '2025-10-28 17:15:00', '2025-10-28 18:10:00', 9, 4, 4, 3, 'Completada'),
(8, '2025-11-19 09:30:00', '2025-11-19 10:30:00', 1, 2, 5, 5, 'Completada'),
(9, '2025-11-11 10:00:00', '2025-11-11 10:40:00', 4, 7, 6, 5, 'Reservada'),
(10, '2025-11-11 11:00:00', '2025-11-11 11:55:00', 9, 4, 6, 7, 'Reservada'),
(11, '2025-11-12 15:00:00', '2025-11-12 15:45:00', 1, 5, 7, 2, 'Reservada'),
(12, '2025-11-12 16:00:00', '2025-11-12 16:25:00', 7, 8, 7, 8, 'Reservada'),
(13, '2025-11-19 11:30:00', '2025-11-19 12:30:00', 1, 2, 8, 5, 'Reservada'),
(14, '2025-11-19 12:45:00', '2025-11-19 13:30:00', 1, 3, 8, 1, 'Reservada'),
(15, '2025-11-19 13:45:00', '2025-11-19 14:35:00', 5, 4, 8, 3, 'Reservada'),
(16, '2025-11-18 14:00:00', '2025-11-18 15:00:00', 1, 8, 9, 5, 'Reservada'),
(17, '2025-11-18 15:15:00', '2025-11-18 15:55:00', 4, 7, 9, 7, 'Reservada'),
(18, '2025-11-20 10:30:00', '2025-11-20 11:20:00', 5, 4, 10, 3, 'Reservada'),
(19, '2025-11-20 11:35:00', '2025-11-20 12:10:00', 6, 5, 10, 4, 'Reservada'),
(20, '2025-11-17 19:06:51', '2025-11-17 20:06:00', 1, 1, 4, 1, 'Completada'),
(21, '2025-11-17 19:07:16', '2025-11-17 20:07:00', 1, 1, 1, 1, 'Completada');

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
(1, 'Masaje Relajante Pampeano', 'Relajacion', 'Masaje suave con técnicas de la pampa húmeda', 'Aceite de lavanda, crema hidratante', 60, 25000.00, 1),
(2, 'Masaje Deportivo Mundialista', 'Corporal', '45', 'Gel frío-calor, aceite de árnica', 45, 28000.00, 0),
(3, 'Exfoliación Dulce de Leche', 'Corporal', 'Exfoliación corporal con productos naturales', 'Exfoliante de azúcar, crema corporal', 30, 18000.00, 1),
(4, 'Facial Anti-Stress Developer', 'Facial', 'Limpieza profunda para eliminar el cansancio', 'Crema facial, mascarilla de arcilla', 40, 22000.00, 1),
(5, 'Terapia con Piedras Calientes', 'Estetico', '50', 'Aceite esencial, piedras calientes', 50, 30000.00, 1),
(6, 'Hidratación Profunda Patagónica', 'Corporal', 'Tratamiento hidratante con productos de la Patagonia', 'Crema de rosa mosqueta, aceite de caléndula', 35, 20000.00, 1),
(7, 'Masaje de Cabeza Estilo Camba', 'Relajacion', 'Masaje craneal para aliviar tensiones', 'Aceite de coco, bálsamo mentolado', 25, 15000.00, 1),
(8, 'Reflexología Argentina', 'Relajacion', 'Masaje en puntos reflejos de pies y manos', 'Crema para masajes, piedras de río', 40, 23000.00, 1),
(9, 'Envoltura de Barro Andino', 'Corporal', 'Envoltura desintoxicante con barro de los Andes', 'Barro volcánico, aceites esenciales', 55, 32000.00, 1),
(10, 'Drenaje Linfático Porteño', 'Corporal', 'Técnica para reducir retención de líquidos', 'Gel drenante, vendas frías', 45, 27000.00, 1);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `dia_de_spa`
--
ALTER TABLE `dia_de_spa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `instalacion`
--
ALTER TABLE `instalacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `masajista`
--
ALTER TABLE `masajista`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `sesion`
--
ALTER TABLE `sesion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

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
  ADD CONSTRAINT `sesion_ibfk_1` FOREIGN KEY (`idTratamiento`) REFERENCES `tratamiento` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sesion_ibfk_3` FOREIGN KEY (`idMasajista`) REFERENCES `masajista` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sesion_ibfk_4` FOREIGN KEY (`idDiaSpa`) REFERENCES `dia_de_spa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sesion_ibfk_5` FOREIGN KEY (`idInstalacion`) REFERENCES `instalacion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
