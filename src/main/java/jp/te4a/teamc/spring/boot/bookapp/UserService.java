package jp.te4a.teamc.spring.boot.bookapp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jp.te4a.teamc.spring.boot.bookapp.bean.UserBean;
import jp.te4a.teamc.spring.boot.bookapp.form.UserForm;
import jp.te4a.teamc.spring.boot.bookapp.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserForm create(UserForm userForm) {
        userForm.setPassword(new BCryptPasswordEncoder().encode(userForm.getPassword()));
        UserBean userBean = new UserBean();
        //画面用ユーザ情報（From）→DB用ユーザ情報（Bean）
        BeanUtils.copyProperties(userForm, userBean);
        //ユーザをDBに追加
        userRepository.save(userBean);
        return userForm;
    }
}
