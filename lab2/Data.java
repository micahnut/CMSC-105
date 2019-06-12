/*     */ package lab2;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class Data
/*     */ {
/*     */   public boolean isNum;
/*     */   public boolean isAlpha;
/*     */   public boolean isString;
/*     */   public String desc;
/*     */   ArrayList<String> values;
/*     */   CategoricalData c;
/*     */   
/*  14 */   public Data() { this.values = new ArrayList(); }
/*     */ 
/*     */ 
/*     */   
/*  18 */   public void addDescription(String s) { this.desc = s.toUpperCase(); }
/*     */ 
/*     */ 
/*     */   
/*  22 */   public void clearData() { this.values.clear(); }
/*     */ 
/*     */ 
/*     */   
/*  26 */   public void addGroup(ArrayList<String> s) { this.values = s; }
/*     */ 
/*     */   
/*     */   public boolean addValue(String s) throws Exception {
/*     */     try {
/*  31 */       if (checkValidity(s)) {
/*  32 */         this.values.add(s);
/*  33 */         return true;
/*     */       } 
/*  35 */       return false;
/*  36 */     } catch (Exception e) {
/*  37 */       throw new Exception(e.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   boolean checkValidity(String s) throws Exception {
/*  43 */     if (s.isEmpty() || s.equals("")) {
/*  44 */       throw new Exception("Provide An Input");
/*     */     }
/*  46 */     if (this.isNum)
/*  47 */       return ifNum(s); 
/*  48 */     if (this.isAlpha) {
/*  49 */       return ifAlpha(s);
/*     */     }
/*  51 */     return ifString(s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean ifNum(String s) throws Exception {
/*     */     try {
/*  60 */       double i = Double.parseDouble(s);
/*  61 */       return true;
/*  62 */     } catch (NumberFormatException e) {
/*  63 */       System.out.println("Input Is Not A Number");
/*  64 */       throw new NumberFormatException("Input is not a number");
/*     */     } 
/*     */   }
/*     */   
/*     */   boolean ifAlpha(String s) throws Exception {
/*  69 */     String pattern2 = "^[a-zA-Z]*$";
/*  70 */     if (s.length() == 1 && s.matches(pattern2)) {
/*  71 */       return true;
/*     */     }
/*  73 */     System.out.println("Input must be a single character");
/*  74 */     throw new IllegalArgumentException("Input  must be a single character");
/*     */   }
/*     */ 
/*     */   
/*     */   boolean ifString(String s) throws Exception {
/*  79 */     if (s.length() > 1) {
/*  80 */       return true;
/*     */     }
/*     */     
/*  83 */     System.out.println("Input to be a string has to be more than 2 characters");
/*  84 */     throw new IllegalArgumentException("Input to be a string has to be more than 2 characters");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDataType(int i) {
/*  89 */     if (i == 1) {
/*  90 */       this.isNum = true;
/*  91 */       this.isAlpha = false;
/*  92 */       this.isString = false;
/*     */     } 
/*     */     
/*  95 */     if (i == 2) {
/*  96 */       this.isAlpha = true;
/*  97 */       this.isNum = false;
/*  98 */       this.isString = false;
/*     */     } 
/* 100 */     if (i == 3) {
/* 101 */       this.isString = true;
/* 102 */       this.isNum = false;
/* 103 */       this.isAlpha = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void performCategor() {
/* 108 */     this.c = new CategoricalData(this.values);
/* 109 */     this.c.run();
/*     */   }
/*     */ 
/*     */   
/* 113 */   public ArrayList<Cat> getCategorData() { return this.c.getData(); }
/*     */ 
/*     */ 
/*     */   
/* 117 */   public ArrayList<String> getData() { return this.values; }
/*     */ 
/*     */ 
/*     */   
/* 121 */   public String getTotalFreq() { return this.c.getTotalFreq(); }
/*     */ 
/*     */ 
/*     */   
/* 125 */   public String getTotalPercent() { return this.c.getTotalPercent(); }
/*     */ 
/*     */ 
/*     */   
/* 129 */   public int getSize() { return this.values.size(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab2/Data.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */