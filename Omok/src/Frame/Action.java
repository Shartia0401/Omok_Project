package Frame;

import java.awt.event.*;


public class Action implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {   
        String location = e.getActionCommand();
        System.out.println(location);
    }
    
}
