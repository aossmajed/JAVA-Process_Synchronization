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

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class buffer {

	private Queue<String> stack = new LinkedList<String>();
        private int size_q;
        int element = 0;
        Boolean check = false;
        String item = " ";
        int pro_con=0;
        public buffer(int max_size)
        {
          size_q = max_size;
        }
        
        public void check(Boolean c)
        {
           this.check=c;
        }
        public void add(String item)
        {
          synchronized(this)
          {
              while(stack.size()==size_q)
              {
                  try {
                      
                     wait();
                } catch (InterruptedException e)
                {
                  e.printStackTrace();
                }
              }
              
              this.stack.add(item);
              element++;
              notify();
          
          }
        }
        public synchronized String consume()
        {
             
             while(stack.isEmpty()) {
                 try {
                     wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }  
             item = stack.remove();
             element--;
             notify();
             return item;
        }
        
        

    void large(int large_prime) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        

   

}

