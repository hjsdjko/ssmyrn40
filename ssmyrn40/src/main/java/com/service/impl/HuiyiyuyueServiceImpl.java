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


import com.dao.HuiyiyuyueDao;
import com.entity.HuiyiyuyueEntity;
import com.service.HuiyiyuyueService;
import com.entity.vo.HuiyiyuyueVO;
import com.entity.view.HuiyiyuyueView;

@Service("huiyiyuyueService")
public class HuiyiyuyueServiceImpl extends ServiceImpl<HuiyiyuyueDao, HuiyiyuyueEntity> implements HuiyiyuyueService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuiyiyuyueEntity> page = this.selectPage(
                new Query<HuiyiyuyueEntity>(params).getPage(),
                new EntityWrapper<HuiyiyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuiyiyuyueEntity> wrapper) {
		  Page<HuiyiyuyueView> page =new Query<HuiyiyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuiyiyuyueVO> selectListVO(Wrapper<HuiyiyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuiyiyuyueVO selectVO(Wrapper<HuiyiyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuiyiyuyueView> selectListView(Wrapper<HuiyiyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuiyiyuyueView selectView(Wrapper<HuiyiyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
