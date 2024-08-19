import java.awt.*; // specifies how components are arranged
import javax.swing.*; // carrega todos os componentes do módulo swing da biblioteca javax

public class LabelFrame extends JFrame // declaração de classe extendida
{
   private final JLabel label1;
   private final JLabel label2;
   private final JLabel label3; // 3 classes privadas de alterações
   
   public LabelFrame() // declara o construtor da classe LableFrame
   {
      super("Testing JLabel"); // nome superior
      setLayout(new FlowLayout()); // colocar layout

      label1 = new JLabel("Label with text"); // variavel atribui um novo objeto Jlabel com parâmentros
      label1.setToolTipText("This is label1"); // variavel invoca um método de texto com ferramenta de dica
      add(label1); // adicionar a variavel lable1 na classe Jframe

      Icon bug = new ImageIcon(getClass().getResource("bug1.png")); // classe icon atribui um novo objeto de imagem com parâmentros de classe e recurso
      label2 = new JLabel("Label with text and icon", bug, // atribui a variavel lable2 um novo objeto Jlable
         SwingConstants.LEFT); // dá um alinhamento para o texto
      label2.setToolTipText("This is label2"); // método de texto com ferramenta de dica
      add(label2); // adicionar a variavel lable2 na classe Jframe

      label3 = new JLabel(); // 
      label3.setText("Label with icon and text at bottom"); // variavel invoca objeto de texto 
      label3.setIcon(bug); // variavel invoca objeto de Icon
      label3.setHorizontalTextPosition(SwingConstants.CENTER); // dá um alinhamento de posição para o texto
      label3.setVerticalTextPosition(SwingConstants.BOTTOM); // dá um alinhamento de posição
      label3.setToolTipText("This is label3"); // método de texto com ferramenta de dica
      add(label3); //  adicionar a variavel lable3 na classe Jframe
   } 
} // end class LabelFrame


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