/*     */ package org.jfree.ui.about;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import java.util.ResourceBundle;
/*     */ import org.jfree.ui.SortableTableModel;
/*     */ import org.jfree.util.ResourceBundleWrapper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SystemPropertiesTableModel
/*     */   extends SortableTableModel
/*     */ {
/*     */   private List properties;
/*     */   private String nameColumnLabel;
/*     */   private String valueColumnLabel;
/*     */   
/*     */   protected static class SystemProperty
/*     */   {
/*     */     private String name;
/*     */     private String value;
/*     */     
/*     */     public SystemProperty(String name, String value) {
/*  87 */       this.name = name;
/*  88 */       this.value = value;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     public String getName() { return this.name; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     public String getValue() { return this.value; }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class SystemPropertyComparator
/*     */     implements Comparator
/*     */   {
/*     */     private boolean ascending;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     public SystemPropertyComparator(boolean ascending) { this.ascending = ascending; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int compare(Object o1, Object o2) {
/* 140 */       if (o1 instanceof SystemPropertiesTableModel.SystemProperty && o2 instanceof SystemPropertiesTableModel.SystemProperty) {
/*     */         
/* 142 */         SystemPropertiesTableModel.SystemProperty sp1 = (SystemPropertiesTableModel.SystemProperty)o1;
/* 143 */         SystemPropertiesTableModel.SystemProperty sp2 = (SystemPropertiesTableModel.SystemProperty)o2;
/* 144 */         if (this.ascending) {
/* 145 */           return sp1.getName().compareTo(sp2.getName());
/*     */         }
/*     */         
/* 148 */         return sp2.getName().compareTo(sp1.getName());
/*     */       } 
/*     */ 
/*     */       
/* 152 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object o) {
/* 166 */       if (this == o) {
/* 167 */         return true;
/*     */       }
/* 169 */       if (!(o instanceof SystemPropertyComparator)) {
/* 170 */         return false;
/*     */       }
/*     */       
/* 173 */       SystemPropertyComparator systemPropertyComparator = (SystemPropertyComparator)o;
/*     */ 
/*     */       
/* 176 */       if (this.ascending != systemPropertyComparator.ascending) {
/* 177 */         return false;
/*     */       }
/*     */       
/* 180 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     public int hashCode() { return this.ascending ? 1 : 0; }
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
/*     */   public SystemPropertiesTableModel() {
/* 208 */     this.properties = new ArrayList();
/*     */     try {
/* 210 */       Properties p = System.getProperties();
/* 211 */       Iterator iterator = p.keySet().iterator();
/* 212 */       while (iterator.hasNext()) {
/* 213 */         String name = (String)iterator.next();
/* 214 */         String value = System.getProperty(name);
/* 215 */         SystemProperty sp = new SystemProperty(name, value);
/* 216 */         this.properties.add(sp);
/*     */       }
/*     */     
/* 219 */     } catch (SecurityException se) {}
/*     */ 
/*     */ 
/*     */     
/* 223 */     Collections.sort(this.properties, new SystemPropertyComparator(true));
/*     */     
/* 225 */     String baseName = "org.jfree.ui.about.resources.AboutResources";
/* 226 */     ResourceBundle resources = ResourceBundleWrapper.getBundle("org.jfree.ui.about.resources.AboutResources");
/*     */ 
/*     */     
/* 229 */     this.nameColumnLabel = resources.getString("system-properties-table.column.name");
/*     */     
/* 231 */     this.valueColumnLabel = resources.getString("system-properties-table.column.value");
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
/*     */   public boolean isSortable(int column) {
/* 246 */     if (column == 0) {
/* 247 */       return true;
/*     */     }
/*     */     
/* 250 */     return false;
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
/* 262 */   public int getRowCount() { return this.properties.size(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 273 */   public int getColumnCount() { return 2; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getColumnName(int column) {
/* 285 */     if (column == 0) {
/* 286 */       return this.nameColumnLabel;
/*     */     }
/*     */     
/* 289 */     return this.valueColumnLabel;
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
/*     */   public Object getValueAt(int row, int column) {
/* 305 */     SystemProperty sp = (SystemProperty)this.properties.get(row);
/* 306 */     if (column == 0) {
/* 307 */       return sp.getName();
/*     */     }
/*     */     
/* 310 */     if (column == 1) {
/* 311 */       return sp.getValue();
/*     */     }
/*     */     
/* 314 */     return null;
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
/*     */   public void sortByColumn(int column, boolean ascending) {
/* 329 */     if (isSortable(column)) {
/* 330 */       super.sortByColumn(column, ascending);
/* 331 */       Collections.sort(this.properties, new SystemPropertyComparator(ascending));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/about/SystemPropertiesTableModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */