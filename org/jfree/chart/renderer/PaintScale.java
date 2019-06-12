package org.jfree.chart.renderer;

import java.awt.Paint;

public interface PaintScale {
  double getLowerBound();
  
  double getUpperBound();
  
  Paint getPaint(double paramDouble);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/renderer/PaintScale.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */