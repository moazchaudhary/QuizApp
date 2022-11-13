package com.ultralegends.hm4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView q1, q2, q3, q4, q5, showResult;
    RadioGroup q1Group, q2Group, q3Group, q4Group, q5Group;
    RadioButton sample,q1o1,q1o2,q1o3,q1o4,q2o1,q2o2,q2o3,q2o4,q3o1,q3o2,q3o3,q3o4,q4o1,q4o2,q4o3,q4o4,q5o1,q5o2,q5o3,q5o4;
    Button resultbtn;
    int counter=0;

    String [] questions = {"Who is the king of Jungle?","What is the SI unit of distance?","What is the capital of Pakistan?","Which instrument is used to see micro-organisms?","Who is the founder of Pakistan?"};

    int noOfQuestions = questions.length;

    String [] options1 = {"Elephant","Tiger","Deer","Lion"};
    String [] options2 = {"meter","Kelvin","liter","Joule"};
    String [] options3 = {"Lahore","Karachi","Islamabad","Peshawar"};
    String [] options4 = {"Telescope","Microscope","Stathoscope","Miniscope"};
    String [] options5 = {"Muhammad Ali Jinnah","Allama Iqbal","Sir Syed Ahmed","Liaqat Ali Khan"};

    int noOfOptions = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1 = findViewById(R.id.q1);
        q1Group = findViewById(R.id.q1group);
        q1o1 = findViewById(R.id.q1o1);
        q1o2 = findViewById(R.id.q1o2);
        q1o3 = findViewById(R.id.q1o3);
        q1o4 = findViewById(R.id.q1o4);

        q2 = findViewById(R.id.q2);
        q2Group = findViewById(R.id.q2group);
        q2o1 = findViewById(R.id.q2o1);
        q2o2 = findViewById(R.id.q2o2);
        q2o3 = findViewById(R.id.q2o3);
        q2o4 = findViewById(R.id.q2o4);

        q3 = findViewById(R.id.q3);
        q3Group = findViewById(R.id.q3group);
        q3o1 = findViewById(R.id.q3o1);
        q3o2 = findViewById(R.id.q3o2);
        q3o3 = findViewById(R.id.q3o3);
        q3o4 = findViewById(R.id.q3o4);

        q4 = findViewById(R.id.q4);
        q4Group = findViewById(R.id.q4group);
        q4o1 = findViewById(R.id.q4o1);
        q4o2 = findViewById(R.id.q4o2);
        q4o3 = findViewById(R.id.q4o3);
        q4o4 = findViewById(R.id.q4o4);

        q5 = findViewById(R.id.q5);
        q5Group = findViewById(R.id.q5group);
        q5o1 = findViewById(R.id.q5o1);
        q5o2 = findViewById(R.id.q5o2);
        q5o3 = findViewById(R.id.q5o3);
        q5o4 = findViewById(R.id.q5o4);


        showResult = findViewById(R.id.showResult);
        resultbtn = findViewById(R.id.resultbtn);

        shuffleArray(questions);
        shuffleArray(options1);
        shuffleArray(options2);
        shuffleArray(options3);
        shuffleArray(options4);
        shuffleArray(options5);

        q1.setText(questions[0]);
        setOptionsOfThisQustion(q1,q1o1,q1o2,q1o3,q1o4);
        q2.setText(questions[1]);
        setOptionsOfThisQustion(q2,q2o1,q2o2,q2o3,q2o4);
        q3.setText(questions[2]);
        setOptionsOfThisQustion(q3,q3o1,q3o2,q3o3,q3o4);
        q4.setText(questions[3]);
        setOptionsOfThisQustion(q4,q4o1,q4o2,q4o3,q4o4);
        q5.setText(questions[4]);
        setOptionsOfThisQustion(q5,q5o1,q5o2,q5o3,q5o4);

        resultbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter=0;
                CheckAnswer(q1, q1Group);
                CheckAnswer(q2, q2Group);
                CheckAnswer(q3, q3Group);
                CheckAnswer(q4, q4Group);
                CheckAnswer(q5, q5Group);

                if(counter<=5)
                {
                    showResult.setText("Your result: "+counter+"/5");
                }
            }
        });
    }

    public void setOptionsOfThisQustion(TextView question, RadioButton o1,RadioButton o2,RadioButton o3,RadioButton o4)
    {
        if(question.getText().toString().equals("Who is the king of Jungle?"))
        {
            o1.setText(options1[0]);
            o2.setText(options1[1]);
            o3.setText(options1[2]);
            o4.setText(options1[3]);
        }
        else if(question.getText().toString().equals("What is the SI unit of distance?"))
        {
            o1.setText(options2[0]);
            o2.setText(options2[1]);
            o3.setText(options2[2]);
            o4.setText(options2[3]);
        }
        else if(question.getText().toString().equals("What is the capital of Pakistan?"))
        {
            o1.setText(options3[0]);
            o2.setText(options3[1]);
            o3.setText(options3[2]);
            o4.setText(options3[3]);
        }
        else if(question.getText().toString().equals("Which instrument is used to see micro-organisms?"))
        {
            o1.setText(options4[0]);
            o2.setText(options4[1]);
            o3.setText(options4[2]);
            o4.setText(options4[3]);
        }
        else if(question.getText().toString().equals("Who is the founder of Pakistan?"))
        {
            o1.setText(options5[0]);
            o2.setText(options5[1]);
            o3.setText(options5[2]);
            o4.setText(options5[3]);
        }
    }

    public void CheckAnswer(TextView question, RadioGroup qGroup)
    {
        int checkedButtenId = qGroup.getCheckedRadioButtonId();
        sample = findViewById(checkedButtenId);
        int colorCounter = 0;
        if(question.getText().toString().equals("Who is the king of Jungle?"))
        {
            if(sample.getText().toString().equals("Lion"))
            {
                counter++;
                colorCounter++;
            }
        }
        else if(question.getText().toString().equals("What is the SI unit of distance?"))
        {
            if(sample.getText().toString().equals("meter"))
            {
                counter++;
                colorCounter++;
            }
        }
        else if(question.getText().toString().equals("What is the capital of Pakistan?"))
        {
            if(sample.getText().toString().equals("Islamabad"))
            {
                counter++;
                colorCounter++;
            }
        }
        else if(question.getText().toString().equals("Which instrument is used to see micro-organisms?"))
        {
            if(sample.getText().toString().equals("Microscope"))
            {
                counter++;
                colorCounter++;
            }
        }
        else if(question.getText().toString().equals("Who is the founder of Pakistan?"))
        {
            if(sample.getText().toString().equals("Muhammad Ali Jinnah"))
            {
                counter++;
                colorCounter++;
            }
        }
        if(colorCounter==0)
        {
            sample.setTextColor(Color.RED);
        }
        else if(colorCounter==1)
        {
            sample.setTextColor(Color.GREEN);
        }
    }

    public void shuffleArray(Object[] array)
    {
        int arrLength = array.length;
        for (int i=0;i<arrLength; i++)
        {
            int s = i+ (int)(Math.random()*(arrLength-i));
            Object temp =array[s];
            array[s] = array[i];
            array[i] = temp;
        }
    }
}


