package wengxiaoyang.hziee.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import wengxiaoyang.hziee.geoquiz.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {


    private ActivityMain2Binding binding;

    /*private Question mQuestion;
    private int mCurrentIndex = 0;
    private int mCurrentAnswer = 0;
    private static int mCheckNumber = 3;
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private static final String KEY_INDEX2 = "index2";
    private static final String KEY_Answer = "Answer";
    private static final String KEY_MIS_CHEATER = "m_is_check";
    private static final String EXTRA_CHECK_NUMBER = "wengxiaoyang.hziee.geoquiz.check_number";
    private static final int REQUEST_CODE_CHEAT = 0;*/


    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };

    //private boolean[] mIsCheater = new boolean[mQuestionBank.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d(TAG, "onCreate(Bundle) called");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        binding.setViewModel(new QuestionViewModel(mQuestionBank));

        /*for (int i = 0; i< mQuestionBank.length; i++) {
            mIsCheater[i] = false;
        }*/

        /*if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
            mCurrentAnswer = savedInstanceState.getInt(KEY_INDEX2, 0);
            mCheckNumber = savedInstanceState.getInt(EXTRA_CHECK_NUMBER,3);
            mIsCheater  =savedInstanceState.getBooleanArray(KEY_MIS_CHEATER);
            int[] answerList = savedInstanceState.getIntArray(KEY_Answer);
            for (int i=0;i < mQuestionBank.length;i++){
                mQuestionBank[i].setIsAnswered(answerList[i]);
            }
        }*/

        //mQuestion = mQuestionBank[mCurrentIndex];


        /*binding.trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(true);
                binding.trueButton.setEnabled(false);
                binding.falseButton.setEnabled(false);
            }
        });

        binding.falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
                if(mCurrentIndex == 0){
                    double i = mCurrentAnswer *1.0 / mQuestionBank.length *100;
                    Toast toast = Toast.makeText(MainActivity2.this, String.valueOf(i), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER, 0,500);
                    toast.show();
                   }
            }
        });

        binding.lastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                updateQuestion();
            }
        });*/

        /*binding.cheatButton.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                //Start CheatActivity
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
                Intent intent = CheatActivity.newIntent(MainActivity2.this, answerIsTrue);
                intent.putExtra(EXTRA_CHECK_NUMBER,mCheckNumber);
                startActivityForResult(intent, REQUEST_CODE_CHEAT);
             }
        });*/

        //updateQuestion();
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE_CHEAT) {
            if (data == null) {
                return;
            }
            mIsCheater[mCurrentIndex] = CheatActivity.wasAnswerShown(data);
            mCheckNumber = data.getIntExtra(EXTRA_CHECK_NUMBER,0);
        }
    }*/

    /*@Override
    public void onStart(){
        super.onStart();
        if (mCheckNumber == 0) {
            binding.cheatButton.setEnabled(false);
        }
        binding.setCheckNumber(mCheckNumber);
        //Log.d(TAG, "onStart() called");
    }*/

    /*@Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "onResume() called");
    }*/

    /*@Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "onPause() called");
    }*/

    /*@Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSavedInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
        savedInstanceState.putInt(KEY_INDEX2,mCurrentAnswer);
        savedInstanceState.putInt(EXTRA_CHECK_NUMBER,mCheckNumber);
        int[] answerList = new int [mQuestionBank.length];
        for(int i = 0;i < answerList.length;i++){
            answerList[i] = mQuestionBank[i].getIsAnswered();
        }

        savedInstanceState.putIntArray(KEY_Answer,answerList);
        savedInstanceState.putBooleanArray(KEY_MIS_CHEATER,mIsCheater);
    }*/

    /*@Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop() called");
    }*/

    /*@Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }*/

    /*private  void updateQuestion() {
        mQuestion = mQuestionBank[mCurrentIndex];
        //binding.setViewModel(new QuestionViewModel(mQuestion));
        ButtonEnable();
    }*/

    /*public void ButtonEnable(){
        if(mQuestionBank[mCurrentIndex].getIsAnswered()>0) {
            binding.trueButton.setEnabled(false);
            binding.falseButton.setEnabled(false);
        }else {
            binding.trueButton.setEnabled(true);
            binding.falseButton.setEnabled(true);
        }
    }*/

    /*private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if (mIsCheater[mCurrentIndex]) {
            messageResId = R.string.judgment_toast;
            mQuestionBank[mCurrentIndex].setIsAnswered(1);
        } else {
            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.correct_toast;
                mCurrentAnswer++;
                mQuestionBank[mCurrentIndex].setIsAnswered(1);
            } else {
                messageResId = R.string.incorrect_toast;
                mQuestionBank[mCurrentIndex].setIsAnswered(1);
            }
        }
        ButtonEnable();

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }*/
}
