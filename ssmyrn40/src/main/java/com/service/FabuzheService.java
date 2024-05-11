package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FabuzheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FabuzheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FabuzheView;


/**
 * 发布者
 *
 * @author 
 * @email 
 * @date 2021-05-10 09:51:10
 */
public interface FabuzheService extends IService<FabuzheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FabuzheVO> selectListVO(Wrapper<FabuzheEntity> wrapper);
   	
   	FabuzheVO selectVO(@Param("ew") Wrapper<FabuzheEntity> wrapper);
   	
   	List<FabuzheView> selectListView(Wrapper<FabuzheEntity> wrapper);
   	
   	FabuzheView selectView(@Param("ew") Wrapper<FabuzheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FabuzheEntity> wrapper);
   	
}

