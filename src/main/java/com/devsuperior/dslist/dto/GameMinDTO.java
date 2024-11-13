package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class GameMinDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String year;
	private String imgUrl;
	private String shortDescription;
	
	public GameMinDTO() {}

	public GameMinDTO(Game entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.year = entity.getYear();
		this.imgUrl = entity.getImgUrl();
		this.shortDescription = entity.getShortDescription();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	
}
