package com.dao;

import com.entity.HuiyiyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuiyiyuyueVO;
import com.entity.view.HuiyiyuyueView;


/**
 * 会议预约
 * 
 * @author 
 * @email 
 * @date 2021-05-10 09:51:10
 */
public interface HuiyiyuyueDao extends BaseMapper<HuiyiyuyueEntity> {
	
	List<HuiyiyuyueVO> selectListVO(@Param("ew") Wrapper<HuiyiyuyueEntity> wrapper);
	
	HuiyiyuyueVO selectVO(@Param("ew") Wrapper<HuiyiyuyueEntity> wrapper);
	
	List<HuiyiyuyueView> selectListView(@Param("ew") Wrapper<HuiyiyuyueEntity> wrapper);

	List<HuiyiyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<HuiyiyuyueEntity> wrapper);
	
	HuiyiyuyueView selectView(@Param("ew") Wrapper<HuiyiyuyueEntity> wrapper);
	
}
