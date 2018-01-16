package com.cihangll.swaggerdemo.domain;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "Database tarafından oluşturulan ürün id - product id değeri")
	private Integer id;

	@Version
	@ApiModelProperty(notes = "Otomatik oluşturulacak version")
	private Integer version;

	@ApiModelProperty(notes = "Uygulamaya özel ürün numarası - productId")
	private String productId;

	@ApiModelProperty(notes = "Ürün açıklama alanı")
	private String description;

	@ApiModelProperty(notes = "Ürün resim url'si")
	private String imageUrl;

	@ApiModelProperty(notes = "Ürün fiyatı")
	private BigDecimal price;

	public Integer getId() {
		return id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
