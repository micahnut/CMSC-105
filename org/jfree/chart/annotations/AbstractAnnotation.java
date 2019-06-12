/*     */ package org.jfree.chart.annotations;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.EventListener;
/*     */ import java.util.List;
/*     */ import javax.swing.event.EventListenerList;
/*     */ import org.jfree.chart.event.AnnotationChangeEvent;
/*     */ import org.jfree.chart.event.AnnotationChangeListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractAnnotation
/*     */   implements Annotation, Cloneable, Serializable
/*     */ {
/*     */   private EventListenerList listenerList;
/*     */   private boolean notify = true;
/*     */   
/*  78 */   protected AbstractAnnotation() { this.listenerList = new EventListenerList(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   public void addChangeListener(AnnotationChangeListener listener) { this.listenerList.add(AnnotationChangeListener.class, listener); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 104 */   public void removeChangeListener(AnnotationChangeListener listener) { this.listenerList.remove(AnnotationChangeListener.class, listener); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasListener(EventListener listener) {
/* 120 */     List list = Arrays.asList(this.listenerList.getListenerList());
/* 121 */     return list.contains(listener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fireAnnotationChanged() {
/* 130 */     if (this.notify) {
/* 131 */       notifyListeners(new AnnotationChangeEvent(this, this));
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
/*     */   protected void notifyListeners(AnnotationChangeEvent event) {
/* 146 */     Object[] listeners = this.listenerList.getListenerList();
/* 147 */     for (int i = listeners.length - 2; i >= 0; i -= 2) {
/* 148 */       if (listeners[i] == AnnotationChangeListener.class) {
/* 149 */         ((AnnotationChangeListener)listeners[i + 1]).annotationChanged(event);
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
/*     */   
/* 165 */   public boolean getNotify() { return this.notify; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotify(boolean flag) {
/* 177 */     this.notify = flag;
/* 178 */     if (this.notify) {
/* 179 */       fireAnnotationChanged();
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
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 195 */     AbstractAnnotation clone = (AbstractAnnotation)super.clone();
/* 196 */     clone.listenerList = new EventListenerList();
/* 197 */     return clone;
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
/* 208 */   private void writeObject(ObjectOutputStream stream) throws IOException { stream.defaultWriteObject(); }
/*     */ 
/*     */ 
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
/* 221 */     stream.defaultReadObject();
/* 222 */     this.listenerList = new EventListenerList();
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/annotations/AbstractAnnotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */