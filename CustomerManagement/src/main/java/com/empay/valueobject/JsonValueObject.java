package com.empay.valueobject;

import java.util.Arrays;

public class JsonValueObject {
	private String title;
	
	private String page;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "[title=" + title + ", page=" + page + "]";
	}

	
	
}