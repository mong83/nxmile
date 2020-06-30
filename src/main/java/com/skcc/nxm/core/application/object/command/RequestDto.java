package com.skcc.nxm.core.application.object.command;


import com.skcc.nxm.core.domain.entity.member.DealerFlag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDto {

    @NotNull(message = "req_fg is empty")
    private String reqFg;      // M1~M4
    @NotNull(message = "searchFg is empty")
    private String searchFg;    //1:회원ID, 2:회원구분번호, 3:카드번호, 4:CI
    private String mbrId;
    private String mbrFg;       //1:일반, 2:법인, 3:개인사업자, 4:패밀리, 5:단체
    private String mbrFgNo;     //법인/개인사업자
    private String ci;
    private String dealerFlag;
    private String corpBizNo;

    @NotNull(message = "mbrSts is empty")
    @Pattern(regexp = "A|U|S",message = "mbrSts value is wrong.(A,U,S)")
    private String mbrSts;

    private String hName;
    private String eName;
    @Email(message = "email format is wrong")
    private String email;
    private String birthDay;
    private String phoneNumber;
    private String sex;

    private String offTelNo;
    private String offZipNo;
    private String offAddr1;
    private String offAddr2;

    private String homeTelNo;
    private String homeZipNo;
    private String homeAddr1;
    private String homeAddr2;

    @NotNull(message = "cardNo is empty")
    @Size(min = 11 , max = 16, message = "cardNo lenth is invalid")
    private String cardNo;
    @NotNull(message = "cardSts is empty")
    @Pattern(regexp = "A|R|F",message = "crdSts value is wrong.(A,R,F)")
    private String cardSts;
    private String coopCardCode;
    private String issueDay;
    private String issueMchtNo;

    private String agreeVersion;
    private String agreeDy;
    private String agreeYN;


    private String mbrUpdDy;

    @NotNull(message = "organCd is empty")
    private String organCode;

}
