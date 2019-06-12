package org.jfree.chart.axis;

public interface TickUnitSource {
  TickUnit getLargerTickUnit(TickUnit paramTickUnit);
  
  TickUnit getCeilingTickUnit(TickUnit paramTickUnit);
  
  TickUnit getCeilingTickUnit(double paramDouble);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/axis/TickUnitSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */