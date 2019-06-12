/*    */ package org.jfree.data.general;
/*    */ 
/*    */ import java.util.EventObject;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DatasetChangeEvent
/*    */   extends EventObject
/*    */ {
/*    */   private Dataset dataset;
/*    */   
/*    */   public DatasetChangeEvent(Object source, Dataset dataset) {
/* 71 */     super(source);
/* 72 */     this.dataset = dataset;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 83 */   public Dataset getDataset() { return this.dataset; }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/general/DatasetChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */