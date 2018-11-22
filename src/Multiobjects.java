//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.util.ArrayList;
//
//public class Multiobjects extends JFrame {
//    private Frame2 frm2;
//    private Container cp;
////   private ArrayList<Boat>boatArrayList=new ArrayList<Boat>();
//   private ArrayList<Thread>threads=new ArrayList<>();
//    public Multiobjects(Frame2 frm){
//        frm2=frm;
//        init();
//    }
//    private void init(){
//cp=this.getContentPane();
//cp.setLayout(null);
//this.setBounds(100,100,600,500);
//this.addKeyListener(new KeyAdapter() {
//    @Override
//    public void keyTyped(KeyEvent e) {
//        System.out.println(e.getKeyCode());
//        if (e.getKeyCode()==32){
////            boatArrayList.add(new Boat());
////            cp.add(boatArrayList.get(boatArrayList.size()-1));
////            System.out.println(boatArrayList.get(boatArrayList.size()-1));
////            threads.add(new Thread(boatArrayList.get(boatArrayList.size()-1)));
////            threads.get(threads.size()-1).start();
////        }
////        System.out.println(boatArrayList.size());
//    }
//});
//Multiobjects.this.addWindowListener(new WindowAdapter() {
//    @Override
//    public void windowClosing(WindowEvent e) {
//        Multiobjects.this.dispose();
//        frm2.setVisible(true);
//    }
//});
//    }
//}
