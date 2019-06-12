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
/*     */ public class Simple extends JFrame implements ActionListener {
/*  17 */   JFrame simpleRand = new JFrame("Simple Random"); Random rand;
/*  18 */   JTextArea sframe = new JTextArea();
/*  19 */   JTextArea items = new JTextArea();
/*  20 */   JButton start = new JButton("Start"); JButton back = new JButton("Back"); JScrollPane scrollup;
/*     */   JScrollPane scrolldown;
/*  22 */   JPanel button = new JPanel();
/*     */   String line;
/*  24 */   String samFrame = "Sampling Frame = "; String samItems = "Sample = ";
/*     */   int[] intArray;
/*     */   char[] charArray;
/*  27 */   int k = 0, sample = 0, input = 0, random = 0, type = 1;
/*     */   
/*     */   public Simple() {
/*  30 */     this.rand = new Random();
/*     */     
/*  32 */     this.items.setEditable(false);
/*  33 */     this.items.setLineWrap(true);
/*  34 */     this.sframe.setEditable(false);
/*  35 */     this.sframe.setLineWrap(true);
/*     */     
/*  37 */     this.button.setLayout(new GridLayout(true, 2));
/*  38 */     this.button.add(this.start);
/*  39 */     this.button.add(this.back);
/*     */     
/*  41 */     this.scrollup = new JScrollPane(this.sframe, 20, 31);
/*  42 */     this.scrolldown = new JScrollPane(this.items, 20, 31);
/*     */     
/*  44 */     this.simpleRand.add(this.scrollup);
/*  45 */     this.simpleRand.add(this.scrolldown);
/*  46 */     this.simpleRand.add(this.button);
/*     */     
/*  48 */     this.start.addActionListener(this);
/*  49 */     this.back.addActionListener(this);
/*     */     
/*  51 */     this.simpleRand.setSize(400, 400);
/*  52 */     this.simpleRand.setVisible(true);
/*  53 */     this.simpleRand.setLocationRelativeTo(null);
/*  54 */     this.simpleRand.setLayout(new GridLayout(3, true));
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/*  59 */       pop = JOptionPane.showInputDialog("Enter size of population:");
/*  60 */       if (pop == null)
/*     */         continue;  try {
/*  62 */         this.input = Integer.parseInt(pop);
/*  63 */       } catch (NumberFormatException e) {
/*  64 */         JOptionPane.showMessageDialog(null, "Value must be an integer!");
/*  65 */         pop = null;
/*     */       }
/*     */     
/*  68 */     } while (pop == null || this.input < 25);
/*     */     
/*     */     do {
/*     */       String in;
/*     */       
/*  73 */       in = JOptionPane.showInputDialog("Choose a type( < 1 > for numbers and < 2 > for characters ): ");
/*  74 */       if (in == null)
/*     */         continue;  try {
/*  76 */         this.type = Integer.parseInt(in);
/*  77 */       } catch (NumberFormatException e) {
/*  78 */         JOptionPane.showMessageDialog(null, "Value must be an integer!");
/*  79 */         in = null;
/*     */       }
/*     */     
/*  82 */     } while (in == null || 
/*  83 */       this.type < 0 || this.type > 2);
/*     */     
/*  85 */     this.input = Integer.parseInt(pop);
/*     */     
/*  87 */     if (this.type == 1) {
/*  88 */       this.intArray = new int[this.input];
/*     */     } else {
/*     */       
/*  91 */       this.charArray = new char[this.input];
/*     */     } 
/*     */     
/*  94 */     for (int i = this.input, j = 0; i > 0; i--, j++) {
/*     */       String samp;
/*     */       do {
/*  97 */         samp = JOptionPane.showInputDialog("Enter items (" + i + " left):");
/*  98 */         if (samp == null)
/*     */           continue;  try {
/* 100 */           if (this.type == 1) {
/* 101 */             this.intArray[j] = Integer.parseInt(samp);
/*     */           }
/* 103 */         } catch (NumberFormatException e) {
/* 104 */           JOptionPane.showMessageDialog(null, "Value must be an integer!");
/* 105 */           samp = null;
/*     */         }
/*     */       
/* 108 */       } while (samp == null);
/*     */       
/* 110 */       if (this.type == 2) {
/* 111 */         this.charArray[j] = samp.charAt(0);
/*     */       }
/*     */     } 
/*     */     
/* 115 */     for (int i = 0; i < this.input; i++) {
/* 116 */       if (this.type == 1) {
/* 117 */         this.samFrame += "{Item: " + this.intArray[i] + " Index: " + (i + 1) + "}";
/*     */       } else {
/*     */         
/* 120 */         this.samFrame += "{Item: " + this.charArray[i] + " Index: " + (i + 1) + "}";
/*     */       } 
/* 122 */       if (i != this.input - 1) {
/* 123 */         this.samFrame += "\n";
/*     */       }
/*     */     } 
/* 126 */     this.sframe.setText(this.samFrame);
/*     */     
/* 128 */     this.simpleRand.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent we) {
/* 131 */             Simple.this.simpleRand.setVisible(false);
/* 132 */             Simple.this.simpleRand.dispose();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/* 138 */   public int randInt(int min, int max) { return this.rand.nextInt(max - min + 1) + min; }
/*     */   
/*     */   public void actionPerformed(ActionEvent e) { // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokevirtual getSource : ()Ljava/lang/Object;
/*     */     //   4: aload_0
/*     */     //   5: getfield start : Ljavax/swing/JButton;
/*     */     //   8: if_acmpne -> 596
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
/*     */     //   53: goto -> 140
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
/*     */     //   162: iconst_0
/*     */     //   163: istore #5
/*     */     //   165: iload #5
/*     */     //   167: aload_0
/*     */     //   168: getfield sample : I
/*     */     //   171: if_icmpge -> 324
/*     */     //   174: aload_0
/*     */     //   175: getfield type : I
/*     */     //   178: iconst_1
/*     */     //   179: if_icmpne -> 253
/*     */     //   182: aload_0
/*     */     //   183: aload_0
/*     */     //   184: iconst_1
/*     */     //   185: aload_0
/*     */     //   186: getfield input : I
/*     */     //   189: invokevirtual randInt : (II)I
/*     */     //   192: putfield random : I
/*     */     //   195: aload_0
/*     */     //   196: getfield intArray : [I
/*     */     //   199: aload_0
/*     */     //   200: getfield random : I
/*     */     //   203: iconst_1
/*     */     //   204: isub
/*     */     //   205: iaload
/*     */     //   206: bipush #-105
/*     */     //   208: if_icmpeq -> 182
/*     */     //   211: aload #4
/*     */     //   213: iload #5
/*     */     //   215: aload_0
/*     */     //   216: getfield random : I
/*     */     //   219: iconst_1
/*     */     //   220: isub
/*     */     //   221: iastore
/*     */     //   222: aload_2
/*     */     //   223: iload #5
/*     */     //   225: aload_0
/*     */     //   226: getfield intArray : [I
/*     */     //   229: aload_0
/*     */     //   230: getfield random : I
/*     */     //   233: iconst_1
/*     */     //   234: isub
/*     */     //   235: iaload
/*     */     //   236: iastore
/*     */     //   237: aload_0
/*     */     //   238: getfield intArray : [I
/*     */     //   241: aload_0
/*     */     //   242: getfield random : I
/*     */     //   245: iconst_1
/*     */     //   246: isub
/*     */     //   247: bipush #-105
/*     */     //   249: iastore
/*     */     //   250: goto -> 318
/*     */     //   253: aload_0
/*     */     //   254: aload_0
/*     */     //   255: iconst_1
/*     */     //   256: aload_0
/*     */     //   257: getfield input : I
/*     */     //   260: invokevirtual randInt : (II)I
/*     */     //   263: putfield random : I
/*     */     //   266: aload_0
/*     */     //   267: getfield charArray : [C
/*     */     //   270: aload_0
/*     */     //   271: getfield random : I
/*     */     //   274: iconst_1
/*     */     //   275: isub
/*     */     //   276: caload
/*     */     //   277: ifeq -> 253
/*     */     //   280: aload #4
/*     */     //   282: iload #5
/*     */     //   284: aload_0
/*     */     //   285: getfield random : I
/*     */     //   288: iconst_1
/*     */     //   289: isub
/*     */     //   290: iastore
/*     */     //   291: aload_3
/*     */     //   292: iload #5
/*     */     //   294: aload_0
/*     */     //   295: getfield charArray : [C
/*     */     //   298: aload_0
/*     */     //   299: getfield random : I
/*     */     //   302: iconst_1
/*     */     //   303: isub
/*     */     //   304: caload
/*     */     //   305: castore
/*     */     //   306: aload_0
/*     */     //   307: getfield charArray : [C
/*     */     //   310: aload_0
/*     */     //   311: getfield random : I
/*     */     //   314: iconst_1
/*     */     //   315: isub
/*     */     //   316: iconst_0
/*     */     //   317: castore
/*     */     //   318: iinc #5, 1
/*     */     //   321: goto -> 165
/*     */     //   324: iconst_0
/*     */     //   325: istore #5
/*     */     //   327: aload_0
/*     */     //   328: getfield type : I
/*     */     //   331: iconst_1
/*     */     //   332: if_icmpne -> 460
/*     */     //   335: aload_2
/*     */     //   336: astore #6
/*     */     //   338: aload #6
/*     */     //   340: arraylength
/*     */     //   341: istore #7
/*     */     //   343: iconst_0
/*     */     //   344: istore #8
/*     */     //   346: iload #8
/*     */     //   348: iload #7
/*     */     //   350: if_icmpge -> 457
/*     */     //   353: aload #6
/*     */     //   355: iload #8
/*     */     //   357: iaload
/*     */     //   358: istore #9
/*     */     //   360: new java/lang/StringBuilder
/*     */     //   363: dup
/*     */     //   364: invokespecial <init> : ()V
/*     */     //   367: aload_0
/*     */     //   368: dup_x1
/*     */     //   369: getfield samItems : Ljava/lang/String;
/*     */     //   372: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   375: ldc '{Item: '
/*     */     //   377: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   380: iload #9
/*     */     //   382: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   385: ldc ' Index: '
/*     */     //   387: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   390: aload #4
/*     */     //   392: iload #5
/*     */     //   394: iaload
/*     */     //   395: iconst_1
/*     */     //   396: iadd
/*     */     //   397: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   400: ldc '}'
/*     */     //   402: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   405: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   408: putfield samItems : Ljava/lang/String;
/*     */     //   411: iload #5
/*     */     //   413: aload_0
/*     */     //   414: getfield sample : I
/*     */     //   417: iconst_1
/*     */     //   418: isub
/*     */     //   419: if_icmpeq -> 448
/*     */     //   422: new java/lang/StringBuilder
/*     */     //   425: dup
/*     */     //   426: invokespecial <init> : ()V
/*     */     //   429: aload_0
/*     */     //   430: dup_x1
/*     */     //   431: getfield samItems : Ljava/lang/String;
/*     */     //   434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   437: ldc '\\n'
/*     */     //   439: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   442: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   445: putfield samItems : Ljava/lang/String;
/*     */     //   448: iinc #5, 1
/*     */     //   451: iinc #8, 1
/*     */     //   454: goto -> 346
/*     */     //   457: goto -> 582
/*     */     //   460: aload_3
/*     */     //   461: astore #6
/*     */     //   463: aload #6
/*     */     //   465: arraylength
/*     */     //   466: istore #7
/*     */     //   468: iconst_0
/*     */     //   469: istore #8
/*     */     //   471: iload #8
/*     */     //   473: iload #7
/*     */     //   475: if_icmpge -> 582
/*     */     //   478: aload #6
/*     */     //   480: iload #8
/*     */     //   482: caload
/*     */     //   483: istore #9
/*     */     //   485: new java/lang/StringBuilder
/*     */     //   488: dup
/*     */     //   489: invokespecial <init> : ()V
/*     */     //   492: aload_0
/*     */     //   493: dup_x1
/*     */     //   494: getfield samItems : Ljava/lang/String;
/*     */     //   497: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   500: ldc '{Item: '
/*     */     //   502: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   505: iload #9
/*     */     //   507: invokevirtual append : (C)Ljava/lang/StringBuilder;
/*     */     //   510: ldc ' Index: '
/*     */     //   512: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   515: aload #4
/*     */     //   517: iload #5
/*     */     //   519: iaload
/*     */     //   520: iconst_1
/*     */     //   521: iadd
/*     */     //   522: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   525: ldc '}'
/*     */     //   527: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   530: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   533: putfield samItems : Ljava/lang/String;
/*     */     //   536: iload #5
/*     */     //   538: aload_0
/*     */     //   539: getfield sample : I
/*     */     //   542: iconst_1
/*     */     //   543: isub
/*     */     //   544: if_icmpeq -> 573
/*     */     //   547: new java/lang/StringBuilder
/*     */     //   550: dup
/*     */     //   551: invokespecial <init> : ()V
/*     */     //   554: aload_0
/*     */     //   555: dup_x1
/*     */     //   556: getfield samItems : Ljava/lang/String;
/*     */     //   559: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   562: ldc '\\n'
/*     */     //   564: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   567: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   570: putfield samItems : Ljava/lang/String;
/*     */     //   573: iinc #5, 1
/*     */     //   576: iinc #8, 1
/*     */     //   579: goto -> 471
/*     */     //   582: aload_0
/*     */     //   583: getfield items : Ljavax/swing/JTextArea;
/*     */     //   586: aload_0
/*     */     //   587: getfield samItems : Ljava/lang/String;
/*     */     //   590: invokevirtual setText : (Ljava/lang/String;)V
/*     */     //   593: goto -> 622
/*     */     //   596: aload_1
/*     */     //   597: invokevirtual getSource : ()Ljava/lang/Object;
/*     */     //   600: aload_0
/*     */     //   601: getfield back : Ljavax/swing/JButton;
/*     */     //   604: if_acmpne -> 622
/*     */     //   607: aload_0
/*     */     //   608: getfield simpleRand : Ljavax/swing/JFrame;
/*     */     //   611: iconst_0
/*     */     //   612: invokevirtual setVisible : (Z)V
/*     */     //   615: aload_0
/*     */     //   616: getfield simpleRand : Ljavax/swing/JFrame;
/*     */     //   619: invokevirtual dispose : ()V
/*     */     //   622: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #144	-> 0
/*     */     //   #146	-> 11
/*     */     //   #147	-> 17
/*     */     //   #148	-> 26
/*     */     //   #149	-> 36
/*     */     //   #150	-> 53
/*     */     //   #152	-> 56
/*     */     //   #155	-> 63
/*     */     //   #156	-> 74
/*     */     //   #157	-> 92
/*     */     //   #158	-> 97
/*     */     //   #163	-> 100
/*     */     //   #160	-> 103
/*     */     //   #161	-> 104
/*     */     //   #162	-> 110
/*     */     //   #164	-> 115
/*     */     //   #166	-> 133
/*     */     //   #168	-> 140
/*     */     //   #169	-> 147
/*     */     //   #170	-> 154
/*     */     //   #172	-> 162
/*     */     //   #173	-> 174
/*     */     //   #175	-> 182
/*     */     //   #176	-> 195
/*     */     //   #177	-> 211
/*     */     //   #178	-> 222
/*     */     //   #179	-> 237
/*     */     //   #183	-> 253
/*     */     //   #184	-> 266
/*     */     //   #185	-> 280
/*     */     //   #186	-> 291
/*     */     //   #187	-> 306
/*     */     //   #172	-> 318
/*     */     //   #190	-> 324
/*     */     //   #191	-> 327
/*     */     //   #192	-> 335
/*     */     //   #193	-> 360
/*     */     //   #194	-> 411
/*     */     //   #195	-> 422
/*     */     //   #196	-> 448
/*     */     //   #192	-> 451
/*     */     //   #200	-> 460
/*     */     //   #201	-> 485
/*     */     //   #202	-> 536
/*     */     //   #203	-> 547
/*     */     //   #204	-> 573
/*     */     //   #200	-> 576
/*     */     //   #208	-> 582
/*     */     //   #209	-> 593
/*     */     //   #210	-> 596
/*     */     //   #211	-> 607
/*     */     //   #212	-> 615
/*     */     //   #214	-> 622
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   104	11	2	ee	Ljava/lang/NumberFormatException;
/*     */     //   165	159	5	i	I
/*     */     //   360	91	9	i	I
/*     */     //   485	91	9	i	C
/*     */     //   147	446	2	sampleArr	[I
/*     */     //   154	439	3	chsampleArr	[C
/*     */     //   162	431	4	index	[I
/*     */     //   327	266	5	j	I
/*     */     //   0	623	0	this	Llab1/Simple;
/*     */     //   0	623	1	e	Ljava/awt/event/ActionEvent;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   63	97	103	java/lang/NumberFormatException }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/lab1/Simple.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */