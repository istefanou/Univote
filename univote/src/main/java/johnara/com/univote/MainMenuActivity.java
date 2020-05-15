package johnara.com.univote;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainMenuActivity extends Activity {

    private String username;
    private String am;
    private String onomateponimo;
    private String tmima;
    private int etos_eisagwghs;
    private String email;
    private boolean melos_dep;
    @Override
    public void onBackPressed() {

    }

    int next_color=0;
    LinearLayout linear_layout_polls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        linear_layout_polls = (LinearLayout) findViewById(R.id.linear_layout_polls);

        Intent intent = getIntent();
        Bundle intentBundle = intent.getExtras();
    }


    public void disable_button(View view) {
        Button result = (Button) findViewById(R.id.result);
        Button top = (Button) findViewById(R.id.top);
        Button subvotes = (Button) findViewById(R.id.subvotes);


        result.setEnabled(true);
        top.setEnabled(true);
        subvotes.setEnabled(true);

        view.setEnabled(false);
    }

    public void new_poll(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        //alert.setIcon(R.drawable.icon).
        LayoutInflater factory = LayoutInflater.from(this);
        final View poll = factory.inflate(R.layout.create_poll, null);
        alert.setTitle(
                "Create Poll:").setView(
                poll).setPositiveButton("Add",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
                        Spinner type = (Spinner) poll.findViewById(R.id.type);
                        EditText subject = (EditText) poll.findViewById(R.id.subject);
                        EditText question = (EditText) poll.findViewById(R.id.question);
                        CheckBox anonymity = (CheckBox) poll.findViewById(R.id.anonymity);
                        EditText time = (EditText) poll.findViewById(R.id.time);

                        add_poll_to_main_menu(type.getSelectedItem().toString(),subject.getText().toString(),question.getText().toString(),anonymity.isChecked(),time.getText().toString());
                    }
                }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
                        /*
                         * User clicked cancel so do some stuff
                         */
                    }
                });
        alert.show();
    }

    private void add_poll_to_main_menu(String s, String subjectText, final String questionText, boolean checked, String time) {
        if(s.equals("Yes-No")){

            LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View poll_created_view = vi.inflate(R.layout.poll_created_yes_no, null);

            TextView question = (TextView) poll_created_view.findViewById(R.id.textview_question);
            question.setText(questionText);

            TextView subject = (TextView) poll_created_view.findViewById(R.id.textview_subject);
            subject.setText(subjectText);

            CheckBox anonimity = (CheckBox) poll_created_view.findViewById(R.id.anonymity);
            anonimity.setChecked(checked);

            final TextView timer = (TextView) poll_created_view.findViewById(R.id.time_remaining);

            final Button yes_button = (Button) poll_created_view.findViewById(R.id.button_yes);
            final Button no_button = (Button) poll_created_view.findViewById(R.id.button_no);

            yes_button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(MainMenuActivity.this, "Voted yes", Toast.LENGTH_SHORT).show();
                    yes_button.setEnabled(false);
                    no_button.setEnabled(false);
                }
            });

            no_button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(MainMenuActivity.this, "Voted no", Toast.LENGTH_SHORT).show();
                    yes_button.setEnabled(false);
                    no_button.setEnabled(false);
                }
            });

            final Button forum_button = (Button) poll_created_view.findViewById(R.id.button_forum);

            forum_button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                   //Need forum class
                }
            });

            String[] time_parts = time.toString().split(":");

            int days = Integer.parseInt(time_parts[0]);

            int hours = Integer.parseInt(time_parts[1]);

            final int minutes = Integer.parseInt(time_parts[2]);


            int time_in_ms = 60000*(minutes+(60*(hours+(24*days))));

            new CountDownTimer(time_in_ms, 1000) {

                public void onTick(long millisUntilFinished) {
                    int seconds_remaining = (int) (millisUntilFinished / 1000);
                    int days_remaining = seconds_remaining/(60*60*24);
                    seconds_remaining = seconds_remaining%(60*60*24);
                    int hours_remaining = seconds_remaining/(60*60);
                    seconds_remaining = seconds_remaining%(60*60);
                    int minutes_remaining = seconds_remaining/(60);
                    seconds_remaining = seconds_remaining%(60);
                    timer.setText(days_remaining+"D"+hours_remaining+"H"+minutes_remaining+"M"+seconds_remaining+"S");
                    //here you can have your logic to set text to edittext
                }

                public void onFinish() {
                    linear_layout_polls.removeView(poll_created_view);
                }

            }.start();

            if(next_color==0){
                poll_created_view.setBackgroundColor(Color.RED);
                next_color=1;
            }
            else{
                poll_created_view.setBackgroundColor(Color.YELLOW);
                next_color=0;
            }
            linear_layout_polls.addView(poll_created_view);
        }
    }


    public void SearchPoll() {

    }

    public void add_new_dep(View view) {
        if(melos_dep) {
            //Open Form for new Dep register
        }
    }

    public void CheckPendingRegisters(View view) {
        if(melos_dep) {
            //ShowPending Register for students
        }
    }

}