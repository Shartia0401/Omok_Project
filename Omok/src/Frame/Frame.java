package Frame;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{

    private short BLACK = -1;
    private short NULL  =  0;
    private short WHITE =  1;

    public static final int X = 19;
    public static final int Y = 19;

    JPanel b;

    public static JButton[][] btns = new JButton[X][Y];

    public Frame()
    {
        setIcon();
        setLayout(null);
        GamePanel a = new GamePanel();
        a.setLayout(null);
        a.setBounds(-20,-20, 900,900);
        getContentPane().setBackground(Color.white);
        buttons();

        add(a);
        add(b);


        setFrame();

    }

    private void buttons()
    {
        

        b = new JPanel();

        b.setLayout(new GridLayout(19,19));
        for(int i = 0; i < X; i++)
        {
            for(int j = 0; j < Y; j++)
            {
                btns[i][j] = new JButton("");
                btns[i][j].setText(Integer.toString(i) + " " + Integer.toString(j));
                btns[i][j].addActionListener(new Action());
                btns[i][j].setBorderPainted(false);
                btns[i][j].setContentAreaFilled(false);
                btns[i][j].setFocusPainted(false);
                btns[i][j].setOpaque(false);
                btns[i][j].setBackground(new Color(255,0,0,0));
                b.add(btns[i][j]);
            }
        }
        b.setOpaque(false);
        b.setBounds(-20,-25, 847, 847);
        

        
    } 

    private void setFrame()
    {
        setTitle("오목");
        setSize(new Dimension(816,835));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setIcon()
    {
        ImageIcon icon = new ImageIcon("icon.jpg");
        Image image = icon.getImage();

        setIconImage(image);
    }
    
    
}
