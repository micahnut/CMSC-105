package org.jfree.chart.util;

import java.awt.image.BufferedImage;

public interface ShadowGenerator {
  BufferedImage createDropShadow(BufferedImage paramBufferedImage);
  
  int calculateOffsetX();
  
  int calculateOffsetY();
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/util/ShadowGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */