/*     */ package lab3;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.Stack;
/*     */ import java.util.Vector;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ 
/*     */ public class Grouped extends JFrame implements ActionListener {
/*  18 */   JFrame gr = new JFrame("Grouped Data");
/*  19 */   JLabel headerTitle = new JLabel("");
/*  20 */   JTextArea result = new JTextArea(); JTextArea desc = new JTextArea(); JPanel up; JPanel down; JPanel mid; JPanel frem; JScrollPane scroll;
/*     */   JScrollPane res;
/*     */   JScrollPane descript;
/*  23 */   JTable table = new JTable(new DefaultTableModel(new Object[] { "Index", "CL", "Mid", "Freq", "FX", "FXi^2" }, false));
/*  24 */   DefaultTableModel model = (DefaultTableModel)this.table.getModel(); JButton edit; JButton mn; JButton mdn; JButton md; JButton main;
/*     */   JButton descri;
/*  26 */   String description = ""; String input; String mowd = ""; String title = ""; String out;
/*  27 */   int choice = 0, index = 0, number = 0, openendedchoice = 0;
/*  28 */   int size = 0; int openended = 0; int type = 0;
/*     */   boolean open = false;
/*  30 */   double change = 0.0D;
/*     */   
/*     */   Interval[] array;
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/*  35 */     if (e.getSource() == this.mn) {
/*  36 */       this.out = "";
/*  37 */       double mean = 0.0D, variance = 0.0D, sdeviation = 0.0D;
/*  38 */       this.out = String.format("Mean: %.2f;\nStandard Deviation: %.2f", new Object[] { Double.valueOf(computeMean(this.array)), Double.valueOf(standardDeviation(this.array)) });
/*  39 */       this.result.setText(this.out);
/*     */     }
/*  41 */     else if (e.getSource() == this.mdn) {
/*  42 */       this.result.setText("Median not computed.");
/*     */     }
/*  44 */     else if (e.getSource() == this.md) {
/*  45 */       this.result.setText(calculateMode(this.array));
/*     */     }
/*  47 */     else if (e.getSource() == this.edit) {
/*  48 */       int intervalnum = 0;
/*  49 */       double newlcl = 0.0D;
/*  50 */       double newucl = 0.0D;
/*  51 */       int newfreq = 0;
/*  52 */       double mid_sqr = 0.0D;
/*     */       
/*  54 */       this.input = new String();
/*     */       do {
/*  56 */         this.input = JOptionPane.showInputDialog("Enter the index:");
/*  57 */         if (this.input == null)
/*     */           continue;  try {
/*  59 */           intervalnum = Integer.parseInt(this.input);
/*  60 */         } catch (NumberFormatException err) {
/*  61 */           JOptionPane.showMessageDialog(null, "Value must be an integer!");
/*  62 */           this.input = null;
/*     */         }
/*     */       
/*  65 */       } while (this.input == null || intervalnum < 1);
/*     */       
/*  67 */       double prev_ucl = 0.0D;
/*  68 */       double next_lcl = 0.0D;
/*     */       
/*  70 */       if (intervalnum > 1 && intervalnum < this.number) {
/*  71 */         Interval prev = this.array[intervalnum - 2];
/*  72 */         Interval next = this.array[intervalnum];
/*  73 */         if (this.type == 2) {
/*  74 */           prev_ucl = ((Double)prev.ucl).doubleValue();
/*  75 */           next_lcl = ((Double)next.lcl).doubleValue();
/*     */         } else {
/*     */           
/*  78 */           prev_ucl = ((Integer)prev.ucl).intValue();
/*  79 */           next_lcl = ((Integer)next.lcl).intValue();
/*     */         }
/*     */       
/*  82 */       } else if (intervalnum == 1) {
/*  83 */         Interval next = this.array[intervalnum];
/*  84 */         if (this.type == 2) {
/*  85 */           next_lcl = ((Double)next.lcl).doubleValue();
/*     */         } else {
/*     */           
/*  88 */           next_lcl = ((Integer)next.lcl).intValue();
/*     */         }
/*     */       
/*  91 */       } else if (intervalnum == this.number) {
/*  92 */         Interval prev = this.array[intervalnum - 2];
/*  93 */         if (this.type == 2) {
/*  94 */           prev_ucl = ((Double)prev.ucl).doubleValue();
/*     */         } else {
/*     */           
/*  97 */           prev_ucl = ((Integer)prev.ucl).intValue();
/*     */         } 
/*     */       } 
/*     */       
/* 101 */       System.out.println();
/* 102 */       System.out.print("Please enter the new value for the lower class limit: ");
/*     */       
/* 104 */       this.input = new String();
/* 105 */       if (this.type == 2) {
/*     */         do {
/* 107 */           this.input = JOptionPane.showInputDialog("For interval number " + intervalnum + "\n New Lower class limit:");
/* 108 */           if (this.input == null)
/*     */             continue;  try {
/* 110 */             if (intervalnum > 1 && intervalnum < this.number) {
/*     */               while (true) {
/* 112 */                 Pattern pattern = Pattern.compile("[0-9]*\\.[0-9]+");
/* 113 */                 Matcher matcher = pattern.matcher(this.input);
/* 114 */                 if (matcher.matches()) {
/* 115 */                   newlcl = Double.parseDouble(this.input);
/* 116 */                   if (newlcl <= prev_ucl || newlcl >= next_lcl) {
/* 117 */                     this.input = null;
/*     */                   }
/*     */                   
/*     */                   break;
/*     */                 } 
/*     */                 
/* 123 */                 this.input = "";
/* 124 */                 newlcl = Double.parseDouble(this.input);
/*     */               }
/*     */             
/* 127 */             } else if (intervalnum == 1) {
/*     */               while (true) {
/* 129 */                 Pattern pattern = Pattern.compile("[0-9]*\\.[0-9]+");
/* 130 */                 Matcher matcher = pattern.matcher(this.input);
/* 131 */                 if (matcher.matches()) {
/* 132 */                   newlcl = Double.parseDouble(this.input);
/* 133 */                   if (newlcl >= next_lcl) {
/* 134 */                     this.input = null;
/*     */                   }
/*     */                   
/*     */                   break;
/*     */                 } 
/*     */                 
/* 140 */                 this.input = "";
/* 141 */                 newlcl = Double.parseDouble(this.input);
/*     */               }
/*     */             
/* 144 */             } else if (intervalnum == this.number) {
/*     */               while (true) {
/* 146 */                 Pattern pattern = Pattern.compile("[0-9]*\\.[0-9]+");
/* 147 */                 Matcher matcher = pattern.matcher(this.input);
/* 148 */                 if (matcher.matches()) {
/* 149 */                   newlcl = Double.parseDouble(this.input);
/* 150 */                   if (newlcl <= prev_ucl) {
/* 151 */                     this.input = null;
/*     */                   }
/*     */                   
/*     */                   break;
/*     */                 } 
/*     */                 
/* 157 */                 this.input = "";
/* 158 */                 newlcl = Double.parseDouble(this.input);
/*     */               }
/*     */             
/*     */             }
/*     */           
/* 163 */           } catch (NumberFormatException err) {
/* 164 */             JOptionPane.showMessageDialog(null, "Value must be a number!");
/* 165 */             this.input = null;
/*     */           }
/*     */         
/*     */         }
/* 169 */         while (this.input == null || newlcl < 0.0D);
/*     */         
/* 171 */         this.input = new String();
/*     */         
/*     */         do {
/* 174 */           this.input = JOptionPane.showInputDialog("For interval number " + intervalnum + "\n New Upper class limit:");
/* 175 */           if (this.input == null)
/*     */             continue;  try {
/* 177 */             if (intervalnum >= 1 && intervalnum < this.number) {
/*     */               while (true) {
/* 179 */                 Pattern pattern = Pattern.compile("[0-9]*\\.[0-9]+");
/* 180 */                 Matcher matcher = pattern.matcher(this.input);
/* 181 */                 if (matcher.matches()) {
/* 182 */                   newucl = Double.parseDouble(this.input);
/* 183 */                   if (newucl <= newlcl || newucl >= next_lcl) {
/* 184 */                     this.input = null;
/*     */                   }
/*     */                   
/*     */                   break;
/*     */                 } 
/*     */                 
/* 190 */                 this.input = "";
/* 191 */                 newucl = Double.parseDouble(this.input);
/*     */               }
/*     */             
/* 194 */             } else if (intervalnum == this.number) {
/*     */               while (true) {
/* 196 */                 Pattern pattern = Pattern.compile("[0-9]*\\.[0-9]+");
/* 197 */                 Matcher matcher = pattern.matcher(this.input);
/* 198 */                 if (matcher.matches()) {
/* 199 */                   newucl = Double.parseDouble(this.input);
/* 200 */                   if (newucl <= newlcl) {
/* 201 */                     this.input = null;
/*     */                   }
/*     */                   
/*     */                   break;
/*     */                 } 
/*     */                 
/* 207 */                 this.input = "";
/* 208 */                 newucl = Double.parseDouble(this.input);
/*     */               }
/*     */             
/*     */             } 
/* 212 */           } catch (NumberFormatException err) {
/* 213 */             JOptionPane.showMessageDialog(null, "Value must contain a decimal!");
/* 214 */             this.input = null;
/*     */           }
/*     */         
/*     */         }
/* 218 */         while (this.input == null || newucl < 0.0D);
/*     */       } else {
/*     */         
/*     */         do {
/* 222 */           this.input = JOptionPane.showInputDialog("For interval number " + intervalnum + "\n New Lower class limit:");
/* 223 */           if (this.input == null)
/*     */             continue;  try {
/* 225 */             if (intervalnum > 1 && intervalnum < this.number)
/*     */             {
/* 227 */               newlcl = Integer.parseInt(this.input);
/* 228 */               if (newlcl <= prev_ucl || newlcl >= next_lcl) {
/* 229 */                 this.input = null;
/*     */ 
/*     */               
/*     */               }
/*     */             
/*     */             }
/* 235 */             else if (intervalnum == 1)
/*     */             {
/* 237 */               newlcl = Integer.parseInt(this.input);
/* 238 */               if (newlcl >= next_lcl) {
/* 239 */                 this.input = null;
/*     */ 
/*     */               
/*     */               }
/*     */             
/*     */             }
/* 245 */             else if (intervalnum == this.number)
/*     */             {
/* 247 */               newlcl = Integer.parseInt(this.input);
/* 248 */               if (newlcl <= prev_ucl) {
/* 249 */                 this.input = null;
/*     */               
/*     */               }
/*     */             
/*     */             }
/*     */ 
/*     */           
/*     */           }
/* 257 */           catch (NumberFormatException err) {
/* 258 */             JOptionPane.showMessageDialog(null, "Value must be an integer!");
/* 259 */             this.input = null;
/*     */           }
/*     */         
/*     */         }
/* 263 */         while (this.input == null || (int)newlcl < 0);
/*     */         
/* 265 */         this.input = new String();
/*     */         
/*     */         do {
/* 268 */           this.input = JOptionPane.showInputDialog("For interval number " + intervalnum + "\n New Upper class limit:");
/* 269 */           if (this.input == null)
/*     */             continue;  try {
/* 271 */             if (intervalnum >= 1 && intervalnum < this.number)
/*     */             {
/* 273 */               newucl = Integer.parseInt(this.input);
/* 274 */               if (newucl <= newlcl || newucl >= next_lcl) {
/* 275 */                 this.input = null;
/*     */ 
/*     */               
/*     */               }
/*     */             
/*     */             }
/* 281 */             else if (intervalnum == this.number)
/*     */             {
/* 283 */               newucl = Integer.parseInt(this.input);
/* 284 */               if (newucl <= newlcl) {
/* 285 */                 this.input = null;
/*     */               
/*     */               }
/*     */             
/*     */             }
/*     */ 
/*     */           
/*     */           }
/* 293 */           catch (NumberFormatException err) {
/* 294 */             JOptionPane.showMessageDialog(null, "Value must be an integer!");
/* 295 */             this.input = null;
/*     */           }
/*     */         
/*     */         }
/* 299 */         while (this.input == null || (int)newucl < 0);
/*     */       } 
/*     */       
/* 302 */       this.input = new String();
/*     */       do {
/* 304 */         this.input = JOptionPane.showInputDialog("For interval number " + intervalnum + "\n New Frequency:");
/* 305 */         if (this.input == null)
/*     */           continue;  try {
/* 307 */           newfreq = Integer.parseInt(this.input);
/* 308 */         } catch (NumberFormatException err) {
/* 309 */           JOptionPane.showMessageDialog(null, "Value must be an integer!");
/* 310 */           this.input = null;
/*     */         }
/*     */       
/* 313 */       } while (this.input == null || newfreq < 1);
/*     */       
/* 315 */       (this.array[intervalnum - 1]).lcl = Double.valueOf(newlcl);
/* 316 */       (this.array[intervalnum - 1]).ucl = Double.valueOf(newucl);
/* 317 */       (this.array[intervalnum - 1]).midpoint = (newlcl + newucl) / 2.0D;
/* 318 */       (this.array[intervalnum - 1]).frequency = newfreq;
/* 319 */       (this.array[intervalnum - 1]).crossprod = (this.array[intervalnum - 1]).midpoint * newfreq;
/* 320 */       mid_sqr = (this.array[intervalnum - 1]).midpoint * (this.array[intervalnum - 1]).midpoint;
/* 321 */       (this.array[intervalnum - 1]).crossprod_sqr = mid_sqr * newfreq;
/*     */       
/* 323 */       this.model.setValueAt(String.valueOf(newlcl + " - " + newucl), intervalnum - 1, 1);
/* 324 */       this.model.setValueAt(String.format("%.2f", new Object[] { Double.valueOf((this.array[intervalnum - 1]).midpoint) }), intervalnum - 1, 2);
/* 325 */       this.model.setValueAt(String.valueOf((this.array[intervalnum - 1]).frequency), intervalnum - 1, 3);
/* 326 */       this.model.setValueAt(String.format("%.2f", new Object[] { Double.valueOf((this.array[intervalnum - 1]).crossprod) }), intervalnum - 1, 4);
/* 327 */       this.model.setValueAt(String.format("%.2f", new Object[] { Double.valueOf((this.array[intervalnum - 1]).crossprod_sqr) }), intervalnum - 1, 5);
/* 328 */       this.model.setValueAt(String.valueOf(totalFreq(this.array)), this.number, 3);
/* 329 */       this.model.setValueAt(String.format("%.2f", new Object[] { Double.valueOf(totalCrosProd(this.array)) }), this.number, 4);
/* 330 */       this.model.setValueAt(String.format("%.2f", new Object[] { Double.valueOf(totalCrosProdSqr(this.array)) }), this.number, 5);
/*     */     
/*     */     }
/* 333 */     else if (e.getSource() == this.main) {
/* 334 */       this.gr.dispose();
/*     */ 
/*     */     
/*     */     }
/* 338 */     else if (e.getSource() == this.descri) {
/* 339 */       this.description = JOptionPane.showInputDialog("Enter interpretation of results:");
/* 340 */       this.desc.setText(this.description);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Grouped() {
/* 347 */     this.frem = new JPanel(new GridBagLayout());
/* 348 */     this.gr.setSize(600, 500);
/* 349 */     this.gr.setResizable(false);
/* 350 */     this.gr.setLayout(new BorderLayout());
/* 351 */     this.gr.setLocationRelativeTo(null);
/* 352 */     this.gr.addWindowListener(new WindowAdapter() {
/*     */           public void windowClosing(WindowEvent we) {
/* 354 */             Grouped.this.gr.dispose();
/*     */           }
/*     */         });
/*     */     
/* 358 */     this.frem.setSize(600, 500);
/*     */     
/* 360 */     this.result.setLineWrap(true);
/* 361 */     this.result.setEditable(false);
/* 362 */     this.desc.setLineWrap(true);
/* 363 */     this.desc.setEditable(false);
/*     */     
/* 365 */     this.res = new JScrollPane(this.result, 20, 31);
/* 366 */     this.scroll = new JScrollPane(this.table, 20, 30);
/* 367 */     this.descript = new JScrollPane(this.desc, 20, 31);
/*     */     
/* 369 */     GridBagConstraints c = new GridBagConstraints();
/* 370 */     c.fill = 2;
/*     */     
/* 372 */     this.mid = new JPanel(new BorderLayout());
/* 373 */     this.mid.setSize(400, 100);
/* 374 */     this.mid.add(this.headerTitle);
/* 375 */     c.ipady = 10;
/* 376 */     c.gridx = 0;
/* 377 */     c.gridy = 0;
/* 378 */     c.weightx = 0.0D;
/* 379 */     this.frem.add(this.mid, c);
/*     */     
/* 381 */     this.up = new JPanel(new BorderLayout());
/* 382 */     this.up.setSize(600, 300);
/* 383 */     this.up.add(this.scroll);
/* 384 */     c.weightx = 0.5D;
/* 385 */     c.weighty = 2.0D;
/* 386 */     c.gridx = 0;
/* 387 */     c.gridy = 1;
/* 388 */     c.ipady = 300;
/* 389 */     this.frem.add(this.up, c);
/*     */ 
/*     */     
/* 392 */     this.edit = new JButton("Edit");
/* 393 */     this.mn = new JButton("Mean");
/* 394 */     this.mdn = new JButton("Median");
/* 395 */     this.md = new JButton("Mode");
/* 396 */     this.main = new JButton("Menu");
/* 397 */     this.descri = new JButton("Interpretation");
/*     */     
/* 399 */     this.edit.addActionListener(this);
/* 400 */     this.mn.addActionListener(this);
/* 401 */     this.mdn.addActionListener(this);
/* 402 */     this.md.addActionListener(this);
/* 403 */     this.main.addActionListener(this);
/* 404 */     this.descri.addActionListener(this);
/*     */     
/* 406 */     c.fill = 2;
/* 407 */     this.down = new JPanel(new GridLayout(3, 3));
/* 408 */     this.down.setSize(600, 100);
/* 409 */     this.down.add(this.res); this.down.add(this.edit); this.down.add(this.main); this.down.add(this.mn); this.down.add(this.mdn); this.down.add(this.md); this.down.add(this.descri); this.down.add(this.descript);
/* 410 */     c.ipady = 75;
/* 411 */     c.gridx = 0;
/* 412 */     c.gridy = 2;
/* 413 */     c.weightx = 0.0D;
/* 414 */     c.insets = new Insets(false, true, true, true);
/* 415 */     this.frem.add(this.down, c);
/*     */     
/* 417 */     this.gr.add(this.frem);
/* 418 */     this.gr.setVisible(true);
/*     */ 
/*     */     
/* 421 */     System.out.println("Grouped Data");
/* 422 */     this.choice = 0;
/*     */     
/*     */     do {
/* 425 */       this.title = JOptionPane.showInputDialog("Enter the title for the data set to be used:");
/* 426 */     } while (this.title == null);
/*     */     
/* 428 */     this.headerTitle.setText("Table 1." + this.title);
/*     */     
/* 430 */     this.input = new String();
/*     */     
/*     */     do {
/* 433 */       this.input = JOptionPane.showInputDialog("Type of data\n[1] - Integer [2] - Float");
/* 434 */       if (this.input == null)
/*     */         continue;  try {
/* 436 */         this.type = Integer.parseInt(this.input);
/* 437 */       } catch (NumberFormatException e) {
/* 438 */         JOptionPane.showMessageDialog(null, "Choices are only 1 and 2!");
/* 439 */         this.input = null;
/*     */       }
/*     */     
/*     */     }
/* 443 */     while (this.input == null || this.type < 0 || this.type > 2);
/*     */     
/*     */     do {
/* 446 */       this.input = JOptionPane.showInputDialog("Enter the number of intervals:");
/* 447 */       if (this.input == null)
/*     */         continue;  try {
/* 449 */         this.number = Integer.parseInt(this.input);
/* 450 */       } catch (NumberFormatException e) {
/* 451 */         JOptionPane.showMessageDialog(null, "Value must be an integer!");
/* 452 */         this.input = null;
/*     */       }
/*     */     
/*     */     }
/* 456 */     while (this.input == null || this.number < 1);
/*     */     
/* 458 */     this.input = new String();
/*     */     
/*     */     do {
/* 461 */       this.input = JOptionPane.showInputDialog("Are there any open-ended intervals? [1] - Yes [2] - No:");
/* 462 */       if (this.input == null)
/*     */         continue;  try {
/* 464 */         this.openendedchoice = Integer.parseInt(this.input);
/* 465 */         if (this.openendedchoice == 1) {
/* 466 */           this.open = true;
/*     */         }
/* 468 */       } catch (NumberFormatException e) {
/* 469 */         JOptionPane.showMessageDialog(null, "Choices are only 1 and 2!");
/* 470 */         this.input = null;
/*     */       }
/*     */     
/*     */     }
/* 474 */     while (this.input == null || this.openendedchoice < 0 || this.openendedchoice > 2);
/*     */ 
/*     */     
/* 477 */     this.array = new Interval[this.number];
/*     */     
/* 479 */     for (i = 0; i < this.number; i++) {
/* 480 */       this.array[i] = new Interval();
/*     */     }
/* 482 */     double nextlcl = -1.0D;
/* 483 */     double prevucl = -1.0D;
/*     */     
/* 485 */     this.input = new String();
/*     */ 
/*     */ 
/*     */     
/* 489 */     for (i = 0; i < this.number; i++) {
/* 490 */       if (this.type == 2) {
/*     */         do {
/* 492 */           this.input = JOptionPane.showInputDialog("For interval number " + (i + 1) + "\n Lower class limit:");
/* 493 */           if (this.input == null)
/*     */             continue;  try {
/* 495 */             while (nextlcl <= prevucl) {
/* 496 */               Pattern pattern = Pattern.compile("[0-9]*\\.[0-9]+");
/* 497 */               Matcher matcher = pattern.matcher(this.input);
/* 498 */               if (matcher.matches()) {
/* 499 */                 (this.array[i]).lcl = Double.valueOf(Double.parseDouble(this.input));
/* 500 */                 if (((Double)(this.array[i]).lcl).doubleValue() <= prevucl) {
/* 501 */                   this.input = null;
/*     */                   break;
/*     */                 } 
/* 504 */                 nextlcl = ((Double)(this.array[i]).lcl).doubleValue();
/*     */                 
/*     */                 break;
/*     */               } 
/*     */               
/* 509 */               this.input = "";
/* 510 */               (this.array[i]).lcl = Double.valueOf(Double.parseDouble(this.input));
/*     */             }
/*     */           
/* 513 */           } catch (NumberFormatException e) {
/* 514 */             JOptionPane.showMessageDialog(null, "Value must contain a decimal!");
/* 515 */             this.input = null;
/*     */           }
/*     */         
/*     */         }
/* 519 */         while (this.input == null || ((Double)(this.array[i]).lcl).doubleValue() < 0.0D);
/*     */         
/* 521 */         this.input = new String();
/*     */         
/*     */         do {
/* 524 */           this.input = JOptionPane.showInputDialog("For interval number " + (i + 1) + "\n Upper class limit:");
/* 525 */           if (this.input == null)
/*     */             continue;  try {
/* 527 */             while (prevucl <= nextlcl) {
/* 528 */               Pattern pattern = Pattern.compile("[0-9]*\\.[0-9]+");
/* 529 */               Matcher matcher = pattern.matcher(this.input);
/* 530 */               if (matcher.matches()) {
/* 531 */                 (this.array[i]).ucl = Double.valueOf(Double.parseDouble(this.input));
/* 532 */                 if (((Double)(this.array[i]).ucl).doubleValue() <= nextlcl) {
/* 533 */                   this.input = null;
/*     */                   break;
/*     */                 } 
/* 536 */                 prevucl = ((Double)(this.array[i]).ucl).doubleValue();
/*     */                 
/*     */                 break;
/*     */               } 
/*     */               
/* 541 */               this.input = "";
/* 542 */               (this.array[i]).ucl = Double.valueOf(Double.parseDouble(this.input));
/*     */             }
/*     */           
/* 545 */           } catch (NumberFormatException e) {
/* 546 */             JOptionPane.showMessageDialog(null, "Value must contain a decimal!");
/* 547 */             this.input = null;
/*     */           }
/*     */         
/*     */         }
/* 551 */         while (this.input == null || ((Double)(this.array[i]).ucl).doubleValue() < 0.0D);
/*     */       } else {
/*     */         
/*     */         do {
/* 555 */           this.input = JOptionPane.showInputDialog("For interval number " + (i + 1) + "\n Lower class limit:");
/* 556 */           if (this.input == null)
/*     */             continue;  try {
/* 558 */             if (nextlcl <= prevucl) {
/* 559 */               (this.array[i]).lcl = Integer.valueOf(Integer.parseInt(this.input));
/* 560 */               if (((Integer)(this.array[i]).lcl).intValue() <= prevucl) {
/* 561 */                 this.input = null;
/*     */               } else {
/*     */                 
/* 564 */                 nextlcl = ((Integer)(this.array[i]).lcl).intValue();
/*     */               }
/*     */             
/*     */             } 
/* 568 */           } catch (NumberFormatException e) {
/* 569 */             JOptionPane.showMessageDialog(null, "Value must be an integer!");
/* 570 */             this.input = null;
/*     */           }
/*     */         
/*     */         }
/* 574 */         while (this.input == null || ((Integer)(this.array[i]).lcl).intValue() < 0);
/*     */         
/* 576 */         this.input = new String();
/*     */         
/*     */         do {
/* 579 */           this.input = JOptionPane.showInputDialog("For interval number " + (i + 1) + "\n Upper class limit:");
/* 580 */           if (this.input == null)
/*     */             continue;  try {
/* 582 */             if (prevucl <= nextlcl) {
/* 583 */               (this.array[i]).ucl = Integer.valueOf(Integer.parseInt(this.input));
/* 584 */               if (((Integer)(this.array[i]).ucl).intValue() <= nextlcl) {
/* 585 */                 this.input = null;
/*     */               }
/*     */               else {
/*     */                 
/* 589 */                 prevucl = ((Integer)(this.array[i]).ucl).intValue();
/*     */               }
/*     */             
/*     */             } 
/* 593 */           } catch (NumberFormatException e) {
/* 594 */             JOptionPane.showMessageDialog(null, "Value must be an integer!");
/* 595 */             this.input = null;
/*     */           }
/*     */         
/*     */         }
/* 599 */         while (this.input == null || ((Integer)(this.array[i]).ucl).intValue() < 0);
/*     */       } 
/*     */       
/* 602 */       this.input = new String();
/*     */       do {
/* 604 */         this.input = JOptionPane.showInputDialog("For interval number " + (i + 1) + "\n Frequency:");
/* 605 */         if (this.input == null)
/*     */           continue;  try {
/* 607 */           (this.array[i]).frequency = Integer.parseInt(this.input);
/* 608 */         } catch (NumberFormatException e) {
/* 609 */           JOptionPane.showMessageDialog(null, "Value must be an integer!");
/* 610 */           this.input = null;
/*     */         }
/*     */       
/* 613 */       } while (this.input == null || (this.array[i]).frequency < 1);
/*     */     } 
/* 615 */     if (this.type == 2) {
/* 616 */       for (int i = 0; i < this.number; i++) {
/* 617 */         (this.array[i]).midpoint = (((Double)(this.array[i]).lcl).doubleValue() + ((Double)(this.array[i]).ucl).doubleValue()) / 2.0D;
/* 618 */         (this.array[i]).crossprod = (this.array[i]).midpoint * (this.array[i]).frequency;
/*     */       } 
/*     */     } else {
/*     */       
/* 622 */       for (int i = 0; i < this.number; i++) {
/* 623 */         (this.array[i]).midpoint = ((((Integer)(this.array[i]).lcl).intValue() + ((Integer)(this.array[i]).ucl).intValue()) / 2);
/* 624 */         (this.array[i]).crossprod = (this.array[i]).midpoint * (this.array[i]).frequency;
/*     */       } 
/*     */     } 
/*     */     
/* 628 */     double square = 0.0D;
/*     */     
/* 630 */     for (i = 0; i < this.number; i++) {
/* 631 */       square = (this.array[i]).midpoint * (this.array[i]).midpoint;
/* 632 */       (this.array[i]).crossprod_sqr = square * (this.array[i]).frequency;
/*     */     } 
/*     */     
/* 635 */     if (this.open) {
/* 636 */       this.input = new String();
/*     */       do {
/* 638 */         this.input = JOptionPane.showInputDialog("Open-ended Intervals:\n[1] - First [2] - Last [3] - Both: ");
/* 639 */         if (this.input == null)
/*     */           continue;  try {
/* 641 */           this.openended = Integer.parseInt(this.input);
/* 642 */         } catch (NumberFormatException i) {
/* 643 */           NumberFormatException e; JOptionPane.showMessageDialog(null, "Choices are only between 1 and 3!");
/* 644 */           this.input = null;
/*     */         }
/*     */       
/*     */       }
/* 648 */       while (this.input == null || this.openended < 0 || this.openended > 3);
/*     */     } 
/*     */ 
/*     */     
/* 652 */     for (int i = 0; i < this.number; i++) {
/* 653 */       Vector row = new Vector();
/* 654 */       row.add(String.valueOf(i + 1));
/* 655 */       row.add(String.valueOf((this.array[i]).lcl + " - " + (this.array[i]).ucl));
/* 656 */       row.add(String.valueOf((this.array[i]).midpoint));
/* 657 */       row.add(String.valueOf((this.array[i]).frequency));
/* 658 */       row.add(String.format("%.2f", new Object[] { Double.valueOf((this.array[i]).crossprod) }));
/* 659 */       row.add(String.format("%.2f", new Object[] { Double.valueOf((this.array[i]).crossprod_sqr) }));
/* 660 */       this.model.addRow(row);
/*     */     } 
/*     */     
/* 663 */     Vector row = new Vector();
/* 664 */     row.add("");
/* 665 */     row.add("");
/* 666 */     row.add("");
/* 667 */     row.add("total: " + String.valueOf(totalFreq(this.array)));
/* 668 */     row.add("total: " + String.format("%.2f", new Object[] { Double.valueOf(totalCrosProd(this.array)) }));
/* 669 */     row.add("total: " + String.format("%.2f", new Object[] { Double.valueOf(totalCrosProdSqr(this.array)) }));
/* 670 */     this.model.addRow(row);
/*     */     
/* 672 */     if (this.open) {
/* 673 */       if (this.openended == 1) {
/* 674 */         this.model.setValueAt(String.valueOf("* - " + (this.array[0]).ucl), 0, 1);
/* 675 */         this.model.setValueAt("", 0, 2);
/* 676 */         this.model.setValueAt("", 0, 4);
/* 677 */         this.model.setValueAt("", 0, 5);
/* 678 */         this.model.setValueAt("total: N/A", this.number, 4);
/* 679 */         this.model.setValueAt("total: N/A", this.number, 5);
/*     */       }
/* 681 */       else if (this.openended == 2) {
/* 682 */         this.model.setValueAt(String.valueOf((this.array[this.number - 1]).lcl + " - *"), this.number - 1, 1);
/* 683 */         this.model.setValueAt("N/A", this.number - 1, 2);
/* 684 */         this.model.setValueAt("N/A", this.number - 1, 4);
/* 685 */         this.model.setValueAt("N/A", this.number - 1, 5);
/* 686 */         this.model.setValueAt("total: N/A", this.number, 4);
/* 687 */         this.model.setValueAt("total: N/A", this.number, 5);
/*     */       } else {
/*     */         
/* 690 */         this.model.setValueAt(String.valueOf("* - " + (this.array[0]).ucl), 0, 1);
/* 691 */         this.model.setValueAt("N/A", 0, 2);
/* 692 */         this.model.setValueAt("N/A", 0, 4);
/* 693 */         this.model.setValueAt("N/A", 0, 5);
/* 694 */         this.model.setValueAt(String.valueOf((this.array[this.number - 1]).lcl + " - *"), this.number - 1, 1);
/* 695 */         this.model.setValueAt("N/A", this.number - 1, 2);
/* 696 */         this.model.setValueAt("N/A", this.number - 1, 4);
/* 697 */         this.model.setValueAt("N/A", this.number - 1, 5);
/* 698 */         this.model.setValueAt("total: N/A", this.number, 4);
/* 699 */         this.model.setValueAt("total: N/A", this.number, 5);
/*     */       } 
/* 701 */       this.open = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String calculateMode(Interval[] array) {
/* 708 */     this.out = "";
/* 709 */     Stack<Interval> s = new Stack<Interval>();
/* 710 */     int max = (array[0]).frequency;
/* 711 */     s.push(array[0]);
/*     */     
/* 713 */     for (i = 1; i < array.length; i++) {
/* 714 */       if ((array[i]).frequency > max) {
/* 715 */         emptyStack(s);
/* 716 */         s.push(array[i]);
/* 717 */         max = (array[i]).frequency;
/*     */       }
/* 719 */       else if ((array[i]).frequency == max) {
/* 720 */         s.push(array[i]);
/*     */       } 
/*     */     } 
/* 723 */     int size = s.size();
/*     */     
/* 725 */     while (!s.empty()) {
/* 726 */       Interval i = (Interval)s.pop();
/* 727 */       this.out = String.format("Modal class:" + i.lcl + " - " + i.ucl + "\nFrequency: " + i.frequency, new Object[0]);
/*     */     } 
/*     */     
/* 730 */     if (size == 1) {
/* 731 */       this.out += "\nUnimodal;";
/* 732 */       System.out.println("Unimodal");
/*     */     }
/* 734 */     else if (size == 2) {
/* 735 */       this.out += "\nBimodal;";
/* 736 */       System.out.println("Bimodal");
/*     */     }
/* 738 */     else if (size > 2) {
/* 739 */       this.out += "\nMultimodal;";
/* 740 */       System.out.println("Multimodal");
/*     */     }
/* 742 */     else if (size == 0) {
/* 743 */       this.out += "\nNo mode;";
/* 744 */       System.out.println("No mode");
/*     */     } 
/*     */     
/* 747 */     return this.out;
/*     */   }
/*     */   
/*     */   public static void emptyStack(Stack<Interval> s) {
/* 751 */     while (!s.empty()) {
/* 752 */       s.pop();
/*     */     }
/*     */   }
/*     */   
/*     */   public static int totalFreq(Interval[] array) {
/* 757 */     int sum = 0;
/* 758 */     for (int i = 0; i < array.length; i++) {
/* 759 */       sum += (array[i]).frequency;
/*     */     }
/* 761 */     return sum;
/*     */   }
/*     */   
/*     */   public static double totalCrosProd(Interval[] array) {
/* 765 */     double sum = 0.0D;
/* 766 */     for (int i = 0; i < array.length; i++) {
/* 767 */       sum += (array[i]).crossprod;
/*     */     }
/* 769 */     return sum;
/*     */   }
/*     */   
/*     */   public static double totalCrosProdSqr(Interval[] array) {
/* 773 */     double sum = 0.0D;
/* 774 */     for (int i = 0; i < array.length; i++) {
/* 775 */       sum += (array[i]).crossprod_sqr;
/*     */     }
/* 777 */     return sum;
/*     */   }
/*     */ 
/*     */   
/* 781 */   public static double computeMean(Interval[] array) { return totalCrosProd(array) / totalFreq(array); }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double standardDeviation(Interval[] array) {
/* 786 */     double n = totalFreq(array);
/* 787 */     double FXi = totalCrosProd(array);
/* 788 */     double FXi_sqrd = totalCrosProdSqr(array);
/*     */     
/* 790 */     double s = (n * FXi_sqrd - FXi * FXi) / n * (n - 1.0D);
/*     */     
/* 792 */     System.out.printf("Variance: %.2f\n", new Object[] { Double.valueOf(s) });
/*     */     
/* 794 */     return Math.sqrt(s);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab3/Grouped.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */