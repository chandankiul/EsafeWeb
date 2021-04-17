package com.esafe.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FileOrFolder {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String operator_economy;
    private String favorite;
    private String created_date;
    
    
	public FileOrFolder(Long id, String title, String author, String operator_economy, String favorite,
			String created_date) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.operator_economy = operator_economy;
		this.favorite = favorite;
		this.created_date = created_date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getOperator_economy() {
		return operator_economy;
	}
	public void setOperator_economy(String operator_economy) {
		this.operator_economy = operator_economy;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	@Override
	public String toString() {
		return "FileOrFolder [id=" + id + ", title=" + title + ", author=" + author + ", operator_economy="
				+ operator_economy + ", favorite=" + favorite + ", created_date=" + created_date + "]";
	}
	public FileOrFolder() {
		super();
	}
    
    
   
}
