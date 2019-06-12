/*     */ package lab2;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class ST extends JFrame {
/*     */   private JLabel header;
/*     */   private JLabel totalper;
/*     */   private JTable table;
/*     */   
/*     */   public ST() {
/*  23 */     init();
/*  24 */     this.model = (DefaultTableModel)this.table.getModel();
/*     */   }
/*     */   private JButton showPieGraph; private JScrollPane scroll; DefaultTableModel model; ArrayList<Cat> categorical;
/*     */   public ST(ArrayList<Cat> categ, String header, String totalPercent, String totalFrequency) {
/*  28 */     this();
/*  29 */     this.categorical = categ;
/*  30 */     setHeader(header);
/*  31 */     setTotalPercent(totalPercent);
/*  32 */     setTable(categ, totalFrequency);
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/*  37 */     this.header = new JLabel();
/*  38 */     this.totalper = new JLabel();
/*  39 */     this.showPieGraph = new JButton();
/*  40 */     this.table = new JTable();
/*  41 */     this.scroll = new JScrollPane();
/*     */     
/*  43 */     setDefaultCloseOperation(2);
/*     */     
/*  45 */     this.header.setFont(new Font("Verdana", true, 15));
/*  46 */     this.header.setHorizontalAlignment(0);
/*  47 */     this.header.setText("Description");
/*     */     
/*  49 */     this.totalper.setFont(new Font("Verdana", false, 12));
/*  50 */     this.totalper.setHorizontalAlignment(0);
/*  51 */     this.totalper.setText("n = 0");
/*     */ 
/*     */ 
/*     */     
/*  55 */     this.showPieGraph.setFont(new Font("Verdana", true, 12));
/*  56 */     this.showPieGraph.setText("SHOW PIE GRAPH");
/*  57 */     this.showPieGraph.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  59 */             ST.this.showPieGraphActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/*  63 */     this.table.setFont(new Font("Verdana", true, 10));
/*  64 */     this.table.setModel(new DefaultTableModel(new Object[0][], new String[] { "VALUE LABELS" })
/*     */         {
/*     */           boolean[] canEdit = { false };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  77 */             return this.canEdit[columnIndex];
/*     */           }
/*     */         });
/*  80 */     this.scroll.setViewportView(this.table);
/*     */     
/*  82 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  83 */     getContentPane().setLayout(layout);
/*  84 */     layout.setHorizontalGroup(layout
/*  85 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  86 */         .addGroup(layout.createSequentialGroup()
/*  87 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  88 */             .addGroup(layout.createSequentialGroup()
/*  89 */               .addGap(0, 0, 32767)
/*  90 */               .addComponent(this.showPieGraph, -2, 194, -2)
/*  91 */               .addGap(88, 88, 88))
/*  92 */             .addGroup(layout.createSequentialGroup()
/*  93 */               .addGap(37, 37, 37)
/*  94 */               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  95 */                 .addComponent(this.header, -2, 375, -2)
/*  96 */                 .addComponent(this.scroll, -2, 375, -2))))
/*  97 */           .addContainerGap(36, 32767))
/*  98 */         .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/*  99 */           .addGap(0, 0, 32767)
/* 100 */           .addComponent(this.totalper, -2, 131, -2)
/* 101 */           .addGap(66, 66, 66)));
/*     */     
/* 103 */     layout.setVerticalGroup(layout
/* 104 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 105 */         .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/* 106 */           .addContainerGap(69, 32767)
/* 107 */           .addComponent(this.header)
/* 108 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 109 */           .addComponent(this.scroll, -2, 229, -2)
/* 110 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 111 */           .addComponent(this.totalper, -2, 15, -2)
/* 112 */           .addGap(46, 46, 46)
/* 113 */           .addComponent(this.showPieGraph)
/* 114 */           .addGap(44, 44, 44)));
/*     */ 
/*     */     
/* 117 */     pack();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void showPieGraphActionPerformed(ActionEvent evt) {
/* 180 */     Object[] options = { "Yes", "No" };
/* 181 */     int choice = JOptionPane.showOptionDialog(this, " Do you want to display the Pie Chart?", "Graph Presentation", 0, 3, null, options, options[0]);
/*     */     
/* 183 */     if (choice == 0) {
/* 184 */       PieChart p = new PieChart(this.header.getText(), this.categorical);
/* 185 */       p.setVisible(true);
/* 186 */       p.setLocationRelativeTo(null);
/* 187 */       p.pack();
/*     */     
/*     */     }
/* 190 */     else if (choice == 1) {
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 199 */   public void setHeader(String s) { this.header.setText(s); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 204 */   public void setTotalPercent(String s) { this.totalper.setText("T% = " + s); }
/*     */ 
/*     */   
/*     */   public void setTable(ArrayList<Cat> cat, String totalfreq) {
/* 208 */     this.model.setRowCount(0);
/* 209 */     this.model.addColumn("Percentage");
/* 210 */     Object[] ob = new Object[2];
/* 211 */     for (Cat y : cat) {
/* 212 */       ob[0] = y.description;
/* 213 */       ob[1] = y.percentString();
/* 214 */       this.model.addRow(ob);
/* 215 */       ob = new Object[2];
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 220 */     SwingUtilities.invokeLater(new Runnable()
/*     */         {
/* 222 */           public void run() { (new ST()).setVisible(true); }
/*     */         });
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab2/ST.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */