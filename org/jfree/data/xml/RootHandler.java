/*     */ package org.jfree.data.xml;
/*     */ 
/*     */ import java.util.Stack;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.helpers.DefaultHandler;
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
/*     */ public class RootHandler
/*     */   extends DefaultHandler
/*     */   implements DatasetTags
/*     */ {
/*     */   private Stack subHandlers;
/*     */   
/*  60 */   public RootHandler() { this.subHandlers = new Stack(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   public Stack getSubHandlers() { return this.subHandlers; }
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
/*     */   public void characters(char[] ch, int start, int length) throws SAXException {
/*  84 */     DefaultHandler handler = getCurrentHandler();
/*  85 */     if (handler != this) {
/*  86 */       handler.characters(ch, start, length);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultHandler getCurrentHandler() {
/*  96 */     DefaultHandler result = this;
/*  97 */     if (this.subHandlers != null && 
/*  98 */       this.subHandlers.size() > 0) {
/*  99 */       Object top = this.subHandlers.peek();
/* 100 */       if (top != null) {
/* 101 */         result = (DefaultHandler)top;
/*     */       }
/*     */     } 
/*     */     
/* 105 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 114 */   public void pushSubHandler(DefaultHandler subhandler) { this.subHandlers.push(subhandler); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   public DefaultHandler popSubHandler() { return (DefaultHandler)this.subHandlers.pop(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xml/RootHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */