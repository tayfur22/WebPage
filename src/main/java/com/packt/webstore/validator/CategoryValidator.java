package com.packt.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class CategoryValidator implements ConstraintValidator<Category, String> {

    private List<String> allowedCategories;

    // Allow to define the allowed categories via constructor
    public CategoryValidator() {
        allowedCategories = Arrays.asList("Electronics", "Clothing", "Books"); // Predefined categories
    }

    @Override
    public boolean isValid(String category, ConstraintValidatorContext context) {
        if (category == null || category.isEmpty()) {
            return false; // Return false if category is empty or null
        }
        return allowedCategories.contains(category); // Check if category is valid
    }

    @Override
    public void initialize(Category constraintAnnotation) {
        // You can initialize or customize allowedCategories here, if needed
    }
}
