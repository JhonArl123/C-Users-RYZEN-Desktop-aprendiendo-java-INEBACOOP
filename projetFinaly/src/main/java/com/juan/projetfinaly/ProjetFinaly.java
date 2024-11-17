

package com.juan.projetfinaly;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;


public class ProjetFinaly {

    public static void main(String[] args) {
        
        showSplashScreen();
        UniConecta ventana = new UniConecta();
        ventana.setVisible(true);
       
    }
    
    private static void showSplashScreen() {
    JWindow splashWindow = new JWindow();
    splashWindow.setLayout(new BorderLayout());

    JProgressBar progressBar = new JProgressBar(0, 100);
    progressBar.setStringPainted(true);
    progressBar.setForeground(Color.blue);
    progressBar.setValue(0);

    JLabel messageLabel = new JLabel("UniConecta...La app que impulsa tu vida Universitaria  0 %", JLabel.CENTER);
    messageLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
    messageLabel.setForeground(Color.BLUE);

    splashWindow.add(progressBar, BorderLayout.SOUTH);
    splashWindow.add(messageLabel, BorderLayout.CENTER);
    splashWindow.setSize(500, 100);
    splashWindow.setLocationRelativeTo(null);
    splashWindow.setVisible(true);

    final int totalTime = 5000;
    final int steps = 100;

    new Thread(() -> {
        try {
            for (int i = 0; i <= steps; i++) {
                progressBar.setValue(i);
                messageLabel.setText("UniConecta...La app que impulsa tu vida Universitaria  " + i + " %");
                Thread.sleep(totalTime / steps);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }).start();

    try {
        Thread.sleep(totalTime);  // Espera a que termine la animación
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    splashWindow.dispose();
  
}
}