/*    */ package lab2;
/*    */ import java.awt.GridBagConstraints;
/*    */ import java.awt.GridBagLayout;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.awt.event.WindowAdapter;
/*    */ import java.awt.event.WindowEvent;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class Menu extends JFrame implements ActionListener {
/*    */   public JFrame main;
/*    */   
/*    */   public Menu() {
/* 16 */     this.main = new JFrame("Summarizing and Presenting Data");
/* 17 */     this.header = new JLabel("Summarizing and Presenting Data");
/* 18 */     this.nume = new JButton("Numerical");
/* 19 */     this.cate = new JButton("Categorical");
/* 20 */     this.nume.addActionListener(this);
/* 21 */     this.cate.addActionListener(this);
/* 22 */     this.main.setSize(300, 300);
/* 23 */     this.main.setLayout(new GridBagLayout());
/* 24 */     GridBagConstraints c = new GridBagConstraints();
/* 25 */     c.fill = 2;
/*    */     
/* 27 */     this.header.setAlignmentX(0.0F);
/* 28 */     this.header.setAlignmentY(0.0F);
/* 29 */     c.weighty = 1.5D;
/* 30 */     c.gridy = 0;
/* 31 */     c.gridx = 0;
/* 32 */     this.main.add(this.header, c);
/*    */     
/* 34 */     c.gridy = 1;
/* 35 */     c.gridx = 0;
/* 36 */     this.main.add(this.cate, c);
/*    */     
/* 38 */     c.gridy = 2;
/* 39 */     c.gridx = 0;
/* 40 */     this.main.add(this.nume, c);
/*    */     
/* 42 */     this.main.setResizable(false);
/* 43 */     this.main.setLocationRelativeTo(null);
/* 44 */     this.main.setVisible(true);
/* 45 */     this.main.addWindowListener(new WindowAdapter()
/*    */         {
/* 47 */           public void windowClosing(WindowEvent we) { System.exit(0); }
/*    */         });
/*    */   }
/*    */   public JButton nume; public JButton cate;
/*    */   public JLabel header;
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 54 */     if (e.getSource() == this.cate) {
/* 55 */       DataPresentor dataPresentor = new DataPresentor();
/*    */     }
/* 57 */     else if (e.getSource() == this.nume) {
/* 58 */       Numerical numerical = new Numerical();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/* 63 */   public static void main(String[] args) { Menu men = new Menu(); }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab2/Menu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */