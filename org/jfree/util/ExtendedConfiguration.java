package org.jfree.util;

public interface ExtendedConfiguration extends Configuration {
  boolean isPropertySet(String paramString);
  
  int getIntProperty(String paramString);
  
  int getIntProperty(String paramString, int paramInt);
  
  boolean getBoolProperty(String paramString);
  
  boolean getBoolProperty(String paramString, boolean paramBoolean);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/util/ExtendedConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */