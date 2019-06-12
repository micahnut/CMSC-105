/*    */ package org.jfree.data.xy;
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
/*    */ public abstract class AbstractXYZDataset
/*    */   extends AbstractXYDataset
/*    */   implements XYZDataset
/*    */ {
/*    */   public double getZValue(int series, int item) {
/* 61 */     double result = NaND;
/* 62 */     Number z = getZ(series, item);
/* 63 */     if (z != null) {
/* 64 */       result = z.doubleValue();
/*    */     }
/* 66 */     return result;
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/AbstractXYZDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */