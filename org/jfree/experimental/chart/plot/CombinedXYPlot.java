/*     */ package org.jfree.experimental.chart.plot;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import org.jfree.chart.axis.ValueAxis;
/*     */ import org.jfree.chart.plot.CombinedDomainXYPlot;
/*     */ import org.jfree.chart.plot.XYPlot;
/*     */ import org.jfree.data.Range;
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
/*     */ public class CombinedXYPlot
/*     */   extends CombinedDomainXYPlot
/*     */ {
/*     */   public CombinedXYPlot(ValueAxis domainAxis, ValueAxis rangeAxis) {
/*  65 */     super(domainAxis);
/*  66 */     setGap(10.0D);
/*  67 */     super.setRangeAxis(rangeAxis);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   public void add(XYPlot subplot) { add(subplot, 1); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(XYPlot subplot, int weight) {
/*  86 */     super.add(subplot, weight);
/*     */     
/*  88 */     ValueAxis l_range = getRangeAxis();
/*  89 */     subplot.setRangeAxis(0, l_range, false);
/*     */     
/*  91 */     super.setRangeAxis(l_range);
/*  92 */     if (null == l_range) {
/*     */       return;
/*     */     }
/*     */     
/*  96 */     l_range.configure();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Range getDataRange(ValueAxis axis) {
/* 108 */     Range l_result = null;
/* 109 */     Iterator l_itr = getSubplots().iterator();
/* 110 */     while (l_itr.hasNext()) {
/* 111 */       XYPlot l_subplot = (XYPlot)l_itr.next();
/*     */       
/* 113 */       l_result = Range.combine(l_result, l_subplot.getDataRange(axis));
/*     */     } 
/* 115 */     return l_result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRangeAxis(ValueAxis axis) {
/* 124 */     Iterator l_itr = getSubplots().iterator();
/* 125 */     while (l_itr.hasNext()) {
/* 126 */       XYPlot l_subplot = (XYPlot)l_itr.next();
/* 127 */       l_subplot.setRangeAxis(0, axis, false);
/*     */     } 
/*     */     
/* 130 */     super.setRangeAxis(axis);
/* 131 */     if (null == axis) {
/*     */       return;
/*     */     }
/*     */     
/* 135 */     axis.configure();
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/plot/CombinedXYPlot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */