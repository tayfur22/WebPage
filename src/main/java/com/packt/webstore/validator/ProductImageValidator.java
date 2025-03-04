package com.packt.webstore.validator;

import com.packt.webstore.domain.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

public class ProductImageValidator implements Validator {

    private long allowedSize; // Maksimum icazə verilən ölçü (bayt ilə)

    public void setAllowedSize(long allowedSize) {
        this.allowedSize = allowedSize;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        MultipartFile productImage = product.getProductImage();

        if (productImage != null && !productImage.isEmpty()) {
            if (productImage.getSize() > allowedSize) {
                errors.rejectValue("productImage", "error.productImage.size", "Image size exceeds the allowed limit.");
            }
        }
    }
}
