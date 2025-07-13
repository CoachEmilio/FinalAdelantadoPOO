package org.uade.models;

import org.uade.types.TipoOperacion;
import java.time.LocalDateTime;

public class Operacion {
    private LocalDateTime fecha; // Fecha de la operación
    private TipoOperacion tipo; // Tipo de operación (ingreso o extracción)
    private float monto; // Monto de la operación

    public Operacion(LocalDateTime fecha, TipoOperacion tipo, float monto) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public TipoOperacion getTipo() {
        return tipo;
    }

    public float getMonto() {
        return monto;
    }
}
