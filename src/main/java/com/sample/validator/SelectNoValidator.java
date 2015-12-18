package com.sample.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SelectNoValidator implements ConstraintValidator<SelectNo, String> {

	@Override
	public void initialize(SelectNo annotation) {

	}

	/**
	 * 
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
        // 「コメント記入の有無」ラジオボタンがチェックされていない場合、バリデーションしない
		if (value == null || value.length() == 0 ) {
			return true;
		}
        // バリデーション
//        if (needComment.equals("no") && comment.length() != 0) {
//            return false;
//        }
        return true;
	}
}
