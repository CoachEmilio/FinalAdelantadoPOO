package org.uade.models;

/*
•Todos los préstamos comparten:
-Número único.
-Fecha de otorgamiento.
-Monto solicitado.
-Plazo en meses.
-Tasa anual.
-Cliente solicitante.
-Las cuotas se calculan según sistema francés (cuota fija mensual) y se debitan automáticamente.
*/

import java.time.LocalDateTime;

public abstract class Prestamo {
    protected int nroPrestamo; // Número único del préstamo
    protected int plazoEnMeses; // Plazo en meses del préstamo
    protected int nroCliente; // Número de cliente solicitante
    protected int cuotasRestantes; // Cuotas restantes del préstamo
    protected LocalDateTime fechaOtorgamiento; // Fecha de otorgamiento del préstamo
    protected float montoPrestado; // Monto solicitado del préstamo
    protected float tasaAnual; // Tasa anual del préstamo
    protected float valorCuota; // Valor de la cuota fija mensual

    public Prestamo(int nroPrestamo, int plazoEnMeses, int nroCliente, float montoPrestado, float tasaAnual) {
        this.nroPrestamo = nroPrestamo;
        this.plazoEnMeses = plazoEnMeses;
        this.nroCliente = nroCliente;
        this.cuotasRestantes = 12;
        this.fechaOtorgamiento = LocalDateTime.now();
        this.montoPrestado = montoPrestado;
        this.tasaAnual = tasaAnual;
        this.valorCuota = (montoPrestado* (1+((tasaAnual*plazoEnMeses)/12))) /12;
    }

    public void setNroPrestamo(int nroPrestamo) {
        this.nroPrestamo = nroPrestamo;
    }

    public int getNroPrestamo() {
        return nroPrestamo;
    }

    public int getPlazoEnMeses() {
        return plazoEnMeses;
    }

    public int getNroCliente() {
        return nroCliente;
    }

    public int getCuotasRestantes() {
        return cuotasRestantes;
    }

    public LocalDateTime getFechaOtorgamiento() {
        return fechaOtorgamiento;
    }

    public float getMontoPrestado() {
        return montoPrestado;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }

    public float obtenerValorCuota() {
        return valorCuota;
    }
}
