/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softmakerjava;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import javax.swing.UIManager;

/**
 *
 * @author Baka
 */
public class SoftMakerJava
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        }
        catch(Exception exc)
        {
            System.err.println("Look and feel not supported! " + exc.toString() );
        }
        
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                LoginForm welcomeFrame = new LoginForm();
                welcomeFrame.setVisible(true);
            }
        });
    }
    
}
