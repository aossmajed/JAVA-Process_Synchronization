/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2;

/**
 *
 * @author aossmajed
 */
import javax.swing.JOptionPane;
import java.awt.event.*;  
import javax.swing.*;
public class Main {


	 public static void main(String[] args) {

             JFrame f=new JFrame("Calculate prime number");  
             JLabel l1,l2;
             l1=new JLabel("Enter N : ");  
             l1.setBounds(30,20, 100,30);  
             final JTextField tf=new JTextField();
             tf.setBounds(150,25, 150,20);
             l2=new JLabel("Enter File Name only(without .txt) : ");  
             l2.setBounds(30,70, 100,30); 
             final JTextField tf2=new JTextField();  
             tf2.setBounds(150,75, 150,20);
             JButton b=new JButton("Start Producer");  
             b.setBounds(30,110,150,20);  
             b.addActionListener(new ActionListener(){  
             public void actionPerformed(ActionEvent e){  
                buffer buf = new buffer(10);
                long startTime = System.currentTimeMillis();                
                int n = Integer.valueOf(tf.getText());
                String file= String.valueOf(tf2.getText());
                
                 
                 Thread producerThread = new Thread(new producer(buf,n,startTime));
                 Thread consumerThread = new Thread(new consumer(buf,file+".txt",startTime));
		 producerThread.start();
                 consumerThread.start();
                
                
                
                

        }  
                });  
                
                f.add(tf);
                f.add(tf2);
                f.add(b);
                f.add(l1); f.add(l2);  
                f.setSize(350,240);  
                f.setLayout(null);  
                f.setVisible(true); 
                
                

                
	}
}

