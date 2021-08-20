package com.sparta.sonam.employeecsvproject.controller.jbdc;

public interface SQLQueries {
    String INSERT_INTO_EMPLOYEE_DB = "INSERT INTO `employee_csv_reader_db`.`employees` (`employee_id`,`name_prefix`," +
            "`first_name`,`middle_initial`,`last_name`,`gender`,`email`,`date_of_birth`,`date_of_joining`, `salary`)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?)";
    String SELECT_ALL = "SELECT * FROM `employee_csv_reader_db`.`employees`";
    String SELECT_RECORD = "SELECT * FROM `employee_csv_reader_db`.`employees` WHERE employee_id = ?";
    String DELETE_RECORD = "DELETE FROM `employee_csv_reader_db`.`employees` WHERE employee_id = ?";
    String UPDATE_RECORD_NAME_PREFIX = "UPDATE `employee_csv_reader_db`.`employees` SET `name_prefix` WHERE employee_id = ?";
    String UPDATE_RECORD_FIRST_NAME = "UPDATE `employee_csv_reader_db`.`employees` SET `first_name` WHERE employee_id = ?";
    String UPDATE_RECORD_MIDDLE_INITIAL = "UPDATE `employee_csv_reader_db`.`employees` SET `middle_initial` WHERE employee_id = ?";
    String UPDATE_RECORD_LAST_NAME = "UPDATE `employee_csv_reader_db`.`employees` SET `last_name` WHERE employee_id = ?";
    String UPDATE_RECORD_GENDER = "UPDATE `employee_csv_reader_db`.`employees` SET `gender` WHERE employee_id = ?";
    String UPDATE_RECORD_EMAIL = "UPDATE `employee_csv_reader_db`.`employees` SET `email` WHERE employee_id = ?";
    String UPDATE_RECORD_DATE_OF_BIRTH = "UPDATE `employee_csv_reader_db`.`employees` SET `date_of_birth` WHERE employee_id = ?";
    String UPDATE_RECORD_DATE_OF_JOINING = "UPDATE `employee_csv_reader_db`.`employees` SET `date_of_joining` WHERE employee_id = ?";
    String UPDATE_RECORD_SALARY = "UPDATE `employee_csv_reader_db`.`employees` SET `first_name` WHERE employee_id = ?";
}
