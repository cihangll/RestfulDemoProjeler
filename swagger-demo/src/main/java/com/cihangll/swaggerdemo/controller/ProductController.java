package com.cihangll.swaggerdemo.controller;

import com.cihangll.swaggerdemo.domain.Product;
import com.cihangll.swaggerdemo.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Api(value = "restswaggertest", description = "Ürünler için kullanılabilecek API")
public class ProductController {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@ApiOperation(value = "Ürünleri liste halinde görüntüleyin.", response = Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Liste başarıyla geldi."),
			@ApiResponse(code = 401, message = "Listeyi görüntüleyebilmeniz için yetkiniz yok."),
			@ApiResponse(code = 403, message = "Ulaşmaya çalıştığınız kaynak erişime kapalıdır."),
			@ApiResponse(code = 404, message = "Ulaşmaya çalıştığınız kaynak bulunamadı.")
	})
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Iterable list() {
		Iterable productList = productService.listAllProducts();
		return productList;
	}

	@ApiOperation(value = "Ürün Id'sine göre ürünü görüntüleyin.", response = Product.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ürün başarıyla geldi."),
			@ApiResponse(code = 401, message = "Ürünü görüntüleyebilmeniz için yetkiniz yok."),
			@ApiResponse(code = 403, message = "Ulaşmaya çalıştığınız kaynak erişime kapalıdır."),
			@ApiResponse(code = 404, message = "Ulaşmaya çalıştığınız kaynak bulunamadı.")
	})
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public Product showProduct(@PathVariable Integer id) {
		Product product = productService.getProductById(id);
		return product;
	}

	@ApiOperation(value = "Ürün ekleyin.", response = ResponseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ürün başarıyla eklendi."),
			@ApiResponse(code = 201, message = "Ürün başarıyla eklendi."),
			@ApiResponse(code = 401, message = "Ürünü ekleyebilmeniz için yetkiniz yok."),
			@ApiResponse(code = 403, message = "Ulaşmaya çalıştığınız kaynak erişime kapalıdır."),
			@ApiResponse(code = 404, message = "Ulaşmaya çalıştığınız kaynak bulunamadı.")
	})
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity saveProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return new ResponseEntity("Product saved successfully.", HttpStatus.OK);
	}

	@ApiOperation(value = "Ürün güncelleyin.", response = ResponseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ürün başarıyla güncellendi."),
			@ApiResponse(code = 201, message = "Ürün başarıyla güncellendi."),
			@ApiResponse(code = 401, message = "Ürünü güncelleyebilmeniz için yetkiniz yok."),
			@ApiResponse(code = 403, message = "Ulaşmaya çalıştığınız kaynak erişime kapalıdır."),
			@ApiResponse(code = 404, message = "Ulaşmaya çalıştığınız kaynak bulunamadı.")
	})
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		Product storedProduct = productService.getProductById(id);
		storedProduct.setDescription(product.getDescription());
		storedProduct.setImageUrl(product.getImageUrl());
		storedProduct.setPrice(product.getPrice());
		productService.saveProduct(storedProduct);
		return new ResponseEntity("Product updated successfully.", HttpStatus.OK);
	}

	@ApiOperation(value = "Ürünü silin.", response = ResponseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ürün başarıyla silindi."),
			@ApiResponse(code = 204, message = "Ürün silmek için içerik bulunamadı.NO CONTENT"),
			@ApiResponse(code = 401, message = "Ürünü silmek için yetkiniz yok."),
			@ApiResponse(code = 403, message = "Ulaşmaya çalıştığınız kaynak erişime kapalıdır."),
			@ApiResponse(code = 404, message = "Ulaşmaya çalıştığınız kaynak bulunamadı.")
	})
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return new ResponseEntity("Product deleted successfully.", HttpStatus.OK);
	}
}
