import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JMenuItem jmiFileDecrypt=new JMenuItem("FileDecrypt");
    private JMenuItem jmiDigitalTimer=new JMenuItem("DigitalTimer");
    private JMenuItem jmimovegame=new JMenuItem("movegame");

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
        jmG.add(jmimovegame);
        jmT.add(jmiencryption);
        jmT.add(jmiFileDecrypt);
        jmT.add(jmiDigitalTimer);
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
        jmiFileDecrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDecrypt fid = new FileDecrypt(Frame2.this);
                fid.setVisible(true);
                Frame2.this.setVisible(false);
            }
        });
        jmiDigitalTimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DigitalTimer dit = new DigitalTimer(Frame2.this);
                dit.setVisible(true);
                Frame2.this.setVisible(false);
            }
        });
        jmimovegame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movegame mov = new movegame(Frame2.this);
                mov.setVisible(true);
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