/*     */ package lab3;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class Ungrouped extends JFrame implements ActionListener {
/*  17 */   JFrame ugr = new JFrame("Ungrouped Data");
/*     */   JLabel headerTitle;
/*  19 */   JTextArea result = new JTextArea(); JTextArea desc = new JTextArea(); JPanel up; JPanel down; JPanel mid; JPanel frem; JScrollPane scroll;
/*     */   JScrollPane res;
/*     */   JScrollPane descript;
/*  22 */   JTable table = new JTable(new DefaultTableModel(new Object[] { "Index", "Data" }, false));
/*  23 */   DefaultTableModel model = (DefaultTableModel)this.table.getModel(); JButton edit; JButton mn; JButton mdn; JButton md; JButton main;
/*     */   JButton descri;
/*  25 */   String description = ""; String input; String mowd = ""; String title = ""; String out;
/*  26 */   int choice = 0, index = 0;
/*  27 */   int size = 0;
/*  28 */   double change = 0.0D;
/*     */   
/*     */   Double[] arr;
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/*  33 */     if (e.getSource() == this.mn) {
/*  34 */       this.out = "";
/*  35 */       double mean = 0.0D, variance = 0.0D, sdeviation = 0.0D;
/*  36 */       mean = getAverage(this.arr);
/*  37 */       variance = getVariance(this.arr, mean);
/*  38 */       sdeviation = Math.sqrt(variance);
/*  39 */       this.out = String.format("Mean: %.2f;\nVariance: %.2f;\nStandard Deviation: %.2f", new Object[] { Double.valueOf(mean), Double.valueOf(variance), Double.valueOf(sdeviation) });
/*  40 */       this.result.setText(this.out);
/*     */     }
/*  42 */     else if (e.getSource() == this.mdn) {
/*  43 */       this.out = "";
/*  44 */       double median = 0.0D, range = 0.0D;
/*  45 */       median = getMedian(this.arr);
/*  46 */       range = getRange(this.arr);
/*  47 */       this.out = String.format("Median: %.2f;\nRange: %.2f", new Object[] { Double.valueOf(median), Double.valueOf(range) });
/*  48 */       this.result.setText(this.out);
/*     */     }
/*  50 */     else if (e.getSource() == this.md) {
/*  51 */       int count = 0;
/*  52 */       count = getPrintMode(this.arr);
/*  53 */       this.result.setText("Mode(s): " + this.mowd);
/*  54 */       if (count == 0) {
/*  55 */         this.result.append(" No Mode...");
/*     */       
/*     */       }
/*  58 */       else if (count == 1) {
/*  59 */         this.result.append(" Unimodal...");
/*     */       }
/*  61 */       else if (count == 2) {
/*  62 */         this.result.append(" Bimodal...");
/*     */       }
/*  64 */       else if (count >= 3) {
/*  65 */         this.result.append(" Multimodal...");
/*     */       }
/*     */     
/*  68 */     } else if (e.getSource() == this.edit) {
/*  69 */       this.input = new String();
/*     */       do {
/*  71 */         this.input = JOptionPane.showInputDialog("Enter the index:");
/*  72 */         if (this.input == null)
/*     */           continue;  try {
/*  74 */           this.index = Integer.parseInt(this.input);
/*  75 */         } catch (NumberFormatException err) {
/*  76 */           JOptionPane.showMessageDialog(null, "Value must be an integer!");
/*  77 */           this.input = null;
/*     */         }
/*     */       
/*     */       }
/*  81 */       while (this.input == null || this.index < 1);
/*     */       
/*  83 */       this.input = new String();
/*     */       do {
/*  85 */         this.input = JOptionPane.showInputDialog("Enter new data:");
/*  86 */         if (this.input == null)
/*     */           continue;  try {
/*  88 */           this.change = Double.parseDouble(this.input);
/*  89 */         } catch (NumberFormatException err) {
/*  90 */           JOptionPane.showMessageDialog(null, "Value must be a number!");
/*  91 */           this.input = null;
/*     */         }
/*     */       
/*     */       }
/*  95 */       while (this.input == null || this.change < 0.0D);
/*     */       
/*  97 */       this.model.setValueAt(String.valueOf(this.change), this.index - 1, 1);
/*  98 */       this.arr[this.index - 1] = Double.valueOf(this.change);
/*     */     
/*     */     }
/* 101 */     else if (e.getSource() == this.main) {
/* 102 */       this.ugr.dispose();
/*     */     
/*     */     }
/* 105 */     else if (e.getSource() == this.descri) {
/* 106 */       this.description = JOptionPane.showInputDialog("Enter interpretation of results:");
/* 107 */       this.desc.setText(this.description);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Ungrouped() {
/* 113 */     this.frem = new JPanel(new GridBagLayout());
/* 114 */     this.ugr.setSize(400, 500);
/* 115 */     this.ugr.setResizable(false);
/* 116 */     this.ugr.setLayout(new BorderLayout());
/* 117 */     this.ugr.setLocationRelativeTo(null);
/* 118 */     this.ugr.addWindowListener(new WindowAdapter() {
/*     */           public void windowClosing(WindowEvent we) {
/* 120 */             Ungrouped.this.ugr.dispose();
/*     */           }
/*     */         });
/*     */     
/* 124 */     this.ugr.setVisible(true);
/* 125 */     this.frem.setSize(400, 400);
/*     */     
/* 127 */     this.result.setLineWrap(true);
/* 128 */     this.result.setEditable(false);
/* 129 */     this.desc.setLineWrap(true);
/* 130 */     this.desc.setEditable(false);
/* 131 */     this.result.setSize(400, 50);
/* 132 */     this.headerTitle = new JLabel("Table 1. " + this.title);
/*     */     
/* 134 */     this.ugr.add(this.headerTitle);
/*     */     
/* 136 */     this.scroll = new JScrollPane(this.table, 20, 31);
/* 137 */     this.res = new JScrollPane(this.result, 20, 31);
/* 138 */     this.descript = new JScrollPane(this.desc, 20, 31);
/*     */     
/* 140 */     GridBagConstraints c = new GridBagConstraints();
/* 141 */     c.fill = 2;
/*     */     
/* 143 */     this.mid = new JPanel(new BorderLayout());
/* 144 */     this.mid.setSize(400, 50);
/* 145 */     this.mid.add(this.headerTitle);
/* 146 */     c.ipady = 10;
/* 147 */     c.gridx = 0;
/* 148 */     c.gridy = 0;
/* 149 */     c.weightx = 0.5D;
/* 150 */     this.frem.add(this.mid, c);
/*     */     
/* 152 */     this.up = new JPanel(new BorderLayout());
/* 153 */     this.up.setSize(400, 250);
/* 154 */     this.up.add(this.scroll);
/* 155 */     c.weightx = 0.0D;
/* 156 */     c.weighty = 2.0D;
/* 157 */     c.gridx = 0;
/* 158 */     c.gridy = 1;
/* 159 */     c.ipady = 250;
/* 160 */     this.frem.add(this.up, c);
/*     */     
/* 162 */     this.edit = new JButton("Edit");
/* 163 */     this.mn = new JButton("Mean");
/* 164 */     this.mdn = new JButton("Median");
/* 165 */     this.md = new JButton("Mode");
/* 166 */     this.main = new JButton("Menu");
/* 167 */     this.descri = new JButton("Interpretation");
/*     */     
/* 169 */     this.edit.addActionListener(this);
/* 170 */     this.mn.addActionListener(this);
/* 171 */     this.mdn.addActionListener(this);
/* 172 */     this.md.addActionListener(this);
/* 173 */     this.main.addActionListener(this);
/* 174 */     this.descri.addActionListener(this);
/*     */     
/* 176 */     c.fill = 2;
/* 177 */     this.down = new JPanel(new GridLayout(3, 3));
/* 178 */     this.down.setSize(400, 100);
/* 179 */     this.down.add(this.res); this.down.add(this.edit); this.down.add(this.main); this.down.add(this.mn); this.down.add(this.mdn); this.down.add(this.md); this.down.add(this.descri); this.down.add(this.descript);
/* 180 */     c.ipady = 75;
/* 181 */     c.gridx = 0;
/* 182 */     c.gridy = 2;
/* 183 */     c.weightx = 0.0D;
/* 184 */     c.insets = new Insets(true, true, true, true);
/* 185 */     this.frem.add(this.down, c);
/*     */     
/* 187 */     this.ugr.add(this.frem);
/*     */     
/*     */     do {
/* 190 */       this.title = JOptionPane.showInputDialog("Enter the title for the data set to be used:");
/* 191 */     } while (this.title == null);
/*     */     
/* 193 */     this.headerTitle.setText("Table 1." + this.title);
/*     */     
/*     */     do {
/* 196 */       this.input = JOptionPane.showInputDialog("Enter the sample size:");
/* 197 */       if (this.input == null)
/*     */         continue;  try {
/* 199 */         this.size = Integer.parseInt(this.input);
/* 200 */       } catch (NumberFormatException e) {
/* 201 */         JOptionPane.showMessageDialog(null, "Value must be an integer!");
/* 202 */         this.input = null;
/*     */       }
/*     */     
/*     */     }
/* 206 */     while (this.input == null || this.size < 1);
/*     */     
/* 208 */     this.arr = new Double[this.size];
/* 209 */     this.input = new String();
/*     */     
/* 211 */     for (i = this.size; i > 0; i--) {
/*     */       do {
/* 213 */         this.input = JOptionPane.showInputDialog("Enter data (" + i + " left):");
/* 214 */         if (this.input == null)
/*     */           continue;  try {
/* 216 */           this.arr[this.size - i] = Double.valueOf(Double.parseDouble(this.input));
/* 217 */         } catch (NumberFormatException e) {
/* 218 */           JOptionPane.showMessageDialog(null, "Value must be a number!");
/* 219 */           this.input = null;
/*     */         }
/*     */       
/* 222 */       } while (this.input == null);
/*     */     } 
/*     */     
/* 225 */     for (int i = 0; i < this.size; i++) {
/* 226 */       Vector row = new Vector();
/* 227 */       row.add(String.valueOf(i + 1));
/* 228 */       row.add(String.valueOf(this.arr[i]));
/* 229 */       this.model.addRow(row);
/*     */     } 
/*     */     
/* 232 */     Arrays.sort(this.arr);
/*     */   }
/*     */ 
/*     */   
/*     */   public static double getAverage(Double[] arr) {
/* 237 */     ave = 0.0D; double sum = 0.0D;
/*     */     
/* 239 */     for (int i = 0; i < arr.length; i++) {
/* 240 */       sum += arr[i].doubleValue();
/*     */     }
/* 242 */     return sum / arr.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double summation(Double[] arr) {
/* 248 */     double sum = 0.0D; var = 0.0D;
/* 249 */     for (int i = 0; i < arr.length; i++) {
/* 250 */       sum += arr[i].doubleValue();
/*     */     }
/*     */     
/* 253 */     return sum / (arr.length - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getVariance(Double[] arr, double mean) {
/* 259 */     variance = 0.0D;
/* 260 */     Double[] samples = new Double[arr.length];
/*     */     
/* 262 */     for (int i = 0; i < arr.length; i++) {
/* 263 */       samples[i] = Double.valueOf((arr[i].doubleValue() - mean) * (arr[i].doubleValue() - mean));
/*     */     }
/*     */     
/* 266 */     return summation(samples);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getMedian(Double[] arr) {
/* 274 */     double median = 0.0D;
/*     */     
/* 276 */     Arrays.sort(arr);
/*     */     
/* 278 */     for (int i = 0; i < arr.length; i++) {
/* 279 */       System.out.println(arr[i]);
/*     */     }
/*     */     
/* 282 */     if (arr.length % 2 == 1) {
/* 283 */       median = arr[(int)Math.floor((arr.length / 2))].doubleValue();
/*     */     } else {
/* 285 */       median = (arr[arr.length / 2].doubleValue() + arr[arr.length / 2 + 1].doubleValue()) / 2.0D - 1.0D;
/*     */     } 
/*     */     
/* 288 */     return median;
/*     */   }
/*     */   
/*     */   public static double getRange(Double[] arr) {
/* 292 */     range = 0.0D;
/*     */     
/* 294 */     return arr[arr.length - 1].doubleValue() - arr[0].doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPrintMode(Double[] arr) {
/* 300 */     this.mowd = "";
/* 301 */     int count = 0, greatest = 0;
/*     */     
/* 303 */     LinkedList<Mode> modes = new LinkedList<Mode>();
/* 304 */     ListIterator<Mode> iterator = modes.listIterator();
/* 305 */     modes.add(new Mode(arr[0].doubleValue()));
/*     */     
/* 307 */     for (i = 1; i < arr.length; i++) {
/* 308 */       if (arr[i - 1].doubleValue() != arr[i].doubleValue())
/*     */       {
/*     */         
/* 311 */         modes.add(new Mode(arr[i].doubleValue()));
/*     */       }
/*     */     } 
/*     */     
/* 315 */     for (i = 0; i < modes.size(); i++) {
/* 316 */       for (int j = 0; j < arr.length; j++) {
/* 317 */         if (((Mode)modes.get(i)).value == arr[j].doubleValue()) {
/* 318 */           ((Mode)modes.get(i)).count++;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 323 */     greatest = ((Mode)modes.get(0)).count;
/* 324 */     count = 1;
/*     */     
/* 326 */     for (i = 1; i < modes.size(); i++) {
/* 327 */       if (greatest < ((Mode)modes.get(i)).count) {
/* 328 */         greatest = ((Mode)modes.get(i)).count;
/* 329 */         count = 1;
/* 330 */       } else if (greatest == ((Mode)modes.get(i)).count) {
/* 331 */         count++;
/* 332 */       } else if (greatest > ((Mode)modes.get(i)).count) {
/*     */       
/*     */       } 
/*     */     } 
/*     */     
/* 337 */     if (count == modes.size()) {
/* 338 */       count = 0;
/*     */     }
/*     */     
/* 341 */     for (int i = 0; i < modes.size() && count != 0; i++) {
/* 342 */       if (((Mode)modes.get(i)).count == greatest) {
/* 343 */         this.mowd += String.valueOf(((Mode)modes.get(i)).value + " : " + ((Mode)modes.get(i)).count + "; ");
/*     */       }
/*     */     } 
/*     */     
/* 347 */     return count;
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab3/Ungrouped.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */