package com.skcc.nxm.core.application.object.command;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDto {

    private String searchFg;    //1:회원ID, 2:회원구분번호, 3:카드번호, 4:CI
    private String mbrFg;       //1:일반, 2:법인, 3:개인사업자, 4:패밀리, 5:단체
    private String mbrId;
    private String mbrFgNo;     //법인/개인사업자

    @NotNull(message = "organCd is empty")
    private String organCode;

}
