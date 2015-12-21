package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

import com.sample.form.InputForm;

/**
 * アプリケーション全体を制御するクラスです(controller).
 * 
 * @author f-konashi
 */
@Controller
public class InputController {
    
    /**
     * 画面で使うフォームに対応したオブジェクトを初期化し、Modelに追加します(Thymeleafからアクセスさせるために必要).
     *
     * @param なし
     * @return フォームへ入力値を格納するオブジェクト
     */
    @ModelAttribute
    InputForm setupOrderInfoForm() {
        return new InputForm();
    }
    
    /**
     * 入力フォームをブラウザに表示します.
     * 
     * @param model
     * @return ブラウザに表示するページ
     */
    @RequestMapping("/")
    public String display(Model model) {
        return "inputForm";
    }
    
    /**
     * バリデーションします.
     * バリデーションエラーがある場合は、エラーメッセージと共にinputFormページを表示します(自画面遷移).
     * バリデーションエラーがない場合は、inputCompleteページを表示します.
     * 
     * @param model
     * @param locale
     * @param inputForm
     * @param result
     * @return ブラウザに表示するページ
     */
    @RequestMapping("/input")
    public String validate(Model model, Locale locale, @Validated(InputForm.GroupOrder.class) InputForm inputForm, BindingResult result) {
        if (result.hasErrors()) {
            return "inputForm";
        }
        return "inputComplete";
    }
}