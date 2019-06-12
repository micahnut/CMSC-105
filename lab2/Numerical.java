/*     */ package lab2;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class Numerical extends JFrame implements ActionListener {
/*  16 */   protected JFrame nume = new JFrame("Numerical");
/*  17 */   protected JTable table = new JTable(new DefaultTableModel(new Object[] { "Limits", "Boundaries", "Midpoint", "Frequency", "%", "<cf", "%cf" }, false)); protected JScrollPane scrollPane; protected JPanel up; protected JPanel down; protected JPanel head; protected JPanel main; protected JButton graph; protected JButton back; protected JButton collapse;
/*     */   protected String title;
/*     */   protected String input;
/*     */   protected String point;
/*     */   protected double range;
/*     */   protected double compute;
/*  23 */   protected double deci = 0.1D; protected int sample; protected int k; protected int width;
/*  24 */   protected int coll = 0; protected int index; protected int type; protected int[] freq; protected int[] cf; protected double[] data; protected double[] cfPercent; protected double[] percent;
/*     */   protected double[] mid;
/*     */   protected double[] cl;
/*     */   protected double[] cb;
/*     */   protected boolean core = false;
/*  29 */   protected DecimalFormat df = new DecimalFormat("#.#");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Numerical() {
/*     */     do {
/*  36 */       this.title = JOptionPane.showInputDialog("Enter the title for the data set to be used:");
/*  37 */     } while (this.title == null);
/*     */     
/*     */     do {
/*  40 */       this.input = JOptionPane.showInputDialog("Enter the sample size:");
/*  41 */       if (this.input == null)
/*     */         continue;  try {
/*  43 */         this.sample = Integer.parseInt(this.input);
/*     */       }
/*  45 */       catch (NumberFormatException e) {
/*  46 */         JOptionPane.showMessageDialog(null, "Value must be an integer!");
/*  47 */         this.input = null;
/*     */       }
/*     */     
/*     */     }
/*  51 */     while (this.input == null || this.sample < 1);
/*     */     
/*  53 */     this.data = new double[this.sample];
/*  54 */     this.input = new String();
/*     */     
/*  56 */     for (i = this.sample; i > 0; i--) {
/*     */       do {
/*  58 */         this.input = JOptionPane.showInputDialog("Enter data (" + i + " left):");
/*  59 */         if (this.input == null)
/*     */           continue;  try {
/*  61 */           this.data[this.sample - i] = Double.parseDouble(this.input);
/*     */         }
/*  63 */         catch (NumberFormatException e) {
/*  64 */           JOptionPane.showMessageDialog(null, "Value must be a number!");
/*  65 */           this.input = null;
/*     */         }
/*     */       
/*  68 */       } while (this.input == null);
/*     */     } 
/*     */     
/*  71 */     Arrays.sort(this.data);
/*     */     
/*  73 */     this.range = this.data[this.sample - 1] - this.data[0];
/*  74 */     this.compute = Math.ceil(1.0D + 3.322D * Math.log10(this.sample));
/*  75 */     this.k = (int)this.compute;
/*  76 */     this.width = (int)Math.ceil(this.range / this.k);
/*     */ 
/*     */     
/*  79 */     this.cl = new double[this.k * 2];
/*  80 */     this.cl[0] = this.data[0];
/*  81 */     this.cl[1] = this.data[0] + (this.width - 1);
/*  82 */     for (i = 2; i < this.cl.length; i += 2) {
/*  83 */       this.cl[i] = this.cl[i - 2] + this.width;
/*  84 */       this.cl[i + 1] = this.cl[i - 1] + this.width;
/*     */     } 
/*     */ 
/*     */     
/*  88 */     this.mid = new double[this.k];
/*  89 */     for (i = 0, j = 0; i < this.k; i++) {
/*  90 */       this.mid[i] = (this.cl[j] + this.cl[j + 1]) / 2.0D;
/*  91 */       j += 2;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  96 */     this.point = String.valueOf(this.cl[0]);
/*  97 */     this.index = this.point.indexOf(".");
/*     */     
/*  99 */     if (this.point.length() - this.index + 1 == 1 && this.point.charAt(this.point.length() - 1) == '0') {
/* 100 */       this.index = 0;
/*     */     } else {
/*     */       
/* 103 */       this.index = this.point.length() - this.index + 1;
/*     */     } 
/*     */     
/* 106 */     for (i = 0; i < this.index; i++) {
/* 107 */       this.deci *= this.deci;
/*     */     }
/*     */     
/* 110 */     this.deci *= 5.0D;
/*     */     
/* 112 */     this.cb = new double[this.k * 2];
/* 113 */     for (i = 0; i < this.cb.length; i++) {
/* 114 */       if (i % 2 == 0) {
/* 115 */         this.cb[i] = this.cl[i] - this.deci;
/*     */       } else {
/*     */         
/* 118 */         this.cb[i] = this.cl[i] + this.deci;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 123 */     this.freq = new int[this.k];
/* 124 */     for (int i = 0, j = 0, l = 0; i < this.k; i++) {
/* 125 */       this.freq[i] = 0;
/* 126 */       for (; l < this.sample; l++) {
/* 127 */         if (this.data[l] <= this.cl[j + 1] && this.data[l] >= this.cl[j]) {
/* 128 */           this.freq[i] = this.freq[i] + 1;
/*     */         } else {
/*     */           
/* 131 */           j += 2;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 138 */     this.cf = new int[this.k];
/* 139 */     this.cf[0] = this.freq[0];
/* 140 */     for (i = 1; i < this.k; i++) {
/* 141 */       this.cf[i] = this.cf[i - 1] + this.freq[i];
/*     */     }
/*     */ 
/*     */     
/* 145 */     this.cfPercent = new double[this.k];
/* 146 */     this.cfPercent[0] = this.freq[0] / this.cf[this.k - 1] * 100.0D;
/* 147 */     System.out.println(this.cfPercent[0] + " lol " + (this.freq[0] / this.cf[this.k - 1]));
/* 148 */     for (i = 1; i < this.k; i++) {
/* 149 */       this.cfPercent[i] = this.freq[i] / this.cf[this.k - 1] * 100.0D + this.cfPercent[i - 1];
/*     */     }
/*     */ 
/*     */     
/* 153 */     this.percent = new double[this.k];
/* 154 */     for (int i = 0; i < this.k; i++) {
/* 155 */       this.percent[i] = this.freq[i] / this.cf[this.k - 1] * 100.0D;
/*     */     }
/*     */     
/* 158 */     this.main = new JPanel();
/* 159 */     this.main.setSize(800, 400);
/* 160 */     this.main.setLayout(new GridBagLayout());
/*     */     
/* 162 */     this.nume.setSize(800, 400);
/*     */     
/* 164 */     GridBagConstraints c = new GridBagConstraints();
/* 165 */     c.fill = 2;
/*     */     
/* 167 */     this.head = new JPanel(new BorderLayout());
/* 168 */     this.head.setSize(800, 75);
/* 169 */     c.weightx = 0.5D;
/* 170 */     c.weighty = 2.0D;
/* 171 */     c.gridx = 0;
/* 172 */     c.gridy = 0;
/* 173 */     c.ipady = 0;
/* 174 */     this.main.add(this.head, c);
/*     */     
/* 176 */     JLabel headerTitle = new JLabel("Table 1. " + this.title);
/* 177 */     this.head.add(headerTitle);
/*     */     
/* 179 */     c.fill = 2;
/* 180 */     this.up = new JPanel(new BorderLayout());
/* 181 */     this.up.setSize(800, 250);
/* 182 */     c.ipady = 250;
/* 183 */     c.gridx = 0;
/* 184 */     c.gridy = 1;
/* 185 */     c.weightx = 0.0D;
/* 186 */     this.main.add(this.up, c);
/*     */     
/* 188 */     c.fill = 2;
/* 189 */     this.down = new JPanel(new GridLayout(true, 3));
/* 190 */     this.down.setSize(800, 75);
/* 191 */     c.ipady = 0;
/* 192 */     c.gridx = 0;
/* 193 */     c.gridy = 2;
/* 194 */     c.insets = new Insets(5, 5, 5, 5);
/* 195 */     this.main.add(this.down, c);
/*     */     
/* 197 */     this.back = new JButton("Restart");
/* 198 */     this.graph = new JButton("Show Graph");
/* 199 */     this.collapse = new JButton("Collapse/Expand");
/*     */ 
/*     */     
/* 202 */     this.back.addActionListener(this);
/* 203 */     this.graph.addActionListener(this);
/* 204 */     this.collapse.addActionListener(this);
/*     */     
/* 206 */     this.down.add(this.graph);
/* 207 */     this.down.add(this.collapse);
/* 208 */     this.down.add(this.back);
/*     */     
/* 210 */     this.scrollPane = new JScrollPane(this.table, 20, 31);
/* 211 */     this.scrollPane.setSize(700, 250);
/* 212 */     this.up.add(this.scrollPane);
/*     */     
/* 214 */     DefaultTableModel model = (DefaultTableModel)this.table.getModel();
/*     */     
/* 216 */     for (int i = 0, j = 0; i < this.k; i++) {
/* 217 */       Vector row = new Vector();
/* 218 */       if (this.index > 0) {
/* 219 */         if (this.index == 1) {
/* 220 */           this.df = new DecimalFormat("#.##");
/*     */         }
/* 222 */         else if (this.index == 2) {
/* 223 */           this.df = new DecimalFormat("#.###");
/*     */         } 
/*     */       }
/* 226 */       row.add(String.format(String.valueOf(this.df.format(this.cl[j])) + " - " + String.valueOf(this.df.format(this.cl[j + 1])), new Object[0]));
/* 227 */       row.add(String.format(String.valueOf(this.df.format(this.cb[j])) + " - " + String.valueOf(this.df.format(this.cb[j + 1])), new Object[0]));
/* 228 */       row.add(String.valueOf(this.df.format(this.mid[i])));
/* 229 */       row.add(String.valueOf(this.freq[i]));
/* 230 */       row.add(String.valueOf(this.percent[i]));
/* 231 */       row.add(String.valueOf(this.cf[i]));
/* 232 */       row.add(String.valueOf(this.cfPercent[i]));
/* 233 */       model.addRow(row);
/* 234 */       j += 2;
/*     */     } 
/* 236 */     Vector row = new Vector();
/* 237 */     row.add("");
/* 238 */     row.add("");
/* 239 */     row.add("");
/* 240 */     row.add(String.valueOf("total: " + this.cf[this.k - 1]));
/* 241 */     row.add("total: 100.0%");
/* 242 */     model.addRow(row);
/*     */     
/* 244 */     this.nume.add(this.main);
/* 245 */     this.nume.setResizable(false);
/* 246 */     this.nume.setLocationRelativeTo(null);
/* 247 */     this.nume.setVisible(true);
/* 248 */     this.nume.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent we) {
/* 251 */             Numerical.this.nume.setDefaultCloseOperation(2);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/* 259 */     if (e.getSource() == this.graph) {
/* 260 */       final BarChart chart = new BarChart(this.title, this.freq, this.mid, this.core, this.coll, this.df);
/* 261 */       chart.pack();
/* 262 */       RefineryUtilities.centerFrameOnScreen(chart);
/* 263 */       chart.setVisible(true);
/* 264 */       chart.addWindowListener(new WindowAdapter() {
/*     */             public void windowClosing(WindowEvent we) {
/* 266 */               chart.dispose();
/*     */             }
/*     */           });
/*     */ 
/*     */     
/*     */     }
/* 272 */     else if (e.getSource() == this.collapse) {
/* 273 */       DefaultTableModel model = (DefaultTableModel)this.table.getModel();
/* 274 */       this.input = new String();
/*     */       
/*     */       do {
/* 277 */         this.input = JOptionPane.showInputDialog("Enter < 1 > for first row or < 2 > for last row:");
/* 278 */         if (this.input == null)
/*     */           continue;  try {
/* 280 */           if (this.core) {
/* 281 */             this.core = false;
/*     */           } else {
/*     */             
/* 284 */             this.core = true;
/*     */           } 
/* 286 */           this.coll = Integer.parseInt(this.input);
/*     */         }
/* 288 */         catch (NumberFormatException er) {
/* 289 */           JOptionPane.showMessageDialog(null, "Value must be an integer!");
/* 290 */           this.input = null;
/*     */         }
/*     */       
/* 293 */       } while (this.input == null);
/*     */       
/* 295 */       if (this.core) {
/* 296 */         if (this.coll == 1) {
/* 297 */           model.setValueAt("* - " + String.valueOf(this.cl[1]), 0, 0);
/* 298 */           model.setValueAt("* - " + String.valueOf(this.cb[1]), 0, 1);
/* 299 */           model.setValueAt("N/A", 0, 2);
/*     */         } else {
/*     */           
/* 302 */           model.setValueAt(String.valueOf(this.cl[this.k * 2 - 2] + " - *"), this.k - 1, 0);
/* 303 */           model.setValueAt(String.valueOf(this.cb[this.k * 2 - 2] + " - *"), this.k - 1, 1);
/* 304 */           model.setValueAt("N/A", this.k - 1, 2);
/*     */         }
/*     */       
/*     */       }
/* 308 */       else if (this.coll == 1) {
/* 309 */         model.setValueAt(String.valueOf(this.cl[0]) + " - " + String.valueOf(this.cl[1]), 0, 0);
/* 310 */         model.setValueAt(String.valueOf(this.cb[0]) + " - " + String.valueOf(this.cl[1]), 0, 1);
/* 311 */         model.setValueAt(String.valueOf(this.mid[0]), 0, 2);
/*     */       } else {
/*     */         
/* 314 */         model.setValueAt(String.valueOf(this.cl[this.k * 2 - 2] + " - " + String.valueOf(this.cl[this.k * 2 - 1])), this.k - 1, 0);
/* 315 */         model.setValueAt(String.valueOf(this.cb[this.k * 2 - 2] + " - " + String.valueOf(this.cb[this.k * 2 - 1])), this.k - 1, 1);
/* 316 */         model.setValueAt(String.valueOf(this.mid[this.k - 1]), this.k - 1, 2);
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 321 */     else if (e.getSource() == this.back) {
/* 322 */       this.nume.dispose();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab2/Numerical.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */