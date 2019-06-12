/*    */ package lab1;
/*    */ 
/*    */ import java.awt.GridLayout;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.awt.event.WindowAdapter;
/*    */ import java.awt.event.WindowEvent;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Menu1
/*    */   extends JFrame
/*    */   implements ActionListener
/*    */ {
/* 17 */   private JFrame main = new JFrame("Basic Sampling Methods");
/* 18 */   private JButton simRand = new JButton("Simple Random");
/* 19 */   private JButton sys = new JButton("Systematic Random");
/* 20 */   private JButton strat = new JButton("Stratified");
/* 21 */   private JButton back = new JButton("Back");
/*    */   
/*    */   public Menu1() {
/* 24 */     this.main.setLayout(new GridLayout(4, true));
/* 25 */     this.main.add(this.simRand);
/* 26 */     this.main.add(this.sys);
/* 27 */     this.main.add(this.strat);
/* 28 */     this.main.add(this.back);
/*    */     
/* 30 */     this.simRand.addActionListener(this);
/* 31 */     this.sys.addActionListener(this);
/* 32 */     this.strat.addActionListener(this);
/* 33 */     this.back.addActionListener(this);
/*    */     
/* 35 */     this.main.setSize(300, 400);
/* 36 */     this.main.setLocationRelativeTo(null);
/* 37 */     this.main.setVisible(true);
/*    */     
/* 39 */     this.main.addWindowListener(new WindowAdapter()
/*    */         {
/* 41 */           public void windowClosing(WindowEvent we) { System.exit(0); }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 49 */     if (e.getSource() == this.simRand) {
/* 50 */       Simple simple = new Simple();
/*    */     }
/* 52 */     else if (e.getSource() == this.sys) {
/* 53 */       Systematic systematic = new Systematic();
/*    */     }
/* 55 */     else if (e.getSource() == this.strat) {
/* 56 */       Stratified stratified = new Stratified();
/*    */     }
/* 58 */     else if (e.getSource() == this.back) {
/*    */     
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 67 */   public static void main(String[] args) { Menu1 men = new Menu1(); }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab1/Menu1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */