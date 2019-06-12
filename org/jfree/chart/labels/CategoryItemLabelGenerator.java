package org.jfree.chart.labels;

import org.jfree.data.category.CategoryDataset;

public interface CategoryItemLabelGenerator {
  String generateRowLabel(CategoryDataset paramCategoryDataset, int paramInt);
  
  String generateColumnLabel(CategoryDataset paramCategoryDataset, int paramInt);
  
  String generateLabel(CategoryDataset paramCategoryDataset, int paramInt1, int paramInt2);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/labels/CategoryItemLabelGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */