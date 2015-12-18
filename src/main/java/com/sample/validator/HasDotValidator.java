package com.sample.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HasDotValidator implements ConstraintValidator<HasDot, String> {

	@Override
	public void initialize(HasDot hasdot) {

	}
	/**
	 * 入力された値に「.(ドット)」が存在するか、正規表現で確認します.
	 * フォームに値が入力されている場合、バリデーションを行いません.
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.length() == 0 ) {
			return false;
		}
		return value.matches("^.*\\..*");
	}
}
