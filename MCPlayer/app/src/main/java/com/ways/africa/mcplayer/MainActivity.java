package com.ways.africa.mcplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int UPDATE_STATUS_FREQUENCY=500;
    private static final int STEP_VALUE=4000;

    private MediaCursorAdapter mediaCursorAdapter= null;

    private TextView.selectedFile= null;

    private SeekBar seekBar= null;

    private MediaPlayer player=null;

    private ImageButton btnPlay= null, btnPrev= null,
            btnRewind= null, btnForward= null, btnNext = null;


    private boolean isStarted= true;

    private String CurrentFile="";

    private boolean isMovingSeekBar= false;

    private final Handler handler= new Handler();

    private final Runnable updatePositionRunnable= new Runnable() {

        @Override
        public void run() {
            updatePosition();
        }
    };
        private void updatePosition() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedFile=(TextView)findViewById(R.id.selectedFile);
        btnPlay=(ImageButton)findViewById(R.id.play);
        btnRewind=(ImageButton)findViewById(R.id.rewind);
        btnPrev=(ImageButton)findViewById(R.id.prev) ;
        btnForward= (ImageButton)findViewById(R.id.fastfoward);
        btnNext= (ImageButton)findViewById(R.id.next);


        player= new MediaPlayer();
        player.setOnCompletionListener(onCompletion);
        seekBar.setOnSeekBarChangeListener(SeekBarChanged);

        Cursor  cursor= getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,null);

        if(cursor!=null){
            
        }
        }
}
