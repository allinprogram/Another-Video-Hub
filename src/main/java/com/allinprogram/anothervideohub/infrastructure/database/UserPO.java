package com.allinprogram.anothervideohub.infrastructure.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * AdminPO
 *
 * @author AllinProgram
 * @since 2022-06-04 19:46 星期六
 */
@Getter
@Setter
@Entity(name = "t_user")
public class UserPO extends Base {

    private String username;

    private String password;
}
