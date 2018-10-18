import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class mainframe extends JFrame{
    private Container cp;
    private JPanel jpn=new JPanel(new GridLayout(4,3,3,3));
    private JButton jbtns[]=new JButton[12];
    private String jbtnlabel[]=new String[10];
    private JLabel jlb=new JLabel("0");
    private Font fnt=new Font(null,Font.BOLD,60);


    public mainframe() {
        ex();
    }

    private void ex() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(50, 50, 300, 400);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(jpn,BorderLayout.CENTER);
        cp.add(jlb,BorderLayout.NORTH);
        genLabel(jbtnlabel);
        for (int i=0;i<10;i++){
            jbtns[i]=new JButton(jbtnlabel[i]);
            jbtns[i].setFont(fnt);
            jpn.add(jbtns[i]);
            jbtns[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JButton jButton=(JButton) actionEvent.getSource();
                    jlb.setText(jlb.getText()+jButton.getText());
                }
            });
        }

        jbtns[10]=new JButton("exit");
        jbtns[11]=new JButton("reflash");


        jpn.add(jbtns[10]);
        jpn.add(jbtns[11]);
        jbtns[10].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jbtns[11].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genLabel(jbtnlabel);
                for (int i=0;i<10;i++){
                    jbtns[i].setText(jbtnlabel[i]);
                }

            }
        });
    }
    private void genLabel(String str[]){
        int i=0;
        Random rnd=new Random(System.currentTimeMillis());
        while (i<10){
            jbtnlabel[i]=Integer.toString(rnd.nextInt(10));
            int j=0;
            boolean flag=false;
            while (j<i){
                if (jbtnlabel[i].equals(jbtnlabel[j])){
                    flag=true;
                    j=i;
                }
                j++;
            }
            if (!flag){
                i++;
            }
        }
    }
}