/*     */ package org.jfree.ui;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.text.DateFormat;
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
/*     */ public class DateCellRenderer
/*     */   extends DefaultTableCellRenderer
/*     */ {
/*     */   private DateFormat formatter;
/*     */   
/*  65 */   public DateCellRenderer() { this(DateFormat.getDateTimeInstance()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DateCellRenderer(DateFormat formatter) {
/*  75 */     this.formatter = formatter;
/*  76 */     setHorizontalAlignment(0);
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
/*     */   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
/*  97 */     setFont(null);
/*  98 */     if (value != null) {
/*  99 */       setText(this.formatter.format(value));
/*     */     } else {
/*     */       
/* 102 */       setText("");
/*     */     } 
/* 104 */     if (isSelected) {
/* 105 */       setBackground(table.getSelectionBackground());
/*     */     } else {
/*     */       
/* 108 */       setBackground(null);
/*     */     } 
/* 110 */     return this;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/DateCellRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */