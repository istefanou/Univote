package johnara.com.univote;
//POINTLESS
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class Forum extends Activity {

    private int id=0;

    LinearLayout linear_layout_messages;
    EditText message;
    int next_color = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum);
        linear_layout_messages = (LinearLayout) findViewById(R.id.linear_layout_messages);
        String title = getIntent().getStringExtra("Title");
        TextView title_textview = (TextView) findViewById(R.id.forum_title);
        message = (EditText) findViewById(R.id.editText_message);

        title_textview.setText("Forum Title : "+title);
    }

    public void send_message(View view) {
        TextView new_message = new TextView(getApplicationContext());
        new_message.setTextColor(Color.BLACK);

        Date currentTime = Calendar.getInstance().getTime();
        String minima = String.valueOf(message.getText());
        Minima_Forum minima_forum = new Minima_Forum(minima,currentTime,id);

        new_message.setText(minima_forum.getMinima()+" ["+minima_forum.getTimeSent()+"]");
        linear_layout_messages.addView(new_message);
        message.setText("");
        saveMessageToDB();
    }

    private void loadMessages(){
        //load messages from DB

    }

    private void saveMessageToDB(){
        //save message from DB

    }
}