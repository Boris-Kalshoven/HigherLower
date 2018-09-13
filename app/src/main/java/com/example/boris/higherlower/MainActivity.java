package com.example.boris.higherlower;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Local variables
    private boolean mNextGuess;
    private int mCurrentScore;
    private TextView mScore;
    private TextView mHighScore;
    private ListView mListView;
    private List mThrows;
    private FloatingActionButton mLowerGuess;
    private FloatingActionButton mHigherGuess;
    private int currentImageIndex = 0;
    private int[] mImageNames;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing variables with view
        mScore = findViewById(R.id.scoreView);
        mHighScore = findViewById(R.id.highscoreView);
        mListView = findViewById(R.id.throwView);
        mLowerGuess = findViewById(R.id.lowerGuessBtn);
        mHigherGuess = findViewById(R.id.higherGuessBtn);
        mImageView = findViewById(R.id.imageViewDices);

        mImageNames = new int[]{R.drawable.d1,R.drawable.d2,R.drawable.d3,
                                R.drawable.d4,R.drawable.d5,R.drawable.d6};

        mLowerGuess.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                currentImageIndex = newDiceThrow();
                countLowerScore();
                mImageView.setImageResource(mImageNames[currentImageIndex]);
            }
        });

        mHigherGuess.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currentImageIndex = newDiceThrow();
                countHigherScore();
                mImageView.setImageResource(mImageNames[currentImageIndex]);
            }
        });
    }

    public int newDiceThrow(){
        int newNumber = (int)((Math.random() * 6) +1);
        return newNumber;
    }



    public void countLowerScore(){
        if (newDiceThrow() < currentImageIndex){
            mCurrentScore++;
            Snackbar.make(mImageView, "Correct", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
        } else {
            Snackbar.make(mImageView, "Wrong", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
            mCurrentScore = 0;
        }

    }

    public void countHigherScore(){
        if (newDiceThrow() > currentImageIndex){
            mCurrentScore++;
            Snackbar.make(mImageView, "Correct", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
        } else {
            Snackbar.make(mImageView, "Wrong", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
            mCurrentScore = 0;
        }
    }


}
