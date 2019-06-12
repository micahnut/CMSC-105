/*     */ package lab1;
/*     */ 
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.util.Random;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ 
/*     */ public class Systematic
/*     */   implements ActionListener {
/*     */   Random rand;
/*  19 */   JFrame sysRand = new JFrame("Systematic Random");
/*  20 */   JTextArea sframe = new JTextArea(); JScrollPane scrollup;
/*  21 */   JTextArea items = new JTextArea();
/*     */   JScrollPane scrolldown;
/*  23 */   JButton start = new JButton("Start"); JButton back = new JButton("Back");
/*  24 */   JPanel button = new JPanel();
/*     */   String line;
/*  26 */   String samFrame = "Sampling Frame = "; String samItems = "Sample = ";
/*     */   int[] intArray;
/*     */   char[] charArray;
/*  29 */   int k = 0, sample = 0, input = 0, random = 0, type = 1;
/*     */   
/*     */   public Systematic() {
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
/*  47 */     this.sysRand.add(this.scrollup);
/*  48 */     this.sysRand.add(this.scrolldown);
/*  49 */     this.sysRand.add(this.button);
/*     */ 
/*     */     
/*  52 */     this.start.addActionListener(this);
/*  53 */     this.back.addActionListener(this);
/*     */     
/*  55 */     this.sysRand.setSize(400, 400);
/*  56 */     this.sysRand.setVisible(true);
/*  57 */     this.sysRand.setLocationRelativeTo(null);
/*  58 */     this.sysRand.setLayout(new GridLayout(3, true));
/*     */ 
/*     */     
/*     */     do {
/*  62 */       pop = JOptionPane.showInputDialog("Enter size of population:");
/*  63 */       if (pop == null)
/*     */         continue;  try {
/*  65 */         this.input = Integer.parseInt(pop);
/*  66 */       } catch (NumberFormatException e) {
/*  67 */         JOptionPane.showMessageDialog(null, "Value must be an integer!");
/*  68 */         pop = null;
/*     */       }
/*     */     
/*  71 */     } while (pop == null || this.input < 25);
/*     */     
/*     */     do {
/*     */       String in;
/*     */       
/*  76 */       in = JOptionPane.showInputDialog("Choose a type( < 1 > for numbers and < 2 > for characters ): ");
/*  77 */       if (in == null)
/*     */         continue;  try {
/*  79 */         this.type = Integer.parseInt(in);
/*  80 */       } catch (NumberFormatException e) {
/*  81 */         JOptionPane.showMessageDialog(null, "Value must be an integer!");
/*  82 */         in = null;
/*     */       }
/*     */     
/*  85 */     } while (in == null || 
/*  86 */       this.type < 0 || this.type > 2);
/*     */ 
/*     */     
/*  89 */     if (this.type == 1) {
/*  90 */       this.intArray = new int[this.input];
/*     */     } else {
/*     */       
/*  93 */       this.charArray = new char[this.input];
/*     */     } 
/*     */     
/*  96 */     for (int i = this.input, j = 0; i > 0; i--, j++) {
/*     */       String samp;
/*     */       do {
/*  99 */         samp = JOptionPane.showInputDialog("Enter items (" + i + " left):");
/* 100 */         if (samp == null)
/*     */           continue;  try {
/* 102 */           if (this.type == 1) {
/* 103 */             this.intArray[j] = Integer.parseInt(samp);
/*     */           }
/* 105 */         } catch (NumberFormatException e) {
/* 106 */           JOptionPane.showMessageDialog(null, "Value must be an integer!");
/* 107 */           samp = null;
/*     */         }
/*     */       
/* 110 */       } while (samp == null);
/*     */       
/* 112 */       if (this.type == 2) {
/* 113 */         this.charArray[j] = samp.charAt(0);
/*     */       }
/*     */     } 
/*     */     
/* 117 */     for (int i = 0; i < this.input; i++) {
/* 118 */       if (this.type == 1) {
/* 119 */         this.samFrame += "{Item: " + this.intArray[i] + " Index: " + (i + 1) + "}";
/*     */       } else {
/*     */         
/* 122 */         this.samFrame += "{Item: " + this.charArray[i] + " Index: " + (i + 1) + "}";
/*     */       } 
/* 124 */       if (i != this.input - 1) {
/* 125 */         this.samFrame += "\n";
/*     */       }
/*     */     } 
/* 128 */     this.sframe.setText(this.samFrame);
/*     */     
/* 130 */     this.sysRand.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent we) {
/* 133 */             Systematic.this.sysRand.setVisible(false);
/* 134 */             Systematic.this.sysRand.dispose();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent e) { // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokevirtual getSource : ()Ljava/lang/Object;
/*     */     //   4: aload_0
/*     */     //   5: getfield start : Ljavax/swing/JButton;
/*     */     //   8: if_acmpne -> 613
/*     */     //   11: aload_0
/*     */     //   12: ldc 'Sample = '
/*     */     //   14: putfield samItems : Ljava/lang/String;
/*     */     //   17: aload_0
/*     */     //   18: ldc 'Enter sample size: '
/*     */     //   20: invokestatic showInputDialog : (Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   23: putfield line : Ljava/lang/String;
/*     */     //   26: aload_0
/*     */     //   27: getfield line : Ljava/lang/String;
/*     */     //   30: invokevirtual isEmpty : ()Z
/*     */     //   33: ifeq -> 56
/*     */     //   36: aload_0
/*     */     //   37: aload_0
/*     */     //   38: getfield input : I
/*     */     //   41: i2d
/*     */     //   42: ldc2_w 0.2
/*     */     //   45: dmul
/*     */     //   46: invokestatic ceil : (D)D
/*     */     //   49: d2i
/*     */     //   50: putfield sample : I
/*     */     //   53: goto -> 133
/*     */     //   56: aload_0
/*     */     //   57: getfield line : Ljava/lang/String;
/*     */     //   60: ifnull -> 133
/*     */     //   63: aload_0
/*     */     //   64: aload_0
/*     */     //   65: getfield line : Ljava/lang/String;
/*     */     //   68: invokestatic parseInt : (Ljava/lang/String;)I
/*     */     //   71: putfield sample : I
/*     */     //   74: aload_0
/*     */     //   75: getfield sample : I
/*     */     //   78: ifle -> 92
/*     */     //   81: aload_0
/*     */     //   82: getfield sample : I
/*     */     //   85: aload_0
/*     */     //   86: getfield input : I
/*     */     //   89: if_icmplt -> 100
/*     */     //   92: aload_0
/*     */     //   93: aconst_null
/*     */     //   94: putfield line : Ljava/lang/String;
/*     */     //   97: goto -> 133
/*     */     //   100: goto -> 115
/*     */     //   103: astore_2
/*     */     //   104: aconst_null
/*     */     //   105: ldc 'Value must be an integer!'
/*     */     //   107: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;)V
/*     */     //   110: aload_0
/*     */     //   111: aconst_null
/*     */     //   112: putfield line : Ljava/lang/String;
/*     */     //   115: aload_0
/*     */     //   116: getfield sample : I
/*     */     //   119: ifle -> 63
/*     */     //   122: aload_0
/*     */     //   123: getfield sample : I
/*     */     //   126: aload_0
/*     */     //   127: getfield input : I
/*     */     //   130: if_icmpge -> 63
/*     */     //   133: aload_0
/*     */     //   134: getfield line : Ljava/lang/String;
/*     */     //   137: ifnull -> 11
/*     */     //   140: aload_0
/*     */     //   141: getfield sample : I
/*     */     //   144: newarray int
/*     */     //   146: astore_2
/*     */     //   147: aload_0
/*     */     //   148: getfield sample : I
/*     */     //   151: newarray char
/*     */     //   153: astore_3
/*     */     //   154: aload_0
/*     */     //   155: getfield sample : I
/*     */     //   158: newarray int
/*     */     //   160: astore #4
/*     */     //   162: aload_0
/*     */     //   163: aload_0
/*     */     //   164: getfield input : I
/*     */     //   167: aload_0
/*     */     //   168: getfield sample : I
/*     */     //   171: idiv
/*     */     //   172: putfield k : I
/*     */     //   175: getstatic java/lang/System.out : Ljava/io/PrintStream;
/*     */     //   178: new java/lang/StringBuilder
/*     */     //   181: dup
/*     */     //   182: invokespecial <init> : ()V
/*     */     //   185: ldc 'k='
/*     */     //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   190: aload_0
/*     */     //   191: getfield k : I
/*     */     //   194: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   197: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   200: invokevirtual println : (Ljava/lang/String;)V
/*     */     //   203: aload_0
/*     */     //   204: getfield rand : Ljava/util/Random;
/*     */     //   207: aload_0
/*     */     //   208: getfield k : I
/*     */     //   211: iconst_1
/*     */     //   212: iadd
/*     */     //   213: invokevirtual nextInt : (I)I
/*     */     //   216: istore #5
/*     */     //   218: getstatic java/lang/System.out : Ljava/io/PrintStream;
/*     */     //   221: new java/lang/StringBuilder
/*     */     //   224: dup
/*     */     //   225: invokespecial <init> : ()V
/*     */     //   228: ldc 'starting point :'
/*     */     //   230: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   233: iload #5
/*     */     //   235: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   238: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   241: invokevirtual println : (Ljava/lang/String;)V
/*     */     //   244: iconst_0
/*     */     //   245: istore #6
/*     */     //   247: iload #6
/*     */     //   249: aload_0
/*     */     //   250: getfield sample : I
/*     */     //   253: if_icmpge -> 341
/*     */     //   256: aload_0
/*     */     //   257: getfield type : I
/*     */     //   260: iconst_1
/*     */     //   261: if_icmpne -> 301
/*     */     //   264: aload #4
/*     */     //   266: iload #6
/*     */     //   268: iload #5
/*     */     //   270: iload #6
/*     */     //   272: aload_0
/*     */     //   273: getfield k : I
/*     */     //   276: imul
/*     */     //   277: iadd
/*     */     //   278: iastore
/*     */     //   279: aload_2
/*     */     //   280: iload #6
/*     */     //   282: aload_0
/*     */     //   283: getfield intArray : [I
/*     */     //   286: iload #5
/*     */     //   288: iload #6
/*     */     //   290: aload_0
/*     */     //   291: getfield k : I
/*     */     //   294: imul
/*     */     //   295: iadd
/*     */     //   296: iaload
/*     */     //   297: iastore
/*     */     //   298: goto -> 335
/*     */     //   301: aload #4
/*     */     //   303: iload #6
/*     */     //   305: iload #5
/*     */     //   307: iload #6
/*     */     //   309: aload_0
/*     */     //   310: getfield k : I
/*     */     //   313: imul
/*     */     //   314: iadd
/*     */     //   315: iastore
/*     */     //   316: aload_3
/*     */     //   317: iload #6
/*     */     //   319: aload_0
/*     */     //   320: getfield charArray : [C
/*     */     //   323: iload #5
/*     */     //   325: iload #6
/*     */     //   327: aload_0
/*     */     //   328: getfield k : I
/*     */     //   331: imul
/*     */     //   332: iadd
/*     */     //   333: caload
/*     */     //   334: castore
/*     */     //   335: iinc #6, 1
/*     */     //   338: goto -> 247
/*     */     //   341: iconst_0
/*     */     //   342: istore #6
/*     */     //   344: aload_0
/*     */     //   345: getfield type : I
/*     */     //   348: iconst_1
/*     */     //   349: if_icmpne -> 477
/*     */     //   352: aload_2
/*     */     //   353: astore #7
/*     */     //   355: aload #7
/*     */     //   357: arraylength
/*     */     //   358: istore #8
/*     */     //   360: iconst_0
/*     */     //   361: istore #9
/*     */     //   363: iload #9
/*     */     //   365: iload #8
/*     */     //   367: if_icmpge -> 474
/*     */     //   370: aload #7
/*     */     //   372: iload #9
/*     */     //   374: iaload
/*     */     //   375: istore #10
/*     */     //   377: new java/lang/StringBuilder
/*     */     //   380: dup
/*     */     //   381: invokespecial <init> : ()V
/*     */     //   384: aload_0
/*     */     //   385: dup_x1
/*     */     //   386: getfield samItems : Ljava/lang/String;
/*     */     //   389: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   392: ldc '{Item: '
/*     */     //   394: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   397: iload #10
/*     */     //   399: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   402: ldc ' Index: '
/*     */     //   404: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   407: aload #4
/*     */     //   409: iload #6
/*     */     //   411: iaload
/*     */     //   412: iconst_1
/*     */     //   413: iadd
/*     */     //   414: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   417: ldc '}'
/*     */     //   419: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   422: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   425: putfield samItems : Ljava/lang/String;
/*     */     //   428: iload #6
/*     */     //   430: aload_0
/*     */     //   431: getfield sample : I
/*     */     //   434: iconst_1
/*     */     //   435: isub
/*     */     //   436: if_icmpeq -> 465
/*     */     //   439: new java/lang/StringBuilder
/*     */     //   442: dup
/*     */     //   443: invokespecial <init> : ()V
/*     */     //   446: aload_0
/*     */     //   447: dup_x1
/*     */     //   448: getfield samItems : Ljava/lang/String;
/*     */     //   451: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   454: ldc '\\n'
/*     */     //   456: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   459: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   462: putfield samItems : Ljava/lang/String;
/*     */     //   465: iinc #6, 1
/*     */     //   468: iinc #9, 1
/*     */     //   471: goto -> 363
/*     */     //   474: goto -> 599
/*     */     //   477: aload_3
/*     */     //   478: astore #7
/*     */     //   480: aload #7
/*     */     //   482: arraylength
/*     */     //   483: istore #8
/*     */     //   485: iconst_0
/*     */     //   486: istore #9
/*     */     //   488: iload #9
/*     */     //   490: iload #8
/*     */     //   492: if_icmpge -> 599
/*     */     //   495: aload #7
/*     */     //   497: iload #9
/*     */     //   499: caload
/*     */     //   500: istore #10
/*     */     //   502: new java/lang/StringBuilder
/*     */     //   505: dup
/*     */     //   506: invokespecial <init> : ()V
/*     */     //   509: aload_0
/*     */     //   510: dup_x1
/*     */     //   511: getfield samItems : Ljava/lang/String;
/*     */     //   514: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   517: ldc '{Item: '
/*     */     //   519: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   522: iload #10
/*     */     //   524: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   527: ldc ' Index: '
/*     */     //   529: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   532: aload #4
/*     */     //   534: iload #6
/*     */     //   536: iaload
/*     */     //   537: iconst_1
/*     */     //   538: iadd
/*     */     //   539: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   542: ldc '}'
/*     */     //   544: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   547: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   550: putfield samItems : Ljava/lang/String;
/*     */     //   553: iload #6
/*     */     //   555: aload_0
/*     */     //   556: getfield sample : I
/*     */     //   559: iconst_1
/*     */     //   560: isub
/*     */     //   561: if_icmpeq -> 590
/*     */     //   564: new java/lang/StringBuilder
/*     */     //   567: dup
/*     */     //   568: invokespecial <init> : ()V
/*     */     //   571: aload_0
/*     */     //   572: dup_x1
/*     */     //   573: getfield samItems : Ljava/lang/String;
/*     */     //   576: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   579: ldc '\\n'
/*     */     //   581: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   584: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   587: putfield samItems : Ljava/lang/String;
/*     */     //   590: iinc #6, 1
/*     */     //   593: iinc #9, 1
/*     */     //   596: goto -> 488
/*     */     //   599: aload_0
/*     */     //   600: getfield items : Ljavax/swing/JTextArea;
/*     */     //   603: aload_0
/*     */     //   604: getfield samItems : Ljava/lang/String;
/*     */     //   607: invokevirtual setText : (Ljava/lang/String;)V
/*     */     //   610: goto -> 639
/*     */     //   613: aload_1
/*     */     //   614: invokevirtual getSource : ()Ljava/lang/Object;
/*     */     //   617: aload_0
/*     */     //   618: getfield back : Ljavax/swing/JButton;
/*     */     //   621: if_acmpne -> 639
/*     */     //   624: aload_0
/*     */     //   625: getfield sysRand : Ljavax/swing/JFrame;
/*     */     //   628: iconst_0
/*     */     //   629: invokevirtual setVisible : (Z)V
/*     */     //   632: aload_0
/*     */     //   633: getfield sysRand : Ljavax/swing/JFrame;
/*     */     //   636: invokevirtual dispose : ()V
/*     */     //   639: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #148	-> 0
/*     */     //   #150	-> 11
/*     */     //   #151	-> 17
/*     */     //   #152	-> 26
/*     */     //   #153	-> 36
/*     */     //   #156	-> 56
/*     */     //   #159	-> 63
/*     */     //   #160	-> 74
/*     */     //   #161	-> 92
/*     */     //   #162	-> 97
/*     */     //   #167	-> 100
/*     */     //   #164	-> 103
/*     */     //   #165	-> 104
/*     */     //   #166	-> 110
/*     */     //   #168	-> 115
/*     */     //   #170	-> 133
/*     */     //   #172	-> 140
/*     */     //   #173	-> 147
/*     */     //   #174	-> 154
/*     */     //   #176	-> 162
/*     */     //   #178	-> 175
/*     */     //   #180	-> 203
/*     */     //   #181	-> 218
/*     */     //   #183	-> 244
/*     */     //   #184	-> 256
/*     */     //   #185	-> 264
/*     */     //   #186	-> 279
/*     */     //   #189	-> 301
/*     */     //   #190	-> 316
/*     */     //   #183	-> 335
/*     */     //   #193	-> 341
/*     */     //   #194	-> 344
/*     */     //   #195	-> 352
/*     */     //   #196	-> 377
/*     */     //   #197	-> 428
/*     */     //   #198	-> 439
/*     */     //   #199	-> 465
/*     */     //   #195	-> 468
/*     */     //   #203	-> 477
/*     */     //   #204	-> 502
/*     */     //   #205	-> 553
/*     */     //   #206	-> 564
/*     */     //   #207	-> 590
/*     */     //   #203	-> 593
/*     */     //   #211	-> 599
/*     */     //   #212	-> 610
/*     */     //   #213	-> 613
/*     */     //   #214	-> 624
/*     */     //   #215	-> 632
/*     */     //   #217	-> 639
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   104	11	2	ee	Ljava/lang/NumberFormatException;
/*     */     //   247	94	6	i	I
/*     */     //   377	91	10	i	I
/*     */     //   502	91	10	i	C
/*     */     //   147	463	2	sampleArr	[I
/*     */     //   154	456	3	chsampleArr	[C
/*     */     //   162	448	4	index	[I
/*     */     //   218	392	5	startingPoint	I
/*     */     //   344	266	6	j	I
/*     */     //   0	640	0	this	Llab1/Systematic;
/*     */     //   0	640	1	e	Ljava/awt/event/ActionEvent;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   63	97	103	java/lang/NumberFormatException }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab1/Systematic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */