/*     */ package org.jfree.data.general;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectInputValidation;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.EventListener;
/*     */ import java.util.List;
/*     */ import javax.swing.event.EventListenerList;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractDataset
/*     */   implements Dataset, Cloneable, Serializable, ObjectInputValidation
/*     */ {
/*     */   private static final long serialVersionUID = 1918768939869230744L;
/*     */   private DatasetGroup group;
/*     */   private EventListenerList listenerList;
/*     */   private boolean notify;
/*     */   
/*     */   protected AbstractDataset() {
/* 103 */     this.group = new DatasetGroup();
/* 104 */     this.listenerList = new EventListenerList();
/* 105 */     this.notify = true;
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
/* 117 */   public DatasetGroup getGroup() { return this.group; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroup(DatasetGroup group) {
/* 129 */     ParamChecks.nullNotPermitted(group, "group");
/* 130 */     this.group = group;
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
/* 144 */   public boolean getNotify() { return this.notify; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotify(boolean notify) {
/* 158 */     this.notify = notify;
/* 159 */     if (notify) {
/* 160 */       fireDatasetChanged();
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
/* 173 */   public void addChangeListener(DatasetChangeListener listener) { this.listenerList.add(DatasetChangeListener.class, listener); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 186 */   public void removeChangeListener(DatasetChangeListener listener) { this.listenerList.remove(DatasetChangeListener.class, listener); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 202 */     List list = Arrays.asList(this.listenerList.getListenerList());
/* 203 */     return list.contains(listener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fireDatasetChanged() {
/* 214 */     if (this.notify) {
/* 215 */       notifyListeners(new DatasetChangeEvent(this, this));
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
/*     */   protected void notifyListeners(DatasetChangeEvent event) {
/* 229 */     Object[] listeners = this.listenerList.getListenerList();
/* 230 */     for (int i = listeners.length - 2; i >= 0; i -= 2) {
/* 231 */       if (listeners[i] == DatasetChangeListener.class) {
/* 232 */         ((DatasetChangeListener)listeners[i + 1]).datasetChanged(event);
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
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 250 */     AbstractDataset clone = (AbstractDataset)super.clone();
/* 251 */     clone.listenerList = new EventListenerList();
/* 252 */     return clone;
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
/* 263 */   private void writeObject(ObjectOutputStream stream) throws IOException { stream.defaultWriteObject(); }
/*     */ 
/*     */ 
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
/* 276 */     stream.defaultReadObject();
/* 277 */     this.listenerList = new EventListenerList();
/* 278 */     stream.registerValidation(this, 10);
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
/*     */ 
/*     */ 
/*     */   
/* 301 */   public void validateObject() { fireDatasetChanged(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/general/AbstractDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */