package org.uade.controllers;

import org.uade.models.*;
import org.uade.types.TipoOperacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PrestamoController {
    private List<Prestamo> listadoPrestamos;
    private static PrestamoController instance = null;

    private PrestamoController() {
        this.listadoPrestamos = new ArrayList<>();
        Prestamo p = new PrestamoPersonal(1234, 12, 1001, 100000, 0.03f);
        listadoPrestamos.add(p);
    }

    public static synchronized PrestamoController getInstance() {
        if (instance == null) {
            instance = new PrestamoController();
        }
        return instance;
    }

    public Prestamo altaPrestamoPersonal(PrestamoPersonalDTO dto) {
        Cliente cliente = ClienteController.getInstance().buscarClientePorNro(dto.getNroCliente());
        if (cliente == null) return null;
        // Asigna un nroPrestamo único y una tasaAnual (ejemplo: 0.03f)
        int nroPrestamo = generarNroPrestamoUnico();
        float tasaAnual = 0.03f; // O agrega tasaAnual al DTO
        PrestamoPersonal prestamo = new PrestamoPersonal(
            nroPrestamo,
            dto.getPlazoEnMeses(),
            dto.getNroCliente(),
            dto.getMontoPrestado(),
            tasaAnual
        );
        listadoPrestamos.add(prestamo);
        return prestamo;
    }

    public void registrarPrestamoPersonal(int nroPrestamo, int plazoEnMeses, int nroCliente, float montoPrestado, float tasaAnual) {
        PrestamoPersonal prestamo = new PrestamoPersonal(nroPrestamo, plazoEnMeses, nroCliente, montoPrestado, tasaAnual);
        listadoPrestamos.add(prestamo);
    }

    public void registrarPrestamoHipotecario(int nroPrestamo, int plazoEnMeses, int nroCliente, float montoPrestado, float tasaAnual, int nroClienteGarante) {
        PrestamoHipotecario prestamo = new PrestamoHipotecario(nroPrestamo, plazoEnMeses, nroCliente, montoPrestado, tasaAnual, nroClienteGarante);
        listadoPrestamos.add(prestamo);
    }

    public void pagarCuotaPrestamo(int nroPrestamo) {
        ClienteController clienteController = ClienteController.getInstance();
        Prestamo prestamo = buscarPrestamo(nroPrestamo);
        if (prestamo == null) return;
        Cliente cliente = clienteController.buscarClientePorNro(prestamo.getNroCliente());
        if (cliente == null) return;
        float valorCuota = prestamo.obtenerValorCuota();
        cliente.getCajaAhorro().debitarDinero(valorCuota);
        cliente.getCajaAhorro().registrarOperacion(LocalDateTime.now(), TipoOperacion.EXTRACCION, valorCuota);
    }

    public int consultarCuotasPendientes(int nroPrestamo) {
        // Implementar lógica si es necesario
        return 0;
    }

    public int consultarCuotasSaldadas(int nroPrestamo) {
        // Implementar lógica si es necesario
        return 0;
    }

    public Prestamo buscarPrestamoActivoPorCliente(int nroCliente) {
        // Implementar lógica si es necesario
        return null;
    }

    public Prestamo buscarPrestamo(int nroPrestamo) {
        for (Prestamo prestamo : listadoPrestamos) {
            if (prestamo.getNroPrestamo() == nroPrestamo) {
                return prestamo;
            }
        }
        return null;
    }
}