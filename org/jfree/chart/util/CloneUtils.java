/*     */ package org.jfree.chart.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class CloneUtils
/*     */ {
/*     */   public static List<?> cloneList(List<?> source) {
/*  65 */     ParamChecks.nullNotPermitted(source, "source");
/*  66 */     List result = new ArrayList();
/*  67 */     for (Object obj : source) {
/*  68 */       if (obj != null) {
/*     */         try {
/*  70 */           result.add(ObjectUtilities.clone(obj)); continue;
/*  71 */         } catch (CloneNotSupportedException ex) {
/*  72 */           throw new RuntimeException(ex);
/*     */         } 
/*     */       }
/*  75 */       result.add(null);
/*     */     } 
/*     */     
/*  78 */     return result;
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
/*     */   public static Map cloneMapValues(Map source) {
/*  92 */     ParamChecks.nullNotPermitted(source, "source");
/*  93 */     Map result = new HashMap();
/*  94 */     for (Object key : source.keySet()) {
/*  95 */       Object value = source.get(key);
/*  96 */       if (value != null) {
/*     */         try {
/*  98 */           result.put(key, ObjectUtilities.clone(value)); continue;
/*  99 */         } catch (CloneNotSupportedException ex) {
/* 100 */           throw new RuntimeException(ex);
/*     */         } 
/*     */       }
/* 103 */       result.put(key, null);
/*     */     } 
/*     */     
/* 106 */     return result;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/util/CloneUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */