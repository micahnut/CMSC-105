/*    */ package org.jfree.ui;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import javax.swing.UIDefaults;
/*    */ import javax.swing.UIManager;
/*    */ import javax.swing.border.EmptyBorder;
/*    */ import javax.swing.border.MatteBorder;
/*    */ import javax.swing.plaf.BorderUIResource;
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
/*    */ public class UIUtilities
/*    */ {
/*    */   public static void setupUI() {
/*    */     try {
/* 70 */       classname = UIManager.getSystemLookAndFeelClassName();
/* 71 */       UIManager.setLookAndFeel(classname);
/*    */     }
/* 73 */     catch (Exception e) {
/* 74 */       defaults.printStackTrace();
/*    */     } 
/*    */     
/* 77 */     UIDefaults uIDefaults = UIManager.getDefaults();
/*    */     
/* 79 */     uIDefaults.put("PopupMenu.border", new BorderUIResource.EtchedBorderUIResource(false, uIDefaults
/*    */ 
/*    */           
/* 82 */           .getColor("controlShadow"), uIDefaults
/* 83 */           .getColor("controlLtHighlight")));
/*    */ 
/*    */ 
/*    */     
/* 87 */     MatteBorder matteborder = new MatteBorder(true, true, true, true, Color.black);
/* 88 */     EmptyBorder emptyborder = new MatteBorder(2, 2, 2, 2, uIDefaults.getColor("control"));
/* 89 */     BorderUIResource.CompoundBorderUIResource compBorder = new BorderUIResource.CompoundBorderUIResource(emptyborder, matteborder);
/*    */     
/* 91 */     BorderUIResource.EmptyBorderUIResource emptyBorderUI = new BorderUIResource.EmptyBorderUIResource(false, false, false, false);
/*    */     
/* 93 */     uIDefaults.put("SplitPane.border", emptyBorderUI);
/* 94 */     uIDefaults.put("Table.scrollPaneBorder", emptyBorderUI);
/* 95 */     uIDefaults.put("ComboBox.border", compBorder);
/* 96 */     uIDefaults.put("TextField.border", compBorder);
/* 97 */     uIDefaults.put("TextArea.border", compBorder);
/* 98 */     uIDefaults.put("CheckBox.border", compBorder);
/* 99 */     uIDefaults.put("ScrollPane.border", emptyBorderUI);
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/UIUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */