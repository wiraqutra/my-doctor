package com.appspot.mydoctor.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

import com.appspot.mydoctor.util.UrlUtil;

public class LinkTag extends TagSupport {

	private static final long serialVersionUID = 3596768805279852675L;

	private String url;

	private PageContext pageContext;
	private Tag parentTag;

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		String sessionId = request.getParameter("sid");
		try {
			if (StringUtils.isNotEmpty(url)) {
				out.print(UrlUtil.addSessionId(url, sessionId));
			}
		} catch (Exception e) {
			throw new JspException(e.getMessage(), e);
		}
		return 0;
	}

	public Tag getParent() {
		return this.parentTag;
	}

	public void release() {
		// TODO Auto-generated method stub

	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	public void setParent(Tag parentTag) {
		this.parentTag = parentTag;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
