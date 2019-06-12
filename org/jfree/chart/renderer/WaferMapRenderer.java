/*     */ package org.jfree.chart.renderer;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Paint;
/*     */ import java.awt.Shape;
/*     */ import java.awt.Stroke;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.jfree.chart.LegendItem;
/*     */ import org.jfree.chart.LegendItemCollection;
/*     */ import org.jfree.chart.plot.DrawingSupplier;
/*     */ import org.jfree.chart.plot.WaferMapPlot;
/*     */ import org.jfree.data.general.WaferMapDataset;
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
/*     */ public class WaferMapRenderer
/*     */   extends AbstractRenderer
/*     */ {
/*     */   private Map paintIndex;
/*     */   private WaferMapPlot plot;
/*     */   private int paintLimit;
/*     */   private static final int DEFAULT_PAINT_LIMIT = 35;
/*     */   public static final int POSITION_INDEX = 0;
/*     */   public static final int VALUE_INDEX = 1;
/*     */   private int paintIndexMethod;
/*     */   
/*  94 */   public WaferMapRenderer() { this(null, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 104 */   public WaferMapRenderer(int paintLimit, int paintIndexMethod) { this(new Integer(paintLimit), new Integer(paintIndexMethod)); }
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
/*     */   public WaferMapRenderer(Integer paintLimit, Integer paintIndexMethod) {
/* 116 */     this.paintIndex = new HashMap();
/*     */     
/* 118 */     if (paintLimit == null) {
/* 119 */       this.paintLimit = 35;
/*     */     } else {
/*     */       
/* 122 */       this.paintLimit = paintLimit.intValue();
/*     */     } 
/*     */     
/* 125 */     this.paintIndexMethod = 1;
/* 126 */     if (paintIndexMethod != null && 
/* 127 */       isMethodValid(paintIndexMethod.intValue())) {
/* 128 */       this.paintIndexMethod = paintIndexMethod.intValue();
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
/*     */   private boolean isMethodValid(int method) {
/* 141 */     switch (method) { case 0:
/* 142 */         return true;
/* 143 */       case 1: return true; }
/* 144 */      return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DrawingSupplier getDrawingSupplier() {
/* 155 */     DrawingSupplier result = null;
/* 156 */     WaferMapPlot p = getPlot();
/* 157 */     if (p != null) {
/* 158 */       result = p.getDrawingSupplier();
/*     */     }
/* 160 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 169 */   public WaferMapPlot getPlot() { return this.plot; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlot(WaferMapPlot plot) {
/* 178 */     this.plot = plot;
/* 179 */     makePaintIndex();
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
/* 190 */   public Paint getChipColor(Number value) { return getSeriesPaint(getPaintIndex(value)); }
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
/* 201 */   private int getPaintIndex(Number value) { return ((Integer)this.paintIndex.get(value)).intValue(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void makePaintIndex() {
/* 209 */     if (this.plot == null) {
/*     */       return;
/*     */     }
/* 212 */     WaferMapDataset data = this.plot.getDataset();
/* 213 */     Number dataMin = data.getMinValue();
/* 214 */     Number dataMax = data.getMaxValue();
/* 215 */     Set uniqueValues = data.getUniqueValues();
/* 216 */     if (uniqueValues.size() <= this.paintLimit) {
/* 217 */       int count = 0;
/* 218 */       for (Iterator i = uniqueValues.iterator(); i.hasNext();) {
/* 219 */         this.paintIndex.put(i.next(), new Integer(count++));
/*     */       
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 225 */       switch (this.paintIndexMethod) {
/*     */         case 0:
/* 227 */           makePositionIndex(uniqueValues);
/*     */           break;
/*     */         case 1:
/* 230 */           makeValueIndex(dataMax, dataMin, uniqueValues);
/*     */           break;
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
/*     */   private void makePositionIndex(Set uniqueValues) {
/* 245 */     int valuesPerColor = (int)Math.ceil(uniqueValues
/* 246 */         .size() / this.paintLimit);
/*     */     
/* 248 */     int count = 0;
/* 249 */     int paint = 0;
/* 250 */     for (Iterator i = uniqueValues.iterator(); i.hasNext(); ) {
/* 251 */       this.paintIndex.put(i.next(), new Integer(paint));
/* 252 */       if (++count % valuesPerColor == 0) {
/* 253 */         paint++;
/*     */       }
/* 255 */       if (paint > this.paintLimit) {
/* 256 */         paint = this.paintLimit;
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
/*     */   private void makeValueIndex(Number max, Number min, Set uniqueValues) {
/* 270 */     double valueRange = max.doubleValue() - min.doubleValue();
/* 271 */     double valueStep = valueRange / this.paintLimit;
/* 272 */     int paint = 0;
/* 273 */     double cutPoint = min.doubleValue() + valueStep;
/* 274 */     for (Iterator i = uniqueValues.iterator(); i.hasNext(); ) {
/* 275 */       Number value = (Number)i.next();
/* 276 */       while (value.doubleValue() > cutPoint) {
/* 277 */         cutPoint += valueStep;
/* 278 */         paint++;
/* 279 */         if (paint > this.paintLimit) {
/* 280 */           paint = this.paintLimit;
/*     */         }
/*     */       } 
/* 283 */       this.paintIndex.put(value, new Integer(paint));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LegendItemCollection getLegendCollection() {
/* 294 */     LegendItemCollection result = new LegendItemCollection();
/* 295 */     if (this.paintIndex != null && this.paintIndex.size() > 0) {
/* 296 */       if (this.paintIndex.size() <= this.paintLimit) {
/* 297 */         Iterator i = this.paintIndex.entrySet().iterator();
/* 298 */         while (i.hasNext())
/*     */         {
/* 300 */           Map.Entry entry = (Map.Entry)i.next();
/* 301 */           String label = entry.getKey().toString();
/* 302 */           String description = label;
/* 303 */           Shape shape = new Rectangle2D.Double(1.0D, 1.0D, 1.0D, 1.0D);
/* 304 */           Paint paint = lookupSeriesPaint(((Integer)entry
/* 305 */               .getValue()).intValue());
/* 306 */           Paint outlinePaint = Color.black;
/* 307 */           Stroke outlineStroke = DEFAULT_STROKE;
/*     */           
/* 309 */           result.add(new LegendItem(label, description, null, null, shape, paint, outlineStroke, outlinePaint));
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 316 */         Set unique = new HashSet();
/* 317 */         Iterator i = this.paintIndex.entrySet().iterator();
/* 318 */         while (i.hasNext()) {
/* 319 */           Map.Entry entry = (Map.Entry)i.next();
/* 320 */           if (unique.add(entry.getValue())) {
/*     */ 
/*     */ 
/*     */             
/* 324 */             String label = getMinPaintValue((Integer)entry.getValue()).toString() + " - " + getMaxPaintValue((Integer)entry.getValue()).toString();
/* 325 */             String description = label;
/* 326 */             Shape shape = new Rectangle2D.Double(1.0D, 1.0D, 1.0D, 1.0D);
/* 327 */             Paint paint = getSeriesPaint(((Integer)entry
/* 328 */                 .getValue()).intValue());
/*     */             
/* 330 */             Paint outlinePaint = Color.black;
/* 331 */             Stroke outlineStroke = DEFAULT_STROKE;
/*     */             
/* 333 */             result.add(new LegendItem(label, description, null, null, shape, paint, outlineStroke, outlinePaint));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 340 */     return result;
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
/*     */   private Number getMinPaintValue(Integer index) {
/* 352 */     double minValue = Double.POSITIVE_INFINITY;
/* 353 */     for (Iterator i = this.paintIndex.entrySet().iterator(); i.hasNext(); ) {
/* 354 */       Map.Entry entry = (Map.Entry)i.next();
/* 355 */       if (((Integer)entry.getValue()).equals(index) && (
/* 356 */         (Number)entry.getKey()).doubleValue() < minValue) {
/* 357 */         minValue = ((Number)entry.getKey()).doubleValue();
/*     */       }
/*     */     } 
/*     */     
/* 361 */     return new Double(minValue);
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
/*     */   private Number getMaxPaintValue(Integer index) {
/* 373 */     double maxValue = Double.NEGATIVE_INFINITY;
/* 374 */     for (Iterator i = this.paintIndex.entrySet().iterator(); i.hasNext(); ) {
/* 375 */       Map.Entry entry = (Map.Entry)i.next();
/* 376 */       if (((Integer)entry.getValue()).equals(index) && (
/* 377 */         (Number)entry.getKey()).doubleValue() > maxValue) {
/* 378 */         maxValue = ((Number)entry.getKey()).doubleValue();
/*     */       }
/*     */     } 
/*     */     
/* 382 */     return new Double(maxValue);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/renderer/WaferMapRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */