package funcoes;

import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class Telefone {
    ImageIcon iconPhone = new ImageIcon ("C:\\BootCampJava\\JavaBasico\\dio-modelando-iPhone-java\\iPhone\\img\\phoneIcon.png");
    public void ligar(){
        // Criação de um JDialog não modal
        JDialog dialog = new JDialog();
        dialog.setTitle("ApplePhone");
        dialog.setSize(200, 100);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(null);  // Centraliza a janela

        // Criação de um JLabel que será atualizado
        JLabel label = new JLabel("Ligando", SwingConstants.CENTER);
        dialog.add(label);
        dialog.setVisible(true);

        // Atualizando a mensagem em um loop
        for (int i = 0; i < 8; i++) {
            try {
                Thread.sleep(1000); // Pausa por 1 segundo entre cada atualização
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Atualiza a mensagem com mais pontos
            label.setText(label.getText() + ".");
        }

        // Fecha o JDialog após a atualização
        dialog.dispose();

        JOptionPane.showMessageDialog(null, "Chamada não atendida!", "ApplePhone", JOptionPane.ERROR_MESSAGE);
        }
    public void atender(){
        JOptionPane.showMessageDialog(null, "Retorne esta ligação quando puder!", "ApplePhone", JOptionPane.INFORMATION_MESSAGE);
    }
    public void verificar(){
        String[] opcoes = {"ClaroOperadora 21-01", "+0555 23-02", "Outro"};

        JComboBox<String> comboBox = new JComboBox<>(opcoes);

        int escolha = JOptionPane.showConfirmDialog(null,
                comboBox,
                "Selecione uma opção",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                iconPhone);

        if (escolha == JOptionPane.OK_OPTION) {
            String selecionado = (String) comboBox.getSelectedItem();
            if (selecionado.equals("ClaroOperadora 21-01")){
                JFrame frame = new JFrame("ClaroOperadora 21-01");
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 100);
                frame.setLocationRelativeTo(null);

                // Criação da barra de progresso
                JProgressBar progressBar = new JProgressBar();
                progressBar.setStringPainted(true);
                progressBar.setBounds(20, 20, 350, 20);
                frame.add(progressBar);
                frame.setVisible(true);

                try {
                    // Carregar o arquivo de áudio
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\BootCampJava\\JavaBasico\\dio-modelando-iPhone-java\\iPhone\\EfeitosSonoros\\eclaro.wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);

                    long audioLength = clip.getMicrosecondLength();

                    // Reproduzir o áudio
                    clip.start();

                    // Atualizar a barra de progresso durante a reprodução
                    Timer timer = new Timer();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            long currentPosition = clip.getMicrosecondPosition();
                            int progress = (int) ((currentPosition * 100) / audioLength);
                            progressBar.setValue(progress);
                            progressBar.setString(progress + "%");

                            // Parar o timer quando o áudio terminar
                            if (currentPosition >= audioLength) {
                                timer.cancel();
                                clip.close();
                            }
                        }
                    };

                    // Atualiza a barra de progresso a cada 100 milissegundos
                    timer.scheduleAtFixedRate(task, 0, 100);

                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Esta mensagem não está mais disponível!", "AVISO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
