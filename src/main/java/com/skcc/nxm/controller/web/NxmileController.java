package com.skcc.nxm.controller.web;

import com.skcc.nxm.core.application.object.command.MemberValidator;
import com.skcc.nxm.core.application.object.command.RequestDto;
import com.skcc.nxm.core.application.service.INxmileService;
import com.skcc.nxm.infrastructure.external_system.ExternalCallSample_Atype;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/member")
public class NxmileController {

    private final INxmileService NXmileService;

    @Autowired
    MemberValidator memberValidator;


    @GetMapping(value = "/sample")
    public ResponseEntity<String> sample(){
        log.debug("[Controller] ConfigServerController Called - sample");

        return new ResponseEntity("sample success", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> register(@RequestBody @Valid RequestDto requestDto){

        log.debug("[Controller] ConfigServerController Called - register");

        //@Valid 통한 입력값 검증

        //@Biz 로직을 통한 입력값 검증
        memberValidator.validate(requestDto);


        System.out.println("====" + requestDto.getSearchFg() +"[" + requestDto.getOrganCode()+"]" +requestDto.getMbrId());

        //외부호출
        ExternalCallSample_Atype externalCallSample_atype = new ExternalCallSample_Atype();
        log.debug("[Controller] ExternalCallSample_Atype Called(before)- register");
        ResponseEntity<String> entity = externalCallSample_atype.doSomeExternalLogic(requestDto);
        String body = entity.getBody();
        log.debug("[Controller] ExternalCallSample_Atype Called(after)- register " + body);
        return  new ResponseEntity<Object>(body , HttpStatus.OK);

        // return NXmileService.register(requestDto);
    }

}
