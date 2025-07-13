package org.uade.models;

import org.uade.models.Prestamo;

public class PrestamoHipotecario extends Prestamo {
    private int nroClienteGarante;

    public PrestamoHipotecario(int nroPrestamo, int plazoEnMeses, int nroCliente, float montoPrestado, float tasaAnual, int nroClienteGarante) {
        super(nroPrestamo, plazoEnMeses, nroCliente, montoPrestado, tasaAnual);
        this.nroClienteGarante = nroClienteGarante;
    }

    public int getNroClienteGarante() {
        return nroClienteGarante;
    }

    public void modificarTasaAnual(float tasaAnual) {
        this.tasaAnual = tasaAnual;
    }
}