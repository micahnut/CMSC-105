/*     */ package org.jfree.data.xml;
/*     */ 
/*     */ import org.jfree.data.general.DefaultPieDataset;
/*     */ import org.jfree.data.general.PieDataset;
/*     */ import org.xml.sax.Attributes;
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
/*     */ public class PieDatasetHandler
/*     */   extends RootHandler
/*     */   implements DatasetTags
/*     */ {
/*     */   private DefaultPieDataset dataset;
/*     */   
/*  61 */   public PieDatasetHandler() { this.dataset = null; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   public PieDataset getDataset() { return this.dataset; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  80 */   public void addItem(Comparable key, Number value) { this.dataset.setValue(key, value); }
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
/*     */   public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
/*  99 */     DefaultHandler current = getCurrentHandler();
/* 100 */     if (current != this) {
/* 101 */       current.startElement(namespaceURI, localName, qName, atts);
/*     */     }
/* 103 */     else if (qName.equals("PieDataset")) {
/* 104 */       this.dataset = new DefaultPieDataset();
/*     */     }
/* 106 */     else if (qName.equals("Item")) {
/* 107 */       ItemHandler subhandler = new ItemHandler(this, this);
/* 108 */       getSubHandlers().push(subhandler);
/* 109 */       subhandler.startElement(namespaceURI, localName, qName, atts);
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
/*     */   public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
/* 128 */     DefaultHandler current = getCurrentHandler();
/* 129 */     if (current != this)
/* 130 */       current.endElement(namespaceURI, localName, qName); 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xml/PieDatasetHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */