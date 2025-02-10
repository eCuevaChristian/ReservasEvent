package packages;

public class FilaReserva {

    private int _SendId;
    private String _TexNombreCliente;
    private String _DatFechaReserva;
    private int _SenCapacidad;
    private String _TexEstado;

    public FilaReserva(int id, String nombre, String fecha, int capacidad) {
        this._SendId = id;
        this._TexNombreCliente = nombre;
        this._DatFechaReserva = fecha;
        this._SenCapacidad = capacidad;
        this._TexEstado = "Pendiente";
    }

    public int get_SendId() {
        return _SendId;
    }

    public String get_TexNombreCliente() {
        return _TexNombreCliente;
    }

    public String get_DatFechaReserva() {
        return _DatFechaReserva;
    }

    public int get_SenCapacidad() {
        return _SenCapacidad;
    }

    public String get_TexEstado() {
        return _TexEstado;
    }

    
    public void set_TexEstado(String estado) {
        this._TexEstado = estado;
    }

    @Override
    public String toString() {
        return String.format("%-4d | %-10s | %-19s | %-8d | %-10s",
                _SendId, _TexNombreCliente, _DatFechaReserva, _SenCapacidad, _TexEstado);
    }
}
