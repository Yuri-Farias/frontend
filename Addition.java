import javax.swing.JOptionPane; // "import" vai importar toda a biblioteca (javax) que por sua vez invoca o modulo (swing) que também invoca o componente (JOptionPane)

public class Addition // Aqui é criada a classe Addition
{ // Aqui ínicia o bloco de código da classe Addition
   public static void main(String[] args) // Aqui é criado o método executor main
   { // Aqui começa o bloco de código do método main      
      String firstNumber = // Aqui é o nome da variável da String
         JOptionPane.showInputDialog("Insira o primeiro número inteiro"); // Exibe um diálogo com uma caixa de dados pedindo um número inteiro
      String secondNumber = // Aqui é o nome da segunda variável da String
         JOptionPane.showInputDialog("Insira o segundo número inteiro"); // Exibe um diálogo com uma caixa de dados pedindo um segundo número inteiro
      
      int number1 = Integer.parseInt(firstNumber); // Aqui o componente vai invocar um metodo (parse) de análise para a variável (firtNumber)
      int number2 = Integer.parseInt(secondNumber); // Aqui o componente vai invocar um metodo (parse) de análise para a variável (secondNumber)

      int sum = number1 + number2;  // Aqui é a soma/resultado dos números 1 e 2 (???)

      JOptionPane.showMessageDialog(null, "A soma é" + sum, // Aqui mostra uma mensagem gerada por parâmetros "The sum is" que vem com a soma 
         "Soma de dois números inteiros", JOptionPane.PLAIN_MESSAGE); // Aqui é a continuação dos parâmetros após a soma ser feita e acertada, vai aparecer a mensagem de confirmação "Sum Of Two Integers"
   } // Aqui encerra o bloco de código do método main
} // Aqui encerra o bloco de código da classe Addition
