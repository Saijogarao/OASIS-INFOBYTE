import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class task1 implements ActionListener
{
    private final static String nayaline = "\n",tabspace="\t";
    public static final Color colortop = new Color(0,0,0),colorbot=new Color(255,255,255);
    public int min=0,max=100;
    JTextArea details;
    JFrame frameS;
    JButton start,exit;
    dialogue1()
    {
        frameS=new JFrame();
        start=new JButton(" START ");
        start.setBackground(Color.darkGray);
        start.setForeground(Color.black);
        start.setFont(new Font("Open Sans", Font.BOLD, 30));
        start.addActionListener(this); 
        exit=new JButton("EXIT");
        exit.setBackground(Color.gray);
        exit.addActionListener(this);
        exit.setForeground(Color.black);
        exit.setFont(new Font("Open Sans", Font.BOLD, 30));
        String x="WELCOME to Guess The Number Game",x1="There are 2 levels :",x2="1)Guessing a number from 1 to 100 ",x3="2)Guessing a number from 1 to 1000 ";
        String x4="Intially player has 4 chances..",x5="Based on the level, number of chances will be reduced by 1 ";
        details=new JTextArea(20,50);
        details.append(tabspace+tabspace+x+nayaline+x1 + nayaline+x2 + nayaline+x3 + nayaline+x4 + nayaline+x5 + nayaline);
        details.setEditable(false);
        details.setFont(new Font("Open Sans", Font.BOLD, 20));
        details.setBackground(Color.black);
        details.setForeground(Color.white);
        GridBagLayout grid = new GridBagLayout(); 
        GridBagConstraints gbc = new GridBagConstraints();  
        frameS.setLayout(grid);   
        GridBagLayout layout = new GridBagLayout();  
        frameS.setLayout(layout);  
        gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.gridx = 0;  
        gbc.gridy = 0;  
        frameS.add(details, gbc);  
        gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.ipady = 20;  
        gbc.gridx = 0;  
        gbc.gridy = 1;  
        frameS.add(start,gbc);  
        gbc.gridx = 0;  
        gbc.gridy = 2;  
        frameS.add(exit, gbc);  
       frameS.setSize(300,300);
        frameS.setVisible(true);
    }  
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==start)
                {
                    String name;
                    int guessed,random,i=1,j=4,w=0;
                    name = JOptionPane.showInputDialog("Please type your name? ");
                    while(true)    
                    {    
                        if(name.isEmpty()){name = JOptionPane.showInputDialog("Please type your name? ");}
                        else{break;}
                    }
                    JOptionPane.showMessageDialog(null, "Hello " + name+",Click OK to Play The Game");
                    guessed=(int)(Float.parseFloat(JOptionPane.showInputDialog("Guess The Number!!")));
                    while(i<j)
                    {
                        random=(int)(Math.random()*(max-min+1)+min);
                        guessed=(int)(Float.parseFloat(JOptionPane.showInputDialog("Guess a Number!!(You have only "+ (j-i)+"chances left)")));
                        if(guessed==random)
                        {
                            w++;
                           if(w==1)
                           { 
                            JOptionPane.showMessageDialog(null, name+",Congratulations ,Level 1 Passed");
                            max=1000;i=0;j=3;
                            }
                            else{JOptionPane.showMessageDialog(null, name+",Congratualtions ,Sucessfully completed  2 Levels");}
                        }
                           
                        
                        i++;
                    }
                    if(i>=j){JOptionPane.showMessageDialog(null,  name+",You Lost (Pess OK to return Back)");}
                }
                if(e.getSource()==exit)
                {
                    System.exit(0);
                }
                
            }
        
    
    public static void main(String a[])
    {
        new dialogue1();
    }
}