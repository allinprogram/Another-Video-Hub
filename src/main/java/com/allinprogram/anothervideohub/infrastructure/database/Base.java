package com.allinprogram.anothervideohub.infrastructure.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Base
 *
 * @author AllinProgram
 * @since 2022-06-04 19:47 星期六
 */
@Getter
@Setter
@MappedSuperclass
public class Base {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;
}
