// Fig. 12.7: LabelTest.java
// Testing LabelFrame.
import javax.swing.JFrame; // importação de biblioteca, seus módulos e componentes

public class LabelTest // declaração de classe
{
   public static void main(String[] args) // declaração/criação do método
   { 
      LabelFrame labelFrame = new LabelFrame();  // definir o frame que vai aparecer na tela
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar ao sair da janela
      labelFrame.setSize(360, 450); // alterar tamanho do frame na tela
      labelFrame.setVisible(true); // comando para aparecer a janela do frame
   } 
} // end class LabelTest


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/