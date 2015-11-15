package com.duapp.music.x.core;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duapp.music.x.utils.SignUtil;

/**
 * 公众号核心Servlet
 * 
 * @author qiuqiu3212
 */
public class CoreServlet extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2080577369324482433L;

	/**
	 * 接入微信公众平台开发,成为开发者
	 * 
	 * @param req
	 * @param resp
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
		String signature = req.getParameter("signature");

		// 时间戳
		String timestamp = req.getParameter("timestamp");

		// 随机数
		String nonce = req.getParameter("nonce");

		// 随机字符串
		String echostr = req.getParameter("echostr");

		Writer out = resp.getWriter();
		if (SignUtil.sign(signature, timestamp, nonce)) {
			out.write(echostr);
		}

		if (out != null) {
			out.close();
			out = null;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
