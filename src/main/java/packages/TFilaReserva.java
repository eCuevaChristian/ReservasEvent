package packages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TFilaReserva {

    private List<FilaReserva> reservas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int ultimoID = 0;

    public void metCrearReserva() {
        String _TexNombreCliente;
        do {
            _TexNombreCliente = JOptionPane.showInputDialog("Nombre del Cliente:");
            if (_TexNombreCliente == null || _TexNombreCliente.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nombre inválido. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (_TexNombreCliente == null || _TexNombreCliente.trim().isEmpty());

        int _SenDia, _SenMes, _SenAnio, _SenHora, _SenMinuto;
        LocalDateTime _DatFechaReserva= null;
        LocalDateTime _DatFechaActual = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        boolean bolFechaValida = false;

        do {
            try {
                _SenAnio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de la reserva (YYYY):"));
                _SenMes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de la reserva (MM):"));
                _SenDia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de la reserva (DD):"));
                _SenHora = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la hora de la reserva (HH):"));
                _SenMinuto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los minutos de la reserva (mm):"));

                _DatFechaReserva = LocalDateTime.of(_SenAnio, _SenMes, _SenDia, _SenHora, _SenMinuto);

                if (_DatFechaReserva.isBefore(_DatFechaActual)) {
                    JOptionPane.showMessageDialog(null, "La fecha no puede ser pasada.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (fuxFechaReservada(_DatFechaReserva)) {
                    JOptionPane.showMessageDialog(null, "Ya existe una reserva en esta fecha y hora. Intente otra.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    bolFechaValida = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Fecha inválida. Ingrese los valores correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!bolFechaValida);

        int _SendCapacidad;
        do {
            try {
                _SendCapacidad = Integer.parseInt(JOptionPane.showInputDialog("Capacidad de Personas:"));
                if (_SendCapacidad <= 0) {
                    JOptionPane.showMessageDialog(null, "La capacidad debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                _SendCapacidad = -1;
                JOptionPane.showMessageDialog(null, "Ingrese un número válido para la capacidad.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (_SendCapacidad <= 0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        reservas.add(new FilaReserva(++ultimoID, _TexNombreCliente, _DatFechaReserva.format(formatter), _SendCapacidad));
        System.out.println("Reserva creada con éxito.");
    }

    public boolean fuxFechaReservada(LocalDateTime fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fechaFormateada = fecha.format(formatter);

        for (FilaReserva reserva : reservas) {
            if (reserva.get_DatFechaReserva().equals(fechaFormateada)) {
                return true;
            }
        }
        return false;
    }

    public void metMostrarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }
        System.out.println("\nLista de Reservas");
        System.out.println("ID   | Cliente    | Fecha y Hora         | Personas | Estado    ");
        System.out.println("------------------------------------------------------------");
        for (FilaReserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    public void metConfirmarReserva() {
        System.out.print("Ingrese el ID de la reserva a confirmar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (FilaReserva reserva : reservas) {
            if (reserva.get_SendId() == id) {
                if (reserva.get_TexEstado().equals("Pendiente")) {
                    reserva.set_TexEstado("Confirmada");
                    System.out.println("Reserva confirmada.");
                } else {
                    JOptionPane.showMessageDialog(null, "La reserva ya esta " + reserva.get_TexEstado(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Reserva no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void metCancelarReserva() {
        System.out.print("Ingrese el ID de la reserva a cancelar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (FilaReserva reserva : reservas) {
            if (reserva.get_SendId() == id) {
                reserva.set_TexEstado("Cancelada");
                JOptionPane.showMessageDialog(null, "Reserva cancelada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Reserva no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
