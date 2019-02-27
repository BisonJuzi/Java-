package com.coderising.litestruts;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Configuration {

	/**
	 * <action.name, ActionConfig>
	 * ActionConfig（<action.name，action.class，action.result>）
	 * action.result（<result.name，result.jsp>...）
	 * 返回ActionConfig
	 */
	Map<String,ActionConfig> actions = new HashMap<>();
	
	public Configuration(String fileName) {		
		
		String packageName = this.getClass().getPackage().getName();
		
		packageName = packageName.replace('.', '/');
		
		InputStream is = this.getClass().getResourceAsStream("/" + packageName + "/" + fileName);
		
		parseXML(is);
		
		try {
			is.close();
		} catch (IOException e) {			
			throw new ConfigurationException(e);
		}
	}
	
	private void parseXML(InputStream is){
		
		 SAXBuilder builder = new SAXBuilder();
		 
		 try {
			 
			Document doc = builder.build(is);
			
			Element root = doc.getRootElement();
			
			for(Element actionElement : root.getChildren("action")){
				
				String actionName = actionElement.getAttributeValue("name");
				String clzName = actionElement.getAttributeValue("class");
				
				ActionConfig ac = new ActionConfig(actionName, clzName);
				
				for(Element resultElement : actionElement.getChildren("result")){
					
					String resultName = resultElement.getAttributeValue("name");
					String viewName = resultElement.getText().trim();
					
					ac.addViewResult(resultName, viewName);					
				}				
				this.actions.put(actionName, ac);
			}						
		} catch (JDOMException e) {
			throw new ConfigurationException(e);			
		} catch (IOException e) {
			throw new ConfigurationException(e);			
		}	 
	}

	public String getClassName(String action) {
		ActionConfig ac = this.actions.get(action);
		if(ac == null){
			return null;
		}
		return ac.getClassName();
	}

	public String getResultView(String action, String resultName) {
		ActionConfig ac = this.actions.get(action);
		if(ac == null){
			return null;
		}
		return ac.getViewName(resultName);
	}
	
	/**
	 * <action name="login" class="com.coderising.litestruts.LoginAction">
	 * 		<result name="success">/jsp/homepage.jsp</result>
	 * 		<result name="fail">/jsp/showLogin.jsp</result>
	 * </action>
	 */
	
	private static class ActionConfig{
		
		// name="login"
		String name; 
		
		// class="com.coderising.litestruts.LoginAction"
		String clzName; 
		
		//<("success","/jsp/homepage.jsp"),("fail"","/jsp/showLogin.jsp")>
		Map<String,String> viewResult = new HashMap<>();
		
		public ActionConfig(String actionName, String clzName) {
			this.name = actionName;
			this.clzName = clzName;
		}
		public String getClassName(){
			return clzName;
		}
		public void addViewResult(String name, String viewName){
			viewResult.put(name, viewName);
		}
		public String getViewName(String resultName){
			return viewResult.get(resultName);
		}
	}

}
