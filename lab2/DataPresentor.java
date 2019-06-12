/*     */ package lab2;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataPresentor
/*     */   extends JFrame
/*     */ {
/*     */   private JLabel typeofData;
/*     */   private JLabel dataD;
/*     */   private JLabel dataI;
/*     */   private JLabel categorical;
/*     */   private JTextField dataDesc;
/*     */   private JRadioButton numB;
/*     */   private JRadioButton alphaB;
/*     */   private JRadioButton stringB;
/*     */   private JTextField dataInput;
/*     */   private ButtonGroup dataGroup;
/*     */   private JComboBox<String> datalist;
/*     */   private JButton showtable;
/*     */   private JButton reset;
/*     */   private Data data;
/*     */   boolean ifNum;
/*     */   boolean ifAlpha;
/*     */   boolean ifString;
/*     */   boolean ifChooseDataType;
/*     */   boolean ifTypedDesc;
/*     */   boolean ifDatainputted;
/*     */   int totalcount;
/*     */   
/*     */   public DataPresentor() { // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial <init> : ()V
/*     */     //   4: aload_0
/*     */     //   5: iconst_0
/*     */     //   6: putfield ifNum : Z
/*     */     //   9: aload_0
/*     */     //   10: iconst_0
/*     */     //   11: putfield ifAlpha : Z
/*     */     //   14: aload_0
/*     */     //   15: iconst_0
/*     */     //   16: putfield ifString : Z
/*     */     //   19: aload_0
/*     */     //   20: iconst_0
/*     */     //   21: putfield ifChooseDataType : Z
/*     */     //   24: aload_0
/*     */     //   25: iconst_0
/*     */     //   26: putfield ifTypedDesc : Z
/*     */     //   29: aload_0
/*     */     //   30: iconst_0
/*     */     //   31: putfield ifDatainputted : Z
/*     */     //   34: aload_0
/*     */     //   35: iconst_0
/*     */     //   36: putfield totalcount : I
/*     */     //   39: aload_0
/*     */     //   40: invokespecial init : ()V
/*     */     //   43: aload_0
/*     */     //   44: new lab2/Data
/*     */     //   47: dup
/*     */     //   48: invokespecial <init> : ()V
/*     */     //   51: putfield data : Llab2/Data;
/*     */     //   54: aload_0
/*     */     //   55: aconst_null
/*     */     //   56: invokevirtual setLocationRelativeTo : (Ljava/awt/Component;)V
/*     */     //   59: aload_0
/*     */     //   60: iconst_2
/*     */     //   61: invokevirtual setDefaultCloseOperation : (I)V
/*     */     //   64: invokestatic getInstalledLookAndFeels : ()[Ljavax/swing/UIManager$LookAndFeelInfo;
/*     */     //   67: astore_1
/*     */     //   68: aload_1
/*     */     //   69: arraylength
/*     */     //   70: istore_2
/*     */     //   71: iconst_0
/*     */     //   72: istore_3
/*     */     //   73: iload_3
/*     */     //   74: iload_2
/*     */     //   75: if_icmpge -> 113
/*     */     //   78: aload_1
/*     */     //   79: iload_3
/*     */     //   80: aaload
/*     */     //   81: astore #4
/*     */     //   83: ldc 'Nimbus'
/*     */     //   85: aload #4
/*     */     //   87: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   90: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   93: ifeq -> 107
/*     */     //   96: aload #4
/*     */     //   98: invokevirtual getClassName : ()Ljava/lang/String;
/*     */     //   101: invokestatic setLookAndFeel : (Ljava/lang/String;)V
/*     */     //   104: goto -> 113
/*     */     //   107: iinc #3, 1
/*     */     //   110: goto -> 73
/*     */     //   113: goto -> 193
/*     */     //   116: astore_1
/*     */     //   117: ldc lab2/DataPresentor
/*     */     //   119: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   122: invokestatic getLogger : (Ljava/lang/String;)Ljava/util/logging/Logger;
/*     */     //   125: getstatic java/util/logging/Level.SEVERE : Ljava/util/logging/Level;
/*     */     //   128: aconst_null
/*     */     //   129: aload_1
/*     */     //   130: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   133: goto -> 193
/*     */     //   136: astore_1
/*     */     //   137: ldc lab2/DataPresentor
/*     */     //   139: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   142: invokestatic getLogger : (Ljava/lang/String;)Ljava/util/logging/Logger;
/*     */     //   145: getstatic java/util/logging/Level.SEVERE : Ljava/util/logging/Level;
/*     */     //   148: aconst_null
/*     */     //   149: aload_1
/*     */     //   150: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   153: goto -> 193
/*     */     //   156: astore_1
/*     */     //   157: ldc lab2/DataPresentor
/*     */     //   159: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   162: invokestatic getLogger : (Ljava/lang/String;)Ljava/util/logging/Logger;
/*     */     //   165: getstatic java/util/logging/Level.SEVERE : Ljava/util/logging/Level;
/*     */     //   168: aconst_null
/*     */     //   169: aload_1
/*     */     //   170: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   173: goto -> 193
/*     */     //   176: astore_1
/*     */     //   177: ldc lab2/DataPresentor
/*     */     //   179: invokevirtual getName : ()Ljava/lang/String;
/*     */     //   182: invokestatic getLogger : (Ljava/lang/String;)Ljava/util/logging/Logger;
/*     */     //   185: getstatic java/util/logging/Level.SEVERE : Ljava/util/logging/Level;
/*     */     //   188: aconst_null
/*     */     //   189: aload_1
/*     */     //   190: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   193: aload_0
/*     */     //   194: iconst_1
/*     */     //   195: invokevirtual setVisible : (Z)V
/*     */     //   198: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #34	-> 0
/*     */     //   #25	-> 4
/*     */     //   #26	-> 9
/*     */     //   #27	-> 14
/*     */     //   #28	-> 19
/*     */     //   #29	-> 24
/*     */     //   #30	-> 29
/*     */     //   #31	-> 34
/*     */     //   #35	-> 39
/*     */     //   #36	-> 43
/*     */     //   #37	-> 54
/*     */     //   #38	-> 59
/*     */     //   #41	-> 64
/*     */     //   #42	-> 83
/*     */     //   #43	-> 96
/*     */     //   #44	-> 104
/*     */     //   #41	-> 107
/*     */     //   #55	-> 113
/*     */     //   #47	-> 116
/*     */     //   #48	-> 117
/*     */     //   #55	-> 133
/*     */     //   #49	-> 136
/*     */     //   #50	-> 137
/*     */     //   #55	-> 153
/*     */     //   #51	-> 156
/*     */     //   #52	-> 157
/*     */     //   #55	-> 173
/*     */     //   #53	-> 176
/*     */     //   #54	-> 177
/*     */     //   #58	-> 193
/*     */     //   #60	-> 198
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   83	24	4	info	Ljavax/swing/UIManager$LookAndFeelInfo;
/*     */     //   117	16	1	ex	Ljava/lang/ClassNotFoundException;
/*     */     //   137	16	1	ex	Ljava/lang/InstantiationException;
/*     */     //   157	16	1	ex	Ljava/lang/IllegalAccessException;
/*     */     //   177	16	1	ex	Ljavax/swing/UnsupportedLookAndFeelException;
/*     */     //   0	199	0	this	Llab2/DataPresentor;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   64	113	116	java/lang/ClassNotFoundException
/*     */     //   64	113	136	java/lang/InstantiationException
/*     */     //   64	113	156	java/lang/IllegalAccessException
/*     */     //   64	113	176	javax/swing/UnsupportedLookAndFeelException }
/*     */   
/*     */   private void init() {
/*  64 */     this.typeofData = new JLabel();
/*  65 */     this.dataD = new JLabel();
/*  66 */     this.dataI = new JLabel();
/*  67 */     this.categorical = new JLabel();
/*  68 */     this.numB = new JRadioButton();
/*  69 */     this.alphaB = new JRadioButton();
/*  70 */     this.stringB = new JRadioButton();
/*  71 */     this.dataInput = new JTextField();
/*  72 */     this.dataDesc = new JTextField();
/*  73 */     this.dataGroup = new ButtonGroup();
/*  74 */     this.datalist = new JComboBox();
/*  75 */     this.showtable = new JButton();
/*  76 */     this.reset = new JButton();
/*     */ 
/*     */ 
/*     */     
/*  80 */     setDefaultCloseOperation(3);
/*  81 */     setTitle("Categorical Data");
/*  82 */     setBackground(new Color('ÿ', 'ÿ', 'ÿ'));
/*  83 */     setResizable(false);
/*     */     
/*  85 */     this.typeofData.setFont(new Font("Verdana", false, 10));
/*  86 */     this.typeofData.setText("TYPE OF DATA");
/*     */     
/*  88 */     this.categorical.setFont(new Font("Verdana", false, 12));
/*  89 */     this.categorical.setText("Categorical");
/*     */     
/*  91 */     this.dataD.setFont(new Font("Verdana", false, 10));
/*  92 */     this.dataD.setText("DATA DESCRIPTION");
/*     */     
/*  94 */     this.dataDesc.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  96 */             DataPresentor.this.dataDescActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 100 */     this.dataI.setFont(new Font("Verdana", false, 10));
/* 101 */     this.dataI.setText("DATA INPUT");
/*     */     
/* 103 */     this.dataInput.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*     */             try {
/* 106 */               DataPresentor.this.dataInputActionPerformed(evt);
/* 107 */             } catch (Exception e) {
/*     */               
/* 109 */               e.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 114 */     this.dataGroup.add(this.numB);
/* 115 */     this.numB.setFont(new Font("Verdana", false, 10));
/* 116 */     this.numB.setText("Numbers");
/* 117 */     this.numB.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 119 */             DataPresentor.this.numBActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 123 */     this.dataGroup.add(this.alphaB);
/* 124 */     this.alphaB.setFont(new Font("Verdana", false, 10));
/* 125 */     this.alphaB.setText("Alphabetic");
/* 126 */     this.alphaB.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 128 */             DataPresentor.this.alphaBActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 132 */     this.dataGroup.add(this.stringB);
/* 133 */     this.stringB.setFont(new Font("Verdana", false, 10));
/* 134 */     this.stringB.setText("String");
/* 135 */     this.stringB.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 137 */             DataPresentor.this.stringBActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 141 */     this.showtable.setFont(new Font("Verdana", true, 11));
/* 142 */     this.showtable.setText("SHOW TABLE");
/* 143 */     this.showtable.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 145 */             DataPresentor.this.showtableActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/* 149 */     this.reset.setFont(new Font("Verdana", true, 11));
/* 150 */     this.reset.setText("RESET");
/* 151 */     this.reset.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 153 */             DataPresentor.this.resetActionPerformed(evt);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 159 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 160 */     getContentPane().setLayout(layout);
/* 161 */     layout.setHorizontalGroup(layout
/* 162 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 163 */         .addGroup(layout.createSequentialGroup()
/* 164 */           .addGap(26, 26, 26)
/* 165 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 166 */             .addGroup(layout.createSequentialGroup()
/* 167 */               .addComponent(this.numB)
/* 168 */               .addGap(18, 18, 18)
/* 169 */               .addComponent(this.alphaB)
/* 170 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 171 */               .addComponent(this.stringB))
/* 172 */             .addComponent(this.dataDesc, -2, 215, -2)
/* 173 */             .addComponent(this.typeofData)
/* 174 */             .addComponent(this.dataD)
/* 175 */             .addComponent(this.dataI)
/* 176 */             .addGroup(layout.createSequentialGroup()
/* 177 */               .addComponent(this.categorical))
/* 178 */             .addGroup(layout.createSequentialGroup()
/* 179 */               .addComponent(this.datalist, -2, 167, -2)
/* 180 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
/* 181 */             .addGroup(layout.createSequentialGroup())
/* 182 */             .addGap(16, 16, 16)
/* 183 */             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 184 */               .addComponent(this.reset, -2, 174, -2)
/* 185 */               .addComponent(this.showtable, -2, 174, -2))
/* 186 */             .addComponent(this.dataInput))
/* 187 */           .addContainerGap(24, 32767)));
/*     */     
/* 189 */     layout.setVerticalGroup(layout
/* 190 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 191 */         .addGroup(layout.createSequentialGroup()
/* 192 */           .addGap(25, 25, 25)
/* 193 */           .addComponent(this.typeofData)
/* 194 */           .addGap(18, 18, 18)
/* 195 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 196 */             .addComponent(this.categorical))
/* 197 */           .addGap(30, 30, 30)
/* 198 */           .addComponent(this.dataD)
/* 199 */           .addGap(18, 18, 18)
/* 200 */           .addComponent(this.dataDesc, -2, -1, -2)
/* 201 */           .addGap(47, 47, 47)
/* 202 */           .addComponent(this.dataI)
/* 203 */           .addGap(18, 18, 18)
/* 204 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 205 */             .addComponent(this.numB)
/* 206 */             .addComponent(this.alphaB)
/* 207 */             .addComponent(this.stringB))
/* 208 */           .addGap(18, 18, 18)
/* 209 */           .addComponent(this.dataInput, -2, -1, -2)
/* 210 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 211 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 212 */             .addComponent(this.datalist, -2, -1, -2))
/* 213 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, 32767)
/* 214 */           .addComponent(this.showtable, -2, 38, -2)
/* 215 */           .addGap(18, 18, 18)
/* 216 */           .addComponent(this.reset, -2, 38, -2)
/* 217 */           .addGap(56, 56, 56)));
/*     */ 
/*     */ 
/*     */     
/* 221 */     pack();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void resetActionPerformed(ActionEvent evt) {
/* 226 */     this.dataInput.setText("");
/* 227 */     this.data.clearData();
/* 228 */     this.datalist.removeAllItems();
/* 229 */     this.numB.setSelected(false);
/* 230 */     this.alphaB.setSelected(false);
/* 231 */     this.stringB.setSelected(false);
/* 232 */     this.dataDesc.setText("");
/* 233 */     this.dataGroup.clearSelection();
/* 234 */     this.ifNum = false;
/* 235 */     this.ifAlpha = false;
/* 236 */     this.ifString = false;
/* 237 */     this.ifChooseDataType = false;
/* 238 */     this.ifTypedDesc = false;
/* 239 */     this.ifDatainputted = false;
/* 240 */     this.totalcount = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void showtableActionPerformed(ActionEvent evt) {
/* 248 */     Object[] options = { "Summary Table" };
/* 249 */     int choice = JOptionPane.showOptionDialog(this, " Do you want to display the Summary Table?", "Table Type", 0, 3, null, options, options[0]);
/*     */     
/* 251 */     if (choice == 0) {
/* 252 */       this.data.performCategor();
/*     */       
/* 254 */       ST s = new ST(this.data.getCategorData(), this.data.desc, this.data.getTotalPercent(), this.data.getTotalFreq());
/* 255 */       s.setVisible(true);
/* 256 */       s.setLocationRelativeTo(null);
/*     */     
/*     */     }
/* 259 */     else if (choice == 1) {
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void stringBActionPerformed(ActionEvent evt) {
/* 268 */     if (!this.ifString) {
/* 269 */       if (!this.ifNum && !this.ifAlpha) {
/* 270 */         this.data.setDataType(3);
/* 271 */         this.ifString = true;
/* 272 */         this.ifNum = false;
/* 273 */         this.ifAlpha = false;
/* 274 */         this.ifChooseDataType = true;
/*     */       } 
/* 276 */       if (this.ifAlpha) {
/* 277 */         Object[] options = { "Ok", "Cancel" };
/* 278 */         int choice = JOptionPane.showOptionDialog(this, "This action will erase your previous inputted data. Do you want to Continue?", "Warning", 0, 3, null, options, options[0]);
/*     */         
/* 280 */         if (choice == 0) {
/* 281 */           this.data.setDataType(3);
/* 282 */           this.ifNum = false;
/* 283 */           this.ifAlpha = false;
/* 284 */           this.ifString = true;
/* 285 */           this.ifChooseDataType = true;
/* 286 */           this.data.clearData();
/* 287 */           this.totalcount = 0;
/* 288 */           this.datalist.removeAllItems();
/*     */         
/*     */         }
/* 291 */         else if (choice == 1) {
/* 292 */           this.ifAlpha = true;
/* 293 */           this.ifNum = false;
/* 294 */           this.ifString = false;
/* 295 */           this.ifChooseDataType = true;
/* 296 */           this.alphaB.setSelected(true);
/*     */         } 
/*     */       } 
/*     */       
/* 300 */       if (this.ifNum) {
/* 301 */         Object[] options = { "Ok", "Cancel" };
/* 302 */         int choice = JOptionPane.showOptionDialog(this, "This action will erase your previous inputted data. Do you want to Continue?", "Warning", 0, 3, null, options, options[0]);
/*     */         
/* 304 */         if (choice == 0) {
/* 305 */           this.data.setDataType(3);
/* 306 */           this.ifNum = false;
/* 307 */           this.ifAlpha = false;
/* 308 */           this.ifString = true;
/* 309 */           this.ifChooseDataType = true;
/* 310 */           this.data.clearData();
/* 311 */           this.totalcount = 0;
/* 312 */           this.datalist.removeAllItems();
/*     */         
/*     */         }
/* 315 */         else if (choice == 1) {
/* 316 */           this.ifAlpha = false;
/* 317 */           this.ifNum = true;
/* 318 */           this.ifString = false;
/* 319 */           this.ifChooseDataType = true;
/* 320 */           this.numB.setSelected(true);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void alphaBActionPerformed(ActionEvent evt) {
/* 332 */     if (!this.ifAlpha) {
/* 333 */       if (!this.ifNum && !this.ifString) {
/* 334 */         this.data.setDataType(2);
/* 335 */         this.ifString = false;
/* 336 */         this.ifNum = false;
/* 337 */         this.ifAlpha = true;
/* 338 */         this.ifDatainputted = true;
/*     */       } 
/* 340 */       if (this.ifNum) {
/* 341 */         Object[] options = { "Ok", "Cancel" };
/* 342 */         int choice = JOptionPane.showOptionDialog(this, "This action will erase your previous inputted data. Do you want to Continue?", "Warning", 0, 3, null, options, options[0]);
/*     */         
/* 344 */         if (choice == 0) {
/* 345 */           this.data.setDataType(2);
/* 346 */           this.ifNum = false;
/* 347 */           this.ifAlpha = true;
/* 348 */           this.ifString = false;
/* 349 */           this.ifChooseDataType = true;
/* 350 */           this.data.clearData();
/* 351 */           this.totalcount = 0;
/* 352 */           this.datalist.removeAllItems();
/*     */         
/*     */         }
/* 355 */         else if (choice == 1) {
/* 356 */           this.ifAlpha = true;
/* 357 */           this.ifNum = false;
/* 358 */           this.ifString = false;
/* 359 */           this.ifChooseDataType = true;
/* 360 */           this.alphaB.setSelected(true);
/*     */         } 
/*     */       } 
/* 363 */       if (this.ifString) {
/* 364 */         Object[] options = { "Ok", "Cancel" };
/* 365 */         int choice = JOptionPane.showOptionDialog(this, "This action will erase your previous inputted data. Do you want to Continue?", "Warning", 0, 3, null, options, options[0]);
/*     */         
/* 367 */         if (choice == 0) {
/* 368 */           this.data.setDataType(2);
/* 369 */           this.ifNum = false;
/* 370 */           this.ifAlpha = true;
/* 371 */           this.ifString = false;
/* 372 */           this.ifChooseDataType = true;
/* 373 */           this.data.clearData();
/* 374 */           this.totalcount = 0;
/* 375 */           this.datalist.removeAllItems();
/*     */         
/*     */         }
/* 378 */         else if (choice == 1) {
/* 379 */           this.ifAlpha = true;
/* 380 */           this.ifNum = false;
/* 381 */           this.ifString = false;
/* 382 */           this.ifChooseDataType = true;
/* 383 */           this.alphaB.setSelected(true);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void numBActionPerformed(ActionEvent evt) {
/* 393 */     if (!this.ifNum) {
/* 394 */       if (!this.ifAlpha && !this.ifString) {
/* 395 */         this.data.setDataType(1);
/* 396 */         this.ifString = false;
/* 397 */         this.ifNum = true;
/* 398 */         this.ifAlpha = false;
/* 399 */         this.ifChooseDataType = true;
/*     */       } 
/* 401 */       if (this.ifAlpha) {
/* 402 */         Object[] options = { "Ok", "Cancel" };
/* 403 */         int choice = JOptionPane.showOptionDialog(this, "This action will erase your previous inputted data. Do you want to Continue?", "Warning", 0, 3, null, options, options[0]);
/*     */         
/* 405 */         if (choice == 0) {
/* 406 */           this.data.setDataType(1);
/* 407 */           this.ifNum = true;
/* 408 */           this.ifAlpha = false;
/* 409 */           this.ifString = false;
/* 410 */           this.ifChooseDataType = true;
/* 411 */           this.data.clearData();
/* 412 */           this.totalcount = 0;
/* 413 */           this.datalist.removeAllItems();
/*     */         
/*     */         }
/* 416 */         else if (choice == 1) {
/* 417 */           this.ifAlpha = false;
/* 418 */           this.ifNum = true;
/* 419 */           this.ifString = false;
/* 420 */           this.ifChooseDataType = true;
/* 421 */           this.numB.setSelected(true);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 426 */       if (this.ifString) {
/* 427 */         Object[] options = { "Ok", "Cancel" };
/* 428 */         int choice = JOptionPane.showOptionDialog(this, "This action will erase your previous inputted data. Do you want to Continue?", "Warning", 0, 3, null, options, options[0]);
/*     */         
/* 430 */         if (choice == 0) {
/* 431 */           this.data.setDataType(1);
/* 432 */           this.ifNum = true;
/* 433 */           this.ifAlpha = false;
/* 434 */           this.ifString = false;
/* 435 */           this.ifChooseDataType = true;
/* 436 */           this.data.clearData();
/* 437 */           this.totalcount = 0;
/* 438 */           this.datalist.removeAllItems();
/*     */         
/*     */         }
/* 441 */         else if (choice == 1) {
/* 442 */           this.ifAlpha = false;
/* 443 */           this.ifNum = true;
/* 444 */           this.ifString = false;
/* 445 */           this.ifChooseDataType = true;
/* 446 */           this.numB.setSelected(true);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dataInputActionPerformed(ActionEvent evt) {
/* 458 */     if (this.ifChooseDataType) {
/* 459 */       if (!this.ifDatainputted) {
/* 460 */         if (this.dataInput.getText().equals("")) {
/* 461 */           JOptionPane.showMessageDialog(this, "Please provide an input");
/* 462 */           this.dataInput.setText("");
/*     */         } else {
/*     */           
/* 465 */           this.data.addValue(this.dataInput.getText());
/* 466 */           this.datalist.addItem(this.dataInput.getText());
/* 467 */           this.datalist.setSelectedItem(this.dataInput.getText());
/* 468 */           this.totalcount++;
/* 469 */           this.dataInput.setText("");
/* 470 */           System.out.println("input count:" + this.totalcount);
/*     */         } 
/*     */       } else {
/*     */         
/* 474 */         this.ifDatainputted = false;
/*     */       } 
/*     */     } else {
/* 477 */       JOptionPane.showMessageDialog(this, "Please Choose Dataype of Input");
/* 478 */       this.dataInput.setText("");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dataDescActionPerformed(ActionEvent evt) {
/* 485 */     if (this.dataDesc.getText().equals("")) {
/* 486 */       JOptionPane.showMessageDialog(this, "Please provide an input", "No input", 0);
/*     */     }
/* 488 */     else if (!this.ifTypedDesc) {
/* 489 */       this.data.addDescription(this.dataDesc.getText());
/* 490 */       this.ifTypedDesc = true;
/* 491 */       this.dataDesc.setText("");
/* 492 */       JOptionPane.showMessageDialog(this, "Data Description has been added");
/*     */     } else {
/* 494 */       Object[] options = { "Ok", "Cancel" };
/* 495 */       int choice = JOptionPane.showOptionDialog(this, "This action will erase your previous inputted data. Do you want to Continue?", "Warning", 0, 3, null, options, options[0]);
/*     */       
/* 497 */       if (choice == 0) {
/* 498 */         this.data.addDescription(this.dataDesc.getText());
/* 499 */         JOptionPane.showMessageDialog(this, "Data Description has been changed");
/*     */       } 
/* 501 */       this.dataDesc.setText("");
/* 502 */       this.ifTypedDesc = true;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab2/DataPresentor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */