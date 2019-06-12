package org.jfree.data.general;

public interface HeatMapDataset {
  int getXSampleCount();
  
  int getYSampleCount();
  
  double getMinimumXValue();
  
  double getMaximumXValue();
  
  double getMinimumYValue();
  
  double getMaximumYValue();
  
  double getXValue(int paramInt);
  
  double getYValue(int paramInt);
  
  double getZValue(int paramInt1, int paramInt2);
  
  Number getZ(int paramInt1, int paramInt2);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/general/HeatMapDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */