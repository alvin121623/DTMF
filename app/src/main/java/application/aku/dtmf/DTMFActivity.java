package application.aku.dtmf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.ContactsContract;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class DTMFActivity extends Activity implements View.OnClickListener,
        View.OnLongClickListener {

    private EditText mPhoneNumberField;
    private Button mOneButton;
    private Button mTwoButton;
    private Button mThreeButton;
    private Button mFourButton;
    private Button mFiveButton;
    private Button mSixButton;
    private Button mSevenButton;
    private Button mEightButton;
    private Button mNineButton;
    private Button mZeroButton;
    private Button mAButton;
    private Button mBButton;
    private Button mCButton;
    private Button mDButton;
    private Button mStartButton;
    private Button mHastagButton;
    private Button mPlusButton;
    private Button mOkButton;
    private ImageButton mDeleteButton;
    private SeekBar sbfrekuensi;
    private TextView tvlama;

    private static final int DURATION = 50; // lama getar (vibratio) waktu tombol ditekan

    private Vibrator mVibrator; // untuk efek getar waktu tombol di tekan
    private DTMFGenerator mDtmfGenerator;

    int lama = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dtmf_activity);

        mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mDtmfGenerator = new DTMFGenerator();
        initUI();
    }

    private void initUI() {
        initializeViews();
        addNumberFormatting();
        setClickListeners();
    }

    private void initializeViews() {
        mPhoneNumberField = (EditText) findViewById(R.id.phone_number);
        mOneButton = (Button) findViewById(R.id.one);
        mTwoButton = (Button) findViewById(R.id.two);
        mThreeButton = (Button) findViewById(R.id.three);
        mFourButton = (Button) findViewById(R.id.four);
        mFiveButton = (Button) findViewById(R.id.five);
        mSixButton = (Button) findViewById(R.id.six);
        mSevenButton = (Button) findViewById(R.id.seven);
        mEightButton = (Button) findViewById(R.id.eight);
        mNineButton = (Button) findViewById(R.id.nine);
        mZeroButton = (Button) findViewById(R.id.zero);
        mAButton = (Button) findViewById(R.id.aaa);
        mBButton = (Button) findViewById(R.id.bbb);
        mCButton = (Button) findViewById(R.id.ccc);
        mDButton = (Button) findViewById(R.id.ddd);
        mStartButton = (Button) findViewById(R.id.start);
        mHastagButton = (Button) findViewById(R.id.hastag);
        mPlusButton = (Button) findViewById(R.id.plus);
        mOkButton = (Button) findViewById(R.id.okButtons);
        mDeleteButton = (ImageButton) findViewById(R.id.deleteButton);
        tvlama = (TextView) findViewById(R.id.tvlama);
        sbfrekuensi = (SeekBar) findViewById(R.id.sbfrekuensi);
    }

    /**
     * Adds number formatting to the field
     */
    private void addNumberFormatting() {
        sbfrekuensi.setProgress(300);
        lama = 300;
        tvlama.setText("Lama Bunyi: "+lama+" Microsecond");
    }

    /**
     * Sets click listeners for the views
     */
    private void setClickListeners() {
        mOneButton.setOnClickListener(this);
        mTwoButton.setOnClickListener(this);
        mThreeButton.setOnClickListener(this);
        mFourButton.setOnClickListener(this);
        mFiveButton.setOnClickListener(this);
        mSixButton.setOnClickListener(this);
        mSevenButton.setOnClickListener(this);
        mEightButton.setOnClickListener(this);
        mNineButton.setOnClickListener(this);
        mZeroButton.setOnClickListener(this);
        mAButton.setOnClickListener(this);
        mBButton.setOnClickListener(this);
        mCButton.setOnClickListener(this);
        mDButton.setOnClickListener(this);
        mStartButton.setOnClickListener(this);
        mHastagButton.setOnClickListener(this);
        mPlusButton.setOnClickListener(this);
        mOkButton.setOnClickListener(this);
        mDeleteButton.setOnClickListener(this);
        mDeleteButton.setOnLongClickListener(this);

        sbfrekuensi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lama = progress;
                tvlama.setText("Lama Bunyi: "+lama+" Microsecond");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void keyPressed(int keyCode) {
        mVibrator.vibrate(DURATION);
        KeyEvent event = new KeyEvent(KeyEvent.ACTION_DOWN, keyCode);
        mPhoneNumberField.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one: {
                keyPressed(KeyEvent.KEYCODE_1);
                return;
            }
            case R.id.two: {
                keyPressed(KeyEvent.KEYCODE_2);
                return;
            }
            case R.id.three: {
                keyPressed(KeyEvent.KEYCODE_3);
                return;
            }
            case R.id.four: {
                keyPressed(KeyEvent.KEYCODE_4);
                return;
            }
            case R.id.five: {
                keyPressed(KeyEvent.KEYCODE_5);
                return;
            }
            case R.id.six: {
                keyPressed(KeyEvent.KEYCODE_6);
                return;
            }
            case R.id.seven: {
                keyPressed(KeyEvent.KEYCODE_7);
                return;
            }
            case R.id.eight: {
                keyPressed(KeyEvent.KEYCODE_8);
                return;
            }
            case R.id.nine: {
                keyPressed(KeyEvent.KEYCODE_9);
                return;
            }
            case R.id.zero: {
                keyPressed(KeyEvent.KEYCODE_0);
                return;
            }
            case R.id.aaa: {
                keyPressed(KeyEvent.KEYCODE_A);
                return;
            }
            case R.id.bbb: {
                keyPressed(KeyEvent.KEYCODE_B);
                return;
            }
            case R.id.ccc: {
                keyPressed(KeyEvent.KEYCODE_C);
                return;
            }
            case R.id.ddd: {
                keyPressed(KeyEvent.KEYCODE_D);
                return;
            }
            case R.id.start: {
                keyPressed(KeyEvent.KEYCODE_STAR);
                return;
            }
            case R.id.hastag: {
                keyPressed(KeyEvent.KEYCODE_POUND);
                return;
            }
            case R.id.plus: {
                keyPressed(KeyEvent.KEYCODE_PLUS);
                return;
            }
            case R.id.deleteButton: {
                keyPressed(KeyEvent.KEYCODE_DEL);
                return;
            }
            case R.id.okButtons: {
                dialNumber();
                return;
            }


        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Uri uri = data.getData();

            if (uri != null) {
                Cursor c = null;
                try {
                    c = getContentResolver().query(uri, new String[]{ 
                                ContactsContract.CommonDataKinds.Phone.NUMBER,  
                                ContactsContract.CommonDataKinds.Phone.TYPE },
                            null, null, null);

                    if (c != null && c.moveToFirst()) {
                        String number = c.getString(0);
                        int type = c.getInt(1);
                        showSelectedNumber(type, number);
                    }
                } finally {
                    if (c != null) {
                        c.close();
                    }
                }
            }
        }
    }

    public void showSelectedNumber(int type, String number) {
    	mPhoneNumberField.setText(number);
    	mPhoneNumberField.setSelection(mPhoneNumberField.getText().length());
    }
    
    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.deleteButton: {
                Editable digits = mPhoneNumberField.getText();
                digits.clear();
                return true;
            }
        }
        return false;
    }

    private void dialNumber() {
        String number = mPhoneNumberField.getText().toString();
        number = number.replace(" ", "");
        if (number.length() > 0) {
        	try {
				mDtmfGenerator.playDtmfSequence(number, lama);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

    }
}
