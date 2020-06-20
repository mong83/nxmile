package com.skcc.nxm.controller.web;

import com.skcc.nxm.core.application.object.command.MemberValidator;
import com.skcc.nxm.core.application.object.command.RequestDto;
import com.skcc.nxm.core.application.service.INxmileService;
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
    //개발하면됨..
    //2020.06.20

    private final INxmileService NXmileService;

    @Autowired
    MemberValidator memberValidator;

    @PostMapping
    public ResponseEntity<Object> register(@RequestBody @Valid RequestDto requestDto, Errors errors){

        log.debug("[Controller] ConfigServerController Called - register");

        //필수입력값 검증
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().build();
        }

        //입력값 검증
        memberValidator.validate(requestDto , errors);

        if(errors.hasErrors()){
            System.out.println("input validation error");
            return ResponseEntity.badRequest().build();
        }


        System.out.println("====" + requestDto.getSearchFg() +"[" + requestDto.getOrganCode()+"]" +requestDto.getMbrId());
        return  ResponseEntity.ok("kyk");
        // return NXmileService.register(requestDto);
    }

}
