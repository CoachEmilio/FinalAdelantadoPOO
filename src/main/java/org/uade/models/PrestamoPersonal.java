package org.uade.models;

import org.uade.models.Prestamo;

public class PrestamoPersonal extends Prestamo{

    public PrestamoPersonal(int nroPrestamo, int plazoEnMeses, int nroCliente, float montoPrestado, float tasaAnual) {
        super(nroPrestamo, plazoEnMeses, nroCliente, montoPrestado, tasaAnual);
    }
}