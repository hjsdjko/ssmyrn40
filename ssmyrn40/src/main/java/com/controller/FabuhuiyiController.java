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

import com.entity.FabuhuiyiEntity;
import com.entity.view.FabuhuiyiView;

import com.service.FabuhuiyiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 发布会议
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-10 09:51:10
 */
@RestController
@RequestMapping("/fabuhuiyi")
public class FabuhuiyiController {
    @Autowired
    private FabuhuiyiService fabuhuiyiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FabuhuiyiEntity fabuhuiyi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fabuzhe")) {
			fabuhuiyi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FabuhuiyiEntity> ew = new EntityWrapper<FabuhuiyiEntity>();
		PageUtils page = fabuhuiyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fabuhuiyi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FabuhuiyiEntity fabuhuiyi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fabuzhe")) {
			fabuhuiyi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FabuhuiyiEntity> ew = new EntityWrapper<FabuhuiyiEntity>();
		PageUtils page = fabuhuiyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fabuhuiyi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FabuhuiyiEntity fabuhuiyi){
       	EntityWrapper<FabuhuiyiEntity> ew = new EntityWrapper<FabuhuiyiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fabuhuiyi, "fabuhuiyi")); 
        return R.ok().put("data", fabuhuiyiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FabuhuiyiEntity fabuhuiyi){
        EntityWrapper< FabuhuiyiEntity> ew = new EntityWrapper< FabuhuiyiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fabuhuiyi, "fabuhuiyi")); 
		FabuhuiyiView fabuhuiyiView =  fabuhuiyiService.selectView(ew);
		return R.ok("查询发布会议成功").put("data", fabuhuiyiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FabuhuiyiEntity fabuhuiyi = fabuhuiyiService.selectById(id);
		fabuhuiyi.setClicknum(fabuhuiyi.getClicknum()+1);
		fabuhuiyi.setClicktime(new Date());
		fabuhuiyiService.updateById(fabuhuiyi);
        return R.ok().put("data", fabuhuiyi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FabuhuiyiEntity fabuhuiyi = fabuhuiyiService.selectById(id);
		fabuhuiyi.setClicknum(fabuhuiyi.getClicknum()+1);
		fabuhuiyi.setClicktime(new Date());
		fabuhuiyiService.updateById(fabuhuiyi);
        return R.ok().put("data", fabuhuiyi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FabuhuiyiEntity fabuhuiyi, HttpServletRequest request){
    	fabuhuiyi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fabuhuiyi);

        fabuhuiyiService.insert(fabuhuiyi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FabuhuiyiEntity fabuhuiyi, HttpServletRequest request){
    	fabuhuiyi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fabuhuiyi);
    	fabuhuiyi.setUserid((Long)request.getSession().getAttribute("userId"));

        fabuhuiyiService.insert(fabuhuiyi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FabuhuiyiEntity fabuhuiyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fabuhuiyi);
        fabuhuiyiService.updateById(fabuhuiyi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fabuhuiyiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<FabuhuiyiEntity> wrapper = new EntityWrapper<FabuhuiyiEntity>();
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

		int count = fabuhuiyiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,FabuhuiyiEntity fabuhuiyi, HttpServletRequest request,String pre){
        EntityWrapper<FabuhuiyiEntity> ew = new EntityWrapper<FabuhuiyiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = fabuhuiyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fabuhuiyi), params), params));
        return R.ok().put("data", page);
    }


}
