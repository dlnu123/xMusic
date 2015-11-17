
package com.duapp.music.x.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duapp.music.x.service.core.CoreService;
import com.duapp.music.x.service.core.impl.CoreServiceImpl;
import com.duapp.music.x.utils.SignUtil;

/**
 * ���ںź���Servlet
 * 
 * @author qiuqiu3212
 */
public class CoreServlet extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2080577369324482433L;

	/**
	 * ����΢�Ź���ƽ̨����,��Ϊ������
	 * 
	 * @param req
	 *            ����
	 * @param resp
	 *            ��Ӧ
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// ΢�ż���ǩ����signature����˿�������д��token�����������е�timestamp������nonce����
		String signature = req.getParameter("signature");

		// ʱ���
		String timestamp = req.getParameter("timestamp");

		// �����
		String nonce = req.getParameter("nonce");

		// ����ַ���
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

		// ��request��response�ı���ת����UTF-8�����������������
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UFT-8");

		// �������󣬻�ȡ���ص�xml��Ϣ
		CoreService coreService = new CoreServiceImpl();
		String responseMsg = coreService.handleRequest(req);

		// �����ɵ�xml����ֵд����Ӧ���������
		PrintWriter writer = resp.getWriter();
		writer.write(responseMsg);
		writer.flush();
		writer.close();
	}

}
