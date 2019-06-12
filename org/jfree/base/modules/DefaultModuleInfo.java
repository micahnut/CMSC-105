/*     */ package org.jfree.base.modules;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultModuleInfo
/*     */   implements ModuleInfo
/*     */ {
/*     */   private String moduleClass;
/*     */   private String majorVersion;
/*     */   private String minorVersion;
/*     */   private String patchLevel;
/*     */   
/*     */   public DefaultModuleInfo() {}
/*     */   
/*     */   public DefaultModuleInfo(String moduleClass, String majorVersion, String minorVersion, String patchLevel) {
/*  82 */     if (moduleClass == null)
/*     */     {
/*  84 */       throw new NullPointerException("Module class must not be null.");
/*     */     }
/*  86 */     this.moduleClass = moduleClass;
/*  87 */     this.majorVersion = majorVersion;
/*  88 */     this.minorVersion = minorVersion;
/*  89 */     this.patchLevel = patchLevel;
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
/* 101 */   public String getModuleClass() { return this.moduleClass; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setModuleClass(String moduleClass) {
/* 111 */     if (moduleClass == null)
/*     */     {
/* 113 */       throw new NullPointerException();
/*     */     }
/* 115 */     this.moduleClass = moduleClass;
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
/* 127 */   public String getMajorVersion() { return this.majorVersion; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 139 */   public void setMajorVersion(String majorVersion) { this.majorVersion = majorVersion; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 151 */   public String getMinorVersion() { return this.minorVersion; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 163 */   public void setMinorVersion(String minorVersion) { this.minorVersion = minorVersion; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 175 */   public String getPatchLevel() { return this.patchLevel; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 187 */   public void setPatchLevel(String patchLevel) { this.patchLevel = patchLevel; }
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
/* 198 */     if (this == o)
/*     */     {
/* 200 */       return true;
/*     */     }
/* 202 */     if (!(o instanceof DefaultModuleInfo))
/*     */     {
/* 204 */       return false;
/*     */     }
/*     */     
/* 207 */     ModuleInfo defaultModuleInfo = (ModuleInfo)o;
/*     */     
/* 209 */     if (!this.moduleClass.equals(defaultModuleInfo.getModuleClass()))
/*     */     {
/* 211 */       return false;
/*     */     }
/* 213 */     return true;
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
/* 225 */   public int hashCode() { return this.moduleClass.hashCode(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 238 */     StringBuffer buffer = new StringBuffer();
/* 239 */     buffer.append(getClass().getName());
/* 240 */     buffer.append("={ModuleClass=");
/* 241 */     buffer.append(getModuleClass());
/* 242 */     if (getMajorVersion() != null) {
/*     */       
/* 244 */       buffer.append("; Version=");
/* 245 */       buffer.append(getMajorVersion());
/* 246 */       if (getMinorVersion() != null) {
/*     */         
/* 248 */         buffer.append("-");
/* 249 */         buffer.append(getMinorVersion());
/* 250 */         if (getPatchLevel() != null) {
/*     */           
/* 252 */           buffer.append("_");
/* 253 */           buffer.append(getPatchLevel());
/*     */         } 
/*     */       } 
/*     */     } 
/* 257 */     buffer.append("}");
/* 258 */     return buffer.toString();
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/base/modules/DefaultModuleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */