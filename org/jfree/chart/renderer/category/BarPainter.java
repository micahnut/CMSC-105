package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;
import org.jfree.ui.RectangleEdge;

public interface BarPainter {
  void paintBar(Graphics2D paramGraphics2D, BarRenderer paramBarRenderer, int paramInt1, int paramInt2, RectangularShape paramRectangularShape, RectangleEdge paramRectangleEdge);
  
  void paintBarShadow(Graphics2D paramGraphics2D, BarRenderer paramBarRenderer, int paramInt1, int paramInt2, RectangularShape paramRectangularShape, RectangleEdge paramRectangleEdge, boolean paramBoolean);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/renderer/category/BarPainter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */