package wengxiaoyang.hziee.geoquiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private int Cheat_Num;
    private Button mShowAnswerButton;
    private boolean mIsShowAnswer = true;
    private  static final String EXTRA_ANSWER_IS_TRUE = "wengxiaoyang.hziee.geoquiz.answer_is_true";
    private  static final String EXTRA_ANSWER_SHOWN = "wengxiaoyang.hziee.geoquiz.answer_shown";
    private static final String EXTRA_CHECK_NUMBER = "wengxiaoyang.hziee.geoquiz.check_number";
    private static final String FIRST_BUG = "first_bug";
    private static final String C_NUM = "c_num";
    private TextView mVersion;

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }

    public static Intent newIntent2(Context packageContext, int mCheckNumber) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_CHECK_NUMBER, mCheckNumber);
        return intent;
    }

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        if (savedInstanceState != null){
            mIsShowAnswer = savedInstanceState.getBoolean(FIRST_BUG,false);
            Cheat_Num = savedInstanceState.getInt(C_NUM,3);
            if (mIsShowAnswer) {
                setAnswerShownResult(mIsShowAnswer);
            }
        }

        int version = Integer.valueOf(Build.VERSION.SDK_INT);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        Cheat_Num = getIntent().getIntExtra(EXTRA_CHECK_NUMBER,0);

        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);

        mVersion = (TextView) findViewById(R.id.api_level);
        mVersion.setText("Api Level:" + version);

        mShowAnswerButton = (Button) findViewById(R.id.show_answer_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                }else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                if (Cheat_Num >= 0) {
                    Cheat_Num--;
                }
                setAnswerShownResult(true);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int cx = mShowAnswerButton.getWidth() /2;
                    int cy = mShowAnswerButton.getHeight() /2;
                    float radius = mShowAnswerButton.getWidth();
                    Animator anim = ViewAnimationUtils.createCircularReveal(mShowAnswerButton, cx, cy, radius, 0);
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            mShowAnswerButton.setVisibility(View.INVISIBLE);
                        }
                    });
                    anim.start();
                } else {
                    mShowAnswerButton.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        data.putExtra(EXTRA_CHECK_NUMBER,Cheat_Num);//作弊次数传回去
        setResult(RESULT_OK, data);
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(FIRST_BUG,mIsShowAnswer);
        savedInstanceState.putInt(C_NUM,Cheat_Num);
    }

}
