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
import java.io.File;  // Import the File class
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;   // Import the FileWriter class
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.*;  
import javax.swing.*;
import java.util.concurrent.TimeUnit;
public class consumer implements Runnable{
    
    buffer buf;
    int count =0;
    String large_prime;
    int check_consumer=0;
    String file;
    producer pro;
     long starttime;
    

    public consumer(buffer buf, String string, long s) {
       this.buf = buf;
       file=string;
       starttime = s;
    }
   
    @Override
    public void run() {
        String item;
        File myObj = new File(file);
        
      try {
        FileWriter fw= new FileWriter(file);
        String aa;
        while(true)
        {
            if(buf.element==0 && buf.check==true)
            {
                 fw.close();
                 long endTime = System.currentTimeMillis();
                 
                 
                 JFrame f2=new JFrame("output");
                 JLabel o1,o2,o3,o4 ,o5,o6 ,o7;
                 o1=new JLabel("The Largest Prime Number : ");  
                 o1.setBounds(30,20, 300,30); 
                 o2=new JLabel(large_prime); 
                 o2.setBounds(310,20, 40,30);
                 o3=new JLabel("# of element (Prime Number) generated : ");  
                 o3.setBounds(30,60, 300,30);
                 o4=new JLabel(Integer.toString(count));  
                 o4.setBounds(310,60, 40,30);
                 
                 
                 
                 o5=new JLabel("Time elapsed since the start of processing :  ");  
                 long ti = (endTime - starttime);
                 String tim =String.valueOf(ti)+ " ms" ;
                 o5.setBounds(30,90, 300,30);
                 o6=new JLabel(tim);  
                 o6.setBounds(310,90, 200,30);
                 
                  
                 
                 JButton b=new JButton("Finish program");  
                 b.setBounds(30,125,150,30);  
                  b.addActionListener(new ActionListener(){  
                  public void actionPerformed(ActionEvent e){  
                      System.exit(0);
        }  
    });
            f2.add(o1);f2.add(o2);f2.add(o3);f2.add(o4);
            f2.add(o5);f2.add(o6);
            f2.add(b);
            f2.setSize(450,230); 
            f2.setLayout(null);  
            f2.setVisible(true);
            TimeUnit.SECONDS.sleep(20);
            System.exit(0);  
            }
            else
            {
               item = buf.consume();
               fw.write(String.valueOf(item) + " , ");
               large_prime=item;
               count++;
            }
            }
        }
      catch (IOException ex) {
                    Logger.getLogger(consumer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
            Logger.getLogger(consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
