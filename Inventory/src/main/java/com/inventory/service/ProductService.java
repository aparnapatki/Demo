package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.Company;
import com.inventory.model.Product;
import com.inventory.repository.CompanyRepository;
import com.inventory.repository.ProductRepository;
import com.inventory.request.ProductRequest;


@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
	}
	public Product getProductById(Long id) {
		return productRepository.findById(id).get();
	}
	
	public Product createProduct(ProductRequest productRequest) {
		
		/*
		 * ModelMapper model= new ModelMapper(); Product product = new Product();
		 * model.map(productRequest, product); Company company=
		 * companyRepository.findById(productRequest.getCompId()).get();
		 * product.setCompany(company);
		 */
		
		Product product= new Product();
		product.setName(productRequest.getName());
		product.setType(productRequest.getType());
		product.setMrp(productRequest.getMrp());
		productRequest.setDiscount(productRequest.getDiscount());
		product.setPrice(productRequest.getPrice());
		product.setQuantity(productRequest.getQuantity());
		product.setAvailableItem(productRequest.getAvailableItem());
		product.setDefectiveItem(product.getDefectiveItem());
		product.setDescription(productRequest.getDescription());
		
		Company company=  companyRepository.findById(productRequest.getCompId()).get();
		product.setCompany(company);
		
		return productRepository.save(product);
	}

	public Product updateProduct(ProductRequest productRequest,Long id) {
		Product product= productRepository.findById(id).get();
		product.setName(productRequest.getName());
		product.setType(productRequest.getType());
		product.setMrp(productRequest.getMrp());
		productRequest.setDiscount(productRequest.getDiscount());
		product.setPrice(productRequest.getPrice());
		product.setQuantity(productRequest.getQuantity());
		product.setAvailableItem(productRequest.getAvailableItem());
		product.setDefectiveItem(product.getDefectiveItem());
		product.setDescription(productRequest.getDescription());
		
		return productRepository.save(product);
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
		
	}
	
}
