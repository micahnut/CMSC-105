package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import org.jfree.ui.RectangleInsets;

public interface BlockFrame {
  RectangleInsets getInsets();
  
  void draw(Graphics2D paramGraphics2D, Rectangle2D paramRectangle2D);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/block/BlockFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */