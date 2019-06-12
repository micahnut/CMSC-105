/*     */ package org.jfree.data.general;
/*     */ 
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.beans.PropertyChangeSupport;
/*     */ import java.beans.PropertyVetoException;
/*     */ import java.beans.VetoableChangeListener;
/*     */ import java.beans.VetoableChangeSupport;
/*     */ import java.io.Serializable;
/*     */ import javax.swing.event.EventListenerList;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.util.ObjectUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Series
/*     */   implements Cloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -6906561437538683581L;
/*     */   private Comparable key;
/*     */   private String description;
/*     */   private EventListenerList listeners;
/*     */   private PropertyChangeSupport propertyChangeSupport;
/*     */   private VetoableChangeSupport vetoableChangeSupport;
/*     */   private boolean notify;
/*     */   
/* 110 */   protected Series(Comparable key) { this(key, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Series(Comparable key, String description) {
/* 120 */     ParamChecks.nullNotPermitted(key, "key");
/* 121 */     this.key = key;
/* 122 */     this.description = description;
/* 123 */     this.listeners = new EventListenerList();
/* 124 */     this.propertyChangeSupport = new PropertyChangeSupport(this);
/* 125 */     this.vetoableChangeSupport = new VetoableChangeSupport(this);
/* 126 */     this.notify = true;
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
/* 137 */   public Comparable getKey() { return this.key; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKey(Comparable key) {
/* 152 */     ParamChecks.nullNotPermitted(key, "key");
/* 153 */     Comparable old = this.key;
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 158 */       this.vetoableChangeSupport.fireVetoableChange("Key", old, key);
/* 159 */       this.key = key;
/*     */ 
/*     */       
/* 162 */       this.propertyChangeSupport.firePropertyChange("Key", old, key);
/* 163 */     } catch (PropertyVetoException e) {
/* 164 */       throw new IllegalArgumentException(e.getMessage());
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
/* 176 */   public String getDescription() { return this.description; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String description) {
/* 188 */     String old = this.description;
/* 189 */     this.description = description;
/* 190 */     this.propertyChangeSupport.firePropertyChange("Description", old, description);
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
/* 203 */   public boolean getNotify() { return this.notify; }
/*     */ 
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
/* 215 */     if (this.notify != notify) {
/* 216 */       this.notify = notify;
/* 217 */       fireSeriesChanged();
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
/* 230 */   public boolean isEmpty() { return (getItemCount() == 0); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int getItemCount();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 259 */     Series clone = (Series)super.clone();
/* 260 */     clone.listeners = new EventListenerList();
/* 261 */     clone.propertyChangeSupport = new PropertyChangeSupport(clone);
/* 262 */     clone.vetoableChangeSupport = new VetoableChangeSupport(clone);
/* 263 */     return clone;
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
/*     */   public boolean equals(Object obj) {
/* 275 */     if (obj == this) {
/* 276 */       return true;
/*     */     }
/* 278 */     if (!(obj instanceof Series)) {
/* 279 */       return false;
/*     */     }
/* 281 */     Series that = (Series)obj;
/* 282 */     if (!getKey().equals(that.getKey())) {
/* 283 */       return false;
/*     */     }
/* 285 */     if (!ObjectUtilities.equal(getDescription(), that.getDescription())) {
/* 286 */       return false;
/*     */     }
/* 288 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 299 */     result = this.key.hashCode();
/*     */     
/* 301 */     return 29 * result + ((this.description != null) ? this.description.hashCode() : 0);
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
/* 315 */   public void addChangeListener(SeriesChangeListener listener) { this.listeners.add(SeriesChangeListener.class, listener); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 325 */   public void removeChangeListener(SeriesChangeListener listener) { this.listeners.remove(SeriesChangeListener.class, listener); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fireSeriesChanged() {
/* 333 */     if (this.notify) {
/* 334 */       notifyListeners(new SeriesChangeEvent(this));
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
/*     */   protected void notifyListeners(SeriesChangeEvent event) {
/* 346 */     Object[] listenerList = this.listeners.getListenerList();
/* 347 */     for (int i = listenerList.length - 2; i >= 0; i -= 2) {
/* 348 */       if (listenerList[i] == SeriesChangeListener.class) {
/* 349 */         ((SeriesChangeListener)listenerList[i + 1]).seriesChanged(event);
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
/* 362 */   public void addPropertyChangeListener(PropertyChangeListener listener) { this.propertyChangeSupport.addPropertyChangeListener(listener); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 371 */   public void removePropertyChangeListener(PropertyChangeListener listener) { this.propertyChangeSupport.removePropertyChangeListener(listener); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 383 */   protected void firePropertyChange(String property, Object oldValue, Object newValue) { this.propertyChangeSupport.firePropertyChange(property, oldValue, newValue); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 395 */   public void addVetoableChangeListener(VetoableChangeListener listener) { this.vetoableChangeSupport.addVetoableChangeListener(listener); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 406 */   public void removeVetoableChangeListener(VetoableChangeListener listener) { this.vetoableChangeSupport.removeVetoableChangeListener(listener); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 420 */   protected void fireVetoableChange(String property, Object oldValue, Object newValue) { this.vetoableChangeSupport.fireVetoableChange(property, oldValue, newValue); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/general/Series.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */