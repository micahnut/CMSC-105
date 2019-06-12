/*    */ package lab3;
/*    */ 
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
/*    */ public class DescMenu
/*    */   extends JFrame
/*    */   implements ActionListener {
/*    */   public JFrame main;
/*    */   public JButton group;
/*    */   
/*    */   public DescMenu() {
/* 20 */     this.main = new JFrame("Descriptive Statistics");
/* 21 */     this.header = new JLabel("Descriptive Statistics");
/* 22 */     this.group = new JButton("Grouped Data");
/* 23 */     this.ungroup = new JButton("Ungrouped Data");
/* 24 */     this.btmain = new JButton("Back to Main Menu");
/* 25 */     this.group.addActionListener(this);
/* 26 */     this.ungroup.addActionListener(this);
/* 27 */     this.btmain.addActionListener(this);
/* 28 */     this.main.setSize(300, 300);
/* 29 */     this.main.setLayout(new GridBagLayout());
/* 30 */     GridBagConstraints c = new GridBagConstraints();
/* 31 */     c.fill = 2;
/*    */     
/* 33 */     this.header.setAlignmentX(0.0F);
/* 34 */     this.header.setAlignmentY(0.0F);
/* 35 */     c.weighty = 1.5D;
/* 36 */     c.gridy = 0;
/* 37 */     c.gridx = 0;
/* 38 */     this.main.add(this.header, c);
/*    */     
/* 40 */     c.gridy = 1;
/* 41 */     c.gridx = 0;
/* 42 */     this.main.add(this.ungroup, c);
/*    */     
/* 44 */     c.gridy = 1;
/* 45 */     c.gridx = 2;
/* 46 */     this.main.add(this.group, c);
/*    */     
/* 48 */     c.gridy = 2;
/* 49 */     c.gridx = 0;
/* 50 */     this.main.add(this.btmain, c);
/*    */     
/* 52 */     this.main.setResizable(false);
/* 53 */     this.main.setLocationRelativeTo(null);
/* 54 */     this.main.setVisible(true);
/* 55 */     this.main.addWindowListener(new WindowAdapter()
/*    */         {
/* 57 */           public void windowClosing(WindowEvent we) { System.exit(0); }
/*    */         });
/*    */   }
/*    */   public JButton ungroup; public JButton btmain;
/*    */   public JLabel header;
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 64 */     if (e.getSource() == this.ungroup) {
/* 65 */       this.main.dispose();
/* 66 */       Ungrouped ungrouped = new Ungrouped();
/*    */     }
/* 68 */     else if (e.getSource() == this.group) {
/* 69 */       this.main.dispose();
/* 70 */       Grouped grouped = new Grouped();
/*    */     }
/* 72 */     else if (e.getSource() == this.btmain) {
/* 73 */       this.main.dispose();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 83 */   public static void main(String[] args) { DescMenu men = new DescMenu(); }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab3/DescMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */