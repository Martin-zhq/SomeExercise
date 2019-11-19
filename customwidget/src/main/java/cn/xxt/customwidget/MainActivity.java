package cn.xxt.customwidget;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewAfterTextChangeEvent;
import com.vdurmont.emoji.EmojiParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    private static  Pattern EMOJI_PATTERN = Pattern.compile("&#\\d{1,6};");

    private EmojiEditText etInput;

    private TextView tvHtml;

    private TextView tvTransform;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        etInput = findViewById(R.id.et_input);
        tvHtml = findViewById(R.id.tv_html);
        tvTransform = findViewById(R.id.tv_transform);

        RxTextView.afterTextChangeEvents(etInput)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TextViewAfterTextChangeEvent>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {
                        String input = etInput.getText().toString();
//                        String htmlInput = EmojiParser.parseToHtmlDecimal(input);
                        String htmlInput = EmojiParser.parseToHtmlHexadecimal(input);
                        Log.d("zhqcount", "htmlo" + htmlInput.length());
                        int maxWord = 2000;
                        if (htmlInput.length() > maxWord) {
//                            Matcher emojiMatcher = EMOJI_PATTERN.matcher(htmlInput);
//                            if (emojiMatcher.find(1992)) {
//                                int firstMatchIndex = emojiMatcher.start();
//                                if (firstMatchIndex > 1999) {
//                                    //直接截取
//                                    htmlInput = htmlInput.substring(0, 2000);
//                                } else {
//                                    //截取到最后一个表情之前
//                                    htmlInput = htmlInput.substring(0, firstMatchIndex);
//                                }
//                            } else {
//                                //直接截取
//                                htmlInput = htmlInput.substring(0, 2000);
//                            }
//
//
//                            etInput.setText(Html.fromHtml(htmlInput));
//                            etInput.setSelection(etInput.getText().length(), etInput.getText().length());
//                            Log.d("zhqcount", etInput.getText().length() + "");
//                            Log.d("zhqcount", "html" + htmlInput.length());
                            Matcher emojiMatcher = EMOJI_PATTERN.matcher(htmlInput);
                            int subStringEndIndex = 0;
                            while (emojiMatcher.find()) {
                                String eachMatchString = emojiMatcher.group();
                                int matchBeginIndex = emojiMatcher.start();
                                int matchEndIndex = matchBeginIndex + eachMatchString.length() - 1;
                                if (matchBeginIndex <= maxWord - 1 && matchEndIndex > maxWord - 1) {
                                    //记录最大字数在被匹配到的字符串的开始和结束中间的开始坐标为待截取坐标
                                    subStringEndIndex = matchBeginIndex;
                                    break;
                                }
                            }
                            if (subStringEndIndex > 0) {
                                //最后一个表情坐标值横跨最大字数，截取到最后一个表情前
                                htmlInput = htmlInput.substring(0, subStringEndIndex);
                            } else {
                                //直接截取
                                htmlInput = htmlInput.substring(0, maxWord);
                            }
                            etInput.setText(Html.fromHtml(htmlInput));
                            etInput.setSelection(etInput.getText().length(), etInput.getText().length());
                            Log.d("zhqcount", etInput.getText().length() + "");
                            Log.d("zhqcount", "html" + htmlInput.length());
                        }
                    }
                });

        RxView.clicks(tvHtml)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Void aVoid) {
//                        String htmlStr = "&#003844;";
//
//                        SpannableStringBuilder builder = new SpannableStringBuilder();
//                        builder.append(EmojiParser.parseToUnicode(htmlStr));
                        Log.d("zhquni", EmojiParser.parseToHtmlDecimal("\uD80C\uDC19"));
//                        tvTransform.setText(EmojiParser.parseToUnicode());
                        if (etInput.getText().toString().length() > 0) {
                            tvTransform.setText(EmojiParser.parseToHtmlHexadecimal(etInput.getText().toString()));
                        }
                    }
                });

        RxView.clicks(tvTransform)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Void aVoid) {
//                        String htmlStr = EmojiParser.parseToHtmlDecimal(tvTransform.getText().toString());

//                        SpannableStringBuilder builder = new SpannableStringBuilder();
//                        builder.append(Html.fromHtml(htmlStr));
//
//                        tvTransform.setText(builder);
//                        etInput.setText(htmlStr);
                    }
                });
    }

    public static void main(String[] args) {
//        int max = 2000;
//        String str = "hahahhahahssssejsojfoajoifjaowf&#128514;";
//        if (str.length() > 2000) {
//
//        }
//        String test = "11h111h222h";
//        Matcher matcher = Pattern.compile("h").matcher(test);
//        if (matcher.find(3)) {
//            System.out.println(matcher.start());
//        }

//        String htmlStr = "&#003844;";
//        String test = Html.fromHtml(htmlStr).toString();
//        System.out.println(test);
//        String htmlTest = EmojiParser.parseToHtmlDecimal(test);
//        System.out.println(htmlTest);
    }


//        try {
//            String string = "11&#128514;sss&#128514;&#128515;&#128513;http://www.baidu.com**...11,15736873291&#128514;";
//            Pattern pattern = Pattern.compile("&#\\d{6};");
//            Matcher matcher = pattern.matcher(string);
//            List<String> stringList = new ArrayList<>();
//            StringBuffer stringBuffer = new StringBuffer();
//            while (matcher.find()){
//                matcher.appendReplacement(stringBuffer, "");
//                if (!stringBuffer.toString().equals("")) {
//                    stringList.add(stringBuffer.toString());
//                }
//                stringList.add(matcher.group());
//                stringBuffer = new StringBuffer();
//            }
//
//            matcher.appendTail(stringBuffer);
//            if (!stringBuffer.toString().equals("")) {
//                stringList.add(stringBuffer.toString());
//            }
//
//            System.out.println(stringList);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


}
