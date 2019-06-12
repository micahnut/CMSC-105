/*     */ package org.jfree.chart.axis;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Tick
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = 6668230383875149773L;
/*     */   private String text;
/*     */   private TextAnchor textAnchor;
/*     */   private TextAnchor rotationAnchor;
/*     */   private double angle;
/*     */   
/*     */   public Tick(String text, TextAnchor textAnchor, TextAnchor rotationAnchor, double angle) {
/*  86 */     ParamChecks.nullNotPermitted(textAnchor, "textAnchor");
/*  87 */     ParamChecks.nullNotPermitted(rotationAnchor, "rotationAnchor");
/*  88 */     this.text = text;
/*  89 */     this.textAnchor = textAnchor;
/*  90 */     this.rotationAnchor = rotationAnchor;
/*  91 */     this.angle = angle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 100 */   public String getText() { return this.text; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 109 */   public TextAnchor getTextAnchor() { return this.textAnchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   public TextAnchor getRotationAnchor() { return this.rotationAnchor; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   public double getAngle() { return this.angle; }
/*     */ 
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
/* 140 */     if (this == obj) {
/* 141 */       return true;
/*     */     }
/* 143 */     if (obj instanceof Tick) {
/* 144 */       Tick t = (Tick)obj;
/* 145 */       if (!ObjectUtilities.equal(this.text, t.text)) {
/* 146 */         return false;
/*     */       }
/* 148 */       if (!ObjectUtilities.equal(this.textAnchor, t.textAnchor)) {
/* 149 */         return false;
/*     */       }
/* 151 */       if (!ObjectUtilities.equal(this.rotationAnchor, t.rotationAnchor)) {
/* 152 */         return false;
/*     */       }
/* 154 */       if (this.angle != t.angle) {
/* 155 */         return false;
/*     */       }
/* 157 */       return true;
/*     */     } 
/* 159 */     return false;
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
/* 171 */   public Object clone() throws CloneNotSupportedException { return (Tick)super.clone(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 182 */   public String toString() { return this.text; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/Tick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */