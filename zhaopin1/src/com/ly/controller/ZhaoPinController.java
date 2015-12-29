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
	 * ��ѯ��ʾ
	 */
	public void showList(){
		 List<ZhaoPin> list=ZhaoPin.zhaopin.showList1();
		 System.out.println(list.get(0).getStr("office"));
		 setAttr("list", list);
		  render("job_info.jsp");
	   }
	/*
	 * ����
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
	    * ����
	    */
	   public void releaseJobInfo(){
		   Integer id=this.getParaToInt("id");
		   if(ZhaoPin.zhaopin.updateRelateDate(id)){
			   /*renderText("�����ɹ�");*/
			   redirect("/zhaopin/showList");
		   }else{
			  /* renderText("����ʧ��");*/
			   redirect("/zhaopin/showList");
		   }
	   }
	   /*
	    * ɾ��
	    */
	public void DeleteJobInfo(){
		   Integer id=this.getParaToInt("id");
		   if(ZhaoPin.zhaopin.deleteJobInfo(id)){
			  /* renderText("ɾ���ɹ�");*/
			   redirect("/zhaopin/showList");
		   }else{
			   renderText("ɾ��ʧ��");
		   }
	}
}
