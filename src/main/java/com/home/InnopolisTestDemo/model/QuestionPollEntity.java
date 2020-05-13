package com.home.InnopolisTestDemo.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Table(name = "polls")
@Getter
@Setter
public class QuestionPollEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "poll", referencedColumnName = "id")
    private PollEntity poll;

    @Column(name = "text_poll")
    private String textPoll;

    @Column(name = "order")
    private long order;
}
