/*     */ package org.jfree.experimental.chart.renderer.xy;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import org.jfree.chart.axis.ValueAxis;
/*     */ import org.jfree.chart.entity.EntityCollection;
/*     */ import org.jfree.chart.plot.CrosshairState;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.chart.plot.XYPlot;
/*     */ import org.jfree.chart.renderer.xy.XYItemRendererState;
/*     */ import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
/*     */ import org.jfree.data.xy.XYDataset;
/*     */ import org.jfree.ui.RectangleEdge;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XYSmoothLineAndShapeRenderer
/*     */   extends XYLineAndShapeRenderer
/*     */ {
/*     */   protected void drawPrimaryLine(XYItemRendererState state, Graphics2D g2, XYPlot plot, XYDataset dataset, int pass, int series, int item, ValueAxis domainAxis, ValueAxis rangeAxis, Rectangle2D dataArea) {
/*  87 */     if (item == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  92 */     double x1 = dataset.getXValue(series, item);
/*  93 */     double y1 = dataset.getYValue(series, item);
/*  94 */     if (Double.isNaN(y1) || Double.isNaN(x1)) {
/*     */       return;
/*     */     }
/*     */     
/*  98 */     double x0 = dataset.getXValue(series, item - 1);
/*  99 */     double y0 = dataset.getYValue(series, item - 1);
/* 100 */     if (Double.isNaN(y0) || Double.isNaN(x0)) {
/*     */       return;
/*     */     }
/*     */     
/* 104 */     RectangleEdge xAxisLocation = plot.getDomainAxisEdge();
/* 105 */     RectangleEdge yAxisLocation = plot.getRangeAxisEdge();
/*     */     
/* 107 */     double transX0 = domainAxis.valueToJava2D(x0, dataArea, xAxisLocation);
/* 108 */     double transY0 = rangeAxis.valueToJava2D(y0, dataArea, yAxisLocation);
/*     */     
/* 110 */     double transX1 = domainAxis.valueToJava2D(x1, dataArea, xAxisLocation);
/* 111 */     double transY1 = rangeAxis.valueToJava2D(y1, dataArea, yAxisLocation);
/*     */ 
/*     */     
/* 114 */     if (Double.isNaN(transX0) || Double.isNaN(transY0) || 
/* 115 */       Double.isNaN(transX1) || Double.isNaN(transY1)) {
/*     */       return;
/*     */     }
/*     */     
/* 119 */     Point2D.Double point0 = new Point2D.Double();
/* 120 */     Point2D.Double point1 = new Point2D.Double();
/* 121 */     Point2D.Double point2 = new Point2D.Double();
/* 122 */     Point2D.Double point3 = new Point2D.Double();
/*     */     
/* 124 */     if (item == 1) {
/* 125 */       point0 = null;
/*     */     } else {
/*     */       
/* 128 */       point0.x = domainAxis.valueToJava2D(dataset.getXValue(series, item - 2), dataArea, xAxisLocation);
/*     */       
/* 130 */       point0.y = rangeAxis.valueToJava2D(dataset.getYValue(series, item - 2), dataArea, yAxisLocation);
/*     */     } 
/*     */ 
/*     */     
/* 134 */     point1.x = transX0;
/* 135 */     point1.y = transY0;
/*     */     
/* 137 */     point2.x = transX1;
/* 138 */     point2.y = transY1;
/*     */     
/* 140 */     if (item + 1 == dataset.getItemCount(series)) {
/* 141 */       point3 = null;
/*     */     } else {
/*     */       
/* 144 */       point3.x = domainAxis.valueToJava2D(dataset.getXValue(series, item + 1), dataArea, xAxisLocation);
/*     */       
/* 146 */       point3.y = rangeAxis.valueToJava2D(dataset.getYValue(series, item + 1), dataArea, yAxisLocation);
/*     */     } 
/*     */ 
/*     */     
/* 150 */     int steps = ((int)((point2.x - point1.x) / 0.2D) < 30) ? (int)((point2.x - point1.x) / 0.2D) : 30;
/*     */ 
/*     */     
/* 153 */     Point2D.Double[] arrayOfDouble = getBezierCurve(point0, point1, point2, point3, 1.0D, steps);
/*     */ 
/*     */     
/* 156 */     for (int i = 1; i < arrayOfDouble.length; i++) {
/* 157 */       transX0 = (arrayOfDouble[i - 1]).x;
/* 158 */       transY0 = (arrayOfDouble[i - 1]).y;
/* 159 */       transX1 = (arrayOfDouble[i]).x;
/* 160 */       transY1 = (arrayOfDouble[i]).y;
/*     */       
/* 162 */       PlotOrientation orientation = plot.getOrientation();
/* 163 */       if (orientation == PlotOrientation.HORIZONTAL) {
/* 164 */         state.workingLine.setLine(transY0, transX0, transY1, transX1);
/*     */       }
/* 166 */       else if (orientation == PlotOrientation.VERTICAL) {
/* 167 */         state.workingLine.setLine(transX0, transY0, transX1, transY1);
/*     */       } 
/*     */       
/* 170 */       if (state.workingLine.intersects(dataArea)) {
/* 171 */         drawFirstPassShape(g2, pass, series, item, state.workingLine);
/*     */       }
/*     */     } 
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
/*     */   protected void drawSecondaryPass(Graphics2D g2, XYPlot plot, XYDataset dataset, int pass, int series, int item, ValueAxis domainAxis, Rectangle2D dataArea, ValueAxis rangeAxis, CrosshairState crosshairState, EntityCollection entities) {}
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
/*     */   public static void getControlPoints(Point2D.Double point0, Point2D.Double point1, Point2D.Double point2, Point2D.Double point3, Point2D.Double control1, Point2D.Double control2, double smooth) {
/* 222 */     if (point0 == null) {
/* 223 */       point0 = point1;
/*     */     }
/* 225 */     if (point3 == null) {
/* 226 */       point3 = point2;
/*     */     }
/*     */     
/* 229 */     Point2D.Double c1 = new Point2D.Double((point0.x + point1.x) / 2.0D, (point0.y + point1.y) / 2.0D);
/*     */     
/* 231 */     Point2D.Double c2 = new Point2D.Double((point1.x + point2.x) / 2.0D, (point1.y + point2.y) / 2.0D);
/*     */     
/* 233 */     Point2D.Double c3 = new Point2D.Double((point2.x + point3.x) / 2.0D, (point2.y + point3.y) / 2.0D);
/*     */ 
/*     */     
/* 236 */     double len1 = point1.distance(point0);
/* 237 */     double len2 = point2.distance(point1);
/* 238 */     double len3 = point3.distance(point2);
/*     */     
/* 240 */     double k1 = len1 / (len1 + len2);
/* 241 */     double k2 = len2 / (len2 + len3);
/*     */     
/* 243 */     Point2D.Double m1 = new Point2D.Double(c1.x + (c2.x - c1.x) * k1, c1.y + (c2.y - c1.y) * k1);
/*     */     
/* 245 */     Point2D.Double m2 = new Point2D.Double(c2.x + (c3.x - c2.x) * k2, c2.y + (c3.y - c2.y) * k2);
/*     */ 
/*     */     
/* 248 */     control1.setLocation(new Point2D.Double(m1.x + (c2.x - m1.x) * smooth + point1.x - m1.x, m1.y + (c2.y - m1.y) * smooth + point1.y - m1.y));
/*     */ 
/*     */     
/* 251 */     control2.setLocation(new Point2D.Double(m2.x + (c2.x - m2.x) * smooth + point2.x - m2.x, m2.y + (c2.y - m2.y) * smooth + point2.y - m2.y));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Point2D.Double[] getBezierCurve(Point2D.Double point0, Point2D.Double point1, Point2D.Double point2, Point2D.Double point3, double smooth, int steps) {
/* 271 */     Point2D.Double control1 = new Point2D.Double();
/* 272 */     Point2D.Double control2 = new Point2D.Double();
/*     */     
/* 274 */     getControlPoints(point0, point1, point2, point3, control1, control2, smooth);
/*     */ 
/*     */     
/* 277 */     Point2D.Double C = new Point2D.Double(3.0D * (control1.x - point1.x), 3.0D * (control1.y - point1.y));
/*     */     
/* 279 */     Point2D.Double B = new Point2D.Double(3.0D * (control2.x - control1.x) - C.x, 3.0D * (control2.y - control1.y) - C.y);
/*     */     
/* 281 */     Point2D.Double A = new Point2D.Double(point2.x - point1.x - C.x - B.x, point2.y - point1.y - C.y - B.y);
/*     */ 
/*     */     
/* 284 */     Point2D.Double[] arrayOfDouble = new Point2D.Double[steps + 1];
/* 285 */     double stepSize = 1.0D / steps;
/* 286 */     double step = stepSize;
/*     */     
/* 288 */     arrayOfDouble[0] = point1;
/* 289 */     for (int i = 1; i < steps; i++) {
/* 290 */       arrayOfDouble[i] = new Point2D.Double(A.x * Math.pow(step, 3.0D) + B.x * 
/* 291 */           Math.pow(step, 2.0D) + C.x * step + point1.x, A.y * 
/* 292 */           Math.pow(step, 3.0D) + B.y * Math.pow(step, 2.0D) + C.y * step + point1.y);
/*     */       
/* 294 */       step += stepSize;
/*     */     } 
/* 296 */     arrayOfDouble[steps] = point2;
/*     */     
/* 298 */     return arrayOfDouble;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/renderer/xy/XYSmoothLineAndShapeRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */