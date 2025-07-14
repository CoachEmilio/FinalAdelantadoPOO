package org.uade.dtos;

public class ClienteDTO {
    private int nroCliente;
    private String documento;
    private String nombreCompleto;
    private String domicilioLegal;

    public ClienteDTO(int nroCliente, String documento, String nombreCompleto, String domicilioLegal) {
        this.nroCliente = nroCliente;
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
        this.domicilioLegal = domicilioLegal;
    }

    public int getNroCliente() { return nroCliente; }
    public String getDocumento() { return documento; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getDomicilioLegal() { return domicilioLegal; }
}