package cn.xxt.customwidget;

import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;

/**
 * @Author zhq
 * @Date 2019-10-11-16:37
 * @Description
 * @Email 1457453696@qq.com
 */
public class EmojiEditText extends AppCompatEditText {

    public EmojiEditText(Context context) {
        super(context);
    }

    public EmojiEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmojiEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTextContextMenuItem(int id) {
        ClipboardManager clip = (ClipboardManager) getContext()
                .getSystemService(Context.CLIPBOARD_SERVICE);
        if (id == android.R.id.paste) {
            Editable text = getText();
            String str = (text != null) ? text.toString() : "";
            CharSequence pasteCharSequence = (clip != null) ? clip.getText() : null;
            if (!TextUtils.isEmpty(pasteCharSequence)) {
                str = str + pasteCharSequence.toString();
            }
            setText(Html.fromHtml(str));
            setSelection(getText().length());
            return true;
        }
        return super.onTextContextMenuItem(id);
    }
}
