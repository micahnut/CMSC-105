package org.jfree.util;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Iterator;

public interface Configuration extends Serializable, Cloneable {
  String getConfigProperty(String paramString);
  
  String getConfigProperty(String paramString1, String paramString2);
  
  Iterator findPropertyKeys(String paramString);
  
  Enumeration getConfigProperties();
  
  Object clone() throws CloneNotSupportedException;
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/util/Configuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */