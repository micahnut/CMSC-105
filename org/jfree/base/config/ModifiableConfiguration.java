package org.jfree.base.config;

import java.util.Enumeration;
import java.util.Iterator;
import org.jfree.util.Configuration;

public interface ModifiableConfiguration extends Configuration {
  void setConfigProperty(String paramString1, String paramString2);
  
  Enumeration getConfigProperties();
  
  Iterator findPropertyKeys(String paramString);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/base/config/ModifiableConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */