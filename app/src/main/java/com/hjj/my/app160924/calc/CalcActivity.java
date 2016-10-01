package com.hjj.my.app160924.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hjj.my.app160924.R;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_num_1,et_num_2;
    Button bt_plus,bt_minus,bt_multi,bt_divide,bt_remainder,bt_equal;
    TextView tv_result;
    int result;
    CalcService service = new CalcServiceImpl();
    CalcDTO cal = new CalcDTO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        et_num_1 = (EditText) findViewById(R.id.et_num_1);
        et_num_2 = (EditText) findViewById(R.id.et_num_2);
        bt_plus = (Button) findViewById(R.id.bt_plus);
        bt_minus = (Button) findViewById(R.id.bt_minus);
        bt_multi = (Button) findViewById(R.id.bt_multi);
        bt_divide = (Button) findViewById(R.id.bt_divide);
        bt_remainder = (Button) findViewById(R.id.bt_remainder);
        bt_equal = (Button) findViewById(R.id.bt_equal);
        tv_result = (TextView) findViewById(R.id.tv_result);
        bt_plus.setOnClickListener(this);
        bt_minus.setOnClickListener(this);
        bt_divide.setOnClickListener(this);
        bt_equal.setOnClickListener(this);
        bt_remainder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int num1 = Integer.parseInt(et_num_1.getText().toString());
        int num2 = Integer.parseInt(et_num_2.getText().toString());
        cal.setNum1(num1);
        cal.setNum2(num2);
       /*cal = service.minus(cal);*/
        switch (v.getId()){
            case R.id.bt_minus       :
                result = service.minus(cal).getResult();
                break;
            case R.id.bt_plus        :
                result = service.plus(cal).getResult();
                break;

            case R.id.bt_divide      :
                result = service.divid(cal).getResult();
                break;
            case R.id.bt_remainder  :
                result = service.remainder(cal).getResult();
                break;
            case R.id.bt_equal       :
                tv_result.setText("계산 결과: "+result);
                break;
        }
    }
}
