package org.fengpiaohong.sudokugame;

import android.app.*;
import android.os.*;
import android.text.*;
import android.view.View.*;
import android.widget.*;
import android.view.*;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    public void onClick(View v) {
        // TODO: Implement this method
        if (v.equals(btnTest1)) {
            met.setText("12345678912345678912345678912345678912345678912345678912345678912345678912345678");
            return;
        }
        if (v.equals(btnTest2)) {
            met.setSelection(2);
            return;
        }
        if (v.equals(btnInit)) {

            return;
        }
    }

    EditText met;
    Button btnTest1, btnTest2, btnInit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        met = (EditText) findViewById(R.id.et);
        btnTest1 = (Button) findViewById(R.id.btntest1);
        btnTest2 = (Button) findViewById(R.id.btntest2);
        btnInit = (Button) findViewById(R.id.btninit);
        btnTest1.setOnClickListener(this);
        btnTest2.setOnClickListener(this);
        btnInit.setOnClickListener(this);


        SpannableStringBuilder builder = new SpannableStringBuilder("红白蓝绿黄");


        //builder.setSpan(redSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        met.setText(builder);

        TextWatcher tw = (new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4) {
                //Toast.makeText(MyApplication.grtContext(),"before "+p1+"  "+p2+"  "+p3+"  "+p4,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTextChanged(CharSequence p1, int p2, int p3, int p4) {
                //Toast.makeText(MyApplication.grtContext(), "on " + p1 + "  " + p2 + "  " + p3 + "  " + p4, Toast.LENGTH_SHORT).show();
                if (p1.length() > 81) {
                    StringBuffer tmp = new StringBuffer(p1.toString());
                    tmp.delete(p2, p2 + p4);
                    met.setText(tmp);
                    if (p4 == 0)
                        met.setSelection(p2 - p3 + p4 + 1);
                    if (p3 == 0)
                        met.setSelection(p2 - p3 + p4 - 1);
                    if (p2 == 0) {
                        met.setSelection(p4);
                    }
                    return;
                }
                met.removeTextChangedListener(this);
                String p = String.valueOf(p1);
                SpannableStringBuilder ssb = new SpannableStringBuilder(p);
                for (int i = 1; i <= p.length() / 9; i++) {
                    ssb.setSpan(FGC.get(i), (i - 1) * 9, i * 9, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                //System.out.println((p.length() / 9) * 9  + "   " + ((p.length()) % 9+(p.length() / 9)*9)+"  ");
                //System.out.println(String.valueOf( p.charAt((int)(p.length() / 9) * 9+ (p.length()-1)>=0?(p.length()-1):0 % 9)));
                if (p.length() % 9 != 0) {
                    /*param1为类html,param2为beginIndex,param3为endIndex 这里不是offset,param4为常量*/
                    ssb.setSpan(FGC.get(p.length() / 9 + 1), (p.length() / 9) * 9, (p.length()) % 9 + (p.length() / 9) * 9, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                met.setText(ssb);
                met.addTextChangedListener(this);
                System.out.println(p2 + "  " + p3 + "  " + p4);
                if (p2 == 0) {
                    met.setSelection(p4);
                } else {
                    if (p4 == 0)

                        met.setSelection(p2);
                    if (p3 == 0)
                        met.setSelection(p2 - p3 + p4);
                }


            }

            @Override
            public void afterTextChanged(Editable p1) {
                //Toast.makeText(MyApplication.grtContext(),"after "+p1,Toast.LENGTH_LONG).show();
            }


        });
        met.addTextChangedListener(tw);
    }
}
