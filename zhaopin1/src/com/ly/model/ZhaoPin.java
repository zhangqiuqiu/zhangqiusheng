package com.ly.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jfinal.plugin.activerecord.Model;
@SuppressWarnings("serial")
public class ZhaoPin extends Model<ZhaoPin> {
	public static final ZhaoPin zhaopin=new ZhaoPin();
	/*
	 * 显示
	 */
	public List<ZhaoPin> showList1(){
		List<ZhaoPin> news = zhaopin.find("SELECT*FROM job_info_zhangqiusheng1");
		return news;
	}
	public boolean saveJobInfo(ZhaoPin news){
		   

		return news.set("createTime",getDate()).set("state", 0).save();
    	
    }
	/*
	 * 更新
	 */
	public boolean updateRelateDate(Integer id){
   	 
		return zhaopin.set("releasedate", getDate()).set("state", 1).set("id", id).update();
    	
    }
	/*
	 * 删除
	 */
    public boolean deleteJobInfo(Integer id){
   	 
		return zhaopin.deleteById(id);
    	
    }
    /*
     * 设置日期
     */
    public Date getDate(){
    	Date now = new Date(); 
    	Date time=null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			time=dateFormat.parse(dateFormat.format(now));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
    }
}
