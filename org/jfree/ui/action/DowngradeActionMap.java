/*     */ package org.jfree.ui.action;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import javax.swing.Action;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DowngradeActionMap
/*     */ {
/*     */   private final HashMap actionMap;
/*     */   private final ArrayList actionList;
/*     */   private DowngradeActionMap parent;
/*     */   
/*     */   public DowngradeActionMap() {
/*  76 */     this.actionMap = new HashMap();
/*  77 */     this.actionList = new ArrayList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  86 */   public void setParent(DowngradeActionMap map) { this.parent = map; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   public DowngradeActionMap getParent() { return this.parent; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(Object key, Action action) {
/* 110 */     if (action == null) {
/* 111 */       remove(key);
/*     */     } else {
/*     */       
/* 114 */       if (this.actionMap.containsKey(key)) {
/* 115 */         remove(key);
/*     */       }
/* 117 */       this.actionMap.put(key, action);
/* 118 */       this.actionList.add(key);
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
/*     */   public Action get(Object key) {
/* 130 */     Action retval = (Action)this.actionMap.get(key);
/* 131 */     if (retval != null) {
/* 132 */       return retval;
/*     */     }
/* 134 */     if (this.parent != null) {
/* 135 */       return this.parent.get(key);
/*     */     }
/* 137 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Object key) {
/* 146 */     this.actionMap.remove(key);
/* 147 */     this.actionList.remove(key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 154 */     this.actionMap.clear();
/* 155 */     this.actionList.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 164 */   public Object[] keys() { return this.actionList.toArray(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 173 */   public int size() { return this.actionMap.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] allKeys() {
/* 184 */     if (this.parent == null) {
/* 185 */       return keys();
/*     */     }
/* 187 */     Object[] parentKeys = this.parent.allKeys();
/* 188 */     Object[] key = keys();
/* 189 */     Object[] retval = new Object[parentKeys.length + key.length];
/* 190 */     System.arraycopy(key, 0, retval, 0, key.length);
/* 191 */     System.arraycopy(retval, 0, retval, key.length, retval.length);
/* 192 */     return retval;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/action/DowngradeActionMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */