package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuiyiyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuiyiyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuiyiyuyueView;


/**
 * 会议预约
 *
 * @author 
 * @email 
 * @date 2021-05-10 09:51:10
 */
public interface HuiyiyuyueService extends IService<HuiyiyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuiyiyuyueVO> selectListVO(Wrapper<HuiyiyuyueEntity> wrapper);
   	
   	HuiyiyuyueVO selectVO(@Param("ew") Wrapper<HuiyiyuyueEntity> wrapper);
   	
   	List<HuiyiyuyueView> selectListView(Wrapper<HuiyiyuyueEntity> wrapper);
   	
   	HuiyiyuyueView selectView(@Param("ew") Wrapper<HuiyiyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuiyiyuyueEntity> wrapper);
   	
}

