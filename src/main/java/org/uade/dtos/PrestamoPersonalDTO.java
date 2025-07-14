package org.uade.dtos;

public class PrestamoPersonalDTO {
    private int nroCliente;
    private float saldoActual;
    private int cuotasRestantes;
    private int plazoEnMeses; // <-- Agregar este atributo
    private float montoPrestado; // Opcional si lo usas en el controller

    public PrestamoPersonalDTO(int nroCliente, float saldoActual, int cuotasRestantes, int plazoEnMeses, float montoPrestado) {
        this.nroCliente = nroCliente;
        this.saldoActual = saldoActual;
        this.cuotasRestantes = cuotasRestantes;
        this.plazoEnMeses = plazoEnMeses;
        this.montoPrestado = montoPrestado;
    }

    public int getNroCliente() { return nroCliente; }
    public float getSaldoActual() { return saldoActual; }
    public int getCuotasRestantes() { return cuotasRestantes; }
    public int getPlazoEnMeses() { return plazoEnMeses; }
    public float getMontoPrestado() { return montoPrestado; }
}