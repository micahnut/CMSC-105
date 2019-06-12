package org.jfree.chart.plot;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;

public interface DrawingSupplier {
  Paint getNextPaint();
  
  Paint getNextOutlinePaint();
  
  Paint getNextFillPaint();
  
  Stroke getNextStroke();
  
  Stroke getNextOutlineStroke();
  
  Shape getNextShape();
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/DrawingSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */