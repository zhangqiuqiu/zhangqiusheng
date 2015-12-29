package com.ly.controller;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.ehcache.CacheName;
import com.jfinal.plugin.ehcache.EvictInterceptor;
import com.ly.model.ZhaoPin;

public class ZhaoPinController extends Controller {

	/*
	 * public void showList1(){ render("index.jsp"); }
	 */
	/*
	 * public void showList(){
	 * 
	 * render("job_info.jsp"); }
	 */
	/*
	 * 查询显示
	 */
	/*@Before(CacheInterceptor.class)
	@CacheName("li")*/
	public void showList() {
		System.out.println("122");
		List<ZhaoPin> list = ZhaoPin.zhaopin.showList1();
		System.out.println(list.toString());
		//System.out.println(list.get(0).getStr("office"));
		setAttr("list", list);
		render("job_info.jsp");
	}

	/*
	 * @Before(CacheInterceptor.class)
	 * 
	 * @CacheName("li") public void showList() { List<ZhaoPin> list =
	 * CacheKit.get("job_info_zhangqiusheng1", "list", new IDataLoader() {
	 * public Object load() { return ZhaoPin.zhaopin.find(
	 * "select * from job_info_zhangqiusheng1"); } }); setAttr("list", list);
	 * render("job_info.jsp"); }
	 */
	/*
	 * @Before(CacheInterceptor.class)
	 * 
	 * @CacheName("list") public void list() { List<ZhaoPin> list =
	 * ZhaoPin.zhaopin.find("select * from job_info_zhangqiusheng1");
	 * setAttr("list", list); render("job_info.jsp"); }
	 */

	@Before(EvictInterceptor.class)
	@CacheName("li")
	public void update() {
		getModel(ZhaoPin.class).update();
		redirect("job_info.jsp");
	}

	/*
	 * 增加
	 */
	@Before(EvictInterceptor.class)
	@CacheName("li")
	public void showEdit() {

		render("job_info_eidt.jsp");
	}

	@Before(EvictInterceptor.class)
	@CacheName("li")
	public void saveJobInfo() {
		ZhaoPin news = this.getModel(ZhaoPin.class);
		ZhaoPin.zhaopin.saveJobInfo(news);
		redirect("/zhaopin/showList");
	}

	/*
	 * 发布
	 */
	@Before(EvictInterceptor.class)
	@CacheName("li")
	public void releaseJobInfo() {
		Integer id = this.getParaToInt("id");
		if (ZhaoPin.zhaopin.updateRelateDate(id)) {
			/* renderText("发布成功"); */
			redirect("/zhaopin/showList");
		} else {
			/* renderText("发布失败"); */
			redirect("/zhaopin/showList");
		}
	}

	/*
	 * 编辑
	 */
	public void showUpdate() {
		render("index.jsp");
	}

	private void redire() {
		// TODO Auto-generated method stub

	}

	/*
	 * 删除
	 */
	@Before(EvictInterceptor.class)
	@CacheName("li")
	public void DeleteJobInfo() {
		Integer id = this.getParaToInt("id");
		if (ZhaoPin.zhaopin.deleteJobInfo(id)) {
			/* renderText("删除成功"); */
			redirect("/zhaopin/showList");
		} else {
			renderText("删除失败");
		}
	}

}
