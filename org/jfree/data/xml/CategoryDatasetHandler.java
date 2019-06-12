/*     */ package org.jfree.data.xml;
/*     */ 
/*     */ import org.jfree.data.category.CategoryDataset;
/*     */ import org.jfree.data.category.DefaultCategoryDataset;
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
/*     */ public class CategoryDatasetHandler
/*     */   extends RootHandler
/*     */   implements DatasetTags
/*     */ {
/*     */   private DefaultCategoryDataset dataset;
/*     */   
/*  61 */   public CategoryDatasetHandler() { this.dataset = null; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   public CategoryDataset getDataset() { return this.dataset; }
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
/*  81 */   public void addItem(Comparable rowKey, Comparable columnKey, Number value) { this.dataset.addValue(value, rowKey, columnKey); }
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
/* 100 */     DefaultHandler current = getCurrentHandler();
/* 101 */     if (current != this) {
/* 102 */       current.startElement(namespaceURI, localName, qName, atts);
/*     */     }
/* 104 */     else if (qName.equals("CategoryDataset")) {
/* 105 */       this.dataset = new DefaultCategoryDataset();
/*     */     }
/* 107 */     else if (qName.equals("Series")) {
/* 108 */       CategorySeriesHandler subhandler = new CategorySeriesHandler(this);
/* 109 */       getSubHandlers().push(subhandler);
/* 110 */       subhandler.startElement(namespaceURI, localName, qName, atts);
/*     */     } else {
/*     */       
/* 113 */       throw new SAXException("Element not recognised: " + qName);
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
/* 132 */     DefaultHandler current = getCurrentHandler();
/* 133 */     if (current != this)
/* 134 */       current.endElement(namespaceURI, localName, qName); 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xml/CategoryDatasetHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */