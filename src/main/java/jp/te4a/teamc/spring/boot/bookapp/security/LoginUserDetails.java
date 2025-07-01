package jp.te4a.teamc.spring.boot.bookapp.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import jp.te4a.teamc.spring.boot.bookapp.bean.UserBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginUserDetails extends User {
    private final UserBean user;

    public LoginUserDetails(UserBean userBean,
            boolean accountNonExpried,  //アカウント無効、認証無効
            boolean credenttialsNonExpired,     //ロック状態を設定可能
            boolean accountNonLocked,       //すべて該当なし（true）でユーザ認証
            Collection<GrantedAuthority> authorities) {     //呼び出し時にリストで設定
        super(userBean.getUsername(), userBean.getPassword(),
                true, true, true, true, authorities);
        this.user = userBean;
    }
}
