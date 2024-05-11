package com.entity.view;

import com.entity.FabuhuiyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 发布会议
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-10 09:51:10
 */
@TableName("fabuhuiyi")
public class FabuhuiyiView  extends FabuhuiyiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FabuhuiyiView(){
	}
 
 	public FabuhuiyiView(FabuhuiyiEntity fabuhuiyiEntity){
 	try {
			BeanUtils.copyProperties(this, fabuhuiyiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
