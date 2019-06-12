package org.jfree.data.general;

public interface Dataset {
  void addChangeListener(DatasetChangeListener paramDatasetChangeListener);
  
  void removeChangeListener(DatasetChangeListener paramDatasetChangeListener);
  
  DatasetGroup getGroup();
  
  void setGroup(DatasetGroup paramDatasetGroup);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/general/Dataset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */