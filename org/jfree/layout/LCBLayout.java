/*     */ package org.jfree.layout;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Insets;
/*     */ import java.awt.LayoutManager;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LCBLayout
/*     */   implements LayoutManager, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -2531780832406163833L;
/*     */   private static final int COLUMNS = 3;
/*     */   private int[] colWidth;
/*     */   private int[] rowHeight;
/*     */   private int labelGap;
/*     */   private int buttonGap;
/*     */   private int vGap;
/*     */   
/*     */   public LCBLayout(int maxrows) {
/*  86 */     this.labelGap = 10;
/*  87 */     this.buttonGap = 6;
/*  88 */     this.vGap = 2;
/*  89 */     this.colWidth = new int[3];
/*  90 */     this.rowHeight = new int[maxrows];
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
/*     */   public Dimension preferredLayoutSize(Container parent) {
/* 102 */     synchronized (parent.getTreeLock()) {
/* 103 */       Insets insets = parent.getInsets();
/* 104 */       int ncomponents = parent.getComponentCount();
/* 105 */       int nrows = ncomponents / 3;
/* 106 */       for (c = 0; c < 3; c++) {
/* 107 */         for (int r = 0; r < nrows; r++) {
/*     */           
/* 109 */           Component component = parent.getComponent(r * 3 + c);
/* 110 */           Dimension d = component.getPreferredSize();
/* 111 */           if (this.colWidth[c] < d.width) {
/* 112 */             this.colWidth[c] = d.width;
/*     */           }
/* 114 */           if (this.rowHeight[r] < d.height) {
/* 115 */             this.rowHeight[r] = d.height;
/*     */           }
/*     */         } 
/*     */       } 
/* 119 */       int totalHeight = this.vGap * (nrows - 1);
/* 120 */       for (int r = 0; r < nrows; r++) {
/* 121 */         totalHeight += this.rowHeight[r];
/*     */       }
/* 123 */       int totalWidth = this.colWidth[0] + this.labelGap + this.colWidth[1] + this.buttonGap + this.colWidth[2];
/*     */       
/* 125 */       return new Dimension(insets.left + insets.right + totalWidth + this.labelGap + this.buttonGap, insets.top + insets.bottom + totalHeight + this.vGap);
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
/*     */   
/*     */   public Dimension minimumLayoutSize(Container parent) {
/* 143 */     synchronized (parent.getTreeLock()) {
/* 144 */       Insets insets = parent.getInsets();
/* 145 */       int ncomponents = parent.getComponentCount();
/* 146 */       int nrows = ncomponents / 3;
/* 147 */       for (c = 0; c < 3; c++) {
/* 148 */         for (int r = 0; r < nrows; r++) {
/*     */           
/* 150 */           Component component = parent.getComponent(r * 3 + c);
/* 151 */           Dimension d = component.getMinimumSize();
/* 152 */           if (this.colWidth[c] < d.width) {
/* 153 */             this.colWidth[c] = d.width;
/*     */           }
/* 155 */           if (this.rowHeight[r] < d.height) {
/* 156 */             this.rowHeight[r] = d.height;
/*     */           }
/*     */         } 
/*     */       } 
/* 160 */       int totalHeight = this.vGap * (nrows - 1);
/* 161 */       for (int r = 0; r < nrows; r++) {
/* 162 */         totalHeight += this.rowHeight[r];
/*     */       }
/* 164 */       int totalWidth = this.colWidth[0] + this.labelGap + this.colWidth[1] + this.buttonGap + this.colWidth[2];
/*     */       
/* 166 */       return new Dimension(insets.left + insets.right + totalWidth + this.labelGap + this.buttonGap, insets.top + insets.bottom + totalHeight + this.vGap);
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
/*     */   public void layoutContainer(Container parent) {
/* 182 */     synchronized (parent.getTreeLock()) {
/* 183 */       Insets insets = parent.getInsets();
/* 184 */       int ncomponents = parent.getComponentCount();
/* 185 */       int nrows = ncomponents / 3;
/* 186 */       for (c = 0; c < 3; c++) {
/* 187 */         for (int r = 0; r < nrows; r++) {
/*     */           
/* 189 */           Component component = parent.getComponent(r * 3 + c);
/* 190 */           Dimension d = component.getPreferredSize();
/* 191 */           if (this.colWidth[c] < d.width) {
/* 192 */             this.colWidth[c] = d.width;
/*     */           }
/* 194 */           if (this.rowHeight[r] < d.height) {
/* 195 */             this.rowHeight[r] = d.height;
/*     */           }
/*     */         } 
/*     */       } 
/* 199 */       int totalHeight = this.vGap * (nrows - 1);
/* 200 */       for (int r = 0; r < nrows; r++) {
/* 201 */         totalHeight += this.rowHeight[r];
/*     */       }
/* 203 */       int totalWidth = this.colWidth[0] + this.colWidth[1] + this.colWidth[2];
/*     */ 
/*     */ 
/*     */       
/* 207 */       int available = parent.getWidth() - insets.left - insets.right - this.labelGap - this.buttonGap;
/*     */       
/* 209 */       this.colWidth[1] = this.colWidth[1] + available - totalWidth;
/*     */ 
/*     */       
/* 212 */       int x = insets.left;
/* 213 */       for (int c = 0; c < 3; c++) {
/* 214 */         int y = insets.top;
/* 215 */         for (int r = 0; r < nrows; r++) {
/* 216 */           int i = r * 3 + c;
/* 217 */           if (i < ncomponents) {
/* 218 */             Component component = parent.getComponent(i);
/* 219 */             Dimension d = component.getPreferredSize();
/* 220 */             int h = d.height;
/* 221 */             int adjust = (this.rowHeight[r] - h) / 2;
/* 222 */             parent.getComponent(i).setBounds(x, y + adjust, this.colWidth[c], h);
/*     */           } 
/*     */           
/* 225 */           y = y + this.rowHeight[r] + this.vGap;
/*     */         } 
/* 227 */         x += this.colWidth[c];
/* 228 */         if (c == 0) {
/* 229 */           x += this.labelGap;
/*     */         }
/* 231 */         if (c == 1)
/* 232 */           x += this.buttonGap; 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addLayoutComponent(Component comp) {}
/*     */   
/*     */   public void removeLayoutComponent(Component comp) {}
/*     */   
/*     */   public void addLayoutComponent(String name, Component comp) {}
/*     */   
/*     */   public void removeLayoutComponent(String name, Component comp) {}
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/layout/LCBLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */