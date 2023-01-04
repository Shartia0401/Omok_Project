package Frame;

import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Action implements ActionListener{
    static Boolean Winner = false;
    static Boolean turn = false;

    JButton button;
    private int x;
    private int y;

    @Override
    public void actionPerformed(ActionEvent e) { 
        button = (JButton)e.getSource();  
        Omokgames(e);

    }

    private void Omokgames(ActionEvent e)
    {

        draw(e);
        win(e);
    }

    private void win(ActionEvent e)
    {
        address(e);

        System.out.println(x);
        System.out.println(y);



        if(Winner == true)
        {
            JFrame select = new JFrame("승리!");
            JLabel winnerLabel = new JLabel();
            select.setSize(new Dimension(400, 400));
            select.setLayout(new BorderLayout());
            select.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            select.setLocationRelativeTo(null);
            select.setVisible(true);

            if(turn)
            {
                winnerLabel.setText("흑돌 승리");
            }
            else
            {
                winnerLabel.setText("흰돌 승리");
            }
            

            select.add(winnerLabel);

            Winner = false;
        }
    }

    void setbutton() //TODO 사용안함
    {
        for(int i = 0; i < Frame.X; i++)
        {
            for(int j = 0; j < Frame.Y; j++)
            {
                Frame.btns[i][j].setText(Integer.toString(i) + " " + Integer.toString(j));
                Frame.btns[i][j].addActionListener(new Action());
                Frame.btns[i][j].setBorderPainted(false);
                Frame.btns[i][j].setContentAreaFilled(false);
                Frame.btns[i][j].setFocusPainted(false);
                Frame.btns[i][j].setOpaque(false);
                Frame.btns[i][j].setBackground(new Color(255,0,0,0));
            }
        }
    }

    private void address(ActionEvent e)
    {
        String address = e.getActionCommand();
        String[] XaY = address.split(" ");
        x = Integer.parseInt(XaY[0]);
        y = Integer.parseInt(XaY[1]);
        findrock();
    }

    void findrock()
    {   
        findleft();
        findright();
        findup();
        findhorizontal();


    }
    void AllCheck(int findx, int findy)
    {
        up(button.getBackground(), findx, findy);
        down(button.getBackground(), findx, findy);
        left(button.getBackground(), findx, findy);
        right(button.getBackground(), findx, findy);
        leftCrossup(button.getBackground(), findx, findy);
        leftCrossdown(button.getBackground(), findx , findy);
        rightCrossup(button.getBackground(), findx , findy);
        rightCrossdown(button.getBackground(), findx , findy);
    }

    void findleft()
    {
        int a, b;
        a = x;
        b = y;
        for(int i = 0; i < 5; i++)
        {
            try {
                if(Frame.btns[a][b].getBackground() == Frame.btns[a - 1][b + 1].getBackground()) 
                {
                    a -= 1;
                    b += 1;
                }
            } catch (IndexOutOfBoundsException e) {
                // TODO: handle exception
            }
        }

        AllCheck(a,b);
    }

    void findup()
    {
        int a, b;
        a = x;
        b = y;
        for(int i = 0; i < 5; i++)
        {
            try {
                if(Frame.btns[a][b].getBackground() == Frame.btns[a + 1][b].getBackground()) 
                {
                    a += 1;
                }   
            } catch (IndexOutOfBoundsException e) {

            }
        }
        AllCheck(a,b);
    }

    void findright()
    {
        int a, b;
        a = x;
        b = y;
        for(int i = 0; i < 5; i++)
        {
            try {
                if(Frame.btns[a][b].getBackground() == Frame.btns[a + 1][b + 1].getBackground()) 
                {
                    a += 1;
                    b += 1;
                }
            } catch (IndexOutOfBoundsException e) {
                // TODO: handle exception
            }
            
        }
        AllCheck(a,b);
    }

    void findhorizontal()
    {
        int a, b;
        a = x;
        b = y;
        for(int i = 0; i < 5; i++)
        {
            try {
                if(Frame.btns[a][b].getBackground() == Frame.btns[a][b +1].getBackground()) 
                {
                    b += 1;
                }
            } catch (IndexOutOfBoundsException e) {

            }
        }
        AllCheck(a,b);
    }


    void up(Color color, int findx, int findy)
    {
        var count = 0;

        for(int i = 0; i < 5; i++)
        {
            try {
                if(Frame.btns[findx + i][findy].getBackground() == color)
                {
                    count++;
                }

            } catch (IndexOutOfBoundsException e) {}
        }
        count(count);
    }

    void down(Color color, int findx, int findy)
    {
        var count = 0;

        for(int i = 0; i < 6; i++)
        {
            try {
                if(Frame.btns[findx - i][findy].getBackground() == color)
                {
                    count++;
                }

            } catch (IndexOutOfBoundsException e) {}
        }
        count(count);
        // j만 1칸씩 추가
    }

        
    void right(Color color, int findx, int findy)
    {
        var count = 0;

        for(int i = 0; i < 5; i++)
        {
            try {
                if(Frame.btns[findx][findy - i].getBackground() == color)
                {
                    count++;
                }

            } catch (IndexOutOfBoundsException e) {}
        }
        count(count);
        //i 추가
    }

    void left(Color color, int findx, int findy)
    {
        var count = 0;

        for(int i = 0; i < 5; i++)
        {
            try {
                if(Frame.btns[findx][findy+ i].getBackground() == color)
                {
                    count++;
                }

            } catch (IndexOutOfBoundsException e) {}
        }
        count(count);
        //i 감소
    }
    
    void leftCrossdown(Color color, int findx, int findy)
    {
        var count = 0;

        for(int i = 0; i < 5; i++)
        {
            try {
                if(Frame.btns[findx - i][findy + i].getBackground() == color)
                {
                    count++;
                }

            } catch (IndexOutOfBoundsException e) {}
        }
        count(count);
        //i 감소 y증가 밑 감소
    }

    void leftCrossup(Color color, int findx, int findy)
    {
        var count = 0;

        for(int i = 0; i < 5; i++)
        {
            try {
                if(Frame.btns[findx + i][findy - i].getBackground() == color)
                {
                    count++;
                }

            } catch (IndexOutOfBoundsException e) {}
        }
        count(count);
        //i 감소 y증가 밑 감소
    }

    void rightCrossup(Color color, int findx, int findy)
    {
        var count = 0;

        for(int i = 0; i < 5; i++)
        {
            try {
                if(Frame.btns[findx + i][findy + i].getBackground() == color)
                {
                    count++;
                }

            } catch (IndexOutOfBoundsException e) {}
        }
        count(count);
        //i 증가 y증가 밑 감소
    }

    void rightCrossdown(Color color, int findx, int findy)
    {
        var count = 0;

        for(int i = 0; i < 5; i++)
        {
            try {
                if(Frame.btns[findx - i][findy - i].getBackground() == color)
                {
                    count++;
                }

            } catch (IndexOutOfBoundsException e) {}
        }
        count(count);
        //i 증가 y증가 밑 감소
    }

    void count(int count)
    {
        if(count == 5)
        {
            System.out.println("승리");
            Winner = true;
        }
    }


    private void draw(ActionEvent e)
    {
        if(turn)
        {
            BackGround(e, Color.WHITE);
            turn = false;
        }
        else
        {
            BackGround(e, Color.BLACK);
            turn = true;
        }
    }

    private void BackGround(ActionEvent e, Color color)
    {

    
        JButton a = (JButton)e.getSource();
        a.setBackground(color);
        a.setBorderPainted(true);
        a.setContentAreaFilled(true);
        a.setFocusPainted(true);
        a.setOpaque(true);
        a.setEnabled(false);
        a.setText(null);
    }
}
