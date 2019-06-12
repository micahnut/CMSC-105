/*    */ package org.jfree.chart.editor;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import javax.swing.JComboBox;
/*    */ import javax.swing.JPanel;
/*    */ import org.jfree.chart.plot.ColorPalette;
/*    */ import org.jfree.chart.plot.RainbowPalette;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PaletteChooserPanel
/*    */   extends JPanel
/*    */ {
/*    */   private JComboBox selector;
/*    */   
/*    */   public PaletteChooserPanel(PaletteSample current, PaletteSample[] available) {
/* 74 */     setLayout(new BorderLayout());
/* 75 */     this.selector = new JComboBox(available);
/* 76 */     this.selector.setSelectedItem(current);
/* 77 */     this.selector.setRenderer(new PaletteSample(new RainbowPalette()));
/* 78 */     add(this.selector);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ColorPalette getSelectedPalette() {
/* 87 */     PaletteSample sample = (PaletteSample)this.selector.getSelectedItem();
/* 88 */     return sample.getPalette();
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/editor/PaletteChooserPanel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */