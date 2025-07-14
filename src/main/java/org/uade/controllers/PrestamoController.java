package org.uade.controllers;

import org.uade.models.*;
import org.uade.types.TipoOperacion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.uade.dtos.PrestamoPersonalDTO;

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
        int nroPrestamo = generarNroPrestamoUnico();
        float tasaAnual = 0.03f;
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

    private int generarNroPrestamoUnico() {
        int max = 1000;
        for (Prestamo p : listadoPrestamos) {
            if (p.getNroPrestamo() > max) {
                max = p.getNroPrestamo();
            }
        }
        return max + 1;
    }

    public void registrarPrestamoPersonal(int nroPrestamo, int plazoEnMeses, int nroCliente, float montoPrestado, float tasaAnual) {
        PrestamoPersonal prestamo = new PrestamoPersonal(nroPrestamo, plazoEnMeses, nroCliente, montoPrestado, tasaAnual);
        listadoPrestamos.add(prestamo);
    }

    public void registrarPrestamoHipotecario(int nroPrestamo, int plazoEnMeses, int nroCliente, float montoPrestado, float tasaAnual, int nroClienteGarante) {
        PrestamoHipotecario prestamo = new PrestamoHipotecario(nroPrestamo, plazoEnMeses, nroCliente, montoPrestado, tasaAnual, nroClienteGarante);
        listadoPrestamos.add(prestamo);
    }

    public PrestamoPersonalDTO pagarCuotaPrestamoDTO(int nroPrestamo) throws Exception {
        ClienteController clienteController = ClienteController.getInstance();
        Prestamo prestamo = buscarPrestamo(nroPrestamo);
        if (prestamo == null) return null;
        if (prestamo.getCuotasRestantes() <= 0) {
            throw new Exception("No hay deuda pendiente.");
        }
        Cliente cliente = clienteController.buscarClientePorNro(prestamo.getNroCliente());
        if (cliente == null) return null;
        float valorCuota = prestamo.obtenerValorCuota();
        prestamo.registrarPagoCuota();
        cliente.getCajaAhorro().debitarDinero(valorCuota);
        cliente.getCajaAhorro().registrarOperacion(LocalDateTime.now(), TipoOperacion.EXTRACCION, valorCuota);
        return new PrestamoPersonalDTO(
            cliente.getNroCliente(),
            cliente.getCajaAhorro().getSaldo(),
            prestamo.getCuotasRestantes(),
            prestamo.getPlazoEnMeses(),
            prestamo.getMontoPrestado()
        );
        }

    public int consultarCuotasPendientes(int nroPrestamo) {
        return 0;
    }

    public int consultarCuotasSaldadas(int nroPrestamo) {
        return 0;
    }

    public Prestamo buscarPrestamoActivoPorCliente(int nroCliente) {
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