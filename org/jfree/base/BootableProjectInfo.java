/*     */ package org.jfree.base;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BootableProjectInfo
/*     */   extends BasicProjectInfo
/*     */ {
/*     */   private String bootClass;
/*     */   private boolean autoBoot;
/*     */   
/*  65 */   public BootableProjectInfo() { this.autoBoot = true; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BootableProjectInfo(String name, String version, String licence, String info) {
/*  78 */     this();
/*  79 */     setName(name);
/*  80 */     setVersion(version);
/*  81 */     setLicenceName(licence);
/*  82 */     setInfo(info);
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
/*     */   public BootableProjectInfo(String name, String version, String info, String copyright, String licenceName) {
/*  96 */     this();
/*  97 */     setName(name);
/*  98 */     setVersion(version);
/*  99 */     setLicenceName(licenceName);
/* 100 */     setInfo(info);
/* 101 */     setCopyright(copyright);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BootableProjectInfo[] getDependencies() {
/* 110 */     ArrayList dependencies = new ArrayList();
/* 111 */     Library[] libraries = getLibraries();
/* 112 */     for (i = 0; i < libraries.length; i++) {
/* 113 */       Library lib = libraries[i];
/* 114 */       if (lib instanceof BootableProjectInfo) {
/* 115 */         dependencies.add(lib);
/*     */       }
/*     */     } 
/*     */     
/* 119 */     Library[] optionalLibraries = getOptionalLibraries();
/* 120 */     for (int i = 0; i < optionalLibraries.length; i++) {
/* 121 */       Library lib = optionalLibraries[i];
/* 122 */       if (lib instanceof BootableProjectInfo) {
/* 123 */         dependencies.add(lib);
/*     */       }
/*     */     } 
/* 126 */     return (BootableProjectInfo[])dependencies
/* 127 */       .toArray(new BootableProjectInfo[dependencies.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addDependency(BootableProjectInfo projectInfo) {
/* 137 */     if (projectInfo == null) {
/* 138 */       throw new NullPointerException();
/*     */     }
/* 140 */     addLibrary(projectInfo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 149 */   public String getBootClass() { return this.bootClass; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 158 */   public void setBootClass(String bootClass) { this.bootClass = bootClass; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 167 */   public boolean isAutoBoot() { return this.autoBoot; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 176 */   public void setAutoBoot(boolean autoBoot) { this.autoBoot = autoBoot; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/base/BootableProjectInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */