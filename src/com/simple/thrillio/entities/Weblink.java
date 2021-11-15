package com.simple.thrillio.entities;

import com.simple.thrillio.partner.Shareable;

public class Weblink extends Bookmark implements Shareable {
	private String url;
	private String host;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return super.toString() + " Weblink [url=" + url + ", host=" + host + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		// TODO Auto-generated method stub
		if (url.contains("porn") || getTitle().contains("porn") || host.contains("adult")
				|| (url.contains("adult") && getTitle().contains("adult"))) {
			return false;
		}
		return true;
	}

	@Override
	public String getItemData() {
StringBuilder sb = new StringBuilder();
		
		sb.append("<item>");
		sb.append("<title>").append(getTitle()).append("</item>");
		sb.append("<type>WebLink</type>");
		sb.append("<url>").append(url).append("</url>");
		sb.append("<host>").append(host).append("</host>");
		sb.append("</item>");
		
		return sb.toString();
	}

}
