package by.pavlovskii.ilya.mvvm.test.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.TextView;

import by.pavlovskii.ilya.mvvm.test.R;
import by.pavlovskii.ilya.mvvm.test.view.AutofitHelper;
import by.pavlovskii.ilya.mvvm.test.view.AutofitLayout;
import timber.log.Timber;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 18.01.2018<br>
 * Time: 11:21<br>
 * Project name: MVVMtest<br>
 * ===================================================================================<br>
 */
public class TestActivity extends AppCompatActivity {

    private static final int MAX_LINES = 3;
    private AutofitLayout vAutofitLayout;
    private EditText vEditText;
    private AutofitHelper mAutofitHelper;

    private int mMaxTextSize;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        vAutofitLayout = findViewById(R.id.vAutofitLayout);
        vEditText = findViewById(R.id.vEditText);
        mAutofitHelper = vAutofitLayout.getAutofitHelper(vEditText);
        mAutofitHelper.setPrecision(0.3f);
        mMaxTextSize = getResources().getDimensionPixelSize(R.dimen.max_text_size);
        vEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mAutofitHelper.autofit();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                autoresizeTextView(editable);
            }
        });
    }

    private void autoresizeTextView(CharSequence charSequence) {
        autoresizeTextView(vEditText, vAutofitLayout, mAutofitHelper, charSequence);
    }

    private void autoresizeTextView(@NonNull TextView textView, @NonNull AutofitLayout autofitLayout,
                                    @NonNull AutofitHelper autofitHelper, @NonNull CharSequence charSequence) {
        int maxWidth = autofitLayout.getWidth() - (autofitLayout.getPaddingLeft() + autofitLayout.getPaddingRight());
        maxWidth = (int) (0.85 * maxWidth);
        int width = textView.getWidth();
        int wordCount = wordCount(charSequence);
        boolean hasNewLines = hasNewline(charSequence);
        Timber.d("TV width: %d Max width: %d Has new lines: %s Line count: %d", width, maxWidth, hasNewLines, textView.getLineCount());
        if (textView.getLineCount() == 1 && !hasNewLines && wordCount == 1 && width < maxWidth) {
            if (autofitHelper.getMaxTextSize() < mMaxTextSize) {
                autofitHelper.setRawMaxTextSize(mMaxTextSize);
            }
            return;
        }
        int newLine = hasNewLines ? 2 : 1;
        int maxLines = Math.max(newLine, Math.min(wordCount, MAX_LINES));
        int textSize = mMaxTextSize / maxLines;
        Timber.d("TV. Word: %d, Lines: %d Text size: %d MAX Text size: %d", wordCount, maxLines, textSize, mMaxTextSize);
        autofitHelper.setRawMaxTextSize(textSize);
        autofitHelper.setMaxLines(maxLines);
    }

    private boolean hasNewline(CharSequence text) {
        return text != null && text.toString().contains("\n");
    }

    private int wordCount(CharSequence text) {
        if (text != null && text.length() > 0) {
            return text.toString()
                    .trim()
                    .split("\\s+")
                    .length;
        } else {
            return 0;
        }
    }
}
