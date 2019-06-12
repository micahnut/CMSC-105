/*    */ package display;
/*    */ 
/*    */ import java.awt.Canvas;
/*    */ import java.awt.Dimension;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Display
/*    */ {
/*    */   private JFrame frame;
/*    */   private Canvas canvas;
/*    */   private String title;
/*    */   private int width;
/*    */   private int height;
/*    */   
/*    */   public Display(String title, int width, int height) {
/* 18 */     this.title = title;
/* 19 */     this.width = width;
/* 20 */     this.height = height;
/*    */     
/* 22 */     createDisplay();
/*    */   }
/*    */   
/*    */   private void createDisplay() {
/* 26 */     this.frame = new JFrame(this.title);
/* 27 */     this.frame.setSize(this.width, this.height);
/* 28 */     this.frame.setDefaultCloseOperation(3);
/* 29 */     this.frame.setResizable(false);
/* 30 */     this.frame.setLocationRelativeTo(null);
/*    */     
/* 32 */     this.frame.setVisible(true);
/*    */     
/* 34 */     this.canvas = new Canvas();
/* 35 */     this.canvas.setPreferredSize(new Dimension(this.width, this.height));
/* 36 */     this.canvas.setMaximumSize(new Dimension(this.width, this.height));
/* 37 */     this.canvas.setMinimumSize(new Dimension(this.width, this.height));
/* 38 */     this.canvas.setFocusable(false);
/*    */     
/* 40 */     this.frame.add(this.canvas);
/* 41 */     this.frame.pack();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 46 */   public Canvas getCanvas() { return this.canvas; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 51 */   public JFrame getFrame() { return this.frame; }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/display/Display.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */