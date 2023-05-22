API REST de Gestión de Productos

Esta API REST permite realizar operaciones de gestión de productos, como crear, obtener, actualizar y eliminar productos. Está desarrollada utilizando Java 8 y el framework Spring.
Requisitos

    Java 8
    Maven
    Spring Framework

Configuración

    1.Clona el repositorio en tu máquina local.
    2.Importa el proyecto en tu entorno de desarrollo preferido.
    3.Asegúrate de tener las dependencias de Spring y Maven correctamente configuradas.
    4.Configura la conexión a la base de datos en el archivo de configuración application.properties o application.yml (ya viene una por defecto).

Ejecución

    Compila el proyecto utilizando Maven: mvn clean install.
    Ejecuta la aplicación: mvn spring-boot:run o mediante el IDE que estés utilizando.

La API estará disponible en http://localhost:3001 por defecto. Puedes modificar el puerto en la configuración si es necesario.

La documentación de los endpoints la podes ver desde http://localhost:3001/swagger-ui/index.html
