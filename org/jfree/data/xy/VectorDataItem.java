/*     */ package org.jfree.data.xy;
/*     */ 
/*     */ import org.jfree.data.ComparableObjectItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VectorDataItem
/*     */   extends ComparableObjectItem
/*     */ {
/*  65 */   public VectorDataItem(double x, double y, double deltaX, double deltaY) { super(new XYCoordinate(x, y), new Vector(deltaX, deltaY)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getXValue() {
/*  74 */     XYCoordinate xy = (XYCoordinate)getComparable();
/*  75 */     return xy.getX();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getYValue() {
/*  84 */     XYCoordinate xy = (XYCoordinate)getComparable();
/*  85 */     return xy.getY();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   public Vector getVector() { return (Vector)getObject(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getVectorX() {
/* 103 */     Vector vi = (Vector)getObject();
/* 104 */     if (vi != null) {
/* 105 */       return vi.getX();
/*     */     }
/*     */     
/* 108 */     return NaND;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getVectorY() {
/* 118 */     Vector vi = (Vector)getObject();
/* 119 */     if (vi != null) {
/* 120 */       return vi.getY();
/*     */     }
/*     */     
/* 123 */     return NaND;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xy/VectorDataItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */