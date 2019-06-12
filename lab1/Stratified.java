/*     */ package lab1;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.util.Arrays;
/*     */ import java.util.Random;
/*     */ import java.util.Scanner;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ 
/*     */ public class Stratified extends JFrame implements ActionListener {
/*     */   Random rand;
/*  17 */   JFrame stratRand = new JFrame("Stratified Random");
/*  18 */   JTextArea sframe = new JTextArea();
/*  19 */   JTextArea items = new JTextArea();
/*  20 */   JButton start = new JButton("Start"); JButton back = new JButton("Back");
/*  21 */   JPanel button = new JPanel(); JScrollPane scrollup;
/*     */   JScrollPane scrolldown;
/*     */   String line;
/*  24 */   String samFrame = "Sampling Frame = "; String samItems = "Sample = "; int[] intArray; int[] intArr; int[] index; int[] strata; int[] intSam; int[] samIndex; int[] countEach;
/*  25 */   Scanner in = new Scanner(System.in); char[] charArray; char[] charArr; char[] chstrata; char[] chSam;
/*     */   int input;
/*     */   int population;
/*  28 */   int count = 1; int counter = 1; int sample; int random = 0; int samTotal = 0; int type = 0;
/*  29 */   double percent = 1.0D;
/*     */   
/*     */   public Stratified() {
/*  32 */     this.rand = new Random();
/*     */     
/*  34 */     this.items.setEditable(false);
/*  35 */     this.items.setLineWrap(true);
/*  36 */     this.sframe.setEditable(false);
/*  37 */     this.sframe.setLineWrap(true);
/*     */     
/*  39 */     this.button.setLayout(new GridLayout(true, 2));
/*  40 */     this.button.add(this.start);
/*  41 */     this.button.add(this.back);
/*     */     
/*  43 */     this.scrollup = new JScrollPane(this.sframe, 20, 31);
/*  44 */     this.scrolldown = new JScrollPane(this.items, 20, 31);
/*     */ 
/*     */     
/*  47 */     this.stratRand.add(this.scrollup);
/*  48 */     this.stratRand.add(this.scrolldown);
/*  49 */     this.stratRand.add(this.button);
/*     */     
/*  51 */     this.start.addActionListener(this);
/*  52 */     this.back.addActionListener(this);
/*     */     
/*  54 */     this.stratRand.setSize(400, 400);
/*  55 */     this.stratRand.setVisible(true);
/*  56 */     this.stratRand.setLocationRelativeTo(null);
/*  57 */     this.stratRand.setLayout(new GridLayout(3, true));
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/*  62 */       pop = JOptionPane.showInputDialog("Enter size of population:");
/*  63 */       if (pop == null)
/*     */         continue;  try {
/*  65 */         this.population = Integer.parseInt(pop);
/*  66 */       } catch (NumberFormatException e) {
/*  67 */         JOptionPane.showMessageDialog(null, "Value must be an integer!");
/*  68 */         pop = null;
/*     */       }
/*     */     
/*  71 */     } while (pop == null || this.population < 25);
/*     */     
/*     */     do {
/*     */       String in;
/*  75 */       in = JOptionPane.showInputDialog("Choose a type( < 1 > for numbers and < 2 > for characters ): ");
/*  76 */       if (in == null)
/*     */         continue;  try {
/*  78 */         this.type = Integer.parseInt(in);
/*  79 */       } catch (NumberFormatException e) {
/*  80 */         JOptionPane.showMessageDialog(null, "Value must be an integer!");
/*  81 */         in = null;
/*     */       }
/*     */     
/*  84 */     } while (in == null || 
/*  85 */       this.type < 0 || this.type > 2);
/*     */     
/*  87 */     this.index = new int[this.population];
/*  88 */     if (this.type == 1) {
/*  89 */       this.intArray = new int[this.population];
/*  90 */       this.intArr = new int[this.population];
/*     */     } else {
/*     */       
/*  93 */       this.charArray = new char[this.population];
/*  94 */       this.charArr = new char[this.population];
/*     */     } 
/*     */     
/*  97 */     for (i = this.population, j = 0; i > 0; i--, j++) {
/*     */       String samp;
/*     */       do {
/* 100 */         samp = JOptionPane.showInputDialog("Enter items (" + i + " left):");
/* 101 */         if (samp == null)
/*     */           continue;  try {
/* 103 */           if (this.type == 1) {
/* 104 */             this.intArray[j] = Integer.parseInt(samp);
/* 105 */             this.intArr[j] = this.intArray[j];
/*     */           } 
/* 107 */         } catch (NumberFormatException e) {
/* 108 */           JOptionPane.showMessageDialog(null, "Value must be an integer!");
/* 109 */           samp = null;
/*     */         }
/*     */       
/* 112 */       } while (samp == null);
/* 113 */       if (this.type == 2) {
/* 114 */         this.charArray[j] = samp.charAt(0);
/* 115 */         this.charArr[j] = this.charArray[j];
/*     */       } 
/*     */     } 
/*     */     
/* 119 */     if (this.type == 1) {
/* 120 */       Arrays.sort(this.intArr);
/*     */     } else {
/*     */       
/* 123 */       Arrays.sort(this.charArr);
/*     */     } 
/*     */     
/* 126 */     for (i = 0; i < this.population - 1; i++) {
/* 127 */       if (this.type == 1) {
/* 128 */         if (this.intArr[i] != this.intArr[i + 1]) {
/* 129 */           this.count++;
/*     */         }
/*     */       }
/* 132 */       else if (this.charArr[i] != this.charArr[i + 1]) {
/* 133 */         this.count++;
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     this.strata = new int[this.count];
/*     */     
/* 139 */     for (int i = 0, j = 0; i < this.population - 1; i++) {
/* 140 */       if (this.type == 1) {
/* 141 */         if (this.intArr[i] != this.intArr[i + 1]) {
/* 142 */           this.strata[j] = i;
/* 143 */           j++;
/*     */         }
/*     */       
/*     */       }
/* 147 */       else if (this.charArr[i] != this.charArr[i + 1]) {
/* 148 */         this.strata[j] = i;
/* 149 */         j++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 154 */     this.strata[this.count - 1] = this.population - 1;
/*     */     
/* 156 */     for (i = 0; i < this.population; i++) {
/* 157 */       for (int j = 0; j < this.population; j++) {
/* 158 */         if (this.type == 1) {
/* 159 */           if (this.intArr[i] == this.intArray[j]) {
/* 160 */             this.index[i] = j;
/* 161 */             this.intArray[j] = -105;
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/* 166 */         } else if (this.charArr[i] == this.charArray[j]) {
/* 167 */           this.index[i] = j;
/* 168 */           this.charArray[j] = Character.MIN_VALUE;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 175 */     this.samFrame += "Strata 1 = ";
/*     */     
/* 177 */     for (int i = 0; i < this.population - 1; i++) {
/* 178 */       if (this.type == 1) {
/* 179 */         if (this.intArr[i] != this.intArr[i + 1]) {
/* 180 */           this.samFrame += "{" + this.intArr[i] + ", " + (this.index[i] + 1) + "}\n";
/* 181 */           this.counter++;
/* 182 */           this.samFrame += "Strata " + this.counter + " = ";
/*     */         } else {
/* 184 */           this.samFrame += "{" + this.intArr[i] + ", " + (this.index[i] + 1) + "}";
/* 185 */           if (this.intArr[i] == this.intArr[i + 1]) {
/* 186 */             this.samFrame += ", ";
/*     */           }
/*     */         }
/*     */       
/*     */       }
/* 191 */       else if (this.charArr[i] != this.charArr[i + 1]) {
/* 192 */         this.samFrame += "{" + this.charArr[i] + ", " + (this.index[i] + 1) + "}\n";
/* 193 */         this.counter++;
/* 194 */         this.samFrame += "Strata " + this.counter + " = ";
/*     */       } else {
/* 196 */         this.samFrame += "{" + this.charArr[i] + ", " + (this.index[i] + 1) + "}";
/* 197 */         if (this.charArr[i] == this.charArr[i + 1]) {
/* 198 */           this.samFrame += ", ";
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 204 */     if (this.type == 1) {
/* 205 */       this.samFrame += "{" + this.intArr[this.population - 1] + ", " + (this.index[this.population - 1] + 1) + "}";
/*     */     } else {
/*     */       
/* 208 */       this.samFrame += "{" + this.charArr[this.population - 1] + ", " + (this.index[this.population - 1] + 1) + "}";
/*     */     } 
/*     */     
/* 211 */     this.sframe.setText(this.samFrame);
/*     */     
/* 213 */     this.stratRand.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent we) {
/* 216 */             Stratified.this.stratRand.setVisible(false);
/* 217 */             Stratified.this.stratRand.dispose();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 224 */   public int randInt(int min, int max) { return this.rand.nextInt(max - min + 1) + min; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/* 230 */     if (e.getSource() == this.start) {
/*     */       do {
/* 232 */         this.samItems = "Sample = ";
/* 233 */         this.line = JOptionPane.showInputDialog("Enter percentage (must be >0 or <100): ");
/* 234 */         if (this.line.isEmpty()) {
/* 235 */           this.percent = 20.0D;
/*     */           break;
/*     */         } 
/* 238 */         if (this.line == null)
/*     */           continue;  try {
/* 240 */           this.percent = Integer.parseInt(this.line);
/* 241 */           if (this.percent >= 100.0D || this.percent <= 0.0D) {
/* 242 */             this.line = "";
/* 243 */             this.percent = Integer.parseInt(this.line);
/*     */           } 
/* 245 */         } catch (NumberFormatException ee) {
/* 246 */           JOptionPane.showMessageDialog(null, "Value must be an integer!");
/* 247 */           this.line = null;
/*     */         }
/*     */       
/* 250 */       } while (this.line == null);
/* 251 */       int l = 0;
/* 252 */       for (i = 0; i < this.count; i++) {
/* 253 */         if (i == 0) {
/* 254 */           this.sample = (int)Math.floor((this.strata[i] + 1) * this.percent / 100.0D);
/*     */         } else {
/*     */           
/* 257 */           this.sample = (int)Math.floor((this.strata[i] - this.strata[i - 1]) * this.percent / 100.0D);
/*     */         } 
/* 259 */         if (this.sample == 0)
/* 260 */           this.sample = 1; 
/* 261 */         this.samTotal += this.sample;
/*     */       } 
/*     */       
/* 264 */       if (this.type == 1) {
/* 265 */         this.intSam = new int[this.samTotal];
/*     */       } else {
/*     */         
/* 268 */         this.chSam = new char[this.samTotal];
/*     */       } 
/* 270 */       this.samIndex = new int[this.samTotal];
/*     */       
/* 272 */       for (i = 0; i < this.count; i++) {
/* 273 */         if (i == 0) {
/* 274 */           this.sample = (int)Math.floor((this.strata[i] + 1) * this.percent / 100.0D);
/* 275 */           System.out.println("sample: " + this.sample);
/*     */         } else {
/*     */           
/* 278 */           this.sample = (int)Math.floor((this.strata[i] - this.strata[i - 1]) * this.percent / 100.0D);
/*     */         } 
/* 280 */         if (this.sample == 0)
/* 281 */           this.sample = 1; 
/* 282 */         for (int j = 0; j < this.sample; j++) {
/* 283 */           if (this.type == 1) {
/* 284 */             if (i == 0) {
/*     */               do {
/* 286 */                 this.random = randInt(0, this.strata[i]);
/* 287 */               } while (this.intArr[this.random] == -105);
/* 288 */             } else if (i == this.count - 1) {
/*     */               do {
/* 290 */                 this.random = randInt(this.strata[i - 1] + 1, this.strata[i]);
/* 291 */               } while (this.intArr[this.random] == -105);
/*     */             } else {
/*     */               do {
/* 294 */                 this.random = randInt(this.strata[i - 1] + 1, this.strata[i]);
/* 295 */               } while (this.intArr[this.random] == -105);
/*     */             } 
/* 297 */             this.intSam[l] = this.intArr[this.random];
/* 298 */             this.samIndex[l] = this.index[this.random];
/* 299 */             this.intArr[this.random] = -105;
/* 300 */             l++;
/*     */           } else {
/*     */             
/* 303 */             if (i == 0) {
/*     */               do {
/* 305 */                 this.random = randInt(0, this.strata[i]);
/* 306 */               } while (this.charArr[this.random] == '\000');
/* 307 */             } else if (i == this.count - 1) {
/*     */               do {
/* 309 */                 this.random = randInt(this.strata[i - 1] + 1, this.strata[i]);
/* 310 */               } while (this.charArr[this.random] == '\000');
/*     */             } else {
/*     */               do {
/* 313 */                 this.random = randInt(this.strata[i - 1] + 1, this.strata[i]);
/* 314 */               } while (this.charArr[this.random] == '\000');
/*     */             } 
/* 316 */             this.chSam[l] = this.charArr[this.random];
/* 317 */             this.samIndex[l] = this.index[this.random];
/* 318 */             this.charArr[this.random] = Character.MIN_VALUE;
/* 319 */             l++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 324 */       for (int i = 0, k = 0; i < this.count; i++) {
/* 325 */         if (i == 0) {
/* 326 */           this.sample = (int)Math.floor((this.strata[i] + 1) * this.percent / 100.0D);
/*     */         } else {
/*     */           
/* 329 */           this.sample = (int)Math.floor((this.strata[i] - this.strata[i - 1]) * this.percent / 100.0D);
/*     */         } 
/* 331 */         if (this.sample == 0)
/* 332 */           this.sample = 1; 
/* 333 */         this.samItems += "Strata " + (i + 1) + " (n = " + this.sample + ") = ";
/* 334 */         for (int j = 0; j < this.sample; j++, k++) {
/* 335 */           if (this.type == 1) {
/* 336 */             this.samItems += "{" + this.intSam[k] + ", " + (this.samIndex[k] + 1) + "}";
/*     */           } else {
/*     */             
/* 339 */             this.samItems += "{" + this.chSam[k] + ", " + (this.samIndex[k] + 1) + "}";
/*     */           } 
/* 341 */           if (j != this.sample - 1)
/* 342 */             this.samItems += ", "; 
/*     */         } 
/* 344 */         this.samItems += "\n";
/*     */       } 
/*     */       
/* 347 */       this.items.setText(this.samItems);
/*     */     }
/* 349 */     else if (e.getSource() == this.back) {
/* 350 */       this.stratRand.setVisible(false);
/* 351 */       this.stratRand.dispose();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab1/Stratified.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */