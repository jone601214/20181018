import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerError;

public class linechat extends JFrame {
    private Container cp;
    private JButton jbtn=new JButton("傳送");
    private JLabel jlb=new JLabel("聊天");
    private Frame2 frm2;
    public linechat(Frame2 frm){
        frm2=frm;
        init();
    }
    private void init() {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frm2.setVisible(true);
            }
        });
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(100, 50);
        this.setSize(800, 600);
        cp = this.getContentPane();
        jlb.setBounds(400,0,400,150);
        jlb.setFont(new Font("標楷體", Font.BOLD, 32));
        jbtn.setBounds(50,50,100,20);
        cp.add(jlb);
        this.add(jbtn);
        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ServerSocket svs=new ServerSocket(3068);
                    System.out.println("等待客戶端的請求中...");
                    Socket s=svs.accept();
                    System.out.println("客戶端已和本機連上線...");
                    OutputStream out=s.getOutputStream();
                    String str="ytjkumyfuki7o9fulogfol";
                    System.out.println("資料正在傳送中....");
                    out.write(str.getBytes());
                    out.close();
                    s.close();
                    System.out.println("資料傳送完畢...");

                }
                catch (Exception esp){
                    System.out.println("發生了"+esp+"例外");
                }
            }
        });

    }
}
//server