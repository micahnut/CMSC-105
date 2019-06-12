/*     */ package org.jfree.chart.title;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import org.jfree.chart.block.Arrangement;
/*     */ import org.jfree.chart.block.BlockContainer;
/*     */ import org.jfree.chart.block.BlockResult;
/*     */ import org.jfree.chart.block.EntityBlockParams;
/*     */ import org.jfree.chart.entity.LegendItemEntity;
/*     */ import org.jfree.chart.entity.StandardEntityCollection;
/*     */ import org.jfree.data.general.Dataset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LegendItemBlockContainer
/*     */   extends BlockContainer
/*     */ {
/*     */   private Dataset dataset;
/*     */   private Comparable seriesKey;
/*     */   private int datasetIndex;
/*     */   private int series;
/*     */   private String toolTipText;
/*     */   private String urlText;
/*     */   
/*     */   public LegendItemBlockContainer(Arrangement arrangement, int datasetIndex, int series) {
/* 103 */     super(arrangement);
/* 104 */     this.datasetIndex = datasetIndex;
/* 105 */     this.series = series;
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
/*     */   public LegendItemBlockContainer(Arrangement arrangement, Dataset dataset, Comparable seriesKey) {
/* 119 */     super(arrangement);
/* 120 */     this.dataset = dataset;
/* 121 */     this.seriesKey = seriesKey;
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
/* 132 */   public Dataset getDataset() { return this.dataset; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 143 */   public Comparable getSeriesKey() { return this.seriesKey; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 154 */   public int getDatasetIndex() { return this.datasetIndex; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 163 */   public int getSeriesIndex() { return this.series; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 174 */   public String getToolTipText() { return this.toolTipText; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 185 */   public void setToolTipText(String text) { this.toolTipText = text; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 196 */   public String getURLText() { return this.urlText; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 207 */   public void setURLText(String text) { this.urlText = text; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object draw(Graphics2D g2, Rectangle2D area, Object params) {
/* 223 */     super.draw(g2, area, null);
/*     */     
/* 225 */     BlockResult r = new BlockResult();
/* 226 */     if (params instanceof EntityBlockParams) {
/* 227 */       EntityBlockParams ebp = (EntityBlockParams)params;
/* 228 */       if (ebp.getGenerateEntities()) {
/* 229 */         StandardEntityCollection standardEntityCollection = new StandardEntityCollection();
/*     */         
/* 231 */         LegendItemEntity entity = new LegendItemEntity((Shape)area.clone());
/* 232 */         entity.setSeriesIndex(this.series);
/* 233 */         entity.setSeriesKey(this.seriesKey);
/* 234 */         entity.setDataset(this.dataset);
/* 235 */         entity.setToolTipText(getToolTipText());
/* 236 */         entity.setURLText(getURLText());
/* 237 */         standardEntityCollection.add(entity);
/* 238 */         r.setEntityCollection(standardEntityCollection);
/*     */       } 
/*     */     } 
/* 241 */     return r;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/title/LegendItemBlockContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */