# ReservasEvent

programa de reservas echo en JAVA

Se debe desarrollar un sistema de gestión de reservas para un único salón de eventos.
Cada reserva tiene la siguiente información:

1. Requerimientos Funcionales y de Negocio
Modelo Reserva
Propiedad    		Tipo    	Descripción
_SenID    		Integer    	Identificador único de la reserva.
_TexNombreCliente    	String    	Nombre del cliente que hace la reserva.
_DatFechaReserva    	DateTime    	Fecha y hora en que se desea la reserva.
_SenCapacidad    	Integer    	Número de personas para la reserva.
_TexEstado    		String    	Puede ser “Pendiente”, “Confirmada” o “Cancelada”.

Reglas de Negocio
No se pueden crear dos reservas para la misma fecha y hora.
(Solo hay un salón disponible, así que no puede haber dos reservas simultáneas).
La capacidad debe ser mayor que 0.
(No se permiten reservas para 0 personas).
El estado de la reserva es "Pendiente" por defecto.
(Solo puede cambiarse a "Confirmada" si se edita la reserva manualmente).
No se pueden crear o actualizar reservas en una fecha pasada.
(Si la fecha ya pasó, se debe rechazar con un error).

2. Requerimientos Técnicos
El sistema debe contar con:

Una clase FilaReserva que represente una reserva individual.
Una clase TFilaReserva que gestione todas las reservas en memoria y aplique las reglas de negocio.
Un simulador de API (métodos en consola) que permita realizar operaciones CRUD.

3. Implementación
📌 Requisitos específicos para el código:

Aplicar POO correctamente (encapsulación, clases bien diseñadas, métodos organizados).
Usar persistencia en memoria con una lista de reservas (List(Of FilaReserva)).
Aplicar nomenclatura estructurada:
_Sen para enteros (_SenID, _SenCapacidad).
_Tex para strings (_TexNombreCliente, _TexEstado).
_Dat para fechas (_DatFechaReserva).
met para métodos (metActualizarReserva, metEliminarReserva).
fux para funciones (fuxObtenerReservas).