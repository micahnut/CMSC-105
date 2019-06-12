/*     */ package org.jfree.chart.plot;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.jfree.chart.LegendItemCollection;
/*     */ import org.jfree.chart.axis.AxisSpace;
/*     */ import org.jfree.chart.axis.AxisState;
/*     */ import org.jfree.chart.axis.NumberAxis;
/*     */ import org.jfree.chart.axis.ValueAxis;
/*     */ import org.jfree.chart.event.PlotChangeEvent;
/*     */ import org.jfree.chart.event.PlotChangeListener;
/*     */ import org.jfree.chart.renderer.xy.XYItemRenderer;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.chart.util.ShadowGenerator;
/*     */ import org.jfree.data.Range;
/*     */ import org.jfree.ui.RectangleEdge;
/*     */ import org.jfree.ui.RectangleInsets;
/*     */ import org.jfree.util.ObjectUtilities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CombinedDomainXYPlot
/*     */   extends XYPlot
/*     */   implements PlotChangeListener
/*     */ {
/*     */   private static final long serialVersionUID = -7765545541261907383L;
/*     */   private List<XYPlot> subplots;
/* 137 */   private double gap = 5.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Rectangle2D[] subplotAreas;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 148 */   public CombinedDomainXYPlot() { this(new NumberAxis()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CombinedDomainXYPlot(ValueAxis domainAxis) {
/* 158 */     super(null, domainAxis, null, null);
/*     */ 
/*     */ 
/*     */     
/* 162 */     this.subplots = new ArrayList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 172 */   public String getPlotType() { return "Combined_Domain_XYPlot"; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 183 */   public double getGap() { return this.gap; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGap(double gap) {
/* 195 */     this.gap = gap;
/* 196 */     fireChangeEvent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRangePannable() {
/* 207 */     for (XYPlot subplot : this.subplots) {
/* 208 */       if (subplot.isRangePannable()) {
/* 209 */         return true;
/*     */       }
/*     */     } 
/* 212 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRangePannable(boolean pannable) {
/* 223 */     for (XYPlot subplot : this.subplots) {
/* 224 */       subplot.setRangePannable(pannable);
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
/*     */   public void setOrientation(PlotOrientation orientation) {
/* 236 */     super.setOrientation(orientation);
/* 237 */     Iterator iterator = this.subplots.iterator();
/* 238 */     while (iterator.hasNext()) {
/* 239 */       XYPlot plot = (XYPlot)iterator.next();
/* 240 */       plot.setOrientation(orientation);
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
/*     */   public void setShadowGenerator(ShadowGenerator generator) {
/* 252 */     setNotify(false);
/* 253 */     super.setShadowGenerator(generator);
/* 254 */     Iterator iterator = this.subplots.iterator();
/* 255 */     while (iterator.hasNext()) {
/* 256 */       XYPlot plot = (XYPlot)iterator.next();
/* 257 */       plot.setShadowGenerator(generator);
/*     */     } 
/* 259 */     setNotify(true);
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
/*     */   public Range getDataRange(ValueAxis axis) {
/* 277 */     Range result = null;
/* 278 */     if (this.subplots != null) {
/* 279 */       Iterator iterator = this.subplots.iterator();
/* 280 */       while (iterator.hasNext()) {
/* 281 */         XYPlot subplot = (XYPlot)iterator.next();
/* 282 */         result = Range.combine(result, subplot.getDataRange(axis));
/*     */       } 
/*     */     } 
/* 285 */     return result;
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
/* 299 */   public void add(XYPlot subplot) { add(subplot, 1); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(XYPlot subplot, int weight) {
/* 315 */     ParamChecks.nullNotPermitted(subplot, "subplot");
/* 316 */     if (weight <= 0) {
/* 317 */       throw new IllegalArgumentException("Require weight >= 1.");
/*     */     }
/*     */ 
/*     */     
/* 321 */     subplot.setParent(this);
/* 322 */     subplot.setWeight(weight);
/* 323 */     subplot.setInsets(RectangleInsets.ZERO_INSETS, false);
/* 324 */     subplot.setDomainAxis(null);
/* 325 */     subplot.addChangeListener(this);
/* 326 */     this.subplots.add(subplot);
/*     */     
/* 328 */     ValueAxis axis = getDomainAxis();
/* 329 */     if (axis != null) {
/* 330 */       axis.configure();
/*     */     }
/* 332 */     fireChangeEvent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(XYPlot subplot) {
/* 342 */     ParamChecks.nullNotPermitted(subplot, "subplot");
/* 343 */     int position = -1;
/* 344 */     int size = this.subplots.size();
/* 345 */     int i = 0;
/* 346 */     while (position == -1 && i < size) {
/* 347 */       if (this.subplots.get(i) == subplot) {
/* 348 */         position = i;
/*     */       }
/* 350 */       i++;
/*     */     } 
/* 352 */     if (position != -1) {
/* 353 */       this.subplots.remove(position);
/* 354 */       subplot.setParent(null);
/* 355 */       subplot.removeChangeListener(this);
/* 356 */       ValueAxis domain = getDomainAxis();
/* 357 */       if (domain != null) {
/* 358 */         domain.configure();
/*     */       }
/* 360 */       fireChangeEvent();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List getSubplots() {
/* 371 */     if (this.subplots != null) {
/* 372 */       return Collections.unmodifiableList(this.subplots);
/*     */     }
/*     */     
/* 375 */     return Collections.EMPTY_LIST;
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
/*     */   protected AxisSpace calculateAxisSpace(Graphics2D g2, Rectangle2D plotArea) {
/* 391 */     AxisSpace space = new AxisSpace();
/* 392 */     PlotOrientation orientation = getOrientation();
/*     */ 
/*     */     
/* 395 */     AxisSpace fixed = getFixedDomainAxisSpace();
/* 396 */     if (fixed != null) {
/* 397 */       if (orientation == PlotOrientation.HORIZONTAL) {
/* 398 */         space.setLeft(fixed.getLeft());
/* 399 */         space.setRight(fixed.getRight());
/*     */       }
/* 401 */       else if (orientation == PlotOrientation.VERTICAL) {
/* 402 */         space.setTop(fixed.getTop());
/* 403 */         space.setBottom(fixed.getBottom());
/*     */       } 
/*     */     } else {
/*     */       
/* 407 */       ValueAxis xAxis = getDomainAxis();
/* 408 */       RectangleEdge xEdge = Plot.resolveDomainAxisLocation(
/* 409 */           getDomainAxisLocation(), orientation);
/* 410 */       if (xAxis != null) {
/* 411 */         space = xAxis.reserveSpace(g2, this, plotArea, xEdge, space);
/*     */       }
/*     */     } 
/*     */     
/* 415 */     Rectangle2D adjustedPlotArea = space.shrink(plotArea, null);
/*     */ 
/*     */     
/* 418 */     int n = this.subplots.size();
/* 419 */     int totalWeight = 0;
/* 420 */     for (i = 0; i < n; i++) {
/* 421 */       XYPlot sub = (XYPlot)this.subplots.get(i);
/* 422 */       totalWeight += sub.getWeight();
/*     */     } 
/* 424 */     this.subplotAreas = new Rectangle2D[n];
/* 425 */     double x = adjustedPlotArea.getX();
/* 426 */     double y = adjustedPlotArea.getY();
/* 427 */     double usableSize = 0.0D;
/* 428 */     if (orientation == PlotOrientation.HORIZONTAL) {
/* 429 */       usableSize = adjustedPlotArea.getWidth() - this.gap * (n - 1);
/*     */     }
/* 431 */     else if (orientation == PlotOrientation.VERTICAL) {
/* 432 */       usableSize = adjustedPlotArea.getHeight() - this.gap * (n - 1);
/*     */     } 
/*     */     
/* 435 */     for (int i = 0; i < n; i++) {
/* 436 */       XYPlot plot = (XYPlot)this.subplots.get(i);
/*     */ 
/*     */       
/* 439 */       if (orientation == PlotOrientation.HORIZONTAL) {
/* 440 */         double w = usableSize * plot.getWeight() / totalWeight;
/* 441 */         this.subplotAreas[i] = new Rectangle2D.Double(x, y, w, adjustedPlotArea
/* 442 */             .getHeight());
/* 443 */         x = x + w + this.gap;
/*     */       }
/* 445 */       else if (orientation == PlotOrientation.VERTICAL) {
/* 446 */         double h = usableSize * plot.getWeight() / totalWeight;
/* 447 */         this.subplotAreas[i] = new Rectangle2D.Double(x, y, adjustedPlotArea
/* 448 */             .getWidth(), h);
/* 449 */         y = y + h + this.gap;
/*     */       } 
/*     */       
/* 452 */       AxisSpace subSpace = plot.calculateRangeAxisSpace(g2, this.subplotAreas[i], null);
/*     */       
/* 454 */       space.ensureAtLeast(subSpace);
/*     */     } 
/*     */ 
/*     */     
/* 458 */     return space;
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
/*     */   public void draw(Graphics2D g2, Rectangle2D area, Point2D anchor, PlotState parentState, PlotRenderingInfo info) {
/* 478 */     if (info != null) {
/* 479 */       info.setPlotArea(area);
/*     */     }
/*     */ 
/*     */     
/* 483 */     RectangleInsets insets = getInsets();
/* 484 */     insets.trim(area);
/*     */     
/* 486 */     setFixedRangeAxisSpaceForSubplots(null);
/* 487 */     AxisSpace space = calculateAxisSpace(g2, area);
/* 488 */     Rectangle2D dataArea = space.shrink(area, null);
/*     */ 
/*     */     
/* 491 */     setFixedRangeAxisSpaceForSubplots(space);
/*     */ 
/*     */     
/* 494 */     ValueAxis axis = getDomainAxis();
/* 495 */     RectangleEdge edge = getDomainAxisEdge();
/* 496 */     double cursor = RectangleEdge.coordinate(dataArea, edge);
/* 497 */     AxisState axisState = axis.draw(g2, cursor, area, dataArea, edge, info);
/* 498 */     if (parentState == null) {
/* 499 */       parentState = new PlotState();
/*     */     }
/* 501 */     parentState.getSharedAxisStates().put(axis, axisState);
/*     */ 
/*     */     
/* 504 */     for (int i = 0; i < this.subplots.size(); i++) {
/* 505 */       XYPlot plot = (XYPlot)this.subplots.get(i);
/* 506 */       PlotRenderingInfo subplotInfo = null;
/* 507 */       if (info != null) {
/* 508 */         subplotInfo = new PlotRenderingInfo(info.getOwner());
/* 509 */         info.addSubplotInfo(subplotInfo);
/*     */       } 
/* 511 */       plot.draw(g2, this.subplotAreas[i], anchor, parentState, subplotInfo);
/*     */     } 
/*     */ 
/*     */     
/* 515 */     if (info != null) {
/* 516 */       info.setDataArea(dataArea);
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
/*     */   public LegendItemCollection getLegendItems() {
/* 528 */     LegendItemCollection result = getFixedLegendItems();
/* 529 */     if (result == null) {
/* 530 */       result = new LegendItemCollection();
/* 531 */       if (this.subplots != null) {
/* 532 */         Iterator iterator = this.subplots.iterator();
/* 533 */         while (iterator.hasNext()) {
/* 534 */           XYPlot plot = (XYPlot)iterator.next();
/* 535 */           LegendItemCollection more = plot.getLegendItems();
/* 536 */           result.addAll(more);
/*     */         } 
/*     */       } 
/*     */     } 
/* 540 */     return result;
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
/* 553 */   public void zoomRangeAxes(double factor, PlotRenderingInfo info, Point2D source) { zoomRangeAxes(factor, info, source, false); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void zoomRangeAxes(double factor, PlotRenderingInfo state, Point2D source, boolean useAnchor) {
/* 568 */     XYPlot subplot = findSubplot(state, source);
/* 569 */     if (subplot != null) {
/* 570 */       subplot.zoomRangeAxes(factor, state, source, useAnchor);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 575 */       Iterator iterator = getSubplots().iterator();
/* 576 */       while (iterator.hasNext()) {
/* 577 */         subplot = (XYPlot)iterator.next();
/* 578 */         subplot.zoomRangeAxes(factor, state, source, useAnchor);
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
/*     */ 
/*     */   
/*     */   public void zoomRangeAxes(double lowerPercent, double upperPercent, PlotRenderingInfo info, Point2D source) {
/* 595 */     XYPlot subplot = findSubplot(info, source);
/* 596 */     if (subplot != null) {
/* 597 */       subplot.zoomRangeAxes(lowerPercent, upperPercent, info, source);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 602 */       Iterator iterator = getSubplots().iterator();
/* 603 */       while (iterator.hasNext()) {
/* 604 */         subplot = (XYPlot)iterator.next();
/* 605 */         subplot.zoomRangeAxes(lowerPercent, upperPercent, info, source);
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
/*     */ 
/*     */   
/*     */   public void panRangeAxes(double panRange, PlotRenderingInfo info, Point2D source) {
/* 622 */     XYPlot subplot = findSubplot(info, source);
/* 623 */     if (subplot == null) {
/*     */       return;
/*     */     }
/* 626 */     if (!subplot.isRangePannable()) {
/*     */       return;
/*     */     }
/* 629 */     PlotRenderingInfo subplotInfo = info.getSubplotInfo(info
/* 630 */         .getSubplotIndex(source));
/* 631 */     if (subplotInfo == null) {
/*     */       return;
/*     */     }
/* 634 */     for (int i = 0; i < subplot.getRangeAxisCount(); i++) {
/* 635 */       ValueAxis rangeAxis = subplot.getRangeAxis(i);
/* 636 */       if (rangeAxis != null) {
/* 637 */         rangeAxis.pan(panRange);
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
/*     */   public XYPlot findSubplot(PlotRenderingInfo info, Point2D source) {
/* 652 */     ParamChecks.nullNotPermitted(info, "info");
/* 653 */     ParamChecks.nullNotPermitted(source, "source");
/* 654 */     XYPlot result = null;
/* 655 */     int subplotIndex = info.getSubplotIndex(source);
/* 656 */     if (subplotIndex >= 0) {
/* 657 */       result = (XYPlot)this.subplots.get(subplotIndex);
/*     */     }
/* 659 */     return result;
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
/*     */   public void setRenderer(XYItemRenderer renderer) {
/* 673 */     super.setRenderer(renderer);
/*     */ 
/*     */     
/* 676 */     Iterator iterator = this.subplots.iterator();
/* 677 */     while (iterator.hasNext()) {
/* 678 */       XYPlot plot = (XYPlot)iterator.next();
/* 679 */       plot.setRenderer(renderer);
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
/*     */   public void setFixedRangeAxisSpace(AxisSpace space) {
/* 691 */     super.setFixedRangeAxisSpace(space);
/* 692 */     setFixedRangeAxisSpaceForSubplots(space);
/* 693 */     fireChangeEvent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setFixedRangeAxisSpaceForSubplots(AxisSpace space) {
/* 703 */     Iterator iterator = this.subplots.iterator();
/* 704 */     while (iterator.hasNext()) {
/* 705 */       XYPlot plot = (XYPlot)iterator.next();
/* 706 */       plot.setFixedRangeAxisSpace(space, false);
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
/*     */   public void handleClick(int x, int y, PlotRenderingInfo info) {
/* 719 */     Rectangle2D dataArea = info.getDataArea();
/* 720 */     if (dataArea.contains(x, y)) {
/* 721 */       for (int i = 0; i < this.subplots.size(); i++) {
/* 722 */         XYPlot subplot = (XYPlot)this.subplots.get(i);
/* 723 */         PlotRenderingInfo subplotInfo = info.getSubplotInfo(i);
/* 724 */         subplot.handleClick(x, y, subplotInfo);
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
/* 737 */   public void plotChanged(PlotChangeEvent event) { notifyListeners(event); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 749 */     if (obj == this) {
/* 750 */       return true;
/*     */     }
/* 752 */     if (!(obj instanceof CombinedDomainXYPlot)) {
/* 753 */       return false;
/*     */     }
/* 755 */     CombinedDomainXYPlot that = (CombinedDomainXYPlot)obj;
/* 756 */     if (this.gap != that.gap) {
/* 757 */       return false;
/*     */     }
/* 759 */     if (!ObjectUtilities.equal(this.subplots, that.subplots)) {
/* 760 */       return false;
/*     */     }
/* 762 */     return super.equals(obj);
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
/*     */   public Object clone() throws CloneNotSupportedException {
/* 776 */     CombinedDomainXYPlot result = (CombinedDomainXYPlot)super.clone();
/* 777 */     result.subplots = (List)ObjectUtilities.deepClone(this.subplots);
/* 778 */     for (it = result.subplots.iterator(); it.hasNext(); ) {
/* 779 */       Plot child = (Plot)it.next();
/* 780 */       child.setParent(result);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 785 */     ValueAxis domainAxis = result.getDomainAxis();
/* 786 */     if (domainAxis != null) {
/* 787 */       domainAxis.configure();
/*     */     }
/*     */     
/* 790 */     return result;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/plot/CombinedDomainXYPlot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */