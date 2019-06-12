/*    */ package org.jfree.util;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface LogTarget
/*    */ {
/*    */   public static final int ERROR = 0;
/*    */   public static final int WARN = 1;
/*    */   public static final int INFO = 2;
/*    */   public static final int DEBUG = 3;
/* 75 */   public static final String[] LEVELS = { "ERROR: ", "WARN:  ", "INFO:  ", "DEBUG: " };
/*    */   
/*    */   void log(int paramInt, Object paramObject);
/*    */   
/*    */   void log(int paramInt, Object paramObject, Exception paramException);
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/util/LogTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */