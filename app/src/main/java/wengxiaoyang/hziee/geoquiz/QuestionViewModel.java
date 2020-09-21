package wengxiaoyang.hziee.geoquiz;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

public class QuestionViewModel extends BaseObservable {
    private Question mQuestion;
    private Question[] mQuestionBank;
    private String[] message = new String[6];
    private static int mCurrentIndex = 0;


    public QuestionViewModel(Question[] question){
        mQuestionBank = question;
        mQuestion = question[0];
    }

    @Bindable
    public int getTextResId() {
        return mQuestion.getTextResId();
    }
    public void setAnswerTrue(boolean answerTrue) {
        mQuestion.setAnswerTrue(answerTrue);
    }

    public boolean isAnswerTrue() {
        return mQuestion.isAnswerTrue();
    }

    public void setTextResId(int textResId) {
        mQuestion.setTextResId(textResId);
    }

    public int getIsAnswered() {
        return mQuestion.getIsAnswered();
    }

    public void setIsAnswered(int isAnswered) {
        mQuestion.setIsAnswered(isAnswered);
    }

    public String getMessage() {
        return message[mCurrentIndex];
    }



    public void trueButtonClick(){
        checkAnswer(true);
        notifyChange();
    }

    public void falseButtonClick(){
        checkAnswer(false);
        notifyChange();
    }

    public void nextButtonClick(){
        mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
        updateQuestion();
        notifyChange();
    }

    public void lastButtonClick(){
        mCurrentIndex = (mCurrentIndex - 1 + mQuestionBank.length) % mQuestionBank.length;
        updateQuestion();
        notifyChange();
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        if (userPressedTrue == answerIsTrue) {
            message[mCurrentIndex] = "回答正确!";
            mQuestionBank[mCurrentIndex].setIsAnswered(1);
        } else {
            message[mCurrentIndex] = "回答错误!";
            mQuestionBank[mCurrentIndex].setIsAnswered(1);
        }
        ButtonEnable();
        notifyChange();
    }

    public int ButtonEnable(){
        if(mQuestionBank[mCurrentIndex].getIsAnswered()>0) {
            return View.INVISIBLE;
        }else {
            return View.VISIBLE;
        }
    }

    private  void updateQuestion() {
        mQuestion = mQuestionBank[mCurrentIndex];
        //binding.setViewModel(new QuestionViewModel(mQuestion));
        ButtonEnable();
        notifyChange();
    }
}
