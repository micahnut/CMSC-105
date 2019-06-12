/*     */ package org.jfree.chart;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintWriter;
/*     */ import org.jfree.chart.encoders.EncoderUtil;
/*     */ import org.jfree.chart.imagemap.ImageMapUtilities;
/*     */ import org.jfree.chart.imagemap.OverLIBToolTipTagFragmentGenerator;
/*     */ import org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator;
/*     */ import org.jfree.chart.imagemap.StandardURLTagFragmentGenerator;
/*     */ import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;
/*     */ import org.jfree.chart.imagemap.URLTagFragmentGenerator;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ChartUtilities
/*     */ {
/* 121 */   public static void applyCurrentTheme(JFreeChart chart) { ChartFactory.getChartTheme().apply(chart); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 138 */   public static void writeChartAsPNG(OutputStream out, JFreeChart chart, int width, int height) throws IOException { writeChartAsPNG(out, chart, width, height, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 159 */   public static void writeChartAsPNG(OutputStream out, JFreeChart chart, int width, int height, boolean encodeAlpha, int compression) throws IOException { writeChartAsPNG(out, chart, width, height, null, encodeAlpha, compression); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeChartAsPNG(OutputStream out, JFreeChart chart, int width, int height, ChartRenderingInfo info) throws IOException {
/* 182 */     ParamChecks.nullNotPermitted(chart, "chart");
/*     */     
/* 184 */     BufferedImage bufferedImage = chart.createBufferedImage(width, height, info);
/* 185 */     EncoderUtil.writeBufferedImage(bufferedImage, "png", out);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeChartAsPNG(OutputStream out, JFreeChart chart, int width, int height, ChartRenderingInfo info, boolean encodeAlpha, int compression) throws IOException {
/* 209 */     ParamChecks.nullNotPermitted(out, "out");
/* 210 */     ParamChecks.nullNotPermitted(chart, "chart");
/* 211 */     BufferedImage chartImage = chart.createBufferedImage(width, height, 2, info);
/*     */     
/* 213 */     writeBufferedImageAsPNG(out, chartImage, encodeAlpha, compression);
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
/*     */   public static void writeScaledChartAsPNG(OutputStream out, JFreeChart chart, int width, int height, int widthScaleFactor, int heightScaleFactor) throws IOException {
/* 234 */     ParamChecks.nullNotPermitted(out, "out");
/* 235 */     ParamChecks.nullNotPermitted(chart, "chart");
/*     */     
/* 237 */     double desiredWidth = (width * widthScaleFactor);
/* 238 */     double desiredHeight = (height * heightScaleFactor);
/* 239 */     double defaultWidth = width;
/* 240 */     double defaultHeight = height;
/* 241 */     boolean scale = false;
/*     */ 
/*     */     
/* 244 */     if (widthScaleFactor != 1 || heightScaleFactor != 1) {
/* 245 */       scale = true;
/*     */     }
/*     */     
/* 248 */     double scaleX = desiredWidth / defaultWidth;
/* 249 */     double scaleY = desiredHeight / defaultHeight;
/*     */     
/* 251 */     BufferedImage image = new BufferedImage((int)desiredWidth, (int)desiredHeight, 2);
/*     */     
/* 253 */     Graphics2D g2 = image.createGraphics();
/*     */     
/* 255 */     if (scale) {
/* 256 */       AffineTransform saved = g2.getTransform();
/* 257 */       g2.transform(AffineTransform.getScaleInstance(scaleX, scaleY));
/* 258 */       chart.draw(g2, new Rectangle2D.Double(0.0D, 0.0D, defaultWidth, defaultHeight), null, null);
/*     */       
/* 260 */       g2.setTransform(saved);
/* 261 */       g2.dispose();
/*     */     } else {
/*     */       
/* 264 */       chart.draw(g2, new Rectangle2D.Double(0.0D, 0.0D, defaultWidth, defaultHeight), null, null);
/*     */     } 
/*     */     
/* 267 */     out.write(encodeAsPNG(image));
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
/* 285 */   public static void saveChartAsPNG(File file, JFreeChart chart, int width, int height) throws IOException { saveChartAsPNG(file, chart, width, height, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void saveChartAsPNG(File file, JFreeChart chart, int width, int height, ChartRenderingInfo info) throws IOException {
/* 307 */     ParamChecks.nullNotPermitted(file, "file");
/* 308 */     out = new BufferedOutputStream(new FileOutputStream(file));
/*     */     try {
/* 310 */       writeChartAsPNG(out, chart, width, height, info);
/*     */     } finally {
/*     */       
/* 313 */       out.close();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void saveChartAsPNG(File file, JFreeChart chart, int width, int height, ChartRenderingInfo info, boolean encodeAlpha, int compression) throws IOException {
/* 337 */     ParamChecks.nullNotPermitted(file, "file");
/* 338 */     ParamChecks.nullNotPermitted(chart, "chart");
/* 339 */     out = new BufferedOutputStream(new FileOutputStream(file));
/*     */     try {
/* 341 */       writeChartAsPNG(out, chart, width, height, info, encodeAlpha, compression);
/*     */     }
/*     */     finally {
/*     */       
/* 345 */       out.close();
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
/*     */ 
/*     */ 
/*     */   
/* 365 */   public static void writeChartAsJPEG(OutputStream out, JFreeChart chart, int width, int height) throws IOException { writeChartAsJPEG(out, chart, width, height, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 385 */   public static void writeChartAsJPEG(OutputStream out, float quality, JFreeChart chart, int width, int height) throws IOException { writeChartAsJPEG(out, quality, chart, width, height, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeChartAsJPEG(OutputStream out, JFreeChart chart, int width, int height, ChartRenderingInfo info) throws IOException {
/* 408 */     ParamChecks.nullNotPermitted(out, "out");
/* 409 */     ParamChecks.nullNotPermitted(chart, "chart");
/* 410 */     BufferedImage image = chart.createBufferedImage(width, height, 1, info);
/*     */     
/* 412 */     EncoderUtil.writeBufferedImage(image, "jpeg", out);
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
/*     */ 
/*     */   
/*     */   public static void writeChartAsJPEG(OutputStream out, float quality, JFreeChart chart, int width, int height, ChartRenderingInfo info) throws IOException {
/* 435 */     ParamChecks.nullNotPermitted(out, "out");
/* 436 */     ParamChecks.nullNotPermitted(chart, "chart");
/* 437 */     BufferedImage image = chart.createBufferedImage(width, height, 1, info);
/*     */     
/* 439 */     EncoderUtil.writeBufferedImage(image, "jpeg", out, quality);
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
/* 457 */   public static void saveChartAsJPEG(File file, JFreeChart chart, int width, int height) throws IOException { saveChartAsJPEG(file, chart, width, height, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 476 */   public static void saveChartAsJPEG(File file, float quality, JFreeChart chart, int width, int height) throws IOException { saveChartAsJPEG(file, quality, chart, width, height, null); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void saveChartAsJPEG(File file, JFreeChart chart, int width, int height, ChartRenderingInfo info) throws IOException {
/* 497 */     ParamChecks.nullNotPermitted(file, "file");
/* 498 */     ParamChecks.nullNotPermitted(chart, "chart");
/* 499 */     out = new BufferedOutputStream(new FileOutputStream(file));
/*     */     try {
/* 501 */       writeChartAsJPEG(out, chart, width, height, info);
/*     */     } finally {
/*     */       
/* 504 */       out.close();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void saveChartAsJPEG(File file, float quality, JFreeChart chart, int width, int height, ChartRenderingInfo info) throws IOException {
/* 528 */     ParamChecks.nullNotPermitted(file, "file");
/* 529 */     ParamChecks.nullNotPermitted(chart, "chart");
/* 530 */     out = new BufferedOutputStream(new FileOutputStream(file));
/*     */     
/*     */     try {
/* 533 */       writeChartAsJPEG(out, quality, chart, width, height, info);
/*     */     } finally {
/*     */       
/* 536 */       out.close();
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
/* 553 */   public static void writeBufferedImageAsJPEG(OutputStream out, BufferedImage image) throws IOException { writeBufferedImageAsJPEG(out, 0.75F, image); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 569 */   public static void writeBufferedImageAsJPEG(OutputStream out, float quality, BufferedImage image) throws IOException { EncoderUtil.writeBufferedImage(image, "jpeg", out, quality); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 584 */   public static void writeBufferedImageAsPNG(OutputStream out, BufferedImage image) throws IOException { EncoderUtil.writeBufferedImage(image, "png", out); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 602 */   public static void writeBufferedImageAsPNG(OutputStream out, BufferedImage image, boolean encodeAlpha, int compression) throws IOException { EncoderUtil.writeBufferedImage(image, "png", out, compression, encodeAlpha); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 616 */   public static byte[] encodeAsPNG(BufferedImage image) throws IOException { return EncoderUtil.encode(image, "png"); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 632 */   public static byte[] encodeAsPNG(BufferedImage image, boolean encodeAlpha, int compression) throws IOException { return EncoderUtil.encode(image, "png", compression, encodeAlpha); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeImageMap(PrintWriter writer, String name, ChartRenderingInfo info, boolean useOverLibForToolTips) throws IOException {
/*     */     StandardToolTipTagFragmentGenerator standardToolTipTagFragmentGenerator;
/* 652 */     if (useOverLibForToolTips) {
/* 653 */       standardToolTipTagFragmentGenerator = new OverLIBToolTipTagFragmentGenerator();
/*     */     }
/*     */     else {
/*     */       
/* 657 */       standardToolTipTagFragmentGenerator = new StandardToolTipTagFragmentGenerator();
/*     */     } 
/*     */     
/* 660 */     ImageMapUtilities.writeImageMap(writer, name, info, standardToolTipTagFragmentGenerator, new StandardURLTagFragmentGenerator());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 687 */   public static void writeImageMap(PrintWriter writer, String name, ChartRenderingInfo info, ToolTipTagFragmentGenerator toolTipTagFragmentGenerator, URLTagFragmentGenerator urlTagFragmentGenerator) throws IOException { writer.println(ImageMapUtilities.getImageMap(name, info, toolTipTagFragmentGenerator, urlTagFragmentGenerator)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 703 */   public static String getImageMap(String name, ChartRenderingInfo info) { return ImageMapUtilities.getImageMap(name, info, new StandardToolTipTagFragmentGenerator(), new StandardURLTagFragmentGenerator()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 728 */   public static String getImageMap(String name, ChartRenderingInfo info, ToolTipTagFragmentGenerator toolTipTagFragmentGenerator, URLTagFragmentGenerator urlTagFragmentGenerator) { return ImageMapUtilities.getImageMap(name, info, toolTipTagFragmentGenerator, urlTagFragmentGenerator); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/ChartUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */