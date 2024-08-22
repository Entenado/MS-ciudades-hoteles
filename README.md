Aplicación de Microservicios para Gestión de Hoteles
Descripción
Esta aplicación gestiona operaciones de hoteles, como reservas de habitaciones, administración de huéspedes, procesamiento de pagos y seguimiento de estadías.
Está construida con una arquitectura de microservicios, permitiendo que cada servicio se desarrolle y despliegue de manera independiente.

Arquitectura
La aplicación consta de varios microservicios, cada uno con una responsabilidad específica:

Eureka Server: Registro de servicios y descubrimiento.
Servicio de Reservas: Gestiona las reservas de habitaciones.
Servicio de Huéspedes: Maneja la información de los huéspedes.
Servicio de Estadías: Monitorea la duración de las estadías y asignación de habitaciones.

Tecnologías Utilizadas
Java & Spring Boot: Backend.
Spring Cloud: Eureka, API Gateway.
MySQL: Base de datos.
Docker & Docker Compose: Contenerización y orquestación.




