import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseTrackerFrame extends JFrame // declaração de classe MouseTrackerFrame extendida de JFrame 
{
   private final JPanel mousePanel; // variavel de JPanel
   private final JLabel statusBar; // variavel de JLabel

   public MouseTrackerFrame() // declarção de construtor com mesmo nome da classe
   {
      super("Demonstrating Mouse Events"); // nome superior

      mousePanel = new JPanel(); 
      mousePanel.setBackground(Color.WHITE); // cor de fundo padrão
      add(mousePanel, BorderLayout.CENTER); 

      statusBar = new JLabel("Mouse outside JPanel"); // nome do sensor quando o mouse etá fora do painel
      add(statusBar, BorderLayout.SOUTH); 

      MouseHandler handler = new MouseHandler(); 
      mousePanel.addMouseListener(handler); 
      mousePanel.addMouseMotionListener(handler);  //
   } 

   private class MouseHandler implements MouseListener, // declaração de classe MouseHandler implementada de MouseListener
      MouseMotionListener 
   {  
      @Override
      public void mouseClicked(MouseEvent event) // quando o mouse for clicado
      {
         statusBar.setText(String.format("Clicked at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // informações do sensor do mouse (direita, esquerda e altura)
      } 

      @Override
      public void mousePressed(MouseEvent event) // quando o mouse for pressionado
      {
         statusBar.setText(String.format("Pressed at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // informações do sensor do mouse (direita, esquerda e altura)
      }

      @Override
      public void mouseReleased(MouseEvent event) // quando o mouse for solto 
      {
         statusBar.setText(String.format("Released at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // informações do sensor do mouse (direita, esquerda e altura)
      }

      @Override
      public void mouseEntered(MouseEvent event) // mouse entra no painel muda cor
      {
         statusBar.setText(String.format("Mouse entered at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // informações do sensor do mouse (direita, esquerda e altura)
         mousePanel.setBackground(Color.GREEN);
      }
      
      @Override
      public void mouseExited(MouseEvent event) // mouse saiu volta cor
      {
         statusBar.setText("Mouse outside JPanel");
         mousePanel.setBackground(Color.WHITE); // definição de cor do painel quando o mouse estiver fora
      }

      @Override
      public void mouseDragged(MouseEvent event) // segurou o clique no painel e arrastou
      {
         statusBar.setText(String.format("Dragged at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // informações do sensor do mouse (direita, esquerda e altura)
      } 

      @Override
      public void mouseMoved(MouseEvent event) // mouse foi movido
      {
         statusBar.setText(String.format("Moved at [left: %d, top: %d, right: %d, bottom: %d]", 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // informações do sensor do mouse (direita, esquerda e altura)
      }
   } 
}