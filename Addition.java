import javax.swing.JOptionPane; // Não sei

public class Addition // Aqui é criada a classe Addition
{
   public static void main(String[] args) // Aqui é criado o método executor main
   { // Aqui começa o bloco de código do método main
      
      String firstNumber = // Aqui é o primeiro número da string
         JOptionPane.showInputDialog("Enter first integer"); // Aqui é pedido para inserir um primeiro número inteiro
      String secondNumber = // Aqui é o segundo número da string
         JOptionPane.showInputDialog("Enter second integer"); // Aqui é pedido para inserir um segundo número inteiro

      
      int number1 = Integer.parseInt(firstNumber); // Não sei
      int number2 = Integer.parseInt(secondNumber); // Não sei

      int sum = number1 + number2;  // Aqui é a soma/resultado dos números 1 e 2

      
      JOptionPane.showMessageDialog(null, "The sum is " + sum, // Aqui mostra uma mensagem quando a soma é acertada
         "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE); // Não sei
   } // Aqui encerra o bloco de código do método main
} // Aqui encerra o bloco de código da classe Addition
