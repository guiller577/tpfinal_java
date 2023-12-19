-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 19-12-2023 a las 15:09:11
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tp_final_java_cac`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oradores`
--

CREATE TABLE `oradores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(55) NOT NULL,
  `apellido` varchar(55) NOT NULL,
  `tema` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `oradores`
--

INSERT INTO `oradores` (`id`, `nombre`, `apellido`, `tema`) VALUES
(1, 'Laura', 'González', 'Introducción a la Programación en Python'),
(2, 'Juan', 'Martínez', 'Desarrollo Web Moderno con JavaScript'),
(3, 'Sofía', 'Ramírez', 'Inteligencia Artificial y Machine Learning'),
(4, 'Carlos', 'Fernández', 'Seguridad Informática en Aplicaciones Web'),
(5, 'Ana', 'López', 'Aplicaciones Móviles con Flutter'),
(6, 'Elena', 'Ruiz', 'Tendencias en Desarrollo Front-End en 2023'),
(7, 'Miguel', 'Torres', 'Introducción a los Microservicios'),
(8, 'Patricia', 'Sánchez', 'Big Data y Análisis de Datos con Python'),
(9, 'Alejandro', 'García', 'Desarrollo de Videojuegos con Unity'),
(10, 'Fernanda', 'Díaz', 'Blockchain y Criptomonedas: Una Visión General'),
(11, 'Roberto', 'Alonso', 'Kotlin vs Java: El Futuro del Desarrollo de Apps en Android'),
(12, 'Carmen', 'Vargas', 'Inteligencia Artificial Aplicada en la Salud'),
(13, 'Luis', 'Molina', 'Arquitecturas Serverless: Ventajas y Desafíos'),
(14, 'Rosa', 'Martín', 'IoT y Smart Cities: Conectando el Mundo Real con el Digital'),
(15, 'Jorge', 'Navarro', 'DevOps y la Automatización de Procesos en la Nube');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `oradores`
--
ALTER TABLE `oradores`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `oradores`
--
ALTER TABLE `oradores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
