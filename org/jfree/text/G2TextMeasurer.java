/*    */ package org.jfree.text;
/*    */ 
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.geom.Rectangle2D;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class G2TextMeasurer
/*    */   implements TextMeasurer
/*    */ {
/*    */   private Graphics2D g2;
/*    */   
/* 65 */   public G2TextMeasurer(Graphics2D g2) { this.g2 = g2; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public float getStringWidth(String text, int start, int end) {
/* 79 */     FontMetrics fm = this.g2.getFontMetrics();
/* 80 */     Rectangle2D bounds = TextUtilities.getTextBounds(text
/* 81 */         .substring(start, end), this.g2, fm);
/*    */     
/* 83 */     return (float)bounds.getWidth();
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/text/G2TextMeasurer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */