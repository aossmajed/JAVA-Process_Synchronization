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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class producer implements Runnable{

        buffer buf;
        consumer con;
        int N;
        int count = 0;
        int large_prime=0;
        int check_producer=0;
        long starttime;
	

        public producer(buffer buf, int n,long s) {
                this.buf = buf;
                N = n;
                starttime = s;
              }
       
        @Override
	public void run() {
            if (N == 0) {
                long endTime = System.currentTimeMillis();
                JFrame f2 = new JFrame("output");
                JLabel o1, o2, o3, o4, o5, o6, o7;
                o1 = new JLabel("The Largest Prime Number : ");
                o1.setBounds(30, 20, 300, 30);
                o2 = new JLabel("there is not prime number(empty)");
                o2.setBounds(310, 20, 200, 30);
                o3 = new JLabel("# of element (Prime Number) generated : ");
                o3.setBounds(30, 60, 300, 30);
                o4 = new JLabel(Integer.toString(0));
                o4.setBounds(310, 60, 40, 30);

                o5 = new JLabel("Time elapsed since the start of processing :  ");
                long ti = 0;
                String tim = String.valueOf(ti) + " ms";
                o5.setBounds(30, 90, 300, 30);
                o6 = new JLabel(tim);
                o6.setBounds(310, 90, 200, 30);

                JButton b = new JButton("Finish program");
                b.setBounds(30, 125, 150, 30);
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                f2.add(o1);
                f2.add(o2);
                f2.add(o3);
                f2.add(o4);
                f2.add(o5);
                f2.add(o6);
                f2.add(b);
                f2.setSize(600, 230);
                f2.setLayout(null);
                f2.setVisible(true);
                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(producer.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            }
            if (N>0)
            {
              buf.add(Integer.toString(1));
            }
            
            for(int num=2; num<=N;num++)
            {
                boolean flag = true;
                for (int i =2 ; i<num ; i++)
                {
                   if(num % i==0)
                   {
                       flag= false;
                       break;
                   }
                   
                
                }
            if (flag==true)
            {
                 //System.out.println("prod : " +num);
                  
                  buf.add(Integer.toString(num));
                  count++;
                  large_prime=num;
                  
            }
            if(num==N)
            {
                 
                 buf.check(true);
                 if(buf.check==true && buf.element==0)
                 {
                      
                  long endTime = System.currentTimeMillis();
                 JFrame f2=new JFrame("output");
                 JLabel o1,o2,o3,o4 ,o5,o6 ,o7;
                 o1=new JLabel("The Largest Prime Number : ");  
                 o1.setBounds(30,20, 300,30); 
                 o2=new JLabel(Integer.toString(large_prime)); 
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
                     try {
                         TimeUnit.SECONDS.sleep(20);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(producer.class.getName()).log(Level.SEVERE, null, ex);
                     }
            System.exit(0);  
                      
 
                 }
            }
            
            }

	}

}