package org.uade.views;

import org.uade.controllers.PrestamoController;
import org.uade.dtos.PrestamoPersonalDTO;

import javax.swing.*;
import java.awt.*;

public class PagoCuotaView extends JFrame {
    private JTextField txtNroPrestamo;
    private JLabel lblSaldo;
    private JLabel lblInfo;

    public PagoCuotaView() {
        setTitle("Pago de Cuota de Préstamo");
        setSize(420, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        JLabel lblTitulo = new JLabel("Registrar Pago de Cuota", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(lblTitulo, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(new JLabel("Nro. Préstamo:"), gbc);

        gbc.gridx = 1;
        txtNroPrestamo = new JTextField(12);
        centerPanel.add(txtNroPrestamo, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        centerPanel.add(new JLabel("Saldo actual:"), gbc);

        gbc.gridx = 1;
        lblSaldo = new JLabel("-");
        centerPanel.add(lblSaldo, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        lblInfo = new JLabel("Ingrese el número de préstamo y presione 'Pagar cuota'.");
        lblInfo.setFont(new Font("Arial", Font.ITALIC, 12));
        centerPanel.add(lblInfo, gbc);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton btnPagar = new JButton("Pagar cuota");
        JButton btnLimpiar = new JButton("Limpiar");
        btnPanel.add(btnPagar);
        btnPanel.add(btnLimpiar);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        btnPagar.addActionListener(e -> {
            try {
                int nroPrestamo = Integer.parseInt(txtNroPrestamo.getText().trim());
                PrestamoController pc = PrestamoController.getInstance();
                PrestamoPersonalDTO dto = pc.pagarCuotaPrestamoDTO(nroPrestamo);
                if (dto == null) {
                    JOptionPane.showMessageDialog(this, "Préstamo o cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                lblSaldo.setText(String.format("$ %.2f", dto.getSaldoActual()));
                JOptionPane.showMessageDialog(this, "Cuota pagada correctamente. Quedan " + dto.getCuotasRestantes() + " cuotas.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnLimpiar.addActionListener(e -> {
            txtNroPrestamo.setText("");
            lblSaldo.setText("-");
        });

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PagoCuotaView::new);
    }
}