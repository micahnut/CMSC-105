/*     */ package org.jfree.experimental.chart.swt;
/*     */ 
/*     */ import org.eclipse.swt.graphics.GC;
/*     */ import org.eclipse.swt.graphics.Image;
/*     */ import org.eclipse.swt.graphics.Point;
/*     */ import org.eclipse.swt.graphics.Rectangle;
/*     */ import org.eclipse.swt.printing.PrintDialog;
/*     */ import org.eclipse.swt.printing.Printer;
/*     */ import org.eclipse.swt.printing.PrinterData;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChartPrintJob
/*     */ {
/*     */   private static final double BORDER = 0.8D;
/*     */   private String jobName;
/*     */   
/*  71 */   public ChartPrintJob(String jobName) { this.jobName = jobName; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void print(Composite elementToPrint) {
/*  80 */     PrintDialog dialog = new PrintDialog(elementToPrint.getShell());
/*  81 */     PrinterData printerData = dialog.open();
/*  82 */     if (printerData == null) {
/*     */       return;
/*     */     }
/*  85 */     startPrintJob(elementToPrint, printerData);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void startPrintJob(Composite elementToPrint, PrinterData printerData) {
/*  90 */     printer = new Printer(printerData);
/*     */     try {
/*  92 */       printer.startJob(this.jobName);
/*     */       
/*  94 */       gc = new GC(printer);
/*     */       try {
/*  96 */         Rectangle printArea = getPrintableArea(printer, 0.8D);
/*  97 */         printer.startPage();
/*  98 */         printComposite(elementToPrint, gc, printArea);
/*  99 */         printer.endPage();
/*     */       } finally {
/* 101 */         gc.dispose();
/*     */       } 
/* 103 */       printer.endJob();
/*     */     } finally {
/*     */       
/* 106 */       printer.dispose();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Rectangle getPrintableArea(Printer printer, double safetyBorder) {
/* 117 */     int safetyBorderWidth = (int)(safetyBorder * (printer.getDPI()).x);
/* 118 */     int safetyBorderHeight = (int)(safetyBorder * (printer.getDPI()).y);
/*     */     
/* 120 */     Rectangle trim = printer.computeTrim(0, 0, 0, 0);
/* 121 */     int trimLeft = -trim.x;
/* 122 */     int trimTop = -trim.y;
/* 123 */     int trimRight = trim.x + trim.width;
/* 124 */     int trimBottom = trim.y + trim.height;
/*     */     
/* 126 */     int marginLeft = Math.max(trimLeft, safetyBorderWidth);
/* 127 */     int marginRight = Math.max(trimRight, safetyBorderWidth);
/* 128 */     int marginTop = Math.max(trimTop, safetyBorderHeight);
/* 129 */     int marginBottom = Math.max(trimBottom, safetyBorderHeight);
/*     */     
/* 131 */     int availWidth = (printer.getClientArea()).width - marginLeft - marginRight;
/*     */     
/* 133 */     int availHeight = (printer.getClientArea()).height - marginTop - marginBottom;
/*     */     
/* 135 */     return new Rectangle(marginLeft, marginTop, availWidth, availHeight);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void printComposite(Composite elementToPrint, GC gc, Rectangle printArea) {
/* 141 */     image = new Image(elementToPrint.getDisplay(), (elementToPrint.getSize()).x, (elementToPrint.getSize()).y);
/*     */     try {
/* 143 */       imageGC = new GC(image);
/*     */       try {
/* 145 */         elementToPrint.print(imageGC);
/* 146 */         Point fittedSize = calcFittedSize(printArea, elementToPrint
/* 147 */             .getSize());
/* 148 */         gc.drawImage(image, 0, 0, (elementToPrint.getSize()).x, 
/* 149 */             (elementToPrint.getSize()).y, printArea.x, printArea.y, fittedSize.x, fittedSize.y);
/*     */       }
/*     */       finally {
/*     */         
/* 153 */         imageGC.dispose();
/*     */       } 
/*     */     } finally {
/* 156 */       image.dispose();
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
/*     */   Point calcFittedSize(Rectangle printArea, Point originalSize) {
/* 170 */     double scaleFactor = Math.min(printArea.height / originalSize.y, printArea.width / originalSize.x);
/*     */ 
/*     */     
/* 173 */     int trgHeight = (int)Math.ceil(originalSize.y * scaleFactor);
/* 174 */     int trgWidth = (int)Math.ceil(originalSize.x * scaleFactor);
/* 175 */     return new Point(trgWidth, trgHeight);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/experimental/chart/swt/ChartPrintJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */