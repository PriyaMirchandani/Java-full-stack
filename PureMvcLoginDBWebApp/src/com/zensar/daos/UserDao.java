package com.zensar.daos;

import java.sql.SQLException;
import java.util.List;

import com.zensar.entities.User;

/**
 * @author Priya mirchandani
 * @version 1.0
 * @creation_date 21 sep 2019 5.23 pm
 * @modification_date 21 sep 2019 5.23pm
 * @copyright Zensar Technologies ,All rights reserved
 * @description- it is data access object interface
 *               it is used in persistance layer of application
 *
 */
public interface UserDao {
void insert(User user) throws SQLException;
void update(User user) throws SQLException;
void delete(User user) throws SQLException;
User getByUsername(String username) throws SQLException;
List<User>getAll()throws SQLException;
}
