/*     */ package org.jfree.util;
/*     */ 
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExtendedConfigurationWrapper
/*     */   implements ExtendedConfiguration
/*     */ {
/*     */   private Configuration parent;
/*     */   
/*     */   public ExtendedConfigurationWrapper(Configuration parent) {
/*  66 */     if (parent == null)
/*     */     {
/*  68 */       throw new NullPointerException("Parent given must not be null");
/*     */     }
/*  70 */     this.parent = parent;
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
/*  82 */   public boolean getBoolProperty(String name) { return getBoolProperty(name, false); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   public boolean getBoolProperty(String name, boolean defaultValue) { return "true".equals(this.parent.getConfigProperty(name, String.valueOf(defaultValue))); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 109 */   public int getIntProperty(String name) { return getIntProperty(name, 0); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIntProperty(String name, int defaultValue) {
/* 123 */     String retval = this.parent.getConfigProperty(name);
/* 124 */     if (retval == null)
/*     */     {
/* 126 */       return defaultValue;
/*     */     }
/*     */     
/*     */     try {
/* 130 */       return Integer.parseInt(retval);
/*     */     }
/* 132 */     catch (Exception e) {
/*     */       
/* 134 */       return defaultValue;
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
/* 146 */   public boolean isPropertySet(String name) { return (this.parent.getConfigProperty(name) != null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   public Iterator findPropertyKeys(String prefix) { return this.parent.findPropertyKeys(prefix); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 168 */   public String getConfigProperty(String key) { return this.parent.getConfigProperty(key); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 184 */   public String getConfigProperty(String key, String defaultValue) { return this.parent.getConfigProperty(key, defaultValue); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 194 */   public Enumeration getConfigProperties() { return this.parent.getConfigProperties(); }
/*     */ 
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
/* 206 */     ExtendedConfigurationWrapper wrapper = (ExtendedConfigurationWrapper)super.clone();
/* 207 */     wrapper.parent = (Configuration)this.parent.clone();
/* 208 */     return this.parent;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/util/ExtendedConfigurationWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */