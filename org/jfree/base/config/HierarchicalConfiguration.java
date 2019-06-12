/*     */ package org.jfree.base.config;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Collections;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.Properties;
/*     */ import java.util.TreeSet;
/*     */ import org.jfree.util.Configuration;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HierarchicalConfiguration
/*     */   implements ModifiableConfiguration, PublicCloneable
/*     */ {
/*     */   private Properties configuration;
/*     */   private Configuration parentConfiguration;
/*     */   
/*  83 */   public HierarchicalConfiguration() { this.configuration = new Properties(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HierarchicalConfiguration(Configuration parentConfiguration) {
/*  93 */     this();
/*  94 */     this.parentConfiguration = parentConfiguration;
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
/* 105 */   public String getConfigProperty(String key) { return getConfigProperty(key, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConfigProperty(String key, String defaultValue) {
/* 121 */     String value = this.configuration.getProperty(key);
/* 122 */     if (value == null)
/*     */     {
/* 124 */       if (isRootConfig()) {
/*     */         
/* 126 */         value = defaultValue;
/*     */       }
/*     */       else {
/*     */         
/* 130 */         value = this.parentConfiguration.getConfigProperty(key, defaultValue);
/*     */       } 
/*     */     }
/* 133 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigProperty(String key, String value) {
/* 144 */     if (key == null)
/*     */     {
/* 146 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 149 */     if (value == null) {
/*     */       
/* 151 */       this.configuration.remove(key);
/*     */     }
/*     */     else {
/*     */       
/* 155 */       this.configuration.setProperty(key, value);
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
/* 166 */   private boolean isRootConfig() { return (this.parentConfiguration == null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 178 */   public boolean isLocallyDefined(String key) { return this.configuration.containsKey(key); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 188 */   protected Properties getConfiguration() { return this.configuration; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertConfiguration(HierarchicalConfiguration config) {
/* 200 */     config.setParentConfig(getParentConfig());
/* 201 */     setParentConfig(config);
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
/*     */   protected void setParentConfig(Configuration config) {
/* 213 */     if (this.parentConfiguration == this)
/*     */     {
/* 215 */       throw new IllegalArgumentException("Cannot add myself as parent configuration.");
/*     */     }
/* 217 */     this.parentConfiguration = config;
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
/* 229 */   protected Configuration getParentConfig() { return this.parentConfiguration; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 241 */   public Enumeration getConfigProperties() { return this.configuration.keys(); }
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
/* 252 */     TreeSet keys = new TreeSet();
/* 253 */     collectPropertyKeys(prefix, this, keys);
/* 254 */     return Collections.unmodifiableSet(keys).iterator();
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
/*     */   private void collectPropertyKeys(String prefix, Configuration config, TreeSet collector) {
/* 269 */     Enumeration enum1 = config.getConfigProperties();
/* 270 */     while (enum1.hasMoreElements()) {
/*     */       
/* 272 */       String key = (String)enum1.nextElement();
/* 273 */       if (key.startsWith(prefix))
/*     */       {
/* 275 */         if (!collector.contains(key))
/*     */         {
/* 277 */           collector.add(key);
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/* 282 */     if (config instanceof HierarchicalConfiguration) {
/*     */       
/* 284 */       HierarchicalConfiguration hconfig = (HierarchicalConfiguration)config;
/* 285 */       if (hconfig.parentConfiguration != null)
/*     */       {
/* 287 */         collectPropertyKeys(prefix, hconfig.parentConfiguration, collector);
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
/* 300 */   protected boolean isParentSaved() { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void configurationLoaded() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream out) throws IOException {
/* 320 */     out.defaultWriteObject();
/* 321 */     if (!isParentSaved()) {
/*     */       
/* 323 */       out.writeBoolean(false);
/*     */     }
/*     */     else {
/*     */       
/* 327 */       out.writeBoolean(true);
/* 328 */       out.writeObject(this.parentConfiguration);
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
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
/* 343 */     in.defaultReadObject();
/* 344 */     boolean readParent = in.readBoolean();
/* 345 */     if (readParent) {
/*     */       
/* 347 */       this.parentConfiguration = (ModifiableConfiguration)in.readObject();
/*     */     }
/*     */     else {
/*     */       
/* 351 */       this.parentConfiguration = null;
/*     */     } 
/* 353 */     configurationLoaded();
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
/* 365 */     HierarchicalConfiguration config = (HierarchicalConfiguration)super.clone();
/* 366 */     config.configuration = (Properties)this.configuration.clone();
/* 367 */     return config;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/base/config/HierarchicalConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */