import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class movegame2 extends JFrame {
    private Container cp;
    private Frame2 frm2;
    private JLabel jlb1=new JLabel();
    private JLabel jlb2=new JLabel();
    private JLabel jlb3=new JLabel();
    private  Timer t1;
    private  Timer t2;
    private ImageIcon imgplan=new ImageIcon("1-2.png");
    private ImageIcon imgpocket=new ImageIcon("2-1.png");
    private ImageIcon imgplan1=new ImageIcon("1-1.png");
    private int targetX,targetY;
    private int origX,origY;
    private boolean isobselect=false;
    public movegame2(Frame2 frm) {
        frm2=frm;
        init();
    }
    private void init() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Frame2 frm=new Frame2();
                frm.setVisible(true);
            }
        });
        this.setBounds(50,50,1000,800);
        cp=this.getContentPane();
        cp.setLayout(null);

        Image img=imgplan1.getImage();
        Image img2=img.getScaledInstance(210,135,Image.SCALE_AREA_AVERAGING);
        imgplan1.setImage(img2);
        jlb3.setIcon(imgplan1);

        Image img1=imgplan.getImage();
        Image img3=img1.getScaledInstance(210,135,Image.SCALE_AREA_AVERAGING);
        imgplan.setImage(img3);
        jlb1.setIcon(imgplan);

        Image img4=imgpocket.getImage();
        Image img5=img4.getScaledInstance(30,50,Image.SCALE_AREA_AVERAGING);
        jlb2.setIcon(imgpocket);
        imgpocket.setImage(img5);

        jlb1.setBounds(350,550,269,187);
        cp.add(jlb1);
        t1=new Timer(50, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jlb2.setLocation(jlb2.getX(),jlb2.getY()-5);
                if (jlb2.getY()<0){
                    t1.stop();
                }
            }
        });
        t2=new Timer(50, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlb1.setLocation(jlb1.getX(),jlb1.getY());
                if (jlb1.getX()<0||jlb1.getX()>350){
                    t2.stop();
                }
            }
        });
        jlb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isobselect=true;
                origX=e.getX();
                origY=e.getY();
                System.out.println("origX:"+origX+"origY:"+origY);
            }
        });
       this.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {

           }

           @Override
           public void mousePressed(MouseEvent e) {
               if (SwingUtilities.isRightMouseButton(e)){
                   targetX=e.getX();
                   targetY=e.getY();
                   System.out.println("origX:"+origX+"origY:"+origY);
                   if (isobselect){
                       jlb1.setLocation(targetX,targetY);

                   }
               }
           }

           @Override
           public void mouseReleased(MouseEvent e) {

           }

           @Override
           public void mouseEntered(MouseEvent e) {

           }

           @Override
           public void mouseExited(MouseEvent e) {

           }
       });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getExtendedKeyCode());
                switch (e.getKeyCode()){
                    case 37:
                        jlb1.setIcon(imgplan);
                        jlb1.setLocation(jlb1.getX()-5,jlb1.getY());
                        break;
                    case 38:
                        jlb1.setIcon(imgplan);
                        jlb1.setLocation(jlb1.getX(),jlb1.getY()-5);
                    case 39:
                        jlb1.setIcon(imgplan1);
                        jlb1.setLocation(jlb1.getX()+5,jlb1.getY());
                        break;
                    case 40:
                        jlb1.setIcon(imgplan);
                        jlb1.setLocation(jlb1.getX(),jlb1.getY()+5);
                    case 32:
                        jlb2.setBounds(jlb1.getX()+50,jlb1.getY(),30,60);
                        cp.add(jlb2);
                        t1.start();
                        break;
                }

            }
        });
    }
}