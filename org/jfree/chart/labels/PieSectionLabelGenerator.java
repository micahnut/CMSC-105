package org.jfree.chart.labels;

import java.text.AttributedString;
import org.jfree.data.general.PieDataset;

public interface PieSectionLabelGenerator {
  String generateSectionLabel(PieDataset paramPieDataset, Comparable paramComparable);
  
  AttributedString generateAttributedSectionLabel(PieDataset paramPieDataset, Comparable paramComparable);
}


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/chart/labels/PieSectionLabelGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */