package com.packt.webstore.domain;

import com.packt.webstore.validator.Category;
import com.packt.webstore.validator.ProductId;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement
public class Product implements Serializable {

    @Pattern(regexp="P[0-9]+", message=" {Pattern.Product.productId.validation}")
    @ProductId
    private static final long serialVersionUID = 1L;
    private String productId;

    @Size(min=4, max=50, message="{Size.Product.name.validation}")
    private String name;

    @Min(value=0, message="Min.Product.unitPrice.validation}")
    @Digits(integer=8, fraction=2, message=" {Digits.Product.unitPrice.validation}")
    @NotNull(message= "{NotNull.Product.unitPrice.validation}")
    private BigDecimal unitPrice;
    private String description;
    private String manufacturer;

    @NotEmpty(message = "{NotEmpty.Product.category.validation}")
    @Category
    private String category;

    @Min(value = 0, message = "{Min.Product.unitsInStock.validation}")

    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;
    private String condition;

    @JsonIgnore
    private MultipartFile productImage;

    @JsonIgnore
    private MultipartFile userManual;

    // Default constructor
    public Product() {
    }

    // Parameterized constructor
    public Product(String productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    // Getters and setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public long getUnitsInOrder() {
        return unitsInOrder;
    }

    public void setUnitsInOrder(long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @XmlTransient
    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    @XmlTransient
    public MultipartFile getUserManual() {
        return userManual;
    }

    public void setUserManual(MultipartFile userManual) {
        this.userManual = userManual;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product other = (Product) obj;
        return productId != null && productId.equals(other.productId);
    }

    @Override
    public int hashCode() {
        return productId != null ? productId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", name=" + name + "]";
    }
}
