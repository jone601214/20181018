import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class lodout  extends JFrame {
    private Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    private int screew=screensize.width,scerrh=screensize.height;
    private int frmw=300,frmh=120;
    private Container cp ;
    private JLabel jl1 =new JLabel("ID");
    private JLabel jl2 =new JLabel("PassWord");
    private JTextField jtf =new JTextField();
    private JPasswordField jps =new JPasswordField();
    private JButton jb1 =new JButton("keyboard");
    private JButton jb2 =new JButton("Long in");
    private JButton jb3 =new JButton("Exit");
    private JPanel jp1 =new JPanel(new GridLayout(2,2,3,3));
    private JPanel jp2 =new JPanel(new GridLayout(1,3,3,3));
    public lodout (){
        init2();
    }
    private void init2(){
        this.setBounds(100, 100, 300, 100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(screew/2-frmw/2,scerrh/2-frmh/2,frmw,frmh);
        cp = this.getContentPane();
        cp.add(jp1,BorderLayout.CENTER);
        cp.add(jp2,BorderLayout.SOUTH);
        jp1.add(jl1);
        jp1.add(jtf);
        jp1.add(jl2);
        jp1.add(jps);
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);
        jb1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainframe mfrm=new mainframe();
                mfrm.setVisible(true);
            }
        });
        jb2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf.getText().equals("1")&&(new String(jps.getPassword()).equals("1"))){
                    Frame2 frm2 = new Frame2();
                    frm2.setVisible(true);
                    lodout.this.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        });
        jb3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}