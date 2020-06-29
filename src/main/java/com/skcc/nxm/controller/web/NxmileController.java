package com.skcc.nxm.controller.web;

import com.skcc.nxm.core.application.object.command.MemberValidator;
import com.skcc.nxm.core.application.object.command.RequestDto;
import com.skcc.nxm.core.application.service.INxmileService;
import com.skcc.nxm.infrastructure.external_system.ExternalCallSample_Atype;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Object> sample(){
        log.debug("[Controller] ConfigServerController Called - sample");

        return ResponseEntity.ok("kyk- external call");
    }

    @PostMapping
    public ResponseEntity<Object> register(@RequestBody @Valid RequestDto requestDto){

        log.debug("[Controller] ConfigServerController Called - register");

        //@Valid 통한 입력값 검증

        //@Biz 로직을 통한 입력값 검증
        memberValidator.validate(requestDto);


        System.out.println("====" + requestDto.getSearchFg() +"[" + requestDto.getOrganCode()+"]" +requestDto.getMbrId());
        return  ResponseEntity.ok("kyk");
        // return NXmileService.register(requestDto);
    }

}
