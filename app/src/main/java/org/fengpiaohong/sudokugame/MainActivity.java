package org.fengpiaohong.sudokugame;

import android.app.*;
import android.os.*;
import android.text.*;
import android.view.View.*;
import android.widget.*;
import android.view.*;

public class MainActivity extends Activity implements OnClickListener
{

	@Override
	public void onClick(View v)
	{
		// TODO: Implement this method
		if(v.equals(btnTest1)){
			met.setText("56789");
			return;
		}
		if(v.equals(btnTest2)){
			
			return;
		}
		if(v.equals(btnInit)){
			
			return;
		}
	}
	
	EditText met;
	Button btnTest1,btnTest2,btnInit;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		met=(EditText) findViewById(R.id.et);
		btnTest1=(Button) findViewById(R.id.btntest1);
		btnTest2=(Button) findViewById(R.id.btntest2);
		btnInit=(Button) findViewById(R.id.btninit);
		btnTest1.setOnClickListener(this);
		btnTest2.setOnClickListener(this);
		btnInit.setOnClickListener(this);
		
		
		SpannableStringBuilder builder = new SpannableStringBuilder("红白蓝绿黄");

		


		
		//builder.setSpan(redSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		

		
		met.setText(builder);
		
		TextWatcher tw=(new TextWatcher()
		{

				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4){
					//Toast.makeText(MyApplication.grtContext(),"before "+p1+"  "+p2+"  "+p3+"  "+p4,Toast.LENGTH_LONG).show();
				}
				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4){
					Toast.makeText(MyApplication.grtContext(),"on "+p1+"  "+p2+"  "+p3+"  "+p4,Toast.LENGTH_LONG).show();
					met.removeTextChangedListener(this);

					SpannableStringBuilder ssb = new SpannableStringBuilder(met.getText());
					for(int i=1;i<=met.getText().length()/9;i++){
						ssb.setSpan(FGC.get(i),(i-1)*9,9,SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					}
					ssb.setSpan(FGC.get(met.getText().length()/9+1),(met.getText().length()/9)*9,met.getText().length()%9,SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
					met.setText(ssb);
					met.addTextChangedListener(this);
					
					
				}

				@Override
				public void afterTextChanged(Editable p1){
					//Toast.makeText(MyApplication.grtContext(),"after "+p1,Toast.LENGTH_LONG).show();
					}

			
		});
		met.addTextChangedListener(tw);
    }
}
