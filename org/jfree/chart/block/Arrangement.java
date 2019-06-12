package org.jfree.chart.block;

import java.awt.Graphics2D;
import org.jfree.ui.Size2D;

public interface Arrangement {
  void add(Block paramBlock, Object paramObject);
  
  Size2D arrange(BlockContainer paramBlockContainer, Graphics2D paramGraphics2D, RectangleConstraint paramRectangleConstraint);
  
  void clear();
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/block/Arrangement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */