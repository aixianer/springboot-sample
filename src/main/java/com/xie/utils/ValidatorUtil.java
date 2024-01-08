package com.xie.utils;

import com.xie.bean.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidatorUtil {
    // 此接口线程安全
    private static Validator validator;
    static {
        // 获取 ValidatorFactory ，再通过其获得 Validator
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public static List<String> valid(User user){
        // 寻找对应的 Validator 对其属性进行校验，若是通过，返回的 Set 为空
        Set<ConstraintViolation<User>> validateInfo = validator.validate(user);
        return validateInfo.stream().map(v -> "属性：" + v.getPropertyPath()
                + "，属性值：" + v.getInvalidValue()
                + "，提示信息：" + v.getMessage()).collect(Collectors.toList());
    }
}
