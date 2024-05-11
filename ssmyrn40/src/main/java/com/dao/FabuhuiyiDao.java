package com.dao;

import com.entity.FabuhuiyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FabuhuiyiVO;
import com.entity.view.FabuhuiyiView;


/**
 * 发布会议
 * 
 * @author 
 * @email 
 * @date 2021-05-10 09:51:10
 */
public interface FabuhuiyiDao extends BaseMapper<FabuhuiyiEntity> {
	
	List<FabuhuiyiVO> selectListVO(@Param("ew") Wrapper<FabuhuiyiEntity> wrapper);
	
	FabuhuiyiVO selectVO(@Param("ew") Wrapper<FabuhuiyiEntity> wrapper);
	
	List<FabuhuiyiView> selectListView(@Param("ew") Wrapper<FabuhuiyiEntity> wrapper);

	List<FabuhuiyiView> selectListView(Pagination page,@Param("ew") Wrapper<FabuhuiyiEntity> wrapper);
	
	FabuhuiyiView selectView(@Param("ew") Wrapper<FabuhuiyiEntity> wrapper);
	
}
