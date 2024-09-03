package com.paolo.appfrontend;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.paolo.dboracle.Db;

public class HomeScreen {

    private static JTextField fieldhost;  // Primeiro campo de texto
    private static JTextField fielduser; // Segundo campo de texto
    private static JTextField fieldpassword;  // Terceiro campo de texto

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

        // Primeiro campo host
        fieldhost = new JTextField(20);
        gbc.gridy = 1;
        mainPanel.add(fieldhost, gbc);

        // Label para o segundo campo usuário
        JLabel secondLabel = new JLabel("Usuário");
        gbc.gridy = 2;
        mainPanel.add(secondLabel, gbc);

        // Segundo campo 
        fielduser = new JTextField(20);
        gbc.gridy = 3;
        mainPanel.add(fielduser, gbc);

        // Label para o terceiro campo
        JLabel thirdLabel = new JLabel("Senha");
        gbc.gridy = 4;
        mainPanel.add(thirdLabel, gbc);

        // Terceiro campo de texto senha
        fieldpassword = new JTextField(20);
        gbc.gridy = 5;
        mainPanel.add(fieldpassword, gbc);

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
                String firstText = fieldhost.getText();
                String secondText = fielduser.getText();
                String thirdText = fieldpassword.getText();
               
                Connection conn = null;
        		conn = Db.getConnection();
        		
        		if(conn != null) {
        			
        			System.out.println("Conexão com o banco correta");
        			new MenuScreen();
        		}
        		else {
        			System.out.println("Conexão falhou");
        		}
        		
        		Db.closeConnection();
            }
        });
        
        

        // Tornando o frame visível
        frame.setVisible(true);
    }

	public static JTextField getFieldHost() {
		return fieldhost;
	}

	public static JTextField getFieldUser() {
		return fielduser;
	}

	public static JTextField getFieldPassword() {
		return fieldpassword;
	}

	
}
