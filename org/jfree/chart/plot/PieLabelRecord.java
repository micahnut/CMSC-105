/*     */ package org.jfree.chart.plot;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.jfree.text.TextBox;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PieLabelRecord
/*     */   implements Comparable, Serializable
/*     */ {
/*     */   private Comparable key;
/*     */   private double angle;
/*     */   private double baseY;
/*     */   private double allocatedY;
/*     */   private TextBox label;
/*     */   private double labelHeight;
/*     */   private double gap;
/*     */   private double linkPercent;
/*     */   
/*     */   public PieLabelRecord(Comparable key, double angle, double baseY, TextBox label, double labelHeight, double gap, double linkPercent) {
/*  93 */     this.key = key;
/*  94 */     this.angle = angle;
/*  95 */     this.baseY = baseY;
/*  96 */     this.allocatedY = baseY;
/*  97 */     this.label = label;
/*  98 */     this.labelHeight = labelHeight;
/*  99 */     this.gap = gap;
/* 100 */     this.linkPercent = linkPercent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   public double getBaseY() { return this.baseY; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   public void setBaseY(double base) { this.baseY = base; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   public double getLowerY() { return this.allocatedY - this.labelHeight / 2.0D; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 137 */   public double getUpperY() { return this.allocatedY + this.labelHeight / 2.0D; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 146 */   public double getAngle() { return this.angle; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 155 */   public Comparable getKey() { return this.key; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 164 */   public TextBox getLabel() { return this.label; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 174 */   public double getLabelHeight() { return this.labelHeight; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 183 */   public double getAllocatedY() { return this.allocatedY; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 192 */   public void setAllocatedY(double y) { this.allocatedY = y; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 201 */   public double getGap() { return this.gap; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 210 */   public double getLinkPercent() { return this.linkPercent; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(Object obj) {
/* 222 */     int result = 0;
/* 223 */     if (obj instanceof PieLabelRecord) {
/* 224 */       PieLabelRecord plr = (PieLabelRecord)obj;
/* 225 */       if (this.baseY < plr.baseY) {
/* 226 */         result = -1;
/*     */       }
/* 228 */       else if (this.baseY > plr.baseY) {
/* 229 */         result = 1;
/*     */       } 
/*     */     } 
/* 232 */     return result;
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
/*     */   public boolean equals(Object obj) {
/* 244 */     if (obj == this) {
/* 245 */       return true;
/*     */     }
/* 247 */     if (!(obj instanceof PieLabelRecord)) {
/* 248 */       return false;
/*     */     }
/* 250 */     PieLabelRecord that = (PieLabelRecord)obj;
/* 251 */     if (!this.key.equals(that.key)) {
/* 252 */       return false;
/*     */     }
/* 254 */     if (this.angle != that.angle) {
/* 255 */       return false;
/*     */     }
/* 257 */     if (this.gap != that.gap) {
/* 258 */       return false;
/*     */     }
/* 260 */     if (this.allocatedY != that.allocatedY) {
/* 261 */       return false;
/*     */     }
/* 263 */     if (this.baseY != that.baseY) {
/* 264 */       return false;
/*     */     }
/* 266 */     if (this.labelHeight != that.labelHeight) {
/* 267 */       return false;
/*     */     }
/* 269 */     if (this.linkPercent != that.linkPercent) {
/* 270 */       return false;
/*     */     }
/* 272 */     if (!this.label.equals(that.label)) {
/* 273 */       return false;
/*     */     }
/* 275 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 285 */   public String toString() { return this.baseY + ", " + this.key.toString(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/PieLabelRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */