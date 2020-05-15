package com.home.InnopolisTestDemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PollDto {

    private Long PollId;

    private String nameOfPoll;

    private Date startDate;

    private Date endDate;

    private Long questionOfPollId;

    private Boolean activity;

    private String textPoll;

    private Long orderNum;
}
