package com.hjj.my.app160924.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hjj.my.app160924.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    Button bt_login,bt_join;
    EditText et_id,et_pw;
    MemberService service = new MemberServiceImpl();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_join = (Button) findViewById(R.id.bt_join);
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        bt_login.setOnClickListener(this);
        bt_join.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String id = et_id.getText().toString(),
                pw = et_pw.getText().toString();
        MemberDTO member = new MemberDTO();
        member.setId(id);
        member.setPw(pw);

        switch (v.getId()) {
            case R.id.bt_login:

                member = service.login(member);
                if(member.getId().equals("NONE")){
                    Toast.makeText(LoginActivity.this,
                            "존재하지 않는 아이디 입니다.",
                            Toast.LENGTH_LONG).show();

                }else if(member.getId().equals("NO_MATCH")){
                    Toast.makeText(LoginActivity.this,
                            "비밀번호가 일치하지 않습니다.",
                            Toast.LENGTH_LONG).show();
                }else {
                Toast.makeText(LoginActivity.this,
                        "환영합니다."+member.getName(),
                        Toast.LENGTH_LONG).show();
                 }
                break;
            case R.id.bt_join:

                break;
        }
    }
}
