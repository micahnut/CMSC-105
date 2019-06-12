/*     */ package org.jfree.chart.encoders;
/*     */ 
/*     */ import com.keypoint.PngEncoder;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
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
/*     */ public class KeypointPNGEncoderAdapter
/*     */   implements ImageEncoder
/*     */ {
/*  60 */   private int quality = 9;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean encodingAlpha = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   public float getQuality() { return this.quality; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  87 */   public void setQuality(float quality) { this.quality = (int)quality; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   public boolean isEncodingAlpha() { return this.encodingAlpha; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   public void setEncodingAlpha(boolean encodingAlpha) { this.encodingAlpha = encodingAlpha; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] encode(BufferedImage bufferedImage) throws IOException {
/* 120 */     ParamChecks.nullNotPermitted(bufferedImage, "bufferedImage");
/* 121 */     PngEncoder encoder = new PngEncoder(bufferedImage, this.encodingAlpha, false, this.quality);
/*     */     
/* 123 */     return encoder.pngEncode();
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
/*     */   public void encode(BufferedImage bufferedImage, OutputStream outputStream) throws IOException {
/* 137 */     ParamChecks.nullNotPermitted(bufferedImage, "bufferedImage");
/* 138 */     ParamChecks.nullNotPermitted(outputStream, "outputStream");
/* 139 */     PngEncoder encoder = new PngEncoder(bufferedImage, this.encodingAlpha, false, this.quality);
/*     */     
/* 141 */     outputStream.write(encoder.pngEncode());
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/encoders/KeypointPNGEncoderAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */