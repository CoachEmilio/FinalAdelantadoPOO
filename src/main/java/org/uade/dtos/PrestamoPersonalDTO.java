package org.uade.dtos;

public class PrestamoPersonalDTO {
    private int nroCliente;
    private float montoPrestado;
    private int plazoEnMeses;

    public PrestamoPersonalDTO(int nroCliente, float montoPrestado, int plazoEnMeses) {
        this.nroCliente = nroCliente;
        this.montoPrestado = montoPrestado;
        this.plazoEnMeses = plazoEnMeses;
    }

    public int getNroCliente() {
        return nroCliente;
    }
    public float getMontoPrestado() {
        return montoPrestado;
    }
    public int getPlazoEnMeses() {
        return plazoEnMeses;
    }
}
