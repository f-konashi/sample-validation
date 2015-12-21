package com.sample.form;

import javax.validation.GroupSequence;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

public class InputForm implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * コメント記入の有無(ラジオボタン) 
     * null(未選択)不可
     */
    @NotNull(groups = GroupOrder1.class)
    private String needComment;

    /**
     * コメント欄(テキストエリア)
     */
    private String comment;

    /**
     * 「コメント記入の有無」ラジオボランのチェックが「はい」の場合で、
     * 「コメント欄」の記入があるかバリデーションします.
     * 「コメント記入の有無」ラジオボランのチェックが「いいえ」の場合は、
     * バリデーションしません.
     * 
     * @return 
     * コメント欄に記入がある場合trueを返します.
     * falseが返る場合は、エラーメッセージを表示させます.
     */

    @AssertTrue(groups = GroupOrder2.class)
    public boolean isCommentWithYes() {
        //  「コメント記入の有無」ラジオボランで、「いいえ」が選択されているか確認する.
        if (needComment == null || needComment.equals("no")) {
            // 「いいえ」が選択されている場合、バリデーションを行わない.
            return true;
        }
        // コメント欄に記入がされているか確認する.
        if (comment.length() == 0) {
            return false;
        }
        return true;
    }

    /**
     * 「コメント記入の有無」ラジオボランのチェックが「いいえ」の場合で、
     * 「コメント欄」の記入があるかバリデーションします.
     * 「コメント記入の有無」ラジオボランのチェックが「はい」の場合は、
     * バリデーションしません.
     * 
     * @return
     * コメント欄に記入がある場合trueを返します.
     * trueが返る場合は、エラーメッセージを表示させます.
     */
    @AssertFalse(groups = GroupOrder2.class)
    public boolean isCommentWithNo() {
        //  「コメント記入の有無」ラジオボランで、「はい」が選択されているか確認する.
        if (needComment == null || needComment.equals("yes")) {
            // 「はい」が選択されている場合、バリデーションを行わない.
            return false;
        }
        // コメント欄に記入がされているか確認する.
        if (comment.length() != 0) {
            return true;
        }
        return false;
    }

    /**
     * バリデーション 入力値チェック(半角数値のみで記入されているか).
     * 
     * commentフィールドに直接{@literal @Pattern(regexp="^[0-9]+$")} を使用すると、
     * コメントの有無「いいえ」で、コメント欄が未記入(エラー)でも、バリデーションしてしまう為.
     *　TODO:空白 +　半角数値の正規表現があるかは後日確認予定.
     *
     * @return
     */
    @AssertTrue(groups = GroupOrder3.class)
    public boolean isSingleByteNum() {
        // 「コメント記入の有無」ラジオボタンが「無」で、コメント未記入の場合、バリデーションしない。
        if (needComment == null || needComment.equals("no") && comment.length() == 0) {
            return true;
        }
        // バリデーション
        if (comment.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }
    
    //　****************************************
    // GroupSequence(バリデーションに順番を付ける為の設定)
    //　****************************************
    
    public interface GroupOrder1 {
    }

    public interface GroupOrder2 {
    }

    public interface GroupOrder3 {
    }

    public interface GroupOrder4 {
    }

    @GroupSequence({ GroupOrder1.class, GroupOrder2.class, GroupOrder3.class, GroupOrder4.class })
    public interface GroupOrder {
    }
    
    //　****************************************
    // setter/getterメソッド
    //　****************************************
    
    /**
     * @return needComment
     */
    public String getNeedComment() {
        return needComment;
    }

    /**
     * @param needComment
     */
    public void setNeedComment(String needComment) {
        this.needComment = needComment;
    }

    /**
     * @return comment
     */
    public String getComment() {
        return comment;
    }
    
    /**
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}