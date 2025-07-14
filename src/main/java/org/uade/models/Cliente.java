package org.uade.models;
/*
•	Documento (DNI o pasaporte, clave primaria)
•	Nombre completo (obligatorio)
•	Domicilio legal (obligatorio)
•	Número de cliente (único, numérico, desde 1000)
•	Caja de ahorro (asociada a cada cliente, permite recibir préstamos y pagar cuotas)
 */
public class Cliente {
    private final int nroCliente;
    private final String documento;
    private final String nombreCompleto;
    private String domicilioLegal;
    private CajaAhorro cajaAhorro;

    public Cliente(int nroCliente, String documento, CajaAhorro cajaAhorro, String nombreCompleto, String domicilioLegal) {
        this.nroCliente = nroCliente;
        this.documento = documento;
        this.cajaAhorro = cajaAhorro;
        this.nombreCompleto = nombreCompleto;
        this.domicilioLegal = domicilioLegal;
    }

    public int getNroCliente() {
        return nroCliente;
    }

    public CajaAhorro getCajaAhorro() {
        return cajaAhorro;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDomicilioLegal() {
        return domicilioLegal;
    }
}