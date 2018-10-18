import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Frame2 extends JFrame{
    private Container cp;
    private JMenuBar jmb=new JMenuBar();
    private JMenu jmF=new JMenu("File");
    private JMenu jmT=new JMenu("Tool");
    private JMenu jmG=new JMenu("Game");
    private JMenu jmH=new JMenu("Help");
    private JMenuItem jmiopen=new JMenuItem("Open");
    private JMenuItem jmiclose=new JMenuItem("Close");
    private JMenuItem jmiexit=new JMenuItem("Exit");
    private JMenuItem jmioxgame=new JMenuItem("oxgame");
    private JMenuItem jmiencryption=new JMenuItem("encryption");
    public Frame2(){
        ex2();
    }
    private void ex2(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(100,100,980,600);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout());
        this.setJMenuBar(jmb);
        jmb.add(jmF);
        jmb.add(jmT);
        jmb.add(jmG);
        jmb.add(jmH);
        jmF.add(jmiopen);
        jmF.add(jmiclose);
        jmF.add(jmiexit);
        jmG.add(jmioxgame);
        jmT.add(jmiencryption);
        jmiexit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmioxgame.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OXGame oxGame=new OXGame();
                oxGame.setVisible(true);
                Frame2.this.setVisible(false);
            }
        });
        jmiencryption.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encryption ept=new encryption(Frame2.this);
                ept.setVisible(true);
                Frame2.this.setVisible(false);
            }
        });
        jmiexit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}