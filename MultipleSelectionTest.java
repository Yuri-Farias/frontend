import javax.swing.JFrame; // importa componentes e modulos da biblioteca

public class MultipleSelectionTest // publicação da classe MultipleSelectionTest
{ // inicio do bloco de codigo da classe0
   public static void main(String[] args) // declaração de método com argumentos
   { // inicio do bloco de codigo do método
      MultipleSelectionFrame multipleSelectionFrame = 
         new MultipleSelectionFrame(); 
      multipleSelectionFrame.setDefaultCloseOperation( // define um modo de fechamento padrão
         JFrame.EXIT_ON_CLOSE); // define o fechamento ao sair ou sair ao fechar
      multipleSelectionFrame.setSize(550, 150); // define tamanho
      multipleSelectionFrame.setVisible(true); // define que o freme é visivel
   } // fim do bloco de codigo do método
} // fim do bloco de codigo da classe