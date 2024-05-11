package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.FabuhuiyiDao;
import com.entity.FabuhuiyiEntity;
import com.service.FabuhuiyiService;
import com.entity.vo.FabuhuiyiVO;
import com.entity.view.FabuhuiyiView;

@Service("fabuhuiyiService")
public class FabuhuiyiServiceImpl extends ServiceImpl<FabuhuiyiDao, FabuhuiyiEntity> implements FabuhuiyiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FabuhuiyiEntity> page = this.selectPage(
                new Query<FabuhuiyiEntity>(params).getPage(),
                new EntityWrapper<FabuhuiyiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FabuhuiyiEntity> wrapper) {
		  Page<FabuhuiyiView> page =new Query<FabuhuiyiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FabuhuiyiVO> selectListVO(Wrapper<FabuhuiyiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FabuhuiyiVO selectVO(Wrapper<FabuhuiyiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FabuhuiyiView> selectListView(Wrapper<FabuhuiyiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FabuhuiyiView selectView(Wrapper<FabuhuiyiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
