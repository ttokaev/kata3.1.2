package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserService {

   private final UserDao userDao;

   @Autowired
   public UserService(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   public void createUser(User user) {
      userDao.createUser(user);
   }

   @Transactional(readOnly = true)
   public List<User> getUsers() {
      return userDao.getUsers();
   }

   @Transactional(readOnly = true)
   public User getUserById(Long id) {
      return userDao.getUserById(id);
   }

   @Transactional
   public void removeUser(User user) {
      userDao.removeUser(user);
   }

   @Transactional
   public void updateUser(User newUser) {
      userDao.updateUser(newUser);
   }
}
