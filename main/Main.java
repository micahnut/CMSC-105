/*     */ package main;
/*     */ 
/*     */ import display.Display;
/*     */ import gfx.Assets;
/*     */ import input.MouseManager;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferStrategy;
/*     */ import state.State;
/*     */ import state.StateManager;
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
/*     */ public class Main
/*     */   implements Runnable
/*     */ {
/*     */   private Display display;
/*     */   private int width;
/*     */   private int height;
/*     */   public String title;
/*     */   private boolean running = false;
/*     */   private Thread thread;
/*     */   private BufferStrategy bs;
/*     */   private Graphics g;
/*     */   public StateManager sm;
/*     */   private MouseManager mouseManager;
/*     */   private Handler handler;
/*     */   
/*     */   public Main(String title, int width, int height) {
/*  36 */     this.width = width;
/*  37 */     this.height = height;
/*  38 */     this.title = title;
/*     */     
/*  40 */     this.mouseManager = new MouseManager();
/*     */   }
/*     */ 
/*     */   
/*     */   private void init() {
/*  45 */     this.display = new Display(this.title, this.width, this.height);
/*  46 */     this.display.getFrame().addMouseListener(this.mouseManager);
/*  47 */     this.display.getFrame().addMouseMotionListener(this.mouseManager);
/*  48 */     this.display.getCanvas().addMouseListener(this.mouseManager);
/*  49 */     this.display.getCanvas().addMouseMotionListener(this.mouseManager);
/*  50 */     Assets.init();
/*     */     
/*  52 */     this.handler = new Handler(this);
/*  53 */     this.sm = new StateManager(this.handler);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  58 */   private void update() { this.sm.update(); }
/*     */ 
/*     */ 
/*     */   
/*     */   private void render() {
/*  63 */     this.bs = this.display.getCanvas().getBufferStrategy();
/*  64 */     if (this.bs == null) {
/*  65 */       this.display.getCanvas().createBufferStrategy(3);
/*     */       
/*     */       return;
/*     */     } 
/*  69 */     this.g = this.bs.getDrawGraphics();
/*     */ 
/*     */     
/*  72 */     this.g.clearRect(0, 0, this.width, this.height);
/*     */     
/*  74 */     this.sm.render(this.g);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     if (State.getState() != null) {
/*  83 */       State.getState().render(this.g);
/*     */     }
/*     */     
/*  86 */     this.bs.show();
/*  87 */     this.g.dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*  93 */     init();
/*     */     
/*  95 */     int fps = 60;
/*     */     
/*  97 */     double timePerTick = (1000000000 / fps);
/*     */ 
/*     */ 
/*     */     
/* 101 */     double delta = 0.0D;
/*     */     
/* 103 */     long lastTime = System.nanoTime();
/* 104 */     long timer = 0L;
/* 105 */     int ticks = 0;
/*     */     
/* 107 */     while (this.running) {
/* 108 */       long now = System.nanoTime();
/* 109 */       delta += (now - lastTime) / timePerTick;
/* 110 */       timer += now - lastTime;
/* 111 */       lastTime = now;
/*     */       
/* 113 */       if (delta >= 1.0D) {
/* 114 */         update();
/* 115 */         render();
/* 116 */         ticks++;
/* 117 */         delta--;
/*     */       } 
/*     */       
/* 120 */       if (timer >= 1000000000L) {
/*     */         
/* 122 */         ticks = 0;
/* 123 */         timer = 0L;
/*     */       } 
/*     */     } 
/*     */     
/* 127 */     stop();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 133 */   public MouseManager getMouseManager() { return this.mouseManager; }
/*     */ 
/*     */ 
/*     */   
/* 137 */   public StateManager getStateManager() { return this.sm; }
/*     */ 
/*     */ 
/*     */   
/* 141 */   public int getWidth() { return this.width; }
/*     */ 
/*     */ 
/*     */   
/* 145 */   public void setWidth(int width) { this.width = width; }
/*     */ 
/*     */ 
/*     */   
/* 149 */   public int getHeight() { return this.height; }
/*     */ 
/*     */ 
/*     */   
/* 153 */   public void setHeight(int height) { this.height = height; }
/*     */ 
/*     */   
/*     */   public void start() {
/* 157 */     if (this.running)
/*     */       return; 
/* 159 */     this.running = true;
/* 160 */     this.thread = new Thread(this);
/* 161 */     this.thread.start();
/*     */   }
/*     */   
/*     */   public void stop() {
/* 165 */     if (!this.running)
/*     */       return; 
/* 167 */     this.running = false;
/*     */     try {
/* 169 */       this.thread.join();
/* 170 */     } catch (InterruptedException e) {
/* 171 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void release() {
/* 177 */     this.display.getFrame().dispose();
/* 178 */     System.exit(0);
/*     */   }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/main/Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.3
 */