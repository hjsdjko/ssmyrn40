package com.entity.vo;

import com.entity.FabuhuiyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 发布会议
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-05-10 09:51:10
 */
public class FabuhuiyiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 会议时间
	 */
	
	private String huiyishijian;
		
	/**
	 * 会议地点
	 */
	
	private String huiyididian;
		
	/**
	 * 会议人数
	 */
	
	private Integer huiyirenshu;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 会议内容
	 */
	
	private String huiyineirong;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：会议时间
	 */
	 
	public void setHuiyishijian(String huiyishijian) {
		this.huiyishijian = huiyishijian;
	}
	
	/**
	 * 获取：会议时间
	 */
	public String getHuiyishijian() {
		return huiyishijian;
	}
				
	
	/**
	 * 设置：会议地点
	 */
	 
	public void setHuiyididian(String huiyididian) {
		this.huiyididian = huiyididian;
	}
	
	/**
	 * 获取：会议地点
	 */
	public String getHuiyididian() {
		return huiyididian;
	}
				
	
	/**
	 * 设置：会议人数
	 */
	 
	public void setHuiyirenshu(Integer huiyirenshu) {
		this.huiyirenshu = huiyirenshu;
	}
	
	/**
	 * 获取：会议人数
	 */
	public Integer getHuiyirenshu() {
		return huiyirenshu;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：会议内容
	 */
	 
	public void setHuiyineirong(String huiyineirong) {
		this.huiyineirong = huiyineirong;
	}
	
	/**
	 * 获取：会议内容
	 */
	public String getHuiyineirong() {
		return huiyineirong;
	}
				
	
	/**
	 * 设置：账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
