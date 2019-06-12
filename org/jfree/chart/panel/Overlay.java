package org.jfree.chart.panel;

import java.awt.Graphics2D;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.event.OverlayChangeListener;

public interface Overlay {
  void paintOverlay(Graphics2D paramGraphics2D, ChartPanel paramChartPanel);
  
  void addChangeListener(OverlayChangeListener paramOverlayChangeListener);
  
  void removeChangeListener(OverlayChangeListener paramOverlayChangeListener);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/panel/Overlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */