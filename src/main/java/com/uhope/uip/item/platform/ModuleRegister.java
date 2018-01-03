package com.uhope.uip.item.platform;

import com.uhope.uip.base.dto.ModuleConfig;

public interface ModuleRegister {

	/**
	 * @Title: register
	 * @Description: 提供给平台调用的模块注册功能接口，返回模块提供的配置信息给平台
	 * @param: @param moduleId
	 * @param: @return
	 * @return: ModuleConfig   
	 * @throws
	 */
	public ModuleConfig register(String moduleId);
	
}
