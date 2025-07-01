package jp.te4a.teamc.spring.boot.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.te4a.teamc.spring.boot.bookapp.bean.UserBean;

public interface UserRepository extends JpaRepository<UserBean, String> {
}