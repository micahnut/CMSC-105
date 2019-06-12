/*    */ package org.jfree.base.log;
/*    */ 
/*    */ import org.jfree.base.modules.AbstractModule;
/*    */ import org.jfree.base.modules.ModuleInitializeException;
/*    */ import org.jfree.base.modules.SubSystem;
/*    */ import org.jfree.util.Log;
/*    */ import org.jfree.util.PrintStreamLogTarget;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultLogModule
/*    */   extends AbstractModule
/*    */ {
/* 70 */   public DefaultLogModule() throws ModuleInitializeException { loadModuleInfo(); }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initialize(SubSystem subSystem) throws ModuleInitializeException {
/* 83 */     if (LogConfiguration.isDisableLogging()) {
/*    */       return;
/*    */     }
/*    */ 
/*    */     
/* 88 */     if (LogConfiguration.getLogTarget()
/* 89 */       .equals(PrintStreamLogTarget.class.getName())) {
/*    */       
/* 91 */       DefaultLog.installDefaultLog();
/* 92 */       Log.getInstance().addTarget(new PrintStreamLogTarget());
/*    */       
/* 94 */       if ("true".equals(subSystem.getGlobalConfig()
/* 95 */           .getConfigProperty("org.jfree.base.LogAutoInit")))
/*    */       {
/* 97 */         Log.getInstance().init();
/*    */       }
/* 99 */       Log.info("Default log target started ... previous log messages could have been ignored.");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/base/log/DefaultLogModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */