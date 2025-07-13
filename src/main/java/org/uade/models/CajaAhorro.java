package org.uade.models;

import org.uade.types.TipoOperacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CajaAhorro {
    private float saldo;
    private List<Operacion> listadoOperaciones;

    public CajaAhorro(float saldo) {
        this.saldo = saldo;
        this.listadoOperaciones = new ArrayList<>();
    }

    public void acreditarDinero(float dinero){
        this.saldo += dinero;
    }

    public void debitarDinero(float dinero){
        this.saldo -= dinero;
    }

    public void registrarOperacion(LocalDateTime fecha, TipoOperacion tipo, float monto){
        this.listadoOperaciones.add(new Operacion(fecha, tipo, monto));
    }

    public List<Operacion> listarOperaciones(){
        return this.listadoOperaciones;
    }

    public float getSaldo() {
        return saldo;
    }
}
