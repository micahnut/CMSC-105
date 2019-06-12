package org.jfree.base.modules;

public interface Module extends ModuleInfo {
  ModuleInfo[] getRequiredModules();
  
  ModuleInfo[] getOptionalModules();
  
  void initialize(SubSystem paramSubSystem) throws ModuleInitializeException;
  
  void configure(SubSystem paramSubSystem) throws ModuleInitializeException;
  
  String getDescription();
  
  String getProducer();
  
  String getName();
  
  String getSubSystem();
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/base/modules/Module.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */