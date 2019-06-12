/*     */ package org.jfree.data.gantt;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.jfree.chart.util.ParamChecks;
/*     */ import org.jfree.data.time.SimpleTimePeriod;
/*     */ import org.jfree.data.time.TimePeriod;
/*     */ import org.jfree.util.ObjectUtilities;
/*     */ import org.jfree.util.PublicCloneable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Task
/*     */   implements Cloneable, PublicCloneable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1094303785346988894L;
/*     */   private String description;
/*     */   private TimePeriod duration;
/*     */   private Double percentComplete;
/*     */   private List subtasks;
/*     */   
/*     */   public Task(String description, TimePeriod duration) {
/*  86 */     ParamChecks.nullNotPermitted(description, "description");
/*  87 */     this.description = description;
/*  88 */     this.duration = duration;
/*  89 */     this.percentComplete = null;
/*  90 */     this.subtasks = new ArrayList();
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
/* 102 */   public Task(String description, Date start, Date end) { this(description, new SimpleTimePeriod(start, end)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   public String getDescription() { return this.description; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String description) {
/* 120 */     ParamChecks.nullNotPermitted(description, "description");
/* 121 */     this.description = description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   public TimePeriod getDuration() { return this.duration; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 139 */   public void setDuration(TimePeriod duration) { this.duration = duration; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 148 */   public Double getPercentComplete() { return this.percentComplete; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   public void setPercentComplete(Double percent) { this.percentComplete = percent; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 166 */   public void setPercentComplete(double percent) { setPercentComplete(new Double(percent)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSubtask(Task subtask) {
/* 175 */     ParamChecks.nullNotPermitted(subtask, "subtask");
/* 176 */     this.subtasks.add(subtask);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 185 */   public void removeSubtask(Task subtask) { this.subtasks.remove(subtask); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 194 */   public int getSubtaskCount() { return this.subtasks.size(); }
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
/* 205 */   public Task getSubtask(int index) { return (Task)this.subtasks.get(index); }
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
/*     */   public boolean equals(Object object) {
/* 217 */     if (object == this) {
/* 218 */       return true;
/*     */     }
/* 220 */     if (!(object instanceof Task)) {
/* 221 */       return false;
/*     */     }
/* 223 */     Task that = (Task)object;
/* 224 */     if (!ObjectUtilities.equal(this.description, that.description)) {
/* 225 */       return false;
/*     */     }
/* 227 */     if (!ObjectUtilities.equal(this.duration, that.duration)) {
/* 228 */       return false;
/*     */     }
/* 230 */     if (!ObjectUtilities.equal(this.percentComplete, that.percentComplete))
/*     */     {
/* 232 */       return false;
/*     */     }
/* 234 */     if (!ObjectUtilities.equal(this.subtasks, that.subtasks)) {
/* 235 */       return false;
/*     */     }
/* 237 */     return true;
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
/* 250 */   public Object clone() throws CloneNotSupportedException { return (Task)super.clone(); }
/*     */ }


/* Location:              /Users/micahnut/Downloads/MiniSP.jar!/org/jfree/data/gantt/Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.3
 */