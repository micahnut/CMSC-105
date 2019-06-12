package org.jfree.chart.encoders;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

public interface ImageEncoder {
  byte[] encode(BufferedImage paramBufferedImage) throws IOException;
  
  void encode(BufferedImage paramBufferedImage, OutputStream paramOutputStream) throws IOException;
  
  float getQuality();
  
  void setQuality(float paramFloat);
  
  boolean isEncodingAlpha();
  
  void setEncodingAlpha(boolean paramBoolean);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/encoders/ImageEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */