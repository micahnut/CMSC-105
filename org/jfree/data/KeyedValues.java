package org.jfree.data;

import java.util.List;

public interface KeyedValues extends Values {
  Comparable getKey(int paramInt);
  
  int getIndex(Comparable paramComparable);
  
  List getKeys();
  
  Number getValue(Comparable paramComparable);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/KeyedValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */