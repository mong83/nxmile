package com.skcc.nxm.core.application.object.command;


import com.skcc.common.error.ErrorCode;
import com.skcc.common.error.exception.BusinessException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class MemberValidator {

    public void validate(RequestDto requestDto) {

        if(requestDto.getSearchFg().equals("1") && requestDto.getMbrId()==null) {
            System.out.println("validate - err"+"["+requestDto.getSearchFg()+"]"+"["+requestDto.getMbrId()+"]");
            throw new BusinessException("NotFound", ErrorCode.EMPTY_MBRID);
        }

            System.out.println("validate - success" + "[" + requestDto.getSearchFg() + "]" + "[" + requestDto.getMbrId() + "]");


    }
}
