package org.jfree.data.general;

public interface SeriesDataset extends Dataset {
  int getSeriesCount();
  
  Comparable getSeriesKey(int paramInt);
  
  int indexOf(Comparable paramComparable);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/general/SeriesDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */