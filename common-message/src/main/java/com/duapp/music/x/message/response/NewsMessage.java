package com.duapp.music.x.message.response;

import java.util.List;

import com.duapp.music.x.message.base.BaseResMessage;
import com.duapp.music.x.message.response.model.Article;

/**
 * �ظ�ͼ����Ϣ
 * 
 * @author qiuqiu3212
 */
public class NewsMessage extends BaseResMessage {

	/**
	 * ͼ����Ϣ����������Ϊ10������
	 */
	private Integer ArticleCount;

	/**
	 * ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ,ע�⣬���ͼ��������10���򽫻�����Ӧ
	 */
	private List<Article> Articles;

	public Integer getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(Integer articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
}
