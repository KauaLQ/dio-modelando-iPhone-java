import funcoes.Internet;
import funcoes.Musica;
import funcoes.Telefone;

import javax.swing.*;
import java.awt.*;

public class Usuario {
    public static void main(String[] args) {
        int numeroPagina = 1;

        Telefone telefone = new Telefone();
        Internet internet = new Internet();
        Musica musica = new Musica();

        ImageIcon iconApple = new ImageIcon ("C:\\BootCampJava\\JavaBasico\\dio-modelando-iPhone-java\\iPhone\\img\\appleLogo.jpg");
        ImageIcon iconPhone = new ImageIcon ("C:\\BootCampJava\\JavaBasico\\dio-modelando-iPhone-java\\iPhone\\img\\phoneIcon.png");
        ImageIcon iconChrome = new ImageIcon ("C:\\BootCampJava\\JavaBasico\\dio-modelando-iPhone-java\\iPhone\\img\\chromeIcon.png");
        ImageIcon iconIpod = new ImageIcon ("C:\\BootCampJava\\JavaBasico\\dio-modelando-iPhone-java\\iPhone\\img\\ipodIcon.png");

        Object[] optionsInitial = {"TELEFONE", "INTERNET", "MÚSICA"};
        Object[] optionsPhone = {"LIGAR", "ATENDER", "CORREIO DE VOZ"};
        Object[] optionsChrome = {"EXIBIR", "ATUALIZAR", "ADICIONAR"};

        int primeiraSelecao = JOptionPane.showOptionDialog(
                null,
                "Olá usuário! o que você deseja?",
                "iPhone 1",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                iconApple,
                optionsInitial,
                optionsInitial[0]);
        if (primeiraSelecao == 0){
            int segundaSelecao = JOptionPane.showOptionDialog(
                    null,
                    "Aguardando...",
                    "ApplePhone",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    iconPhone,
                    optionsPhone,
                    optionsPhone[0]);
            if (segundaSelecao == 0){
                telefone.ligar();
            } else if (segundaSelecao == 1) {
                telefone.atender();
            } else if (segundaSelecao == 2) {
                telefone.verificar();
            }
        }
        
        else if (primeiraSelecao == 1){
            while (true) {
                JTextField campoTexto = new JTextField(10);

                int segundaSelecao = JOptionPane.showOptionDialog(
                        null,
                        campoTexto,
                        "Página " +  numeroPagina,
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        iconChrome,
                        optionsChrome,
                        optionsChrome[0]);
                String textoInserido = campoTexto.getText();
                if (segundaSelecao == 0) {
                    internet.exibir(textoInserido);
                    break;
                } else if (segundaSelecao == 1) {
                    internet.atualizar();
                } else if (segundaSelecao == 2) {
                    internet.novaGuia();
                    numeroPagina++;
                }
            }
        }

        else if (primeiraSelecao == 2){
            JFrame frame = new JFrame("iPod");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.setIconImage(iconIpod.getImage());

            // Adicionando JComboBox para seleção de músicas
            String[] opcoes = {"música 1", "música 2", "música 3"};
            JComboBox<String> comboBox = new JComboBox<>(opcoes);

            // Adicionando botões
            JButton tocarBtn = new JButton("Tocar");
            JButton pausarBtn = new JButton("Pausar");
            JButton pararBtn = new JButton("Parar");

            pausarBtn.setEnabled(false);
            pararBtn.setEnabled(false);

            Musica.progressBar = new JProgressBar(0, 100);
            Musica.progressBar.setValue(0);
            Musica.progressBar.setStringPainted(true);
            Musica.progressBar.setForeground(Color.ORANGE);

            // Painel com layout
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5, 1));
            panel.add(comboBox);
            panel.add(tocarBtn);
            panel.add(pausarBtn);
            panel.add(pararBtn);
            panel.add(Musica.progressBar);

            frame.add(panel);
            frame.setLocationRelativeTo(null); // Centralizar janela
            frame.setVisible(true);

            // Ação do botão "Tocar"
            tocarBtn.addActionListener(e -> {
                String musicaSelecionada = (String) comboBox.getSelectedItem();
                musica.tocar(musicaSelecionada);
                tocarBtn.setEnabled(false);  // Desabilitar "Tocar" enquanto a música está tocando
                pausarBtn.setEnabled(true);
                pararBtn.setEnabled(true);
            });

            // Ação do botão "Pausar"
            pausarBtn.addActionListener(e -> {
                if (Musica.isPaused) {
                    musica.resumeMusica();
                    pausarBtn.setText("Pausar");
                } else {
                    musica.pauseMusica();
                    pausarBtn.setText("Continuar");
                }
            });

            // Ação do botão "Parar"
            pararBtn.addActionListener(e -> {
                musica.pararMusica();
                tocarBtn.setEnabled(true);  // Reabilitar "Tocar"
                pausarBtn.setEnabled(false);
                pararBtn.setEnabled(false);
                pausarBtn.setText("Pausar");  // Resetar o texto do botão Pausar
            });
        }
    }
}
