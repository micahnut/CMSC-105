/*     */ package org.jfree.chart.plot;
/*     */ 
/*     */ import java.awt.geom.Point2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.jfree.chart.ChartRenderingInfo;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.io.SerialUtilities;
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
/*     */ public class PlotRenderingInfo
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 8446720134379617220L;
/*     */   private ChartRenderingInfo owner;
/*     */   private Rectangle2D plotArea;
/*     */   private Rectangle2D dataArea;
/*     */   private List subplotInfo;
/*     */   
/*     */   public PlotRenderingInfo(ChartRenderingInfo owner) {
/*  90 */     this.owner = owner;
/*  91 */     this.dataArea = new Rectangle2D.Double();
/*  92 */     this.subplotInfo = new ArrayList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   public ChartRenderingInfo getOwner() { return this.owner; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 112 */   public Rectangle2D getPlotArea() { return this.plotArea; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 124 */   public void setPlotArea(Rectangle2D area) { this.plotArea = area; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 135 */   public Rectangle2D getDataArea() { return this.dataArea; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   public void setDataArea(Rectangle2D area) { this.dataArea = area; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 156 */   public int getSubplotCount() { return this.subplotInfo.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 167 */   public void addSubplotInfo(PlotRenderingInfo info) { this.subplotInfo.add(info); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 180 */   public PlotRenderingInfo getSubplotInfo(int index) { return (PlotRenderingInfo)this.subplotInfo.get(index); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSubplotIndex(Point2D source) {
/* 197 */     ParamChecks.nullNotPermitted(source, "source");
/* 198 */     int subplotCount = getSubplotCount();
/* 199 */     for (int i = 0; i < subplotCount; i++) {
/* 200 */       PlotRenderingInfo info = getSubplotInfo(i);
/* 201 */       Rectangle2D area = info.getDataArea();
/* 202 */       if (area.contains(source)) {
/* 203 */         return i;
/*     */       }
/*     */     } 
/* 206 */     return -1;
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
/* 218 */     if (this == obj) {
/* 219 */       return true;
/*     */     }
/* 221 */     if (!(obj instanceof PlotRenderingInfo)) {
/* 222 */       return false;
/*     */     }
/* 224 */     PlotRenderingInfo that = (PlotRenderingInfo)obj;
/* 225 */     if (!ObjectUtilities.equal(this.dataArea, that.dataArea)) {
/* 226 */       return false;
/*     */     }
/* 228 */     if (!ObjectUtilities.equal(this.plotArea, that.plotArea)) {
/* 229 */       return false;
/*     */     }
/* 231 */     if (!ObjectUtilities.equal(this.subplotInfo, that.subplotInfo)) {
/* 232 */       return false;
/*     */     }
/* 234 */     return true;
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
/*     */   public Object clone() throws CloneNotSupportedException {
/* 246 */     PlotRenderingInfo clone = (PlotRenderingInfo)super.clone();
/* 247 */     if (this.plotArea != null) {
/* 248 */       clone.plotArea = (Rectangle2D)this.plotArea.clone();
/*     */     }
/* 250 */     if (this.dataArea != null) {
/* 251 */       clone.dataArea = (Rectangle2D)this.dataArea.clone();
/*     */     }
/* 253 */     clone.subplotInfo = new ArrayList(this.subplotInfo.size());
/* 254 */     for (int i = 0; i < this.subplotInfo.size(); i++) {
/*     */       
/* 256 */       PlotRenderingInfo info = (PlotRenderingInfo)this.subplotInfo.get(i);
/* 257 */       clone.subplotInfo.add(info.clone());
/*     */     } 
/* 259 */     return clone;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream stream) throws IOException {
/* 270 */     stream.defaultWriteObject();
/* 271 */     SerialUtilities.writeShape(this.dataArea, stream);
/* 272 */     SerialUtilities.writeShape(this.plotArea, stream);
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
/*     */   private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
/* 285 */     stream.defaultReadObject();
/* 286 */     this.dataArea = (Rectangle2D)SerialUtilities.readShape(stream);
/* 287 */     this.plotArea = (Rectangle2D)SerialUtilities.readShape(stream);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/PlotRenderingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */