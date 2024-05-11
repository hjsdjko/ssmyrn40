package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FabuhuiyiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FabuhuiyiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FabuhuiyiView;


/**
 * 发布会议
 *
 * @author 
 * @email 
 * @date 2021-05-10 09:51:10
 */
public interface FabuhuiyiService extends IService<FabuhuiyiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FabuhuiyiVO> selectListVO(Wrapper<FabuhuiyiEntity> wrapper);
   	
   	FabuhuiyiVO selectVO(@Param("ew") Wrapper<FabuhuiyiEntity> wrapper);
   	
   	List<FabuhuiyiView> selectListView(Wrapper<FabuhuiyiEntity> wrapper);
   	
   	FabuhuiyiView selectView(@Param("ew") Wrapper<FabuhuiyiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FabuhuiyiEntity> wrapper);
   	
}

