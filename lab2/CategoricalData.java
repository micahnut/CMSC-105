/*    */ package lab2;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ public class CategoricalData {
/*    */   ArrayList<Cat> categoricalD;
/*    */   
/*    */   public CategoricalData(ArrayList<String> values) {
/* 12 */     this.categoricalD = new ArrayList();
/* 13 */     this.output = new ArrayList();
/* 14 */     this.strcpy = values;
/* 15 */     collection();
/*    */   }
/*    */   ArrayList<String> output; ArrayList<String> strcpy;
/*    */   public void run() {
/* 19 */     init();
/* 20 */     checkValues();
/*    */   }
/*    */   
/*    */   public void init() {
/* 24 */     for (String s : this.output) {
/* 25 */       this.categoricalD.add(new Cat(s, this.strcpy.size()));
/*    */     }
/*    */   }
/*    */   
/*    */   public void checkValues() {
/* 30 */     for (String i : this.strcpy) {
/* 31 */       for (Cat c : this.categoricalD)
/* 32 */         c.checkValue(i); 
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getTotalFreq() {
/* 37 */     int i = 0;
/* 38 */     for (Cat c : this.categoricalD) {
/* 39 */       i += c.frequency;
/*    */     }
/* 41 */     return String.valueOf(i);
/*    */   }
/*    */ 
/*    */   
/* 45 */   public ArrayList<Cat> getData() { return this.categoricalD; }
/*    */ 
/*    */   
/*    */   private void collection() {
/* 49 */     HashSet<String> h = new HashSet<String>();
/* 50 */     h.addAll(this.strcpy);
/* 51 */     this.output.addAll(h);
/* 52 */     Collections.sort(this.output);
/*    */   }
/*    */   
/*    */   public String getTotalPercent() {
/* 56 */     double i = 0.0D;
/* 57 */     for (Cat c : this.categoricalD) {
/* 58 */       i += c.percentage();
/*    */     }
/* 60 */     Double shorttenedDouble = Double.valueOf((new BigDecimal(i)).setScale(2, 5).doubleValue());
/* 61 */     return String.valueOf(shorttenedDouble + " %");
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab2/CategoricalData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */