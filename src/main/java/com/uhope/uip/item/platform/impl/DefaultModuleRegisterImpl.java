package com.uhope.uip.item.platform.impl;

import com.uhope.uip.base.dto.ModuleConfig;

import com.uhope.uip.item.platform.ModuleRegister;
import com.uhope.uip.item.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class DefaultModuleRegisterImpl implements ModuleRegister {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultModuleRegisterImpl.class);
	@Override
	public ModuleConfig register(String moduleId) {

		//TODO 保存moduleId 到配置文件, 这里是平台分配的moduleId
		LOGGER.info("the moduleId is {}.", moduleId);
		//返回业务模块 提供的菜单、组件、Page等信息给 平台
		URL url = DefaultModuleRegisterImpl.class.getResource("/");
		
		ModuleConfig config = JsonUtil.parseJsonConfig(url.getPath()+"static/config/config.json");
		
		
		return config;
	}

}
