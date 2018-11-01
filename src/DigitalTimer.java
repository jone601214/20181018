import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DigitalTimer extends JFrame {
    private Container cp;
private Frame2 frm2;
private JLabel jlbS[]=new JLabel[8];
private JPanel jpnC=new JPanel(new GridLayout(1,8,2,2));
private String jlbImageName[]={"0.PNG","1.PNG","2.PNG","3.PNG","4.PNG","5.PNG","6.PNG","7.PNG","8.PNG","9.PNG"};
private ImageIcon icon[]=new ImageIcon[10];
private JPanel jpnS=new JPanel(new GridLayout(1,3,3,3));
private JButton jbtnstart=new JButton("start");
private JButton jbtnreset=new JButton("reset");
private JButton jbtnclose=new JButton("close");
private Timer t1;
private int h,m,s;
public DigitalTimer(Frame2 frm){
    frm2=frm;
    init();
}
private void init(){
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp=this.getContentPane();
    this.setBounds(100,100,300,150);
    cp.setLayout(new BorderLayout(3,3));
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            frm2.setVisible(true);
        }
    });
    for (int i=0;i<10;i++){
        icon[i]=new ImageIcon(jlbImageName[i]);
        Image img=icon[i].getImage();
        Image newimg=img.getScaledInstance(30,60, Image.SCALE_SMOOTH);
        icon[i]=new ImageIcon(newimg);
    }
    jlbS[6]=new JLabel(":");
    jlbS[6].setFont(new Font(null,Font.BOLD,24));
    jlbS[6].setHorizontalAlignment(JLabel.CENTER);
    jlbS[7]=new JLabel(":");
    jlbS[7].setFont(new Font(null,Font.BOLD,24));
    jlbS[7].setHorizontalAlignment(JLabel.CENTER);
    for (int i=0;i<6;i++){
        jlbS[i]=new JLabel(icon[0]);
        if (i==2){
            jpnC.add(jlbS[6]);
            jpnC.add(jlbS[i]);
        }else if (i==4){
            jpnC.add(jlbS[7]);
            jpnC.add(jlbS[i]);
        }else {
            jpnC.add(jlbS[i]);
        }
    }
    t1=new Timer(300, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            s++;
            if (s==60){
                s=0;
                m++;
                if (m==60){
                    m=0;
                    h++;
                }
            }
            if ((s%2)==0){
                jlbS[6].setForeground(Color.green);
                jlbS[7].setForeground(Color.green);
            }else {
                jlbS[6].setForeground(Color.black);
                jlbS[7].setForeground(Color.black);
            }
            jlbS[5].setIcon(icon[s%10]);
            jlbS[4].setIcon(icon[s/10]);
            jlbS[3].setIcon(icon[m%10]);
            jlbS[2].setIcon(icon[m/10]);
            jlbS[1].setIcon(icon[h%10]);
            jlbS[0].setIcon(icon[h/10]);
        }
    });
   cp.add(jpnC,BorderLayout.CENTER);
   cp.add(jpnS,BorderLayout.SOUTH);
   jpnS.add(jbtnstart);jpnS.add(jbtnreset);jpnS.add(jbtnclose);
   jbtnstart.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           JButton tmptn=(JButton)e.getSource();
           if (tmptn.getText().equals("start")){
               t1.start();
               tmptn.setText("Pause");
           }else {
               t1.stop();
               tmptn.setText("start");
           }
       }
   });
  }
}
