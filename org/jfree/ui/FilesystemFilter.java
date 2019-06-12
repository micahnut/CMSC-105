/*     */ package org.jfree.ui;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FilenameFilter;
/*     */ import javax.swing.filechooser.FileFilter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FilesystemFilter
/*     */   extends FileFilter
/*     */   implements FilenameFilter
/*     */ {
/*     */   private String[] fileext;
/*     */   private String descr;
/*     */   private boolean accDirs;
/*     */   
/*  68 */   public FilesystemFilter(String fileext, String descr) { this(fileext, descr, true); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  80 */   public FilesystemFilter(String fileext, String descr, boolean accDirs) { this(new String[] { fileext }, descr, accDirs); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FilesystemFilter(String[] fileext, String descr, boolean accDirs) {
/*  93 */     this.fileext = (String[])fileext.clone();
/*  94 */     this.descr = descr;
/*  95 */     this.accDirs = accDirs;
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
/*     */   public boolean accept(File dir, String name) {
/* 107 */     File f = new File(dir, name);
/* 108 */     if (f.isDirectory() && acceptsDirectories()) {
/* 109 */       return true;
/*     */     }
/*     */     
/* 112 */     for (int i = 0; i < this.fileext.length; i++) {
/* 113 */       if (name.endsWith(this.fileext[i])) {
/* 114 */         return true;
/*     */       }
/*     */     } 
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean accept(File dir) {
/* 128 */     if (dir.isDirectory() && acceptsDirectories()) {
/* 129 */       return true;
/*     */     }
/*     */     
/* 132 */     for (int i = 0; i < this.fileext.length; i++) {
/* 133 */       if (dir.getName().endsWith(this.fileext[i])) {
/* 134 */         return true;
/*     */       }
/*     */     } 
/* 137 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 146 */   public String getDescription() { return this.descr; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 155 */   public void acceptDirectories(boolean b) { this.accDirs = b; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 164 */   public boolean acceptsDirectories() { return this.accDirs; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/FilesystemFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */