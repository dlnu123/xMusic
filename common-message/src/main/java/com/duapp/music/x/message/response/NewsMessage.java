package com.duapp.music.x.message.response;

import java.util.List;

import com.duapp.music.x.message.base.BaseResMessage;
import com.duapp.music.x.message.response.model.Article;

/**
 * 回复图文消息
 * 
 * @author qiuqiu3212
 */
public class NewsMessage extends BaseResMessage {

	/**
	 * 图文消息个数，限制为10条以内
	 */
	private Integer ArticleCount;

	/**
	 * 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
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
