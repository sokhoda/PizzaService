package validators.javax;

import domain.AddressType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CheckZipCodeValidator implements ConstraintValidator<CheckZipCode, String> {

    private AddressType addressType;

//    @Value("${zip.home.prefix}")
    private String zipHomePrefix = "12";

//    @Value("${zip.office.prefix}")
    private String zipOfficePrefix = "34";

    @Override
    public void initialize(CheckZipCode constraintAnnotation) {
        this.addressType = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        switch (addressType) {
            case HOME:
                return value.startsWith(zipHomePrefix);
            case OFFICE:
                return value.startsWith(zipOfficePrefix);
            default:
                return false;
        }
    }
}