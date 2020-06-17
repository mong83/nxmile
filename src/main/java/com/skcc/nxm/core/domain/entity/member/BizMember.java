package com.skcc.nxm.core.domain.entity.member;

import com.skcc.nxm.core.domain.entity.card.Card;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("2")
@Getter
@Setter
public class BizMember extends Member {

    private String bizNo;

    private DealerFlag dealerFlag;

}
