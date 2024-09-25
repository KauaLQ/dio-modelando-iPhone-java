package funcoes;

import javax.swing.*;

public class Internet {
    Icon iconChrome = new ImageIcon ("C:\\BootCampJava\\JavaBasico\\dio-modelando-iPhone-java\\iPhone\\img\\chromeIcon.png");
    public void exibir(String textoPesquisa){
        JOptionPane.showMessageDialog(null, textoPesquisa,"Resutado da Pesquisa",JOptionPane.INFORMATION_MESSAGE,iconChrome);
    }
    public void atualizar(){
        JOptionPane.showMessageDialog(null, "Página atualizada!","Google Chrome",JOptionPane.INFORMATION_MESSAGE,iconChrome);
    }
    public void novaGuia(){
        JOptionPane.showMessageDialog(null, "Nova página adicionada!","Google Chrome",JOptionPane.INFORMATION_MESSAGE,iconChrome);
    }
}
