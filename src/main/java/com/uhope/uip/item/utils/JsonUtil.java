package com.uhope.uip.item.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.uhope.uip.base.dto.ModuleConfig;
import com.uhope.uip.base.dto.ModuleFunction;
import com.uhope.uip.base.util.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

   
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

	public static ModuleConfig parseJsonConfig(String path) {
		 
		//path "config/config.json"
		String jsonConfig = FileUtil.readFile(path, "UTF-8");
		
		if(StringUtils.isEmpty(jsonConfig)){
			LOGGER.error("read json config failure.");
			return null;
		}
		
		// 将json字符串转换为json对象
		JSONObject jsonObj = JSON.parseObject(jsonConfig);

		ModuleConfig moduleConfig = new ModuleConfig();

		moduleConfig.setId(jsonObj.getString("id"));
		moduleConfig.setModuleName(jsonObj.getString("moduleName"));
		moduleConfig.setVersion(jsonObj.getString("version"));// description
		moduleConfig.setDescription(jsonObj.getString("description"));
		
		//设置菜单列表
		List<ModuleFunction> menuList = new ArrayList<ModuleFunction>();
		JSONArray menusArray = jsonObj.getJSONArray("menus");

		//获取菜单列表
		for (int i = 0; i < menusArray.size(); i++) {
			JSONObject menuObj = menusArray.getJSONObject(i);

			ModuleFunction menu = new ModuleFunction();

			menu.setSeqId(menuObj.getString("seqId"));
			menu.setParentId(menuObj.getString("parentId"));
			menu.setIsLeaf(menuObj.getBoolean("isLeaf"));
			menu.setIsRoot(menuObj.getBoolean("isRoot"));
			menu.setName(menuObj.getString("name"));
			menu.setIcon(menuObj.getString("icon"));
			menu.setUrl(menuObj.getString("url"));
			menu.setMenuType(menuObj.getInteger("menuType"));
			
			List<String> requireJSList = new ArrayList<String>();
			JSONArray requireJS = menuObj.getJSONArray("requireJS");
			if(requireJS !=null && requireJS.size()>0){
				for (int j = 0; j < requireJS.size(); j++){
					requireJSList.add(requireJS.getString(j));
				}
			}
			menu.setRequireJS(requireJSList);
			menu.setDescription(menuObj.getString("description"));
			menuList.add(menu);
		}
		moduleConfig.setMenus(menuList);
		
		//设置组件列表
		List<ModuleFunction> comptList = new ArrayList<ModuleFunction>();
		JSONArray components = jsonObj.getJSONArray("components");

		//获取组件列表
		for (int i = 0; i < components.size(); i++) {
			JSONObject componentObj = components.getJSONObject(i);

			ModuleFunction compt = new ModuleFunction();
			//组件列表当前只涉及这几个字段，后续看情况调整补齐
			compt.setSeqId(componentObj.getString("seqId"));
			//menu.setParentId(menuObj.getString("parentId"));
			//menu.setIsLeaf(menuObj.getBoolean("isLeaf"));
			//menu.setIsRoot(menuObj.getBoolean("isRoot"));
			compt.setName(componentObj.getString("name"));
			//menu.setIcon(menuObj.getString("icon"));
			compt.setUrl(componentObj.getString("url"));
			List<String> requireJSList = new ArrayList<String>();
			JSONArray requireJS = componentObj.getJSONArray("requireJS");
			if(requireJS !=null && requireJS.size()>0){
				for (int j = 0; j < requireJS.size(); j++){
					requireJSList.add(requireJS.getString(j));
				}
			}
			compt.setRequireJS(requireJSList);
			
			compt.setDescription(componentObj.getString("description"));
			comptList.add(compt);
		}
		moduleConfig.setComponents(comptList);
		
		//设置页面列表
		List<ModuleFunction> pageList = new ArrayList<ModuleFunction>();
		JSONArray pages = jsonObj.getJSONArray("pages");

		//获取page列表
		for (int i = 0; i < pages.size(); i++) {
			JSONObject pageObj = pages.getJSONObject(i);

			ModuleFunction page = new ModuleFunction();
			//Page列表当前只涉及这几个字段，后续看情况调整补齐
			page.setSeqId(pageObj.getString("seqId"));
			//menu.setParentId(menuObj.getString("parentId"));
			//menu.setIsLeaf(menuObj.getBoolean("isLeaf"));
			//menu.setIsRoot(menuObj.getBoolean("isRoot"));
			page.setName(pageObj.getString("name"));
			//menu.setIcon(menuObj.getString("icon"));
			page.setUrl(pageObj.getString("url"));
			List<String> requireJSList = new ArrayList<String>();
			JSONArray requireJS = pageObj.getJSONArray("requireJS");
			if(requireJS !=null && requireJS.size()>0){
				for (int j = 0; j < requireJS.size(); j++){
					requireJSList.add(requireJS.getString(j));
				}
			}
			page.setRequireJS(requireJSList);
			page.setDescription(pageObj.getString("description"));
			pageList.add(page);
		}
		moduleConfig.setPages(pageList);

		return moduleConfig;
	}


}
