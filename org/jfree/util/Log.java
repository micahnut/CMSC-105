/*     */ package org.jfree.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Log
/*     */ {
/*     */   private int debuglevel;
/*     */   private LogTarget[] logTargets;
/*     */   private HashMap logContexts;
/*     */   private static Log singleton;
/*     */   
/*     */   public static class SimpleMessage
/*     */   {
/*     */     private String message;
/*     */     private Object[] param;
/*     */     
/*     */     public SimpleMessage(String message, Object param1) {
/*  80 */       this.message = message;
/*  81 */       this.param = new Object[] { param1 };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SimpleMessage(String message, Object param1, Object param2) {
/*  93 */       this.message = message;
/*  94 */       this.param = new Object[] { param1, param2 };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SimpleMessage(String message, Object param1, Object param2, Object param3) {
/* 107 */       this.message = message;
/* 108 */       this.param = new Object[] { param1, param2, param3 };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SimpleMessage(String message, Object param1, Object param2, Object param3, Object param4) {
/* 123 */       this.message = message;
/* 124 */       this.param = new Object[] { param1, param2, param3, param4 };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SimpleMessage(String message, Object[] param) {
/* 134 */       this.message = message;
/* 135 */       this.param = param;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 144 */       StringBuffer b = new StringBuffer();
/* 145 */       b.append(this.message);
/* 146 */       if (this.param != null) {
/* 147 */         for (int i = 0; i < this.param.length; i++) {
/* 148 */           b.append(this.param[i]);
/*     */         }
/*     */       }
/* 151 */       return b.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Log() {
/* 178 */     this.logContexts = new HashMap();
/* 179 */     this.logTargets = new LogTarget[0];
/* 180 */     this.debuglevel = 100;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Log getInstance() {
/* 189 */     if (singleton == null) {
/* 190 */       singleton = new Log();
/*     */     }
/* 192 */     return singleton;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 201 */   protected static void defineLog(Log log) { singleton = log; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 211 */   public int getDebuglevel() { return this.debuglevel; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 221 */   protected void setDebuglevel(int debuglevel) { this.debuglevel = debuglevel; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTarget(LogTarget target) {
/* 231 */     if (target == null) {
/* 232 */       throw new NullPointerException();
/*     */     }
/* 234 */     LogTarget[] data = new LogTarget[this.logTargets.length + 1];
/* 235 */     System.arraycopy(this.logTargets, 0, data, 0, this.logTargets.length);
/* 236 */     data[this.logTargets.length] = target;
/* 237 */     this.logTargets = data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeTarget(LogTarget target) {
/* 246 */     if (target == null) {
/* 247 */       throw new NullPointerException();
/*     */     }
/* 249 */     ArrayList l = new ArrayList();
/* 250 */     l.addAll(Arrays.asList(this.logTargets));
/* 251 */     l.remove(target);
/*     */     
/* 253 */     LogTarget[] targets = new LogTarget[l.size()];
/* 254 */     this.logTargets = (LogTarget[])l.toArray(targets);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 263 */   public LogTarget[] getTargets() { return (LogTarget[])this.logTargets.clone(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void replaceTargets(LogTarget target) {
/* 272 */     if (target == null) {
/* 273 */       throw new NullPointerException();
/*     */     }
/* 275 */     this.logTargets = new LogTarget[] { target };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 284 */   public static void debug(Object message) { log(3, message); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 294 */   public static void debug(Object message, Exception e) { log(3, message, e); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 303 */   public static void info(Object message) { log(2, message); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 313 */   public static void info(Object message, Exception e) { log(2, message, e); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 322 */   public static void warn(Object message) { log(1, message); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 332 */   public static void warn(Object message, Exception e) { log(1, message, e); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 341 */   public static void error(Object message) { log(0, message); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 351 */   public static void error(Object message, Exception e) { log(0, message, e); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doLog(int level, Object message) {
/* 363 */     if (level > 3) {
/* 364 */       level = 3;
/*     */     }
/* 366 */     if (level <= this.debuglevel) {
/* 367 */       for (int i = 0; i < this.logTargets.length; i++) {
/* 368 */         LogTarget t = this.logTargets[i];
/* 369 */         t.log(level, message);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 383 */   public static void log(int level, Object message) { getInstance().doLog(level, message); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 398 */   public static void log(int level, Object message, Exception e) { getInstance().doLog(level, message, e); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doLog(int level, Object message, Exception e) {
/* 413 */     if (level > 3) {
/* 414 */       level = 3;
/*     */     }
/*     */     
/* 417 */     if (level <= this.debuglevel) {
/* 418 */       for (int i = 0; i < this.logTargets.length; i++) {
/* 419 */         LogTarget t = this.logTargets[i];
/* 420 */         t.log(level, message, e);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 440 */   public static boolean isDebugEnabled() { return (getInstance().getDebuglevel() >= 3); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 450 */   public static boolean isInfoEnabled() { return (getInstance().getDebuglevel() >= 2); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 460 */   public static boolean isWarningEnabled() { return (getInstance().getDebuglevel() >= 1); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 470 */   public static boolean isErrorEnabled() { return (getInstance().getDebuglevel() >= 0); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 481 */   public static LogContext createContext(Class context) { return createContext(context.getName()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 492 */   public static LogContext createContext(String context) { return getInstance().internalCreateContext(context); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected LogContext internalCreateContext(String context) {
/* 503 */     synchronized (this) {
/* 504 */       LogContext ctx = (LogContext)this.logContexts.get(context);
/* 505 */       if (ctx == null) {
/* 506 */         ctx = new LogContext(context);
/* 507 */         this.logContexts.put(context, ctx);
/*     */       } 
/* 509 */       return ctx;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/util/Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */