/*    */ package lab2;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ public class Cat {
/*    */   public String description;
/*    */   public int frequency;
/*    */   double percentage;
/*    */   int total;
/*    */   
/*    */   public Cat(String description, int total) {
/* 12 */     this.description = description;
/* 13 */     this.total = total;
/*    */   }
/*    */   
/*    */   public double percentage() {
/* 17 */     this.percentage = this.frequency / this.total * 100.0D;
/* 18 */     return this.percentage;
/*    */   }
/*    */   
/*    */   public String percentString() {
/* 22 */     Double shorttenedDouble = Double.valueOf((new BigDecimal(this.percentage)).setScale(3, 5).doubleValue());
/* 23 */     return String.valueOf(shorttenedDouble + " %");
/*    */   }
/*    */   
/*    */   public double tPercentage() {
/* 27 */     Double shorttenedDouble = Double.valueOf((new BigDecimal(this.percentage)).setScale(3, 5).doubleValue());
/* 28 */     return shorttenedDouble.doubleValue();
/*    */   }
/*    */ 
/*    */   
/* 32 */   public void setFrequency(int frequency) { this.frequency = frequency; }
/*    */ 
/*    */ 
/*    */   
/* 36 */   public String freqString() { return String.valueOf(this.frequency); }
/*    */ 
/*    */   
/*    */   public void checkValue(String s) {
/* 40 */     if (this.description.replaceAll("\\s+", "").equals(s.replaceAll("\\s+", ""))) {
/* 41 */       this.frequency++;
/*    */     }
/*    */   }
/*    */   
/*    */   public String toString() {
/* 46 */     s = "";
/* 47 */     s = s + this.description;
/* 48 */     s = s + "::" + this.frequency;
/* 49 */     s = s + "::" + percentage();
/* 50 */     return s + "\n";
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab2/Cat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */