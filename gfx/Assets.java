/*    */ package gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ public class Assets
/*    */ {
/*    */   private static final int width = 32;
/*    */   private static final int height = 32;
/*    */   public static BufferedImage[] exit;
/*    */   public static BufferedImage[] controllers;
/*    */   public static BufferedImage[] mainmenu;
/*    */   public static BufferedImage[] back;
/*    */   public static BufferedImage[] data2;
/*    */   public static BufferedImage[] data;
/*    */   public static BufferedImage[] chart;
/*    */   public static BufferedImage[] piechart;
/*    */   public static BufferedImage[] simplerand;
/*    */   public static BufferedImage[] sysrand;
/*    */   public static BufferedImage[] stratrand;
/*    */   public static BufferedImage menu1;
/*    */   public static BufferedImage menu2;
/*    */   public static BufferedImage BS;
/*    */   public static BufferedImage DS;
/*    */   public static BufferedImage SP;
/*    */   
/*    */   public static void init() {
/* 28 */     menusheet = new SpriteSheet(ImageLoader.loadImage("/textures/MainMenu.png"));
/* 29 */     SpriteSheet labactsheet = new SpriteSheet(ImageLoader.loadImage("/textures/Menu.png"));
/* 30 */     SpriteSheet exitsheet = new SpriteSheet(ImageLoader.loadImage("/textures/exit.png"));
/* 31 */     SpriteSheet menuBsheet = new SpriteSheet(ImageLoader.loadImage("/textures/menub.png"));
/* 32 */     SpriteSheet controller = new SpriteSheet(ImageLoader.loadImage("/textures/controllers.png"));
/* 33 */     SpriteSheet BSsheet = new SpriteSheet(ImageLoader.loadImage("/textures/BasicSampling.png"));
/* 34 */     SpriteSheet DSsheet = new SpriteSheet(ImageLoader.loadImage("/textures/Descriptive Statistics.png"));
/* 35 */     SpriteSheet SPsheet = new SpriteSheet(ImageLoader.loadImage("/textures/Summarizing.png"));
/* 36 */     SpriteSheet backsheet = new SpriteSheet(ImageLoader.loadImage("/textures/arrow.png"));
/* 37 */     SpriteSheet boxsheet = new SpriteSheet(ImageLoader.loadImage("/textures/boxfiles.png"));
/* 38 */     SpriteSheet chartsheet = new SpriteSheet(ImageLoader.loadImage("/textures/charttrend.png"));
/* 39 */     SpriteSheet SRsheet = new SpriteSheet(ImageLoader.loadImage("/textures/simplerandom.png"));
/* 40 */     SpriteSheet STRsheet = new SpriteSheet(ImageLoader.loadImage("/textures/stratified.png"));
/* 41 */     SpriteSheet SYRsheet = new SpriteSheet(ImageLoader.loadImage("/textures/systematic.png"));
/* 42 */     SpriteSheet piesheet = new SpriteSheet(ImageLoader.loadImage("/textures/pie.png"));
/* 43 */     SpriteSheet pie2sheet = new SpriteSheet(ImageLoader.loadImage("/textures/pie2.png"));
/* 44 */     SpriteSheet graphsheet = new SpriteSheet(ImageLoader.loadImage("/textures/timeline.png"));
/* 45 */     SpriteSheet graph2sheet = new SpriteSheet(ImageLoader.loadImage("/textures/timeline2.png"));
/*    */ 
/*    */     
/* 48 */     menu1 = menusheet.crop(0, 0, 450, 450);
/* 49 */     exit = new BufferedImage[2];
/* 50 */     exit[0] = exitsheet.crop(0, 0, 64, 64);
/* 51 */     exit[1] = exitsheet.crop(64, 64, 64, 64);
/*    */     
/* 53 */     mainmenu = new BufferedImage[2];
/* 54 */     mainmenu[0] = menuBsheet.crop(0, 0, 64, 64);
/* 55 */     mainmenu[1] = menuBsheet.crop(64, 64, 64, 64);
/*    */     
/* 57 */     controllers = new BufferedImage[2];
/* 58 */     controllers[0] = controller.crop(64, 64, 64, 64);
/* 59 */     controllers[1] = controller.crop(0, 0, 64, 64);
/*    */     
/* 61 */     menu2 = labactsheet.crop(0, 0, 450, 450);
/* 62 */     BS = BSsheet.crop(0, 0, 450, 450);
/* 63 */     DS = DSsheet.crop(0, 0, 450, 450);
/* 64 */     SP = SPsheet.crop(0, 0, 450, 450);
/*    */     
/* 66 */     back = new BufferedImage[2];
/* 67 */     back[0] = backsheet.crop(0, 0, 64, 64);
/* 68 */     back[1] = backsheet.crop(64, 64, 64, 64);
/*    */     
/* 70 */     data = new BufferedImage[2];
/* 71 */     data[0] = boxsheet.crop(0, 0, 64, 64);
/* 72 */     data[1] = boxsheet.crop(64, 64, 64, 64);
/*    */     
/* 74 */     data2 = new BufferedImage[2];
/* 75 */     data2[0] = graphsheet.crop(0, 0, 1600, 1600);
/* 76 */     data2[1] = graph2sheet.crop(0, 0, 1600, 1600);
/*    */     
/* 78 */     chart = new BufferedImage[2];
/* 79 */     chart[0] = chartsheet.crop(0, 0, 64, 64);
/* 80 */     chart[1] = chartsheet.crop(64, 64, 64, 64);
/*    */     
/* 82 */     simplerand = new BufferedImage[2];
/* 83 */     simplerand[0] = SRsheet.crop(0, 0, 96, 64);
/* 84 */     simplerand[1] = SRsheet.crop(96, 64, 96, 64);
/*    */     
/* 86 */     sysrand = new BufferedImage[2];
/* 87 */     sysrand[0] = SYRsheet.crop(0, 0, 96, 64);
/* 88 */     sysrand[1] = SYRsheet.crop(96, 64, 96, 64);
/*    */     
/* 90 */     stratrand = new BufferedImage[2];
/* 91 */     stratrand[0] = STRsheet.crop(0, 0, 96, 64);
/* 92 */     stratrand[1] = STRsheet.crop(96, 64, 96, 64);
/*    */     
/* 94 */     piechart = new BufferedImage[2];
/* 95 */     piechart[0] = piesheet.crop(0, 0, 512, 512);
/* 96 */     piechart[1] = pie2sheet.crop(0, 0, 512, 512);
/*    */   }
/*    */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/gfx/Assets.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */