package com.entity.view;

import com.entity.HuiyiyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 会议预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-10 09:51:10
 */
@TableName("huiyiyuyue")
public class HuiyiyuyueView  extends HuiyiyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuiyiyuyueView(){
	}
 
 	public HuiyiyuyueView(HuiyiyuyueEntity huiyiyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, huiyiyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
