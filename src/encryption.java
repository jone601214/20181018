import javax.naming.Name;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class encryption     extends JFrame{
    private Container cp;
    private JTextArea jtaR = new JTextArea("",30,15);
    private JTextArea jtaL = new JTextArea("",30,15);
    private JScrollPane jspR = new JScrollPane(jtaR);
    private JScrollPane jspL = new JScrollPane(jtaL);
    private JPanel jpnC = new JPanel(new GridLayout(9,1,5,5));
    private JPanel jpnR = new JPanel(new GridLayout(1,1,5,5));
    private JPanel jpnL = new JPanel(new GridLayout(1,1,5,5));
    private JLabel jlb1 = new JLabel("Method");
    private String method [] = {"DES","AES", "Caesar","XOR"};
    private JComboBox jca = new JComboBox<String>(method);
    private JLabel jlb2 = new JLabel("Password");
    private JTextField jtf = new JTextField();
    private JRadioButton jrb1=new JRadioButton("Encrypt");
    private JRadioButton jrb2=new JRadioButton("Decrypt");
    private JButton jbtrun = new JButton("Run");
    private JButton jbtclose = new JButton("Close");
    private JButton jbtclear = new JButton("Clear");
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmf = new JMenu("File");
    private JMenuItem jmsave=new JMenuItem("SAVE");
    private JMenu jmh = new JMenu("Help");
    private JMenuItem jmiOpen = new JMenuItem("OPEN");
    private JFileChooser jfc = new JFileChooser();
    Frame2 frm5;
    public encryption(Frame2 frm6){
        frm5 = frm6;
        ex1();
    }private void ex1(){
        this.setBounds(200,200,600,540);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Frame2 frm=new Frame2();
                frm.setVisible(true);
            }
        });
        this.setJMenuBar(jmb);
        cp = this.getContentPane();
        cp.add(jpnL, BorderLayout.WEST);
        cp.add(jpnC, BorderLayout.CENTER);
        cp.add(jpnR, BorderLayout.EAST);
        jpnL.add(jspL);
        jpnR.add(jspR);
        jpnC.add(jlb1);
        jpnC.add(jca);
        jpnC.add(jlb2);
        jpnC.add(jtf);
        jpnC.add(jrb1);
        jpnC.add(jrb2);
        jpnC.add(jbtrun);
        jpnC.add(jbtclear);
        jpnC.add(jbtclose);
        buttonGroup.add(jrb1);
        buttonGroup.add(jrb2);
        jmb.add(jmf);
        jmb.add(jmh);
        jmf.add(jmiOpen);
        jmf.add(jmsave);
        jmiOpen.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (jfc.showOpenDialog(encryption.this)==JFileChooser.APPROVE_OPTION){
                        jtaL.setText("");
                        String str = "";
                        File selectFile = jfc.getSelectedFile();
                        FileReader fr = new FileReader("C:\\Users\\USER");
                        BufferedReader bufferedReader = new BufferedReader(fr);
                        while((str = bufferedReader.readLine())!=null){
                            jtaL.append(str);
                        }
                        fr.close();
                    }
                }catch (IOException ioe){
                    JOptionPane.showMessageDialog(encryption.this,"No File is not find");
                }
            }
        });

        jbtrun.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrb1.isSelected()){
                    int dataLength = jtaL.getText().length();
                    if (dataLength>0) {
                        switch (jca.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(encryption.this, "Sorry" + jca.getSelectedItem() + "not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(encryption.this, "Sorry" + jca.getSelectedItem() + "not implement yet!");
                                break;
                            case 2:
                                char data[] = jtaL.getText().toCharArray();
                                int key = Integer.parseInt(jtf.getText());
                                try {
                                    for (int i = 0; i < data.length; i++) {
                                        data[i] = (char) (data[i] + key);
                                    }
                                    jtaR.setText(new String(data));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(encryption.this, "key is not Number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(encryption.this, "Error" + exp1.toString());
                                }
                                break;
                            case 3:
                                char data1[]=jtaL.getText().toCharArray();
                                char key1[]=jtf.getText().toCharArray();
                                for (int i=0;i<data1.length;i++){
                                    data1[i]=(char)((int)data1[i]^(int)key1[i%key1.length]);
                                }
                                jtaR.setText(new String(data1));
                                break;
                        }
                    }
                }else if (jrb2.isSelected()) {
                    int dataLength = jtaR.getText().length();
                    if (dataLength > 0) {
                        switch (jca.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(encryption.this, "Sorry" + jca.getSelectedItem() + "not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(encryption.this, "Sorry" + jca.getSelectedItem() + "not implement yet!");
                                break;
                            case 2:
                                char data[] = jtaR.getText().toCharArray();
                                int key = Integer.parseInt(jtf.getText());
                                try {
                                    for (int i = 0; i < data.length; i++) {
                                        data[i] = (char) (data[i] - key);
                                    }
                                    jtaL.setText(new String(data));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(encryption.this, "key is not Number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(encryption.this, "Error" + exp1.toString());
                                }
                                break;
                            case 3:
                                char data1[] = jtaL.getText().toCharArray();
                                int key1 = Integer.parseInt(jtf.getText());
                                try {
                                    for (int i = 0; i < data1.length; i++) {
                                        data1[i] = (char) (data1[i] - key1);
                                    }
                                    jtaR.setText(new String(data1));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(encryption.this, "key is not Number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(encryption.this, "Error" + exp1.toString());
                                }
                                break;
                        }
                    }
                }
            }
        });
        jbtclose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame2 frm2 = new Frame2();
                frm2.setVisible(true);
                encryption.this.dispose();

            }
        });
        jmsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (jtaR.getText().length()>0){
                        jfc.setFileFilter(new FileNameExtensionFilter(".txt.doc","txt","doc"));
                        if (jfc.showOpenDialog(encryption.this)==JFileChooser.APPROVE_OPTION){
                            File selectFile=new File(jfc.getSelectedFile().getPath() + jfc.getSelectedFile().getName() + ".txt");
                        FileWriter fr = new FileWriter(selectFile);
                        BufferedWriter bufferedWriter = new BufferedWriter(fr);
                        bufferedWriter.write(jtaR.getText());
                        bufferedWriter.close();
                        }
                        } else {
                        JOptionPane.showMessageDialog(encryption.this,"No File is not find");
                        }
                    }catch (IOException ie){
                        JOptionPane.showMessageDialog(encryption.this,"open file error"+ie.toString());
                    } catch (Exception exp1) {
                        JOptionPane.showMessageDialog(encryption.this, "Error" + exp1.toString());
                    }
                }
            });
        jbtclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaR.setText(" ");
                jtaL.setText(" ");
            }
        });
    }
}