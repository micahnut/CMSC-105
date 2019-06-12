/*     */ package org.jfree.util;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.Properties;
/*     */ import java.util.TreeSet;
/*     */ import org.jfree.base.config.ModifiableConfiguration;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultConfiguration
/*     */   extends Properties
/*     */   implements ModifiableConfiguration
/*     */ {
/*  78 */   public String getConfigProperty(String key) { return getProperty(key); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   public String getConfigProperty(String key, String defaultValue) { return getProperty(key, defaultValue); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator findPropertyKeys(String prefix) {
/* 105 */     TreeSet collector = new TreeSet();
/* 106 */     Enumeration enum1 = keys();
/* 107 */     while (enum1.hasMoreElements()) {
/*     */       
/* 109 */       String key = (String)enum1.nextElement();
/* 110 */       if (key.startsWith(prefix))
/*     */       {
/* 112 */         if (!collector.contains(key))
/*     */         {
/* 114 */           collector.add(key);
/*     */         }
/*     */       }
/*     */     } 
/* 118 */     return Collections.unmodifiableSet(collector).iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   public Enumeration getConfigProperties() { return keys(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigProperty(String key, String value) {
/* 139 */     if (value == null) {
/*     */       
/* 141 */       remove(key);
/*     */     }
/*     */     else {
/*     */       
/* 145 */       setProperty(key, value);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/util/DefaultConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */