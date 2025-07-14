package org.uade.models;

import java.time.LocalDateTime;
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
public abstract class Prestamo {
    protected int nroPrestamo;
    protected int plazoEnMeses;
    protected int nroCliente;
    protected int cuotasRestantes;
    protected LocalDateTime fechaOtorgamiento;
    protected float montoPrestado;
    protected float tasaAnual;
    protected float valorCuota;

    public Prestamo(int nroPrestamo, int plazoEnMeses, int nroCliente, float montoPrestado, float tasaAnual) {
        this.nroPrestamo = nroPrestamo;
        this.plazoEnMeses = plazoEnMeses;
        this.nroCliente = nroCliente;
        this.cuotasRestantes = plazoEnMeses;
        this.fechaOtorgamiento = LocalDateTime.now();
        this.montoPrestado = montoPrestado;
        this.tasaAnual = tasaAnual;
        this.valorCuota = (montoPrestado * (1 + ((tasaAnual * plazoEnMeses) / 12))) / plazoEnMeses;
    }

    public void registrarPagoCuota() {
        if (cuotasRestantes > 0) {
            cuotasRestantes--;
        }
    }

    public int getNroPrestamo() { return nroPrestamo; }
    public int getPlazoEnMeses() { return plazoEnMeses; }
    public int getNroCliente() { return nroCliente; }
    public int getCuotasRestantes() { return cuotasRestantes; }
    public LocalDateTime getFechaOtorgamiento() { return fechaOtorgamiento; }
    public float getMontoPrestado() { return montoPrestado; }
    public float getTasaAnual() { return tasaAnual; }
    public float obtenerValorCuota() { return valorCuota; }
}
