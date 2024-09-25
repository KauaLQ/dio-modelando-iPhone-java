package funcoes;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.swing.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Musica {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Clip clip;
    Timer timer;
    public static JProgressBar progressBar;
    public static boolean isPaused = false;
    public void tocar(String escolhaMusica){
        if (escolhaMusica.equals("música 1")){
            executorService.submit(() -> {
                try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\BootCampJava\\JavaBasico\\dio-modelando-iPhone-java\\iPhone\\EfeitosSonoros\\ELA NÃO VAI VOLTAR_Joao Gomes.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                    isPaused = false;
                    iniciarBarraDeProgresso();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } else if (escolhaMusica.equals("música 2")) {
            executorService.submit(() -> {
                try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\BootCampJava\\JavaBasico\\dio-modelando-iPhone-java\\iPhone\\EfeitosSonoros\\IdaseVindas.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                    isPaused = false;
                    iniciarBarraDeProgresso();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } else if (escolhaMusica.equals("música 3")) {
            executorService.submit(() -> {
                try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\BootCampJava\\JavaBasico\\dio-modelando-iPhone-java\\iPhone\\EfeitosSonoros\\Malta_Diz pra mim.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                    isPaused = false;
                    iniciarBarraDeProgresso();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
    public void iniciarBarraDeProgresso(){
        long duracaoTotal = clip.getMicrosecondLength() / 1000;  // Em milissegundos
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (clip != null && clip.isRunning()) {
                    long tempoAtual = clip.getMicrosecondPosition() / 1000;  // Em milissegundos
                    int progresso = (int) ((tempoAtual * 100) / duracaoTotal);  // Percentual da barra
                    progressBar.setValue(progresso);
                }
            }
        }, 0, 500);  // Atualiza a cada 500ms (meio segundo)
    }
    public void resumeMusica(){
        if (clip != null && isPaused) {
            clip.start();
            isPaused = false;
        }
    }
    public void pauseMusica(){
        if (clip != null && clip.isRunning()) {
            clip.stop();
            isPaused = true;
        }
    }
    public void pararMusica(){
        if (clip != null) {
            clip.stop();
            clip.close();
            if (timer != null) {
                timer.cancel();  // Cancelar o timer ao parar a música
                progressBar.setValue(0);
            }
        }
    }
}
