/*     */ package org.jfree.ui;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.text.NumberFormat;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.table.DefaultTableCellRenderer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NumberCellRenderer
/*     */   extends DefaultTableCellRenderer
/*     */ {
/*  65 */   public NumberCellRenderer() { setHorizontalAlignment(4); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
/*  86 */     setFont(null);
/*  87 */     NumberFormat nf = NumberFormat.getNumberInstance();
/*  88 */     if (value != null) {
/*  89 */       setText(nf.format(value));
/*     */     } else {
/*     */       
/*  92 */       setText("");
/*     */     } 
/*  94 */     if (isSelected) {
/*  95 */       setBackground(table.getSelectionBackground());
/*     */     } else {
/*     */       
/*  98 */       setBackground(null);
/*     */     } 
/* 100 */     return this;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/NumberCellRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */