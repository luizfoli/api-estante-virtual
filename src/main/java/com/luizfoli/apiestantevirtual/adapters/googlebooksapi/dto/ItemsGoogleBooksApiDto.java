package com.luizfoli.apiestantevirtual.adapters.googlebooksapi.dto;

public class ItemsGoogleBooksApiDto {

	private String id;
	private String kind;
	private String etag;
	private String selfLink;
	private VolumeInfoGoogleBooksApiDTO volumeInfo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getEtag() {
		return etag;
	}
	public void setEtag(String etag) {
		this.etag = etag;
	}
	public String getSelfLink() {
		return selfLink;
	}
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}
	public VolumeInfoGoogleBooksApiDTO getVolumeInfo() {
		return volumeInfo;
	}
	public void setVolumeInfo(VolumeInfoGoogleBooksApiDTO volumeInfo) {
		this.volumeInfo = volumeInfo;
	}
	
	
	
}
