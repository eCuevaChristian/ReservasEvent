package packages;

import javax.swing.JOptionPane;
public class Principal {

    public static void main(String[] args) {
        TFilaReserva sistema = new TFilaReserva();
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU DE RESERVAS\n"
                    + "1: Crear Reserva\n"
                    + "2: Mostrar Reservas\n"
                    + "3: Confirmar Reserva\n"
                    + "4: Cancelar Reserva\n"
                    + "5: Salir\n"
                    + "Elige una opción: "
            ));

            switch (opcion) {
                case 1 ->
                    sistema.metCrearReserva();
                case 2 ->
                    sistema.metMostrarReservas();
                case 3 ->
                    sistema.metConfirmarReserva();
                case 4 ->
                    sistema.metCancelarReserva();
                case 5 ->
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                default ->
                    JOptionPane.showMessageDialog(null, "Opción inválida. Inténtalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 5);
    }
}
