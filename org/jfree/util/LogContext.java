/*     */ package org.jfree.util;
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
/*     */ public class LogContext
/*     */ {
/*     */   private String contextPrefix;
/*     */   
/*  61 */   public LogContext(String contextPrefix) { this.contextPrefix = contextPrefix; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   public boolean isDebugEnabled() { return Log.isDebugEnabled(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public boolean isInfoEnabled() { return Log.isInfoEnabled(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   public boolean isWarningEnabled() { return Log.isWarningEnabled(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   public boolean isErrorEnabled() { return Log.isErrorEnabled(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public void debug(Object message) { log(3, message); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 121 */   public void debug(Object message, Exception e) { log(3, message, e); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   public void info(Object message) { log(2, message); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 140 */   public void info(Object message, Exception e) { log(2, message, e); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 149 */   public void warn(Object message) { log(1, message); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 159 */   public void warn(Object message, Exception e) { log(1, message, e); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 168 */   public void error(Object message) { log(0, message); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 178 */   public void error(Object message, Exception e) { log(0, message, e); }
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
/*     */   public void log(int level, Object message) {
/* 190 */     if (this.contextPrefix != null) {
/* 191 */       Log.getInstance().doLog(level, new Log.SimpleMessage(this.contextPrefix, ":", message));
/*     */     } else {
/*     */       
/* 194 */       Log.getInstance().doLog(level, message);
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
/*     */   public void log(int level, Object message, Exception e) {
/* 210 */     if (this.contextPrefix != null) {
/* 211 */       Log.getInstance().doLog(level, new Log.SimpleMessage(this.contextPrefix, ":", message), e);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 216 */       Log.getInstance().doLog(level, message, e);
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
/*     */   public boolean equals(Object o) {
/* 228 */     if (this == o) {
/* 229 */       return true;
/*     */     }
/* 231 */     if (!(o instanceof LogContext)) {
/* 232 */       return false;
/*     */     }
/*     */     
/* 235 */     LogContext logContext = (LogContext)o;
/*     */     
/* 237 */     if (this.contextPrefix != null) {
/*     */       
/* 239 */       if (!this.contextPrefix.equals(logContext.contextPrefix)) {
/* 240 */         return false;
/*     */       
/*     */       }
/*     */     }
/* 244 */     else if (logContext.contextPrefix != null) {
/* 245 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 249 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 258 */   public int hashCode() { return (this.contextPrefix != null) ? this.contextPrefix.hashCode() : 0; }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/util/LogContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */