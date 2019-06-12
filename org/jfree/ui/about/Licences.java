/*     */ package org.jfree.ui.about;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Licences
/*     */ {
/*     */   public static final String GPL = "GNU GENERAL PUBLIC LICENSE\n";
/*     */   public static final String LGPL = "GNU LESSER GENERAL PUBLIC LICENSE\n";
/*     */   private static Licences singleton;
/*     */   
/*     */   public static Licences getInstance() {
/*  91 */     if (singleton == null) {
/*  92 */       singleton = new Licences();
/*     */     }
/*  94 */     return singleton;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   public String getGPL() { return readStringResource("gpl-2.0.txt"); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 112 */   public String getLGPL() { return readStringResource("lgpl-2.1.txt"); }
/*     */ 
/*     */   
/*     */   private String readStringResource(String name) {
/* 116 */     StringBuilder sb = new StringBuilder();
/* 117 */     streamReader = null;
/*     */     try {
/* 119 */       inputStream = getClass().getResourceAsStream(name);
/* 120 */       streamReader = new InputStreamReader(inputStream, "UTF-8");
/* 121 */       BufferedReader in = new BufferedReader(streamReader); String line;
/* 122 */       while ((line = in.readLine()) != null) {
/* 123 */         sb.append(line).append("\n");
/*     */       }
/* 125 */     } catch (UnsupportedEncodingException ex) {
/* 126 */       throw new RuntimeException(ex);
/* 127 */     } catch (IOException e) {
/* 128 */       throw new RuntimeException(e);
/*     */     } finally {
/*     */       try {
/* 131 */         streamReader.close();
/* 132 */       } catch (IOException ex) {
/* 133 */         throw new RuntimeException(ex);
/*     */       } 
/*     */     } 
/* 136 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/ui/about/Licences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */