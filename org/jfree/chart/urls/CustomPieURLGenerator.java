/*     */ package org.jfree.chart.urls;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.jfree.data.general.PieDataset;
/*     */ import org.jfree.util.PublicCloneable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomPieURLGenerator
/*     */   implements PieURLGenerator, Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7100607670144900503L;
/*     */   private ArrayList urls;
/*     */   
/*  74 */   public CustomPieURLGenerator() { this.urls = new ArrayList(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   public String generateURL(PieDataset dataset, Comparable key, int pieIndex) { return getURL(key, pieIndex); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   public int getListCount() { return this.urls.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getURLCount(int list) {
/* 116 */     int result = 0;
/* 117 */     Map urlMap = (Map)this.urls.get(list);
/* 118 */     if (urlMap != null) {
/* 119 */       result = urlMap.size();
/*     */     }
/* 121 */     return result;
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
/*     */   public String getURL(Comparable key, int mapIndex) {
/* 133 */     String result = null;
/* 134 */     if (mapIndex < getListCount()) {
/* 135 */       Map urlMap = (Map)this.urls.get(mapIndex);
/* 136 */       if (urlMap != null) {
/* 137 */         result = (String)urlMap.get(key);
/*     */       }
/*     */     } 
/* 140 */     return result;
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
/* 155 */   public void addURLs(Map urlMap) { this.urls.add(urlMap); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object o) {
/* 168 */     if (o == this) {
/* 169 */       return true;
/*     */     }
/*     */     
/* 172 */     if (o instanceof CustomPieURLGenerator) {
/* 173 */       CustomPieURLGenerator generator = (CustomPieURLGenerator)o;
/* 174 */       if (getListCount() != generator.getListCount()) {
/* 175 */         return false;
/*     */       }
/*     */       
/* 178 */       for (int pieItem = 0; pieItem < getListCount(); pieItem++) {
/* 179 */         if (getURLCount(pieItem) != generator.getURLCount(pieItem)) {
/* 180 */           return false;
/*     */         }
/* 182 */         Set keySet = ((HashMap)this.urls.get(pieItem)).keySet();
/*     */         
/* 184 */         for (Iterator i = keySet.iterator(); i.hasNext(); ) {
/* 185 */           String key = (String)i.next();
/* 186 */           if (!getURL(key, pieItem).equals(generator
/* 187 */               .getURL(key, pieItem))) {
/* 188 */             return false;
/*     */           }
/*     */         } 
/*     */       } 
/* 192 */       return true;
/*     */     } 
/* 194 */     return false;
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
/* 206 */     CustomPieURLGenerator urlGen = new CustomPieURLGenerator();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 211 */     for (Iterator i = this.urls.iterator(); i.hasNext(); ) {
/* 212 */       Map map = (Map)i.next();
/*     */       
/* 214 */       Map newMap = new HashMap();
/* 215 */       for (Iterator j = map.keySet().iterator(); j.hasNext(); ) {
/* 216 */         String key = (String)j.next();
/* 217 */         newMap.put(key, map.get(key));
/*     */       } 
/*     */       
/* 220 */       urlGen.addURLs(newMap);
/*     */     } 
/*     */     
/* 223 */     return urlGen;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/urls/CustomPieURLGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */