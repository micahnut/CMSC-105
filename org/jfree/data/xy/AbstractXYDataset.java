/*    */ package org.jfree.data.xy;
/*    */ 
/*    */ import org.jfree.data.DomainOrder;
/*    */ import org.jfree.data.general.AbstractSeriesDataset;
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
/*    */ public abstract class AbstractXYDataset
/*    */   extends AbstractSeriesDataset
/*    */   implements XYDataset
/*    */ {
/* 63 */   public DomainOrder getDomainOrder() { return DomainOrder.NONE; }
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
/*    */   public double getXValue(int series, int item) {
/* 76 */     double result = NaND;
/* 77 */     Number x = getX(series, item);
/* 78 */     if (x != null) {
/* 79 */       result = x.doubleValue();
/*    */     }
/* 81 */     return result;
/*    */   }
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
/*    */   public double getYValue(int series, int item) {
/* 94 */     double result = NaND;
/* 95 */     Number y = getY(series, item);
/* 96 */     if (y != null) {
/* 97 */       result = y.doubleValue();
/*    */     }
/* 99 */     return result;
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/AbstractXYDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */