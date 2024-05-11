package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.HuiyiyuyueEntity;
import com.entity.view.HuiyiyuyueView;

import com.service.HuiyiyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 会议预约
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-10 09:51:10
 */
@RestController
@RequestMapping("/huiyiyuyue")
public class HuiyiyuyueController {
    @Autowired
    private HuiyiyuyueService huiyiyuyueService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuiyiyuyueEntity huiyiyuyue, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fabuzhe")) {
			huiyiyuyue.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			huiyiyuyue.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuiyiyuyueEntity> ew = new EntityWrapper<HuiyiyuyueEntity>();
		PageUtils page = huiyiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyiyuyue), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuiyiyuyueEntity huiyiyuyue, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fabuzhe")) {
			huiyiyuyue.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			huiyiyuyue.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuiyiyuyueEntity> ew = new EntityWrapper<HuiyiyuyueEntity>();
		PageUtils page = huiyiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyiyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuiyiyuyueEntity huiyiyuyue){
       	EntityWrapper<HuiyiyuyueEntity> ew = new EntityWrapper<HuiyiyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huiyiyuyue, "huiyiyuyue")); 
        return R.ok().put("data", huiyiyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuiyiyuyueEntity huiyiyuyue){
        EntityWrapper< HuiyiyuyueEntity> ew = new EntityWrapper< HuiyiyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huiyiyuyue, "huiyiyuyue")); 
		HuiyiyuyueView huiyiyuyueView =  huiyiyuyueService.selectView(ew);
		return R.ok("查询会议预约成功").put("data", huiyiyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuiyiyuyueEntity huiyiyuyue = huiyiyuyueService.selectById(id);
        return R.ok().put("data", huiyiyuyue);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuiyiyuyueEntity huiyiyuyue = huiyiyuyueService.selectById(id);
        return R.ok().put("data", huiyiyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuiyiyuyueEntity huiyiyuyue, HttpServletRequest request){
    	huiyiyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyiyuyue);

        huiyiyuyueService.insert(huiyiyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuiyiyuyueEntity huiyiyuyue, HttpServletRequest request){
    	huiyiyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyiyuyue);
    	huiyiyuyue.setUserid((Long)request.getSession().getAttribute("userId"));

        huiyiyuyueService.insert(huiyiyuyue);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HuiyiyuyueEntity huiyiyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huiyiyuyue);
        huiyiyuyueService.updateById(huiyiyuyue);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huiyiyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<HuiyiyuyueEntity> wrapper = new EntityWrapper<HuiyiyuyueEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fabuzhe")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = huiyiyuyueService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
