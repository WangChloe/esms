package com.plan.a.es.webapp.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.plan.a.es.dto.BaseResult;

/**
 * 所有action的父类
 * 
 * @author jimmy.zhou
 *
 */
public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public static boolean isDebug = false;

	Logger log = Logger.getLogger(getClass());

	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	private Gson createGsonInstans() {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = builder.create();
		return gson;
	}

	protected void responseWriterJson(String responseText) throws IOException {
		if (isDebug) {
			log.info(responseText);
			return;
		}
		this.getResponse().setCharacterEncoding("UTF-8");
		this.getResponse().setContentType("application/json");
		this.getResponse().getWriter().print(responseText);
	}

	protected void responseWriterHtml(String responseText) throws IOException {
		if (isDebug) {
			log.info(responseText);
			return;
		}
		this.getResponse().setCharacterEncoding("UTF-8");
		this.getResponse().setContentType("text/html");
		this.getResponse().getWriter().print(responseText);
	}

	protected void returnJson(String code, String msg, Object data) throws IOException {
		BaseResult result = new BaseResult();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(data);
		String json = createGsonInstans().toJson(result);
		responseWriterJson(json);
	}

	protected void returnSuccessJson(String msg, Object data) throws IOException {
		returnJson("0", msg, data);
	}

	protected void returnSuccessJson(Object data) throws IOException {
		returnJson("0", "Success", data);
	}

	protected void returnExceptionJson(Exception exception) {
		try {
			// XXX 使用更详细的错误信息，暂时不需要
			// String errInfo = "";
			// errInfo = errInfo + exception.getMessage() + "\r\n";
			// StackTraceElement[] stackTraces = exception.getStackTrace();
			// for(StackTraceElement stackTrace : stackTraces){
			// errInfo = errInfo + stackTrace + "\r\n";
			// }
			// returnJson("1", exception.getMessage(), errInfo);
			returnJson("1", exception.getMessage(), null);
		} catch (IOException e) {
			log.error(e, e);
		}
	}

}
