package com.skcc.nxm.controller.web;

import com.skcc.nxm.core.application.object.command.RequestDto;
import com.skcc.nxm.core.application.service.INxmileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/member")
public class NxmileController {
    //개발하면됨..
    //2020.06.20

    private final INxmileService NXmileService;

    @PostMapping
    public ResponseEntity<Object> register(@RequestBody @Valid RequestDto requestDto){
        log.debug("[Controller] ConfigServerController Called - register");
        return NXmileService.register(requestDto);
    }

}
