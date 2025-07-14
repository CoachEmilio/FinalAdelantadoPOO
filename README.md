## AdelantadoPOO - Resolución
Este proyecto implementa la gestión de préstamos bancarios siguiendo el enunciado y el diagrama de clases.


Resolución punto por punto
Modelo de clases:
Se crearon las clases Cliente, CajaAhorro, Operacion, Prestamo (abstracta), PrestamoPersonal y PrestamoHipotecario respetando los atributos y métodos del diagrama.


Controladores:
Se implementaron ClienteController y PrestamoController para manejar la lógica de negocio y la relación entre clientes y préstamos.


Registro de operaciones:
Cada vez que se acredita o debita dinero en la caja de ahorro, se registra una operación (Operacion) con fecha, tipo y monto.


Préstamos personales e hipotecarios:
Se pueden registrar ambos tipos de préstamos. El hipotecario requiere un cliente garante.


Pago de cuotas:
Se implementó la funcionalidad para pagar cuotas mensuales, debitando el valor correspondiente de la caja de ahorro y registrando la operación.


Interfaz gráfica:
Se desarrolló una vista sencilla (PagoCuotaView) para registrar el pago de cuotas de préstamo.


Enumeraciones y tipos:
Se utilizó la enumeración TipoOperacion para distinguir entre ingresos y extracciones.


## Cambios realizados hoy
<hr>
Se revisó la lógica de pago de cuotas para asegurar que el saldo de la caja de ahorro quede en cero tras pagar todas las cuotas.
Se ajustó el saldo inicial del cliente para pruebas, calculando el monto total a pagar por el préstamo (suma de las 12 cuotas).
Se verificó que el método de débito en CajaAhorro no permita saldo negativo y que la validación de deuda pendiente funcione correctamente.
Se confirmó que la vista de pago de cuota muestra el saldo actualizado y la cantidad de cuotas restantes.
Se aclaró que el modelo es una simplificación para pruebas y simulaciones, pero respeta la lógica bancaria básica.
<hr>

Notas
El sistema respeta las relaciones y multiplicidades del diagrama.
Se siguió el sistema francés para el cálculo de cuotas.
El código está organizado por paquetes y usa Maven para la gestión del proyecto.

Cualquier duda o consulta, estoy a disposición.