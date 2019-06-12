/*     */ package org.jfree.data.xml;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import org.jfree.data.DefaultKeyedValues;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CategorySeriesHandler
/*     */   extends DefaultHandler
/*     */   implements DatasetTags
/*     */ {
/*     */   private RootHandler root;
/*     */   private Comparable seriesKey;
/*     */   private DefaultKeyedValues values;
/*     */   
/*     */   public CategorySeriesHandler(RootHandler root) {
/*  71 */     this.root = root;
/*  72 */     this.values = new DefaultKeyedValues();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   public void setSeriesKey(Comparable key) { this.seriesKey = key; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   public void addItem(Comparable key, Number value) { this.values.addValue(key, value); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 110 */     if (qName.equals("Series")) {
/* 111 */       setSeriesKey(atts.getValue("name"));
/* 112 */       ItemHandler subhandler = new ItemHandler(this.root, this);
/* 113 */       this.root.pushSubHandler(subhandler);
/*     */     }
/* 115 */     else if (qName.equals("Item")) {
/* 116 */       ItemHandler subhandler = new ItemHandler(this.root, this);
/* 117 */       this.root.pushSubHandler(subhandler);
/* 118 */       subhandler.startElement(namespaceURI, localName, qName, atts);
/*     */     }
/*     */     else {
/*     */       
/* 122 */       throw new SAXException("Expecting <Series> or <Item> tag...found " + qName);
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
/*     */   public void endElement(String namespaceURI, String localName, String qName) {
/* 140 */     if (this.root instanceof CategoryDatasetHandler) {
/* 141 */       CategoryDatasetHandler handler = (CategoryDatasetHandler)this.root;
/*     */       
/* 143 */       Iterator iterator = this.values.getKeys().iterator();
/* 144 */       while (iterator.hasNext()) {
/* 145 */         Comparable key = (Comparable)iterator.next();
/* 146 */         Number value = this.values.getValue(key);
/* 147 */         handler.addItem(this.seriesKey, key, value);
/*     */       } 
/*     */       
/* 150 */       this.root.popSubHandler();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/xml/CategorySeriesHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */