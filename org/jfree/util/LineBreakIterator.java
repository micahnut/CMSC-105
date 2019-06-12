/*     */ package org.jfree.util;
/*     */ 
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
/*     */ 
/*     */ public class LineBreakIterator
/*     */   implements Iterator
/*     */ {
/*     */   public static final int DONE = -1;
/*     */   private char[] text;
/*     */   private int position;
/*     */   
/*  67 */   public LineBreakIterator() { setText(""); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   public LineBreakIterator(String text) { setText(text); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int nextPosition() {
/*     */     char c;
/*     */     boolean eol;
/*  87 */     if (this.text == null)
/*     */     {
/*  89 */       return -1;
/*     */     }
/*  91 */     if (this.position == -1)
/*     */     {
/*  93 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  98 */     int nChars = this.text.length;
/*  99 */     int nextChar = this.position;
/*     */ 
/*     */     
/*     */     do {
/* 103 */       if (nextChar >= nChars) {
/*     */ 
/*     */         
/* 106 */         this.position = -1;
/* 107 */         return -1;
/*     */       } 
/*     */       
/* 110 */       eol = false;
/* 111 */       c = Character.MIN_VALUE;
/*     */       
/*     */       int i;
/*     */       
/* 115 */       for (i = nextChar; i < nChars; i++) {
/*     */         
/* 117 */         c = this.text[i];
/* 118 */         if (c == '\n' || c == '\r') {
/*     */           
/* 120 */           eol = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 125 */       nextChar = i;
/* 126 */     } while (!eol);
/*     */     
/* 128 */     nextChar++;
/* 129 */     if (c == '\r')
/*     */     {
/* 131 */       if (nextChar < nChars && this.text[nextChar] == '\n')
/*     */       {
/* 133 */         nextChar++;
/*     */       }
/*     */     }
/* 136 */     this.position = nextChar;
/* 137 */     return this.position;
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
/*     */   public int nextWithEnd() {
/* 150 */     int pos = this.position;
/* 151 */     if (pos == -1)
/*     */     {
/* 153 */       return -1;
/*     */     }
/* 155 */     if (pos == this.text.length) {
/*     */       
/* 157 */       this.position = -1;
/* 158 */       return -1;
/*     */     } 
/* 160 */     int retval = nextPosition();
/* 161 */     if (retval == -1)
/*     */     {
/* 163 */       return this.text.length;
/*     */     }
/* 165 */     return retval;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 175 */   public String getText() { return new String(this.text); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(String text) {
/* 185 */     this.position = 0;
/* 186 */     this.text = text.toCharArray();
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
/* 198 */   public boolean hasNext() { return (this.position != -1); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object next() {
/* 208 */     if (this.position == -1)
/*     */     {
/*     */       
/* 211 */       return null;
/*     */     }
/*     */     
/* 214 */     int lastFound = this.position;
/* 215 */     int pos = nextWithEnd();
/* 216 */     if (pos == -1)
/*     */     {
/*     */       
/* 219 */       return new String(this.text, lastFound, this.text.length - lastFound);
/*     */     }
/*     */ 
/*     */     
/* 223 */     if (pos > 0) {
/*     */       
/* 225 */       int end = lastFound;
/* 226 */       for (; pos > end && (this.text[pos - 1] == '\n' || this.text[pos - 1] == '\r'); pos--);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 233 */     return new String(this.text, lastFound, pos - lastFound);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 253 */   public void remove() { throw new UnsupportedOperationException("This iterator is read-only."); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/util/LineBreakIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */