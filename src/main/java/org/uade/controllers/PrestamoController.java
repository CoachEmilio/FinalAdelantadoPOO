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
        this.listadoPrestamos = new ArrayList<Prestamo>();
        Prestamo p = new PrestamoPersonal(1234, 12, 12345678, 100000, 0.03f);
        listadoPrestamos.add(p);
    }
    public static synchronized PrestamoController getInstance() {
        if (instance == null) {
            instance = new PrestamoController();
        }
        return instance;
    }
    public void registrarPrestamoPersonal(int nroPrestamo, int plazoEnMeses, int nroCliente, float montoPrestado, float tasaAnual) {
        //debo revisar lógica
        PrestamoPersonal prestamo = new PrestamoPersonal(nroPrestamo, plazoEnMeses, nroCliente, montoPrestado, tasaAnual);
        listadoPrestamos.add(prestamo);
    }
    public void registrarPrestamoHipotecario(int nroPrestamo, int plazoEnMeses, int nroCliente, float montoPrestado, float tasaAnual, int nroClienteGarante) {
        //debo revisar lógica
        PrestamoHipotecario prestamo = new PrestamoHipotecario(nroPrestamo, plazoEnMeses, nroCliente, montoPrestado, tasaAnual, nroClienteGarante);
        listadoPrestamos.add(prestamo);
    }
    public void pagarCuotaPrestamo(int nroPrestamo){
        ClienteController clienteController = ClienteController.getInstance();
        Prestamo prestamo = buscarPrestamo(nroPrestamo); //uso metodo de abajo linea 68
        if (prestamo == null) {
            System.out.println("Prestamo no encontrado");
            return;
        }
        Cliente cliente = clienteController.buscarClientePorNro(prestamo.getNroCliente());

        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return;
        }
        float valorCuota = prestamo.obtenerValorCuota();
        cliente.getCajaAhorro().debitarDinero(valorCuota);
        cliente.getCajaAhorro().registrarOperacion(LocalDateTime.now(), TipoOperacion.EXTRACCION, valorCuota);

    }

     public int consultarCuotasPendientes(int nroPrestamo) {
        /*Prestamo prestamo = buscarPrestamoPorNro(nroPrestamo);
        if (prestamo == null) {
            System.out.println("Prestamo no encontrado");
            return -1; // Indica que no se encontró el préstamo
        }
        return prestamo.getPlazoEnMeses() - prestamo.getCuotasPagadas();
        */
         return 0;
     }
     public int consultarCuotasSaldadas(int nroPrestamo) { return 0;  // Implementar lógica si es necesario}
     }
     public Prestamo buscarPrestamoActivoPorCliente(int nroCliente){return null;}

    public Prestamo buscarPrestamo(int nroPrestamo){
        for (Prestamo prestamo : listadoPrestamos) {
            if (prestamo.getNroPrestamo() == nroPrestamo) {
                return prestamo;
            }
        }
        return null; // Si no se encuentra el préstamo
    }

}
