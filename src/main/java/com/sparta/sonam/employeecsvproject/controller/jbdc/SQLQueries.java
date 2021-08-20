package com.sparta.sonam.employeecsvproject.controller.jbdc;

public interface SQLQueries {
    String INSERT_INTO_EMPLOYEE_DB = "INSERT INTO `employee_csv_reader_db`.`employees` (`employee_id`,`name_prefix`," +
            "`first_name`,`middle_initial`,`last_name`,`gender`,`email`,`date_of_birth`,`date_of_joining`, `salary`" +
            "VALUES (?,?,?,?,?,?,?,?,?,?)";
}
