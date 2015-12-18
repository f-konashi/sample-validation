package com.sample.form;

import java.io.Serializable;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

public class InputForm implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * コメント記入の有無(ラジオボタン)
     *  【バリデーション】
     * ・チェック必須 
     * ・「はい」にチェックを付けた場合： テキストエリアに入力必須
     * ・「いいえ」にチェックを付けた場合： テキストエリアに入力不可
     * 
     */
    @NotNull(groups = GroupOrder1.class)
    private String needComment;

    /**
     * コメント欄(テキストエリア)
     *  【バリデーション】
     *   ・半角数値のみ入力可能
     */
    private String comment;

    /**
     * バリデーション
     * コメントチェック「有」で、コメント記入あるかを確認する.
     * 
     * @return　テキストエリアにコメント記入がある場合true
     */
    
    @AssertTrue(groups = GroupOrder2.class)
    public boolean isCommentWithYes() {
        // 「コメント記入の有無」ラジオボタンがチェックされていない場合、バリデーションしない
        if (needComment == null) {
            return true;
        }
        // バリデーション
        if (needComment.equals("yes") && comment.length() != 0) {
            return true;
        }
        return false;
    }
    
    /**
     * バリデーション
     * コメントチェック「無」で、コメント記入あるかを確認する.
     * 
     * @return テキストエリアにコメント記入がある場合true
     */
    @AssertFalse(groups = GroupOrder2.class)
    public boolean isCommentWithNo() {
        // 「コメント記入の有無」ラジオボタンがチェックされていない場合、バリデーションしない
        if (needComment == null) {
            return true;
        }
        // バリデーション
        if (needComment.equals("no") && comment.length() == 0) {
            return true;
        }
        return false;
    }
     
    /**
     * バリデーション
     * 入力値チェック(半角数値のみで記入されているか)
     * 
     * @return
     */
    @AssertTrue(groups = GroupOrder3.class)
    public boolean isSingleByteNum() {
        // 「コメント記入の有無」ラジオボタンがチェックされていない場合、バリデーションしない
        if (needComment == null) {
            return true;
        }
        // 「コメント記入の有無」ラジオボタンが「無」で、コメント未記入の場合、バリデーションしない。
        if (needComment.equals("no") && comment.length() == 0) {
            return true;
        }
        // バリデーション
        if (comment.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }
    
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
