/*     */ package org.jfree.base;
/*     */ 
/*     */ import org.jfree.JCommon;
/*     */ import org.jfree.base.config.ModifiableConfiguration;
/*     */ import org.jfree.util.Configuration;
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
/*     */ public class BaseBoot
/*     */   extends AbstractBoot
/*     */ {
/*     */   private static BaseBoot singleton;
/*     */   private BootableProjectInfo bootableProjectInfo;
/*     */   
/*  73 */   private BaseBoot() { this.bootableProjectInfo = JCommon.INFO; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  82 */   public static ModifiableConfiguration getConfiguration() { return (ModifiableConfiguration)getInstance().getGlobalConfig(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Configuration loadConfiguration() {
/* 100 */     return createDefaultHierarchicalConfiguration("/org/jfree/base/jcommon.properties", "/jcommon.properties", true, BaseBoot.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AbstractBoot getInstance() {
/* 110 */     if (singleton == null) {
/* 111 */       singleton = new BaseBoot();
/*     */     }
/* 113 */     return singleton;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void performBoot() {
/* 122 */     ObjectUtilities.setClassLoaderSource(getConfiguration().getConfigProperty("org.jfree.ClassLoader"));
/*     */     
/* 124 */     getPackageManager().addModule(org.jfree.base.log.DefaultLogModule.class.getName());
/* 125 */     getPackageManager().load("org.jfree.jcommon.modules.");
/* 126 */     getPackageManager().initializeModules();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 135 */   protected BootableProjectInfo getProjectInfo() { return this.bootableProjectInfo; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/base/BaseBoot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */