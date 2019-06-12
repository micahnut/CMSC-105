/*     */ package org.jfree.ui;
/*     */ 
/*     */ import javax.swing.text.AttributeSet;
/*     */ import javax.swing.text.BadLocationException;
/*     */ import javax.swing.text.PlainDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LengthLimitingDocument
/*     */   extends PlainDocument
/*     */ {
/*     */   private int maxlen;
/*     */   
/*  65 */   public LengthLimitingDocument() { this(-1); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   public LengthLimitingDocument(int maxlen) { this.maxlen = maxlen; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  87 */   public void setMaxLength(int maxlen) { this.maxlen = maxlen; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   public int getMaxLength() { return this.maxlen; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
/* 109 */     if (str == null) {
/*     */       return;
/*     */     }
/*     */     
/* 113 */     if (this.maxlen < 0) {
/* 114 */       super.insertString(offs, str, a);
/*     */     }
/*     */     
/* 117 */     char[] numeric = str.toCharArray();
/* 118 */     StringBuffer b = new StringBuffer();
/* 119 */     b.append(numeric, 0, Math.min(this.maxlen, numeric.length));
/* 120 */     super.insertString(offs, b.toString(), a);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/LengthLimitingDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */