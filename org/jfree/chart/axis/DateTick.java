/*     */ package org.jfree.chart.axis;
/*     */ 
/*     */ import java.util.Date;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.ui.TextAnchor;
/*     */ import org.jfree.util.ObjectUtilities;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DateTick
/*     */   extends ValueTick
/*     */ {
/*     */   private Date date;
/*     */   
/*  73 */   public DateTick(Date date, String label, TextAnchor textAnchor, TextAnchor rotationAnchor, double angle) { this(TickType.MAJOR, date, label, textAnchor, rotationAnchor, angle); }
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
/*     */   public DateTick(TickType tickType, Date date, String label, TextAnchor textAnchor, TextAnchor rotationAnchor, double angle) {
/*  92 */     super(tickType, date.getTime(), label, textAnchor, rotationAnchor, angle);
/*     */     
/*  94 */     ParamChecks.nullNotPermitted(tickType, "tickType");
/*  95 */     this.date = date;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 104 */   public Date getDate() { return this.date; }
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
/*     */   public boolean equals(Object obj) {
/* 116 */     if (obj == this) {
/* 117 */       return true;
/*     */     }
/* 119 */     if (!(obj instanceof DateTick)) {
/* 120 */       return false;
/*     */     }
/* 122 */     DateTick that = (DateTick)obj;
/* 123 */     if (!ObjectUtilities.equal(this.date, that.date)) {
/* 124 */       return false;
/*     */     }
/* 126 */     return super.equals(obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 136 */   public int hashCode() { return this.date.hashCode(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/DateTick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */