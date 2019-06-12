/*     */ package org.jfree.util;
/*     */ 
/*     */ import java.awt.Stroke;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import org.jfree.io.SerialUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StrokeList
/*     */   extends AbstractObjectList
/*     */ {
/*  74 */   public Stroke getStroke(int index) { return (Stroke)get(index); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   public void setStroke(int index, Stroke stroke) { set(index, stroke); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  95 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
/*     */ 
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
/* 107 */     if (o == null) {
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     if (o == this) {
/* 112 */       return true;
/*     */     }
/*     */     
/* 115 */     if (o instanceof StrokeList) {
/* 116 */       return super.equals(o);
/*     */     }
/*     */     
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 129 */   public int hashCode() { return super.hashCode(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream stream) throws IOException {
/* 141 */     stream.defaultWriteObject();
/* 142 */     int count = size();
/* 143 */     stream.writeInt(count);
/* 144 */     for (int i = 0; i < count; i++) {
/* 145 */       Stroke stroke = getStroke(i);
/* 146 */       if (stroke != null) {
/* 147 */         stream.writeInt(i);
/* 148 */         SerialUtilities.writeStroke(stroke, stream);
/*     */       } else {
/*     */         
/* 151 */         stream.writeInt(-1);
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
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
/* 167 */     stream.defaultReadObject();
/* 168 */     int count = stream.readInt();
/* 169 */     for (int i = 0; i < count; i++) {
/* 170 */       int index = stream.readInt();
/* 171 */       if (index != -1)
/* 172 */         setStroke(index, SerialUtilities.readStroke(stream)); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/util/StrokeList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */