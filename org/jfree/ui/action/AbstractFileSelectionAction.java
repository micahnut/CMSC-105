/*     */ package org.jfree.ui.action;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.io.File;
/*     */ import javax.swing.JFileChooser;
/*     */ import org.jfree.ui.ExtensionFileFilter;
/*     */ import org.jfree.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractFileSelectionAction
/*     */   extends AbstractActionDowngrade
/*     */ {
/*     */   private JFileChooser fileChooser;
/*     */   private Component parent;
/*     */   
/*  74 */   public AbstractFileSelectionAction(Component parent) { this.parent = parent; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract String getFileExtension();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract String getFileDescription();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   protected File getCurrentDirectory() { return new File("."); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected File performSelectFile(File selectedFile, int dialogType, boolean appendExtension) {
/* 115 */     if (this.fileChooser == null) {
/* 116 */       this.fileChooser = createFileChooser();
/*     */     }
/*     */     
/* 119 */     this.fileChooser.setSelectedFile(selectedFile);
/* 120 */     this.fileChooser.setDialogType(dialogType);
/* 121 */     int option = this.fileChooser.showDialog(this.parent, null);
/* 122 */     if (option == 0) {
/* 123 */       File selFile = this.fileChooser.getSelectedFile();
/* 124 */       String selFileName = selFile.getAbsolutePath();
/* 125 */       if (!StringUtils.endsWithIgnoreCase(selFileName, getFileExtension())) {
/* 126 */         selFileName = selFileName + getFileExtension();
/*     */       }
/* 128 */       return new File(selFileName);
/*     */     } 
/* 130 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected JFileChooser createFileChooser() {
/* 139 */     JFileChooser fc = new JFileChooser();
/* 140 */     fc.addChoosableFileFilter(new ExtensionFileFilter(
/* 141 */           getFileDescription(), getFileExtension()));
/*     */     
/* 143 */     fc.setMultiSelectionEnabled(false);
/* 144 */     fc.setCurrentDirectory(getCurrentDirectory());
/* 145 */     return fc;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/action/AbstractFileSelectionAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */