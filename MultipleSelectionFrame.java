import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// importa funções da bibilioteca java e javax 
public class MultipleSelectionFrame extends JFrame // define a classe MutipleSelectionframe
{
   private final JList<String> colorJList; // lista para o nome das cores
   private final JList<String> copyJList; // lista para nomes copiados
   private final JList<String> copyJList2; // copia 2 do Jlist

   private JButton copyJButton; // botão de copiar nomes selecionados
   private JButton copyJButton2; // copia 2 do Jbutton

   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"}; // define o nome das opções 

   public MultipleSelectionFrame() // declara o consntrutor com mesmo nome da classe
   {
      super("Multiple Selection Lists"); // nome superior dentro do frame
      setLayout(new FlowLayout());

      colorJList = new JList<String>(colorNames); // inserir nomes
      colorJList.setVisibleRowCount(5); // linhas que vão aparecer
      colorJList.setSelectionMode( // selecionar opções
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //selecionar multiplas opções
      add(new JScrollPane(colorJList)); 

      copyJButton = new JButton("Copy >>>"); // nome do botão "Coyy"
      copyJButton.addActionListener(
         new ActionListener() 
         {  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               copyJList.setListData(
                  colorJList.getSelectedValuesList().toArray( // envia para matriz
                     new String[0]));
            }
         } 
      ); 
      add(copyJButton); 

      copyJList = new JList<String>(); 
      copyJList.setVisibleRowCount(5); // define quantidade de linhas exibidas
      copyJList.setFixedCellWidth(100); // define a largura da cela fixa
      copyJList.setFixedCellHeight(15); // define a altura fixa da cela fixa
      copyJList.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION); // função que impede de selecionar varias opções
      add(new JScrollPane(copyJList));

      copyJButton2 = new JButton("Copy >>>"); // nome do botão "Copy"
      copyJButton2.addActionListener(
         new ActionListener() 
         {  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               copyJList2.setListData(
                  copyJList.getSelectedValuesList().toArray( // envia para matriz
                     new String[0]));
            }
         } 
      ); 
      add(copyJButton2); 

      copyJList2 = new JList<String>(); 
      copyJList2.setVisibleRowCount(5); // define quantidade de linhas exibidas
      copyJList2.setFixedCellWidth(100); // define a largura da cela fixa
      copyJList2.setFixedCellHeight(15); // define a altura fixa da cela fixa
      copyJList2.setSelectionMode(
         ListSelectionModel.SINGLE_SELECTION); // função que impede de selecionar varias opções
      add(new JScrollPane(copyJList2)); 
     } 
   }