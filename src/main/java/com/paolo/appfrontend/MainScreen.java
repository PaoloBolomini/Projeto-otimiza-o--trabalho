package com.paolo.appfrontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen {
    private static JLabel displayLabel; // Label para mostrar os registros
    private static JTextField searchField; // Campo de texto para digitação
    private static String textomenu = "<html>Clique em alguma consulta e escreva o nome da tabela ou informação para gerar o retorno.<br><br>"
    		+ "Consulta 1 - Verifica de qual função ou cadastros gerais a tabela é consultada.<br>"
    		+ "Consulta 2 - Fornece a informação de qual relatório no sistema consulta determinada tabela.<br>"
    		+ "Consulta 3 - Verifica de qual tabela no banco é uma determinada Primary Key ou Foreign Key.<br>"
    		+ "Consulta 4 - Valida Objetos/XML/HL7/DicOjetos e retona a informação de qual desses registros consulta a tabela descrita.<br>";

    public static void main(String[] args) {
        // Criando o JFrame
        JFrame frame = new JFrame("Aplicação");
        frame.setSize(900, 550);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Painel principal para agrupar todos os componentes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Criando os botões
        JButton button1 = new JButton("Consulta 1");
        JButton button2 = new JButton("Consulta 2");
        JButton button3 = new JButton("Consulta 3");
        JButton button4 = new JButton("Consulta 4");

        // Adicionando os botões ao painel dos botões
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

        // Painel para o campo de texto e botão de pesquisa
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        searchField = new JTextField(20); // Campo de texto para pesquisa
        JButton searchButton = new JButton("Pesquisar");

        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Painel para criar margens ao redor do displayPanel
        JPanel marginPanel = new JPanel();
        marginPanel.setLayout(new BorderLayout());
        marginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margens de 10 pixels

        // Painel para exibir as informações
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2)); // Adiciona uma borda

        displayLabel = new JLabel(textomenu, SwingConstants.CENTER);
        displayPanel.add(displayLabel, BorderLayout.CENTER);

        // Adiciona o displayPanel dentro do marginPanel
        marginPanel.add(displayPanel, BorderLayout.CENTER);

        // Adiciona os painéis ao painel principal
        mainPanel.add(buttonPanel, BorderLayout.NORTH); // Painel de botões no topo
        mainPanel.add(searchPanel, BorderLayout.SOUTH); // Painel de pesquisa na parte inferior
        mainPanel.add(marginPanel, BorderLayout.CENTER); // MarginPanel no centro

        // Adiciona o painel principal ao frame
        frame.add(mainPanel, BorderLayout.CENTER);

        // Adicionando ação aos botões
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLabel.setText(textomenu);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLabel.setText(textomenu);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLabel.setText(textomenu);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLabel.setText(textomenu);
            }
        });

        // Adicionando ação ao botão de pesquisa
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText();
                displayLabel.setText("Você pesquisou: " + searchText);
            }
        });

        // Tornando o frame visível
        frame.setVisible(true);
    }
}
