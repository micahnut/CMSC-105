/*     */ package org.jfree.util;
/*     */ 
/*     */ import java.awt.Shape;
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
/*     */ public class ShapeList
/*     */   extends AbstractObjectList
/*     */ {
/*  74 */   public Shape getShape(int index) { return (Shape)get(index); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   public void setShape(int index, Shape shape) { set(index, shape); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 109 */     if (obj == this) {
/* 110 */       return true;
/*     */     }
/* 112 */     if (!(obj instanceof ShapeList)) {
/* 113 */       return false;
/*     */     }
/* 115 */     ShapeList that = (ShapeList)obj;
/* 116 */     int listSize = size();
/* 117 */     for (int i = 0; i < listSize; i++) {
/* 118 */       if (!ShapeUtilities.equal((Shape)get(i), (Shape)that.get(i))) {
/* 119 */         return false;
/*     */       }
/*     */     } 
/* 122 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 132 */   public int hashCode() { return super.hashCode(); }
/*     */ 
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
/* 144 */     stream.defaultWriteObject();
/* 145 */     int count = size();
/* 146 */     stream.writeInt(count);
/* 147 */     for (int i = 0; i < count; i++) {
/* 148 */       Shape shape = getShape(i);
/* 149 */       if (shape != null) {
/* 150 */         stream.writeInt(i);
/* 151 */         SerialUtilities.writeShape(shape, stream);
/*     */       } else {
/*     */         
/* 154 */         stream.writeInt(-1);
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
/* 170 */     stream.defaultReadObject();
/* 171 */     int count = stream.readInt();
/* 172 */     for (int i = 0; i < count; i++) {
/* 173 */       int index = stream.readInt();
/* 174 */       if (index != -1)
/* 175 */         setShape(index, SerialUtilities.readShape(stream)); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/util/ShapeList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */