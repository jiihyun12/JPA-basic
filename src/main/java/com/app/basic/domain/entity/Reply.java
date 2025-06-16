package com.app.basic.domain.entity;

import com.app.basic.domain.type.ReplyStatus;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TBL_REPLY")
public class Reply {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include // 포함
    private Long id;
    //    @EqualsAndHashCode.Exclude 제거
    private String replyContent;
    private String replyWrite;
    @Enumerated(EnumType.STRING)
    private ReplyStatus replyStatus;
}
