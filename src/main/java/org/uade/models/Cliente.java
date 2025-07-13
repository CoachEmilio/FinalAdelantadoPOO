package org.uade.models;

/*
•	Documento (DNI o pasaporte, clave primaria)
•	Nombre completo (obligatorio)
•	Domicilio legal (obligatorio)
•	Número de cliente (único, numérico, desde 1000)
•	Caja de ahorro (asociada a cada cliente, permite recibir préstamos y pagar cuotas)
 */
public class Cliente {
    private final int nroCliente; // Número de cliente, único y numérico, desde 1000
    private int dni; // Documento (DNI o pasaporte), clave primaria
    private final String NombreCompleto; // Nombre completo, obligatorio
    private String DomicilioLegal; // Domicilio legal, obligatorio
    private CajaAhorro cajaAhorro; // Caja de ahorro asociada al cliente


    public Cliente(int nroCliente, CajaAhorro ca, String juanPerez, String domicilioLegal) {
        this.nroCliente = nroCliente;
        this.cajaAhorro = ca;
        this.NombreCompleto = juanPerez;
        this.DomicilioLegal = domicilioLegal;
    }

    public int getNroCliente() {
        return nroCliente;
    }

    public CajaAhorro getCajaAhorro() {
        return cajaAhorro;
    }
}
