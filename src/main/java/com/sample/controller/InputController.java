package com.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

import com.sample.form.GroupOrder;
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
     * 
     * @param model
     * @return ブラウザに表示するページ
     */
    @RequestMapping("/input")
    public String validate(Model model, Locale locale, @Validated(GroupOrder.class) InputForm inputForm, BindingResult result) {
        // バリデーションエラーがあるか確認する。        
        if (result.hasErrors()) {
            return "inputForm";
        }
        return "inputComplete";
    }
}