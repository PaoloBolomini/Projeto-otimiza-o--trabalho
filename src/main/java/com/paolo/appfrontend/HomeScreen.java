package com.paolo.appfrontend;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HomeScreen {

    private static JTextField firstField;  // Primeiro campo de texto
    private static JTextField secondField; // Segundo campo de texto
    private static JTextField thirdField;  // Terceiro campo de texto

    public HomeScreen() {
        // Criando o JFrame
        JFrame frame = new JFrame("Aplicação");
        frame.setSize(900, 550);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Painel principal para agrupar todos os componentes
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margens entre os componentes
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        // Label para o primeiro campo
        JLabel firstLabel = new JLabel("Host");
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(firstLabel, gbc);

        // Primeiro campo de texto
        firstField = new JTextField(20);
        gbc.gridy = 1;
        mainPanel.add(firstField, gbc);

        // Label para o segundo campo
        JLabel secondLabel = new JLabel("Usuário");
        gbc.gridy = 2;
        mainPanel.add(secondLabel, gbc);

        // Segundo campo de texto
        secondField = new JTextField(20);
        gbc.gridy = 3;
        mainPanel.add(secondField, gbc);

        // Label para o terceiro campo
        JLabel thirdLabel = new JLabel("Senha");
        gbc.gridy = 4;
        mainPanel.add(thirdLabel, gbc);

        // Terceiro campo de texto
        thirdField = new JTextField(20);
        gbc.gridy = 5;
        mainPanel.add(thirdField, gbc);

        // Botão de pesquisa
        JButton searchButton = new JButton("Conectar");
        gbc.gridy = 6;
        mainPanel.add(searchButton, gbc);

        // Adiciona o painel principal ao frame
        frame.add(mainPanel, BorderLayout.CENTER);

        // Adicionando ação ao botão de pesquisa
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstText = firstField.getText();
                String secondText = secondField.getText();
                String thirdText = thirdField.getText();
                System.out.println("retorno 1  " + firstText);
                System.out.println("retorno 2  " + secondText);
                System.out.println("retorno 3  " + thirdText);
            }
        });

        // Tornando o frame visível
        frame.setVisible(true);
    }
}
