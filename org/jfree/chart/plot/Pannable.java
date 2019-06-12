package org.jfree.chart.plot;

import java.awt.geom.Point2D;

public interface Pannable {
  PlotOrientation getOrientation();
  
  boolean isDomainPannable();
  
  boolean isRangePannable();
  
  void panDomainAxes(double paramDouble, PlotRenderingInfo paramPlotRenderingInfo, Point2D paramPoint2D);
  
  void panRangeAxes(double paramDouble, PlotRenderingInfo paramPlotRenderingInfo, Point2D paramPoint2D);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/Pannable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */