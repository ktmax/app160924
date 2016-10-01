package com.hjj.my.app160924.member;

import android.util.Log;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberServiceImpl implements MemberService{
    MemberDAO dao = new MemberDAO();
    @Override
    public MemberDTO login(MemberDTO param) {
        Log.i("----service 에서 받은 id : ",param.getId());   // 모니터에서 보이게 찍음
        Log.i("----service 에서 받은 pw : ",param.getPw());   // 모니터에서 보이게 찍음
        MemberDTO member = new MemberDTO();
        //MemberDTO member = new MemberDTO();
        member = dao.select(param);
        if(member ==null){
            member.setId("NONE");
           // member.setId(param.getid()+"는 존재하지 않는 아이디 입니다.");
            return member;
        }else if(member.getPw().equals(param.getPw())){
            return member;
        }else{
            member.setId("NO_MATCH");
           // member.setId(param.getid()+"의 비밀번호가 일치하지 않습니다.");
            return member;
        }
    }

    @Override
    public MemberDTO join(MemberDTO  param) {
        return null;
    }
}
