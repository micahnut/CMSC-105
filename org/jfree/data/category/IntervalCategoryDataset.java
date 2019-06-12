package org.jfree.data.category;

public interface IntervalCategoryDataset extends CategoryDataset {
  Number getStartValue(int paramInt1, int paramInt2);
  
  Number getStartValue(Comparable paramComparable1, Comparable paramComparable2);
  
  Number getEndValue(int paramInt1, int paramInt2);
  
  Number getEndValue(Comparable paramComparable1, Comparable paramComparable2);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/category/IntervalCategoryDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */