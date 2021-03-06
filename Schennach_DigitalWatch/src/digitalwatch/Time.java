/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalwatch;

import java.awt.GridLayout;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Christoph
 */
public class Time extends JPanel implements Runnable{

    private Digit digitSecondE = new Digit(0);
    private Digit digitSecondT = new Digit(0);
    private Digit digitMinuteE = new Digit(0);
    private Digit digitMinuteT = new Digit(0);
    private Digit digitHourE = new Digit(0);
    private Digit digitHourT = new Digit(0);
    
    private int secondE;
    private int secondT;
    private int minuteE;
    private int minuteT;
    private int hourE;
    private int hourT;
    
    private JLabel colon1 = new JLabel();
    private JLabel colon2 = new JLabel();
    
    public Time(LocalTime time) {
        this.setLayout(new GridLayout(1,8));
        this.setOpaque(true);
        this.setSize(536,40);
        
        secondE = time.getSecond()%10;
        secondT = time.getSecond()/10;
        minuteE = time.getMinute()%10;
        minuteT = time.getMinute()/10;
        hourE = time.getHour()%10;
        hourT = time.getHour()/10;
        
        changeTime(); 
        
        colon1.setIcon(new ImageIcon("src/icons/doppelpunkt.png"));
        colon2.setIcon(new ImageIcon("src/icons/doppelpunkt.png"));
        
        drawPanel();
        
        
    }
    
    @Override
    public void run() {
         while(true){
            if(secondE == 9){
                secondE = 0;
                secondT++;
                
                if(secondT == 6){
                    secondT = 0;
                    minuteE++;
                    
                    if(minuteE == 10){
                        minuteE = 0;
                        minuteT++;
                        
                        if(minuteT == 6){
                            minuteT =0;
                            hourE++;
                         }
                         if(hourE == 4 && hourT == 2){
                              hourT = 0;
                              hourE =0;
                         }
                         if(hourE == 10){
                              hourT++;
                              hourE = 0;
                         }
                    }
                }
            }
            else{
            secondE++;
            }
            changeTime();
            
          
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(LocalTime.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    private void drawPanel() {
        this.removeAll();
        this.add(digitHourT);
        this.add(digitHourE);
        this.add(colon1);
        this.add(digitMinuteT);
        this.add(digitMinuteE);
        this.add(colon2);
        this.add(digitSecondT);
        this.add(digitSecondE);
       
    }

    private void changeTime() {
       digitSecondE.setValue(secondE);
        digitSecondT.setValue(secondT);
        digitMinuteE.setValue(minuteE);
        digitMinuteT.setValue(minuteT);
        digitHourE.setValue(hourE);
        digitHourT.setValue(hourT);
    }
    
    

    
}
