package org.jfree.data.statistics;

import java.util.List;
import org.jfree.data.category.CategoryDataset;

public interface BoxAndWhiskerCategoryDataset extends CategoryDataset {
  Number getMeanValue(int paramInt1, int paramInt2);
  
  Number getMeanValue(Comparable paramComparable1, Comparable paramComparable2);
  
  Number getMedianValue(int paramInt1, int paramInt2);
  
  Number getMedianValue(Comparable paramComparable1, Comparable paramComparable2);
  
  Number getQ1Value(int paramInt1, int paramInt2);
  
  Number getQ1Value(Comparable paramComparable1, Comparable paramComparable2);
  
  Number getQ3Value(int paramInt1, int paramInt2);
  
  Number getQ3Value(Comparable paramComparable1, Comparable paramComparable2);
  
  Number getMinRegularValue(int paramInt1, int paramInt2);
  
  Number getMinRegularValue(Comparable paramComparable1, Comparable paramComparable2);
  
  Number getMaxRegularValue(int paramInt1, int paramInt2);
  
  Number getMaxRegularValue(Comparable paramComparable1, Comparable paramComparable2);
  
  Number getMinOutlier(int paramInt1, int paramInt2);
  
  Number getMinOutlier(Comparable paramComparable1, Comparable paramComparable2);
  
  Number getMaxOutlier(int paramInt1, int paramInt2);
  
  Number getMaxOutlier(Comparable paramComparable1, Comparable paramComparable2);
  
  List getOutliers(int paramInt1, int paramInt2);
  
  List getOutliers(Comparable paramComparable1, Comparable paramComparable2);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/statistics/BoxAndWhiskerCategoryDataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */