package com.ly.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.ly.model.ZhaoPin;

public class ZhaoPinController extends Controller {

	/*public void showList1(){
		render("index.jsp");	
	}*/
/*	public void showList(){
		
		render("job_info.jsp");
	}*/
	/*
	 * 查询显示
	 */
	public void showList(){
		 List<ZhaoPin> list=ZhaoPin.zhaopin.showList1();
		 System.out.println(list.get(0).getStr("office"));
		 setAttr("list", list);
		  render("job_info.jsp");
	   }
	/*
	 * 增加
	 */
	   public void showEdit(){ 
		  
		   render("job_info_eidt.jsp");
	   }
	   public void saveJobInfo(){
		   ZhaoPin news=this.getModel(ZhaoPin.class);
		   ZhaoPin.zhaopin.saveJobInfo(news);
		   redirect("/zhaopin/showList");
	   }
	   /*
	    * 发布
	    */
	   public void releaseJobInfo(){
		   Integer id=this.getParaToInt("id");
		   if(ZhaoPin.zhaopin.updateRelateDate(id)){
			   /*renderText("发布成功");*/
			   redirect("/zhaopin/showList");
		   }else{
			  /* renderText("发布失败");*/
			   redirect("/zhaopin/showList");
		   }
	   }
	   /*
	    * 删除
	    */
	public void DeleteJobInfo(){
		   Integer id=this.getParaToInt("id");
		   if(ZhaoPin.zhaopin.deleteJobInfo(id)){
			  /* renderText("删除成功");*/
			   redirect("/zhaopin/showList");
		   }else{
			   renderText("删除失败");
		   }
	}
}
