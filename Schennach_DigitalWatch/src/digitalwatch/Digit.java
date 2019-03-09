/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalwatch;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Christoph
 */
public class Digit extends JLabel {
    private int value;

    public void setValue(int value) {
        this.value = value;
        this.setIcon(new ImageIcon("src/icons/"+value+".png"));
    }
    public Digit(int number) {
        this.setSize(40,67);
        this.setIcon(new ImageIcon("src/icons/"+number+".png"));
        value = number;
    }
}
