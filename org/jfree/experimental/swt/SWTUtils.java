/*     */ package org.jfree.experimental.swt;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.Paint;
/*     */ import java.awt.Point;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.DirectColorModel;
/*     */ import java.awt.image.IndexColorModel;
/*     */ import java.awt.image.WritableRaster;
/*     */ import javax.swing.JPanel;
/*     */ import org.eclipse.swt.events.MouseEvent;
/*     */ import org.eclipse.swt.graphics.Color;
/*     */ import org.eclipse.swt.graphics.Device;
/*     */ import org.eclipse.swt.graphics.Font;
/*     */ import org.eclipse.swt.graphics.FontData;
/*     */ import org.eclipse.swt.graphics.GC;
/*     */ import org.eclipse.swt.graphics.ImageData;
/*     */ import org.eclipse.swt.graphics.PaletteData;
/*     */ import org.eclipse.swt.graphics.Point;
/*     */ import org.eclipse.swt.graphics.RGB;
/*     */ import org.eclipse.swt.graphics.Rectangle;
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
/*     */ public class SWTUtils
/*     */ {
/*     */   private static final String Az = "ABCpqr";
/*  91 */   protected static final JPanel DUMMY_PANEL = new JPanel();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FontData toSwtFontData(Device device, Font font, boolean ensureSameSize) {
/* 116 */     FontData fontData = new FontData();
/* 117 */     fontData.setName(font.getFamily());
/*     */     
/* 119 */     fontData.setStyle(font.getStyle());
/*     */     
/* 121 */     int height = (int)Math.round(font.getSize() * 72.0D / 
/* 122 */         (device.getDPI()).y);
/* 123 */     fontData.setHeight(height);
/*     */ 
/*     */     
/* 126 */     if (ensureSameSize) {
/* 127 */       GC tmpGC = new GC(device);
/* 128 */       Font tmpFont = new Font(device, fontData);
/* 129 */       tmpGC.setFont(tmpFont);
/* 130 */       if ((tmpGC.textExtent("ABCpqr")).x > DUMMY_PANEL
/* 131 */         .getFontMetrics(font).stringWidth("ABCpqr")) {
/* 132 */         while ((tmpGC.textExtent("ABCpqr")).x > DUMMY_PANEL
/* 133 */           .getFontMetrics(font).stringWidth("ABCpqr")) {
/* 134 */           tmpFont.dispose();
/* 135 */           height--;
/* 136 */           fontData.setHeight(height);
/* 137 */           tmpFont = new Font(device, fontData);
/* 138 */           tmpGC.setFont(tmpFont);
/*     */         }
/*     */       
/* 141 */       } else if ((tmpGC.textExtent("ABCpqr")).x < DUMMY_PANEL
/* 142 */         .getFontMetrics(font).stringWidth("ABCpqr")) {
/* 143 */         while ((tmpGC.textExtent("ABCpqr")).x < DUMMY_PANEL
/* 144 */           .getFontMetrics(font).stringWidth("ABCpqr")) {
/* 145 */           tmpFont.dispose();
/* 146 */           height++;
/* 147 */           fontData.setHeight(height);
/* 148 */           tmpFont = new Font(device, fontData);
/* 149 */           tmpGC.setFont(tmpFont);
/*     */         } 
/*     */       } 
/* 152 */       tmpFont.dispose();
/* 153 */       tmpGC.dispose();
/*     */     } 
/* 155 */     return fontData;
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
/*     */   public static Font toAwtFont(Device device, FontData fontData, boolean ensureSameSize) {
/* 176 */     int height = (int)Math.round((fontData.getHeight() * (device.getDPI()).y) / 72.0D);
/*     */ 
/*     */ 
/*     */     
/* 180 */     if (ensureSameSize) {
/* 181 */       GC tmpGC = new GC(device);
/* 182 */       Font tmpFont = new Font(device, fontData);
/* 183 */       tmpGC.setFont(tmpFont);
/* 184 */       JPanel DUMMY_PANEL = new JPanel();
/*     */       
/* 186 */       Font tmpAwtFont = new Font(fontData.getName(), fontData.getStyle(), height);
/* 187 */       if (DUMMY_PANEL.getFontMetrics(tmpAwtFont).stringWidth("ABCpqr") > 
/* 188 */         (tmpGC.textExtent("ABCpqr")).x) {
/* 189 */         while (DUMMY_PANEL.getFontMetrics(tmpAwtFont).stringWidth("ABCpqr") > 
/* 190 */           (tmpGC.textExtent("ABCpqr")).x) {
/* 191 */           height--;
/*     */           
/* 193 */           tmpAwtFont = new Font(fontData.getName(), fontData.getStyle(), height);
/*     */         }
/*     */       
/* 196 */       } else if (DUMMY_PANEL.getFontMetrics(tmpAwtFont).stringWidth("ABCpqr") < 
/* 197 */         (tmpGC.textExtent("ABCpqr")).x) {
/* 198 */         while (DUMMY_PANEL.getFontMetrics(tmpAwtFont).stringWidth("ABCpqr") < 
/* 199 */           (tmpGC.textExtent("ABCpqr")).x) {
/* 200 */           height++;
/*     */           
/* 202 */           tmpAwtFont = new Font(fontData.getName(), fontData.getStyle(), height);
/*     */         } 
/*     */       } 
/* 205 */       tmpFont.dispose();
/* 206 */       tmpGC.dispose();
/*     */     } 
/* 208 */     return new Font(fontData.getName(), fontData.getStyle(), height);
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
/*     */   public static Font toAwtFont(Device device, Font font) {
/* 221 */     FontData fontData = font.getFontData()[0];
/* 222 */     return toAwtFont(device, fontData, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Color toAwtColor(Color color) {
/* 233 */     return new Color(color.getRed(), color.getGreen(), color
/* 234 */         .getBlue());
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
/*     */   public static Color toSwtColor(Device device, Paint paint) {
/*     */     Color color;
/* 249 */     if (paint instanceof Color) {
/* 250 */       color = (Color)paint;
/*     */     } else {
/*     */       
/*     */       try {
/* 254 */         throw new Exception("only color is supported at present... setting paint to uniform black color");
/*     */       
/*     */       }
/* 257 */       catch (Exception e) {
/* 258 */         e.printStackTrace();
/* 259 */         color = new Color(false, false, false);
/*     */       } 
/*     */     } 
/* 262 */     return new Color(device, color
/* 263 */         .getRed(), color.getGreen(), color.getBlue());
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
/*     */   public static Color toSwtColor(Device device, Color color) {
/* 277 */     return new Color(device, color
/* 278 */         .getRed(), color.getGreen(), color.getBlue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Rectangle toSwtRectangle(Rectangle2D rect2d) {
/* 288 */     return new Rectangle(
/* 289 */         (int)Math.round(rect2d.getMinX()), 
/* 290 */         (int)Math.round(rect2d.getMinY()), 
/* 291 */         (int)Math.round(rect2d.getWidth()), 
/* 292 */         (int)Math.round(rect2d.getHeight()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Rectangle2D toAwtRectangle(Rectangle rect) {
/* 302 */     Rectangle2D rect2d = new Rectangle2D.Double();
/* 303 */     rect2d.setRect(rect.x, rect.y, rect.width, rect.height);
/* 304 */     return rect2d;
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
/* 318 */   public static Point2D toAwtPoint(Point p) { return new Point(p.x, p.y); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 332 */   public static Point toSwtPoint(Point p) { return new Point(p.x, p.y); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Point toSwtPoint(Point2D p) {
/* 346 */     return new Point((int)Math.round(p.getX()), 
/* 347 */         (int)Math.round(p.getY()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static MouseEvent toAwtMouseEvent(MouseEvent event) {
/* 357 */     int button = 0;
/* 358 */     switch (event.button) { case 1:
/* 359 */         button = 1; break;
/* 360 */       case 2: button = 2; break;
/* 361 */       case 3: button = 3; break; }
/*     */     
/* 363 */     int modifiers = 0;
/* 364 */     if ((event.stateMask & 0x40000) != 0) {
/* 365 */       modifiers |= 0x80;
/*     */     }
/* 367 */     if ((event.stateMask & 0x20000) != 0) {
/* 368 */       modifiers |= 0x40;
/*     */     }
/* 370 */     if ((event.stateMask & 0x10000) != 0) {
/* 371 */       modifiers |= 0x200;
/*     */     }
/* 373 */     return new MouseEvent(DUMMY_PANEL, event.hashCode(), event.time, modifiers, event.x, event.y, true, false, button);
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
/*     */   public static ImageData convertAWTImageToSWT(Image image) {
/* 386 */     ParamChecks.nullNotPermitted(image, "image");
/* 387 */     int w = image.getWidth(null);
/* 388 */     int h = image.getHeight(null);
/* 389 */     if (w == -1 || h == -1) {
/* 390 */       return null;
/*     */     }
/* 392 */     BufferedImage bi = new BufferedImage(w, h, true);
/* 393 */     Graphics g = bi.getGraphics();
/* 394 */     g.drawImage(image, 0, 0, null);
/* 395 */     g.dispose();
/* 396 */     return convertToSWT(bi);
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
/*     */   public static ImageData convertToSWT(BufferedImage bufferedImage) {
/* 408 */     if (bufferedImage.getColorModel() instanceof DirectColorModel) {
/*     */       
/* 410 */       DirectColorModel colorModel = (DirectColorModel)bufferedImage.getColorModel();
/*     */       
/* 412 */       PaletteData palette = new PaletteData(colorModel.getRedMask(), colorModel.getGreenMask(), colorModel.getBlueMask());
/*     */       
/* 414 */       ImageData data = new ImageData(bufferedImage.getWidth(), bufferedImage.getHeight(), colorModel.getPixelSize(), palette);
/*     */       
/* 416 */       WritableRaster raster = bufferedImage.getRaster();
/* 417 */       int[] pixelArray = new int[3];
/* 418 */       for (int y = 0; y < data.height; y++) {
/* 419 */         for (int x = 0; x < data.width; x++) {
/* 420 */           raster.getPixel(x, y, pixelArray);
/* 421 */           int pixel = palette.getPixel(new RGB(pixelArray[0], pixelArray[1], pixelArray[2]));
/*     */           
/* 423 */           data.setPixel(x, y, pixel);
/*     */         } 
/*     */       } 
/* 426 */       return data;
/*     */     } 
/* 428 */     if (bufferedImage.getColorModel() instanceof IndexColorModel) {
/*     */       
/* 430 */       IndexColorModel colorModel = (IndexColorModel)bufferedImage.getColorModel();
/* 431 */       int size = colorModel.getMapSize();
/* 432 */       byte[] reds = new byte[size];
/* 433 */       byte[] greens = new byte[size];
/* 434 */       byte[] blues = new byte[size];
/* 435 */       colorModel.getReds(reds);
/* 436 */       colorModel.getGreens(greens);
/* 437 */       colorModel.getBlues(blues);
/* 438 */       RGB[] rgbs = new RGB[size];
/* 439 */       for (int i = 0; i < rgbs.length; i++) {
/* 440 */         rgbs[i] = new RGB(reds[i] & 0xFF, greens[i] & 0xFF, blues[i] & 0xFF);
/*     */       }
/*     */       
/* 443 */       PaletteData palette = new PaletteData(rgbs);
/*     */       
/* 445 */       ImageData data = new ImageData(bufferedImage.getWidth(), bufferedImage.getHeight(), colorModel.getPixelSize(), palette);
/*     */       
/* 447 */       data.transparentPixel = colorModel.getTransparentPixel();
/* 448 */       WritableRaster raster = bufferedImage.getRaster();
/* 449 */       int[] pixelArray = new int[1];
/* 450 */       for (int y = 0; y < data.height; y++) {
/* 451 */         for (int x = 0; x < data.width; x++) {
/* 452 */           raster.getPixel(x, y, pixelArray);
/* 453 */           data.setPixel(x, y, pixelArray[0]);
/*     */         } 
/*     */       } 
/* 456 */       return data;
/*     */     } 
/* 458 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/swt/SWTUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */