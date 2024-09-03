import javax.swing.JFrame; // importação da biblioteca javax

public class MouseTracker // declaração de classe
{ // inicio do bloco de codigo  da classe
   public static void main(String[] args) // declaração de método usado no codigo e seus parâmetros
   { // inicio do bloco de codigo do metodo
      MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame(); 
      mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define se vai fechar ao sair
      mouseTrackerFrame.setSize(300, 100); // define largura e altura
      mouseTrackerFrame.setVisible(true); // define se é visivel
   } // fim do bloco de codigo do metodo
} // fim do bloco de codigo da classe