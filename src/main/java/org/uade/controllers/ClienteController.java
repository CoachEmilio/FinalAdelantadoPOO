package org.uade.controllers;

import org.uade.models.Cliente;
import org.uade.models.CajaAhorro;
import org.uade.models.Operacion;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> listadoClientes;
    private static ClienteController instance = null;

    private ClienteController() {
        this.listadoClientes = new ArrayList<>();
        CajaAhorro ca = new CajaAhorro(2000000);
        Cliente c = new Cliente(1001, "12345678", ca, "Juan Perez", "Calle Falsa 123");
        listadoClientes.add(c);
    }

    public static synchronized ClienteController getInstance() {
        if (instance == null) {
            instance = new ClienteController();
        }
        return instance;
    }

    public Cliente buscarClientePorNro(int nroCliente) {
        for (Cliente cliente : listadoClientes) {
            if (cliente.getNroCliente() == nroCliente) {
                return cliente;
            }
        }
        return null;
    }

    public List<Operacion> listarOperaciones(int nroCliente) {
        Cliente cliente = buscarClientePorNro(nroCliente);
        if (cliente == null) return null;
        return cliente.getCajaAhorro().listarOperaciones();
    }

    public void solicitarPrestamo(int nroCliente, float montoPrestado, int plazoEnMeses) {
        // Implementar lógica de solicitud de préstamo si es necesario
    }
}