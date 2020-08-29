package com.luizfoli.apiestantevirtual.adapters.googlebooksapi.dto;

import java.util.List;

public class VolumeGoogleBooksApiDTO {

	private String kind;
	private int totalItems;
	private List<ItemsGoogleBooksApiDto> items;

	public String getKind() {
		return kind;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public int getTotalItems() {
		return totalItems;
	}
	
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public List<ItemsGoogleBooksApiDto> getItems() {
		return items;
	}

	public void setItems(List<ItemsGoogleBooksApiDto> items) {
		this.items = items;
	}
	
	
	
}