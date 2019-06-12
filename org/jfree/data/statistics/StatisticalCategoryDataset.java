package org.jfree.data.statistics;

import org.jfree.data.category.CategoryDataset;

public interface StatisticalCategoryDataset extends CategoryDataset {
  Number getMeanValue(int paramInt1, int paramInt2);
  
  Number getMeanValue(Comparable paramComparable1, Comparable paramComparable2);
  
  Number getStdDevValue(int paramInt1, int paramInt2);
  
  Number getStdDevValue(Comparable paramComparable1, Comparable paramComparable2);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/statistics/StatisticalCategoryDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */