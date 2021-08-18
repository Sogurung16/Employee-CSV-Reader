package com.sparta.sonam.jdbc;

public interface SQLQueries {
    String INSERT_INTO_DB = "INSERT INTO `userdb_schema`.`users` (`id`, `user-name`, `email`) VALUES (?, ?, ?)";
    String SELECT_ALL = "SELECT * FROM userdb_schema.users;";
    String SELECT_RECORD = "SELECT * FROM userdb_schema.users WHERE id = ?";
    String DELETE_RECORD = "DELETE FROM userdb_schema.users WHERE id = ?";
    String UPDATE_RECORD_NAME = "UPDATE `userdb_schema`.`users` SET `user-name` = ? WHERE id = ?";
    String UPDATE_RECORD_EMAIL = "UPDATE `userdb_schema`.`users` SET `email` = ? WHERE id = ?";
}
