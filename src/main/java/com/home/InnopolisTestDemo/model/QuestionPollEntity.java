package com.home.InnopolisTestDemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "question_of_poll")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionPollEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "poll")
    @MapsId
    private PollEntity poll;

    @Column(name = "text_poll")
    private String textPoll;

    @Column(name = "order_num")
    private Long orderNum;
}
