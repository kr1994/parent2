package com.kris.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.kris.dao.UserDao;
import com.kris.entity.User;

@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginManagedBean {
	private UserDao userDAO = new UserDao();
	private User user = new User();

	public String send() {
		user = userDAO.getUser(user.getNameUser(), user.getPassword());
		if (user == null) {
			user = new User();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "User not found!", " Login Error!"));
			return null;
		} else {
			return "/main";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
