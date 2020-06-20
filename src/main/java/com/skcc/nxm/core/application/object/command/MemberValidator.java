package com.skcc.nxm.core.application.object.command;


import com.skcc.common.error.ErrorCode;
import com.skcc.common.error.exception.BusinessException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class MemberValidator {

    public void validate(RequestDto requestDto, Errors errors) {

        if(requestDto.getSearchFg().equals("1") && requestDto.getMbrId()==null){
            errors.rejectValue("mbrId","wrongValue","mbrId is wrong");
            BusinessException businessException = new BusinessException("NotFound", ErrorCode.ENTITY_NOT_FOUND);
            System.out.println("validate - err"+"["+requestDto.getSearchFg()+"]"+"["+requestDto.getMbrId()+"]"+businessException.getMessage());
        }else {

            System.out.println("validate - success" + "[" + requestDto.getSearchFg() + "]" + "[" + requestDto.getMbrId() + "]");
        }

    }
}
